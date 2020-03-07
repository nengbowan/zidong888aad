package com.aad888;

import com.aad888.config.Config;
import com.aad888.dto.*;
import com.aad888.enums.BetType;
import com.aad888.util.HttpClientUtils;
import com.aad888.util.NumberUtil;
import com.aad888.util.RuoKuai;
import com.aad888.util.StringUtils;
import com.aad888.util.feifei.Hello;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Api {

    //Cookie自动维护对象
    private CookieStore cookieStore = new BasicCookieStore();

    private HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

    private String verifyBefore = null;

    private String username;

    private String password;

    private String SESSION_ID;

    private String baseUrl = "https://www.240zr.com:9900";

//    private String baseUrl = "http://juren96.com";

//    private String ltBaseUrl = "http://lt.juren96.com";

    private String ltBaseUrl = "https://latticecatch.com:8899";

    private int[] betMoney;

    private int betIndex;

    public Api(String username, String password, int[] betMoney) {
        this.username = username;

        this.password = password;

        this.betMoney = betMoney;

    }

//    public
    /**
     * 获取验证码前置参数
     *
     * @return
     */
    public String getVerifyBefore() {
        String url = baseUrl + "/infe/verify/mkcode?_=0.86498886432721221541129057496";

        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0"));
        httpGet.addHeader(new BasicHeader("Referer", "https://www.240zr.com:9900/entrance/page/soya?ni=1"));
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


    public static String getUsernameAndBalance(String content){
        String username = null;
        String balance = null;
        Pattern userRegex = Pattern.compile("帐号：</span><strong>(.*)</strong>");
        Pattern balanceRegex = Pattern.compile("<span>BBIN 余额：</span>\n        <strong>(.*)</strong>");
        Matcher userMatcher = userRegex.matcher(content);
        Matcher balanceMatcher = balanceRegex.matcher(content);
        if(userMatcher.find()){
            username = userMatcher.group(1);
        }
        if(balanceMatcher.find()){
            balance = balanceMatcher.group(1);
        }
        StringBuffer result = new StringBuffer();
        if(username != null){
            result.append("欢迎您,"+username);
        }
        if(balance != null){
            result.append("\n当前余额:"+balance);
        }
        return result.toString();

    }

    public void doIt() throws Exception{
        int flag = 0;
        do{
            getVerifyBefore();
            String path = getVerfiyPath();
            String verifyCode = Hello.recognize(path);
            if(StringUtils.isEmpty(verifyCode)){
                System.out.println("验证码识别失败");
                return;
            }
            flag = doLogin(verifyCode);
        }while(flag==2);

        if(flag == 0){
            System.out.println("登陆失败");
            return;
        }



//        String checkUrlHtml = checkRule();
//
//        CheckRuleDto ruleDto = parseCheckUrlHtml(checkUrlHtml);

//        String unreadJson = getUnreadMessage();

//        UnreadMessage unreadMessage = parseUnreadMessage(unreadJson);

        //500 Internal error
//        String lotteryHtml = indexModuleSystem(ruleDto.getGtype(), ruleDto.getPageSize(), ruleDto.getUid());
//
//        this.htmlUsername = parseLotteryHtml2Username(lotteryHtml);
//
//        this.htmlMoney = parseLotteryHtml2Money(lotteryHtml);
//
        happy();

        client.execute(new HttpGet(baseUrl + "infe/rest/game/lottery/lobby.json?_=1575039742324"));

        //请求第三方cookie
        client.execute(new HttpGet(ltBaseUrl + "/pt/mem/ajax/cdn.json"));
        client.execute(new HttpGet(ltBaseUrl+"/pt/mem/ajax/orderad/item/lddr"));
        client.execute(new HttpGet(ltBaseUrl+"/vender.php?lang=zh-cn&referer_url=/pt/../charon/%23/game/lddr"));
        client.execute(new HttpGet(ltBaseUrl+"/vender.php?lang=zh-cn&referer_url=/pt/../charon/"));
        client.execute(new HttpGet(ltBaseUrl+"/pt/mem/ajax/config/init.json"));
        float max = 0;



        //获取梯子记录
        String recordsJson =  getResultedLddr();

        String lobbeyJson = getLobbyJson();
//
//

//
//
//
        List<LddrHistoryRecord> records = JSONObject.parseArray(recordsJson ,LddrHistoryRecord.class);

        //获取最近梯子记录
//        int count = 200; //默认取200条记录
        String recentLddrJson = getRecentLddr(200);
        List<LddrHistoryRecord> recentRecords = JSONObject.parseArray(recentLddrJson ,LddrHistoryRecord.class);
//        String gameNum = "201811051436";
//        String betType = "3";
//        String betMoney = "5";

        //获取一期记录 getNext_game是空的 就是可以投注的 ，  ， 并查看当前是否可以下注

        // 第一次

        LddrResp currentLddr = null;
        String currentLddrNum = null;
        do{
            try{
                String resp = addr(null);
                currentLddr = JSONObject.parseObject(resp, LddrResp.class);;
                currentLddrNum = currentLddr.getOpening_game().getNum();
            }catch (JSONException exception){
                exception.printStackTrace();
                System.out.println("密码错误");
                return;
            }
//            currentLddr = JSONObject.parseObject(addr(null), LddrResp.class);;
//            currentLddrNum = currentLddr.getOpening_game().getNum();

        }while(currentLddrNum.equals(""));


        //查看当前开奖是否为三单

        System.out.println(currentLddr.getRecent_game().getResult());
        System.exit(0);
        String currentMoney = currentLddr.getUser().getBalance().getCash();

        String nextLddrNum = null;
        String nextMoney = null;
        betIndex = 0;
        int count = 0;

        if(count >= 1500 / 5  && max >= 1500){
            System.out.println("完成目标　，　退出　");
            return;
        }
        int betSum = 0;
        while (true) {
            System.out.println("当前期数:"+currentLddrNum);
            int cut4 = NumberUtil.cut4(currentLddrNum);
            //反向下注
//            System.out.println("当前下注轮次:" + betIndex);

//            doBet(currentLddrNum, NumberUtil.isJiShu(cut4) ? BetType.SHUANG : BetType.DAN, betMoney[betIndex] + "");


//            if(betIndex < 6){
                doBet(currentLddrNum, NumberUtil.isJiShu(cut4) ? BetType.SHUANG : BetType.DAN, betMoney[betIndex] + "");
                count++;
                betSum+= betMoney[betIndex];
            System.out.println("总下注次数:"+count);
            System.out.println("总下注金钱:"+betSum);
//            }else{
//
//                doBet(currentLddrNum, NumberUtil.isJiShu(cut4) ? BetType.SHUANG : BetType.DAN, betMoney[betIndex] + "");
//            }

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
                LddrResp nextLddrDto =null;
                try{
                    nextLddrDto = JSONObject.parseObject(lddrResp, LddrResp.class);
                }catch (JSONException ex){
                    ex.printStackTrace();
                    nextLddrDto = JSONObject.parseObject(lddrResp, LddrResp.class);
                }

                if(nextLddrDto.getOpening_game()!= null){
                    nextLddrNum = nextLddrDto.getOpening_game().getNum();
                    nextMoney = nextLddrDto.getUser().getBalance().getCash();
                    //如果nextGameResp下一次游戏记录为空 ， 代表可以投注
                }
//                else{
//                    try {
//                        Thread.sleep(4000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("官方开采系统有误，重试");
//                    nextLddrNum = nextLddrDto.getOpening_game().getNum();
//                    nextMoney = nextLddrDto.getUser().getBalance().getCash();
//                    //如果nextGameResp下一次游戏记录为空 ， 代表可以投注
//                }
            } while (nextLddrNum.equals("") || betAfterGameNum.equalsIgnoreCase(nextLddrNum));

            //休眠两秒，以获取实际中奖与否的金额
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LddrResp tempDto = JSONObject.parseObject(addr(null), LddrResp.class) ;

            System.out.println("上期开奖结果:"+tempDto.getRecent_game().getResult());

            nextMoney = tempDto.getUser().getBalance().getCash();

            System.out.println("当前余额:"+nextMoney);

            float max1 = Math.max(Float.valueOf(betAfterMoney) ,Float.valueOf(nextMoney) );


            max = Math.max(max , max1);
            System.out.println("最大余额："+  max);

            //判断是否输赢
            if (hasLose(betAfterMoney, nextMoney)) {
                betIndex++;

                if(betIndex == 8){
                    betIndex = 0;
                }

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
        String login2Url = ltBaseUrl+"/charon/";
        HttpGet login2Get = new HttpGet(login2Url);
        login2Get.addHeader(new BasicHeader(Config.WebHeaderConfig.USERAGENT_KEY, Config.WebHeaderConfig.USERAGENT_VALUE));
        String login2BeforeResp = HttpClientUtils.getOrPost(login2Get, client);
        System.out.println("login2BeforeResp"+login2BeforeResp);
        return login2BeforeResp;
    }

    private BetResp parseBetResp(String betRespJson) {
        return JSONObject.parseObject(betRespJson, BetResp.class);
    }

    /**
     * 获取　账户　,　余额　
     */
    private void happy() {
        try {
            String content = EntityUtils.toString(client.execute(new HttpGet("https://www.240zr.com:9900/entrance/page/lottery?ni=1")).getEntity());
            System.out.println(getUsernameAndBalance(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String doBetUrl = ltBaseUrl+"/pt/mem/ajax/order/LDDR.json?lang=zh-cn";
        HttpPost httpPost = new HttpPost(doBetUrl);
        Map<String, String> headerParams = new HashMap();
//        headerParams.put("Content-Type","application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", ltBaseUrl + "/charon/");
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
        //game: LDDR
        //game_num: 201911260921
        //datatype: array
        //entrance: 0
        //portal: 0
        //client: 0
        //platform: 0
        //orders[3:ODD]: {"gold":1,"odds":3.92}
        //单
        if (BetType.DAN == betType) {
            nvps.add(new BasicNameValuePair("orders[ODD:END]", "{\"gold\":" + betMoney + ",\"odds\":1.97}"));
            //双
        } else if (BetType.SHUANG == betType) {
            nvps.add(new BasicNameValuePair("orders[EVEN:END]", "{\"gold\":" + betMoney + ",\"odds\":1.97}"));
        } else if (BetType.SANDAN == betType) {
            //三单
            nvps.add(new BasicNameValuePair("orders[3:ODD]", "{\"gold\":" + betMoney + ",\"odds\":3.92}"));
        }else {
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
        String recentLddrUrl = ltBaseUrl + "/pt/mem/ajax/recent_resulted/LDDR/" + count + ".json";

        HttpGet httpGet = new HttpGet(recentLddrUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", ltBaseUrl + "/charon/");
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
        String resultLddrUrl = ltBaseUrl + "/pt/mem/ajax/lddr/resulted.json";

        HttpGet httpGet = new HttpGet(resultLddrUrl);
        Map<String, String> headerParams = new HashMap();
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", ltBaseUrl + "/charon/");
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

//    private String checkRule() {
//        String checkRuleUrl = baseUrl + "/app/member/chk_rule.php";
//        HttpPost httpPost = new HttpPost(checkRuleUrl);
//        Map<String, String> headerParams = new HashMap();
////        headerParams.put("Content-Type","application/x-www-form-urlencoded");
//        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
//        headerParams.put("Referer", "https://888aad.com/infe/login/login");
//        if (headerParams != null && headerParams.size() > 0) {
//            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
//                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
//            }
//        }
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//
//
//        nvps.add(new BasicNameValuePair("uid", this.SESSION_ID));
//
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
//        try {
//            HttpResponse response = this.client.execute(httpPost);
//            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
//            return respStr;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 检查密码是否需要重新设置
     */
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

    /**
     * 1　成功　0　失败 2 验证码错误
     * @param verifyCode
     * @return
     */
    private int doLogin(String verifyCode) {
        //登录
        String doLoginUrl = baseUrl + "/entrance/login.json";
        HttpPost httpPost = new HttpPost(doLoginUrl);
        Map<String, String> headerParams = new HashMap();
//        headerParams.put("Content-Type","application/x-www-form-urlencoded");
        headerParams.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        headerParams.put("Referer", "https://www.490zr.com:9885/entrance/page/soya?ni=1");
        if (headerParams != null && headerParams.size() > 0) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                httpPost.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //username: freebuf002
        //password: asd081623
        //captcha: iayd
        //sr: f13ef7d6e6a107fe7af4
        //token:
        //csessionid:
        //sig:
        //scene: nc_login
        //appkey:
        nvps.add(new BasicNameValuePair("username", this.username));
        nvps.add(new BasicNameValuePair("password", this.password));
        nvps.add(new BasicNameValuePair("captcha", verifyCode));
        nvps.add(new BasicNameValuePair("sr", verifyBefore.split(";")[1]));
        nvps.add(new BasicNameValuePair("token", ""));
        nvps.add(new BasicNameValuePair("csessionid", ""));
        nvps.add(new BasicNameValuePair("sig", ""));
        nvps.add(new BasicNameValuePair("scene", "nc_login"));
        nvps.add(new BasicNameValuePair("appkey", ""));
//        nvps.add(new BasicNameValuePair("uid2", "guest"));
//        nvps.add(new BasicNameValuePair("SS", verifyBefore.split(";")[0]));
//
//        nvps.add(new BasicNameValuePair("TS", verifyBefore.split(";")[2]));



        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));
        try {
            HttpResponse response = this.client.execute(httpPost);

            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());

            if(respStr.contains("111031906")){
                return 2;
            }
            if(!respStr.contains("\"login_result\":1")){
                System.out.println(("postbody:" + nvps));
                System.out.println("login错误:"+"requesturl:"+doLoginUrl+"resp:"+respStr);
                return 0;
            }

            //设置sessionId的时机 方便后期调用
//            setSessionId(respStr);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
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
        String url = ltBaseUrl + "/pt/mem/ajax/lddr/source.json?lang=zh-cn";
        if (num != null) {
            url = url + "&num=" + num;
        }

        HttpGet httpGet = new HttpGet(url);

        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();//设置请求和传输超时时间

        httpGet.setConfig(requestConfig);

        httpGet.addHeader(new BasicHeader(Config.WebHeaderConfig.USERAGENT_KEY, Config.WebHeaderConfig.USERAGENT_VALUE));
        httpGet.addHeader(new BasicHeader("Referer", ltBaseUrl + "/charon/"));



        try{
            HttpResponse response = this.client.execute(httpGet);
            String respStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return respStr;
        }catch (Exception exception){
            System.out.println("系统超时，再次请求");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return addr(num);
        }

    }

}
