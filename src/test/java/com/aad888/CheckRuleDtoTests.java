package com.aad888;


import com.aad888.dto.CheckRuleDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class CheckRuleDtoTests {
    @Test
    private void parseCheckRuleHtml(){
        String resp = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <title>WELCOME 888真人官网直营-888D.com-邀您一起刷新博彩新记录</title>\n" +
                "</head>\n" +
                "<body onload=\"document.myForm.submit();\">\n" +
                "    <form action=\"/cl/index.php?module=System\" method=\"post\" name=\"myForm\" id=\"myForm\">\n" +
                "        <input type=\"hidden\" name=\"uid\" value=\"63316d3350d33c5e0769577e7764c0ea8ea08e4a\" />\n" +
                "        <input type=\"hidden\" name=\"gtype\" value=\"FT\" />\n" +
                "        <input type=\"hidden\" name=\"page_site\" value=\"\" />\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        Document doc = Jsoup.parse(resp);
        String uid = doc.select("input[name=uid]").get(0).text();
        String gtype = doc.select("input[name=gtype]").get(0).text();
        CheckRuleDto ruleDto = CheckRuleDto.builder()
                .uid(uid)
                .gtype(gtype)
                .build();
    }
}
