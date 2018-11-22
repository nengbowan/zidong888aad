package com.aad888;

import com.aad888.config.Config;
import com.aad888.dto.*;
import com.aad888.enums.BetType;
import com.aad888.util.HttpClientUtils;
import com.aad888.util.NumberUtil;
import com.aad888.util.RuoKuai;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import java.io.*;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Api {

    //Cookie自动维护对象
    private CookieStore cookieStore = new BasicCookieStore();

    private HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    private String verifyBefore = null;

    private String username;

    private String password;

    private String SESSION_ID;

    private String htmlUsername; //页面获取的用户名

    private String htmlMoney; //页面获取的金额

    private String baseUrl = "http://888aad.com";

    private int[] betMoney;

    private int betIndex;

    public Api(String username, String password, int[] betMoney) {
        this.username = username;

        this.password = password;

        this.betMoney = betMoney;

    }

    /**
     * 获取验证码前置参数
     *
     * @return
     */
    public String getVerifyBefore() {
        String url = baseUrl + "/infe/verify/mkcode?_=0.86498886432721221541129057496";

        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0"));
        httpGet.addHeader(new BasicHeader("Referer", "https://888aad.com/cl/index.php?module=System&method=first"));
        try {
            HttpResponse httpResponse = client.execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();

            String resp = EntityUtils.toString(httpEntity, Charset.defaultCharset());

            this.verifyBefore = resp;
            return resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getVerfiyPath() {
        if (verifyBefore.split(";").length != 3) {
            throw new IllegalArgumentException("获取verifyBefore失败");
        }
        String userHome = System.getProperty("user.home");
        String url = baseUrl + "/infe/verify/macpic?SR=" + verifyBefore.split(";")[1];

        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        try {
            HttpGet httpGet = new HttpGet(url);
            if (headerParams != null && headerParams.size() > 0) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    httpGet.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }

            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            File targetFile = new File(userHome + "/" + System.currentTimeMillis() + ".png");
            FileUtils.copyToFile(inputStream, targetFile);
            return targetFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void doIt() {
        getVerifyBefore();
        String path = getVerfiyPath();
        //调用模块识别验证码
        String xmlResp = RuoKuai.createByPost(
                RuoKuai.username, RuoKuai.password,
                RuoKuai.typeId, RuoKuai.timeout,
                RuoKuai.softId, RuoKuai.softKey,
                path);

        String verifyCode = getVerifyCode(xmlResp);

        doLogin(verifyCode);

        passwdCheck();

        String checkUrlHtml = checkRule();

        CheckRuleDto ruleDto = parseCheckUrlHtml(checkUrlHtml);

//        String unreadJson = getUnreadMessage();

//        UnreadMessage unreadMessage = parseUnreadMessage(unreadJson);

        //500 Internal error
        String lotteryHtml = indexModuleSystem(ruleDto.getGtype(), ruleDto.getPageSize(), ruleDto.getUid());

        this.htmlUsername = parseLotteryHtml2Username(lotteryHtml);

        this.htmlMoney = parseLotteryHtml2Money(lotteryHtml);

        happy();


        //二次授权 草拟吗 真难找哎 找了俩星期
        String secondAuth = lotteryLoginBefore();

//        String lobbeyJson = getLobbyJson();
//
//

//
//        //获取梯子记录
//        String recordsJson =  getResultedLddr();
//
//        List<LddrHistoryRecord> records = JSONObject.parseArray(recordsJson ,LddrHistoryRecord.class);

        //获取最近梯子记录
//        int count = 200; //默认取200条记录
//        String recentLddrJson = getRecentLddr(count);
//        List<LddrHistoryRecord> recentRecords = JSONObject.parseArray(recentLddrJson ,LddrHistoryRecord.class);
//        String gameNum = "201811051436";
//        String betType = "3";
//        String betMoney = "5";

        //获取一期记录 getNext_game是空的 就是可以投注的 ，  ， 并查看当前是否可以下注

        // 第一次

        LddrResp currentLddr = null;
        String currentLddrNum = null;
        do{
            currentLddr = JSONObject.parseObject(addr(null), LddrResp.class);;
            currentLddrNum = currentLddr.getOpening_game().getNum();
        }while(currentLddrNum.equals(""));

        String currentMoney = currentLddr.getUser().getBalance().getCash();

        String nextLddrNum = null;
        String nextMoney = null;
        betIndex = 0;
        while (true) {
            System.out.println("当前期数:"+currentLddrNum);
            int cut4 = NumberUtil.cut4(currentLddrNum);
            //反向下注
//            System.out.println("当前下注轮次:" + betIndex);
            doBet(currentLddrNum, NumberUtil.isJiShu(cut4) ? BetType.SHUANG : BetType.DAN, betMoney[betIndex] + "");


            String betAfterGameNum = null;
            LddrResp betAfterDto = null;
            do{

                String betAfterResp = addr(null);
                betAfterDto = JSONObject.parseObject(betAfterResp, LddrResp.class);
                betAfterGameNum = betAfterDto.getOpening_game().getNum();

            }while (betAfterGameNum.equals(""));

            String betAfterMoney = betAfterDto.getUser().getBalance().getCash();
            System.out.println("下注完余额:"+betAfterMoney);
            do {
                String lddrResp = addr(null);
                LddrResp nextLddrDto = JSONObject.parseObject(lddrResp, LddrResp.class);
                nextLddrNum = nextLddrDto.getOpening_game().getNum();
                nextMoney = nextLddrDto.getUser().getBalance().getCash();
                //如果nextGameResp下一次游戏记录为空 ， 代表可以投注
            } while (nextLddrNum.equals("") || betAfterGameNum.equalsIgnoreCase(nextLddrNum));

            //休眠两秒，以获取实际中奖与否的金额
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextMoney = JSONObject.parseObject(addr(null), LddrResp.class).getUser().getBalance().getCash();;

            System.out.println("当前余额:"+nextMoney);


            //判断是否输赢
            if (hasLose(betAfterMoney, nextMoney)) {
                betIndex++;
            } else {
                betIndex = 0;
            }

            currentLddrNum = nextLddrNum;
            currentMoney = nextMoney;

            nextLddrNum = "";
            nextMoney = "";
        }

        //betType 1 单
        //betType 2 双
//        String betRespJson = doBet(Long.valueOf(recentRecords.get(0).getNum()) +1 +"" , betType , betMoney);
    }

    private boolean hasLose(String currentMoney, String nextMoney) {
        return currentMoney.equalsIgnoreCase(nextMoney);
    }

    private String lotteryLoginBefore() {
        String login2Url = "http://lt.888aad.com/vender.php?lang=zh-cn&referer_url=/pt/../charon/";
        HttpGet login2Get = new HttpGet(login2Url);
        login2Get.addHeader(new BasicHeader(Config.WebHeaderConfig.USERAGENT_KEY, Config.WebHeaderConfig.USERAGENT_VALUE));
        String login2BeforeResp = HttpClientUtils.getOrPost(login2Get, client);
        return login2BeforeResp;
    }

    private BetResp parseBetResp(String betRespJson) {
        return JSONObject.parseObject(betRespJson, BetResp.class);
    }

    private void happy() {
        System.out.println(this.htmlUsername + " \tWish all the best wishes for you.");
        System.out.println("当前余额为 : " + this.htmlMoney);
    }

    private UnreadMessage parseUnreadMessage(String unreadJson) {
        return JSONObject.parseObject(unreadJson, UnreadMessage.class);
    }

    private String getUnreadMessage() {
        String unreadUrl = baseUrl + "/infe/macenter/message/usermsgcontrollerv2/getUnreadMsg.json";

        HttpGet httpGet = new HttpGet(unreadUrl);
        httpGet.addHeader(new BasicHeader("Referer", "https://888aad.com/cl/index.php?module=System"));
        httpGet.addHeader(new BasicHeader(Config.WebHeaderConfig.USERAGENT_KEY, Config.WebHeaderConfig.USERAGENT_VALUE));

        try {
            HttpResponse httpResponse = client.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String respStr = EntityUtils.toString(httpEntity, Charset.defaultCharset());
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String doBet(String gameNum, Integer betType, String betMoney) {

        //下注地址
        String doBetUrl = "http://lt.888aad.com/pt/mem/ajax/order/LDDR.json?lang=zh-cn";
        HttpPost httpPost = new HttpPost(doBetUrl);
        Map<String, String> headerParams = new HashMap();
//        headerParams.put("Content-Type","application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://lt.888aad.com/charon/");
        headerParams.put("Content-Type", "application/x-www-form-urlencoded");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //三
        //game=LDDR&
        // game_num=201811051300&d
        // atatype=array&
        // entrance=0&
        // portal=0&
        // client=0&
        // platform=0&
        // orders[3:STAIRS]={"gold":6,"odds":1.97}
//        TODO 具体下注策略
//        client	0
//        datatype	array
//        entrance	0
//        game	LDDR
//        game_num	201811040730
//        orders[3:EVEN]	{"gold":11,"odds":3.94}
//        orders[4:ODD]	{"gold":22,"odds":3.94}
//        platform	0
//        portal	0
        nvps.add(new BasicNameValuePair("client", "0"));
        nvps.add(new BasicNameValuePair("datatype", "array"));
        nvps.add(new BasicNameValuePair("entrance", "0"));
        nvps.add(new BasicNameValuePair("game", "LDDR"));
        nvps.add(new BasicNameValuePair("game_num", gameNum));
        nvps.add(new BasicNameValuePair("portal", "0"));
        nvps.add(new BasicNameValuePair("platform", "0"));
        //单
        if (BetType.DAN == betType) {
            nvps.add(new BasicNameValuePair("orders[ODD:END]", "{\"gold\":" + betMoney + ",\"odds\":1.97}"));
            //双
        } else if (BetType.SHUANG == betType) {
            nvps.add(new BasicNameValuePair("orders[EVEN:END]", "{\"gold\":" + betMoney + ",\"odds\":1.97}"));
        } else {
            System.out.println("程序已停止运行，因为不可预计的结果出现，停止下注!");
            System.exit(0);
        }

//        nvps.add(new BasicNameValuePair("orders["+betType+":STAIRS]" , "{\"gold\":"+betMoney+",\"odds\":1.97}"));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
        try {
            HttpResponse response = this.client.execute(httpPost);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            BetResp betResp = parseBetResp(respStr);
            if (betResp.isResult()) {
                System.out.println("下注期数:" + gameNum + "\t下注金额:" + betMoney + "\t下注方式:" + (betType == BetType.SHUANG ? "双" : "单"));
            } else {
                System.out.println("下注失败!" + respStr);
            }
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getRecentLddr(int count) {
        if (count == 0) {
            throw new IllegalArgumentException("获取最近记录条数失败 " + count);
        }
        String recentLddrUrl = "http://lt.888aad.com/pt/mem/ajax/recent_resulted/LDDR/" + count + ".json";

        HttpGet httpGet = new HttpGet(recentLddrUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://lt.888aad.com/charon/");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpGet.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        try {
            HttpResponse response = this.client.execute(httpGet);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getResultedLddr() {
        String resultLddrUrl = "http://lt.888aad.com/pt/mem/ajax/lddr/resulted.json";

        HttpGet httpGet = new HttpGet(resultLddrUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://lt.888aad.com/charon/");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpGet.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        try {
            HttpResponse response = this.client.execute(httpGet);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getLobbyJson() {

        String getLobbyUrl = baseUrl + "/infe/rest/game/lottery/lobby.json?lastChange=1541335743058&_=1541335743059";
        HttpGet httpGet = new HttpGet(getLobbyUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://888aad.com/cl/index.php?module=System");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpGet.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        try {
            HttpResponse response = this.client.execute(httpGet);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String parseLotteryHtml2Money(String lotteryHtml) {
        org.jsoup.nodes.Document doc = Jsoup.parse(lotteryHtml);
        String money = doc.select("#_bbsportBalance strong").get(0).text();
        return money;
    }

    private String parseLotteryHtml2Username(String lotteryHtml) {
        org.jsoup.nodes.Document doc = Jsoup.parse(lotteryHtml);
        String username = doc.select(".ele-accinfo.ele-acc-name strong").get(0).text();
        return username;
    }

    private String indexModuleSystem(String gtype, String pageSize, String uid) {


        String doLoginUrl = baseUrl + "/cl/?module=System&method=Ltlottery";
        HttpPost httpPost = new HttpPost(doLoginUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("Content-Type", "application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://888aad.com/app/member/chk_rule.php");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("gtype", gtype));
        nvps.add(new BasicNameValuePair("page_site", pageSize == null ? "" : pageSize));
        nvps.add(new BasicNameValuePair("uid", uid));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
        try {
            HttpResponse response = this.client.execute(httpPost);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CheckRuleDto parseCheckUrlHtml(String checkUrlHtml) {
        org.jsoup.nodes.Document doc = Jsoup.parse(checkUrlHtml);
        String uid = doc.select("input[name=uid]").get(0).attr("value");
        String gtype = doc.select("input[name=gtype]").get(0).attr("value");
        String pageSize = doc.select("input[name=page_site]").get(0).attr("value");
        CheckRuleDto ruleDto = CheckRuleDto.builder()
                .uid(uid)
                .gtype(gtype)
                .pageSize(pageSize)
                .build();
        return ruleDto;
    }

    private String checkRule() {
        String checkRuleUrl = baseUrl + "/app/member/chk_rule.php";
        HttpPost httpPost = new HttpPost(checkRuleUrl);
        Map<String, String> headerParams = new HashMap();
//        headerParams.put("Content-Type","application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://888aad.com/infe/login/login");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();


        nvps.add(new BasicNameValuePair("uid", this.SESSION_ID));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
        try {
            HttpResponse response = this.client.execute(httpPost);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void passwdCheck() {
        String doLoginUrl = baseUrl + "/infe/user/pwdlogin/check?_=" + System.currentTimeMillis();
        HttpGet httpGet = new HttpGet(doLoginUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://888aad.com/infe/login/login");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpGet.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        try {
            HttpResponse response = this.client.execute(httpGet);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doLogin(String verifyCode) {
        //登录
        String doLoginUrl = baseUrl + "/infe/login/login";
        HttpPost httpPost = new HttpPost(doLoginUrl);
        Map<String, String> headerParams = new HashMap();
//        headerParams.put("Content-Type","application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://888aad.com/cl/index.php?module=System&method=first");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //uid2=guest
        // SS=3f33634f7451fcb6c0081561e7374b2d
        // SR=8a7efb7320e90c5e7af4
        // TS=1541129979
        // username=freebuf002
        // passwd=abc081623
        // rmNum=7981
        nvps.add(new BasicNameValuePair("uid2", "guest"));
        nvps.add(new BasicNameValuePair("SS", verifyBefore.split(";")[0]));
        nvps.add(new BasicNameValuePair("SR", verifyBefore.split(";")[1]));
        nvps.add(new BasicNameValuePair("TS", verifyBefore.split(";")[2]));
        nvps.add(new BasicNameValuePair("username", this.username));
        nvps.add(new BasicNameValuePair("passwd", this.password));
        nvps.add(new BasicNameValuePair("rmNum", verifyCode));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
        try {
            HttpResponse response = this.client.execute(httpPost);

            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());


            //设置sessionId的时机 方便后期调用
            setSessionId(respStr);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setSessionId(String respStr) {
        org.jsoup.nodes.Document doc = Jsoup.parse(respStr);
        this.SESSION_ID = doc.select("input[name=uid]").attr("value");
    }

    private String getVerifyCode(String respXml) {

        try {

            SAXReader reader = new SAXReader();


            Document doc = reader.read(new ByteArrayInputStream(respXml
                    .getBytes("UTF8")));

            if (doc.getRootElement().element("Result") == null) {
                System.out.print("验证码识别失败");
                System.exit(0);
            }

            Element rootEle = doc.getRootElement().element("Result");

            if (rootEle != null) {
                return rootEle.getText();
            } else {
                return null;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String addr(Long num) {
        String url = "http://lt.888aad.com/pt/mem/ajax/lddr/source.json?lang=zh-cn";
        if (num != null) {
            url = url + "&num=" + num;
        }

        HttpGet httpGet = new HttpGet(url);

        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();//设置请求和传输超时时间

        httpGet.setConfig(requestConfig);

        httpGet.addHeader(new BasicHeader(Config.WebHeaderConfig.USERAGENT_KEY, Config.WebHeaderConfig.USERAGENT_VALUE));
        httpGet.addHeader(new BasicHeader("Referer", "https://lt.888aad.com/charon/"));

        try {

            try{
                HttpResponse response = this.client.execute(httpGet);
                String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
                return respStr;
            }catch (SocketTimeoutException socketTimeoutException){
                System.out.println("系统超时，再次请求");
                return addr(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
