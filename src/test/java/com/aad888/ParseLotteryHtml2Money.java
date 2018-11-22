//package com.aad888;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//public class ParseLotteryHtml2Money {
//
//    public void parseLotteryHtml2Money(){
//        String lotteryPage = "<!DOCTYPE html>" +
//                "<html class=\"ltlottery zh-cn is-login \">" +
//                "<head>" +
//                "<meta charset=\"UTF-8\">" +
//                "" +
//                "<title>888真人官网直营</title>" +
//                "<link href=\"https://p1.xf0371.com/cl/tpl/commonFile/css/standard.css?v=ver112.138\" rel=\"stylesheet\">" +
//                "<link href=\"/cl/tpl/zr888d/ver1/css/zr888d.css?v=ver112.138\" rel=\"stylesheet\">" +
//                "<link href=\"/cl/tpl/template/style/element/font-awesome.css?v=ver112.138\" rel=\"stylesheet\">" +
//                "" +
//                "<style>/* header */" +
//                ".login-wrap-align {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/url_img.png') 781px center no-repeat;" +
//                "}" +
//                ".login-submit {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/btn_login.png') center top no-repeat;" +
//                "}" +
//                ".header-join {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/btn_joinus.png') center top no-repeat;" +
//                "}" +
//                ".SU-Menual .logout-btn {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/btn_logout.png') center top no-repeat;" +
//                "}" +
//                "" +
//                "/* first */" +
//                ".first #mainBody {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/content_bg.png') center 1029px no-repeat;" +
//                "}" +
//                ".first #page-container {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/content_bg1.png') center 846px no-repeat;" +
//                "}" +
//                ".login-first .header-join {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_btn_joinus.png') center top no-repeat;" +
//                "}" +
//                ".first-game-live {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_livecasino.png') center top no-repeat;" +
//                "}" +
//                ".first-game-sport {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_sports.png') center top no-repeat;" +
//                "}" +
//                ".first-game-lottery {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_lottery.png') center top no-repeat;" +
//                "}" +
//                ".first-star-img {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_title.png') center 37px no-repeat;" +
//                "}" +
//                ".first-star-left {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_content_man01.png') center top no-repeat;" +
//                "}" +
//                ".first-star-center {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_content_man02.png') center top no-repeat;" +
//                "}" +
//                ".first-star-right {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_content_man03.png') center top no-repeat;" +
//                "}" +
//                ".first-about-img {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/first_footer_01.png') center 54px no-repeat;" +
//                "}" +
//                "" +
//                "/*banner-wrap*/" +
//                ".banner-wrap {" +
//                "    background: url('/cl/tpl/zr888d/ver1/image/lang/zh-cn/title_welcome.jpg') center top no-repeat;" +
//                "}" +
//                "</style>" +
//                "" +
//                "<script src=\"/cl/js/jquery-1.7.2.min.js?v=ver112.138\"></script>" +
//                "<script src=\"/cl/js/jquery-ui-1.8.21.custom.min.js?v=ver112.138\"></script>" +
//                "<link href=\"/cl/tpl/commonFile/css/jquery-ui/black/jquery-ui-1.9.2.custom.css?v=ver112.138\" rel=\"stylesheet\" />" +
//                "<script src=\"/cl/js/common.js?v=ver112.138\"></script>" +
//                "<script src=\"/cl/js/tools/upup.js?v=ver112.138\" data-ltl=\"Y\" id=\"upupjs\"></script>" +
//                "<script src=\"/cl/js/tools/float.js?v=ver112.138\"></script>" +
//                "<script src=\"/cl/js/pluging/swfobject.js?v=ver112.138\"></script>" +
//                "<script src=\"/cl/js/pluging/jquery.cookie.js?v=ver112.138\"></script>" +
//                "</head>" +
//                "<body>" +
//                "            <div id=\"mainBody\">" +
//                "            <div id=\"page-header\">" +
//                "    <div class=\"header-top clearfix\">" +
//                "        <!-- lang -->" +
//                "        <div class=\"lang-wrap\">" +
//                "            <span class=\"lang-title\">语言选择：</span>" +
//                "            <span class=\"lang\">" +
//                "                                <style>" +
//                ".ele-lang-wrap {" +
//                "    height: 20px;" +
//                "    vertical-align: middle;" +
//                "    display: inline-block; *display: inline; *zoom: 1;" +
//                "}" +
//                ".ele-lang-option {" +
//                "    width: 22px;" +
//                "        height: 16px;" +
//                "        vertical-align: top;" +
//                "    *margin-left: 4px;" +
//                "    background: url('/cl/tpl/template/images/element/lang_rect.png') no-repeat;" +
//                "    display: inline-block; *display: inline; *zoom: 1;" +
//                "}" +
//                ".ele-lang-zh-cn {" +
//                "    background-position: 0 -40px;" +
//                "}" +
//                ".ele-lang-en {" +
//                "    background-position: 0 -80px;" +
//                "}" +
//                ".ele-lang-ja {" +
//                "    background-position: 0 -120px;" +
//                "}" +
//                ".ele-lang-ko {" +
//                "    background-position: 0 -160px;" +
//                "}" +
//                ".ele-lang-vi {" +
//                "    background-position: 0 -200px;" +
//                "}" +
//                ".ele-lang-th {" +
//                "    background-position: 0 -240px;" +
//                "}" +
//                "</style>" +
//                "<span class=\"ele-lang-wrap\">" +
//                "        <a href=\"/infe/setparam/language/zh-tw\" target=\"mem_index\" class=\"ele-lang-option ele-lang-zh-tw\" title=\"繁體中文\"></a>" +
//                "        <a href=\"/infe/setparam/language/zh-cn\" target=\"mem_index\" class=\"ele-lang-option ele-lang-zh-cn\" title=\"简体中文\"></a>" +
//                "        <a href=\"/infe/setparam/language/en\" target=\"mem_index\" class=\"ele-lang-option ele-lang-en\" title=\"English\"></a>" +
//                "    </span>" +
//                "" +
//                "" +
//                "" +
//                "            </span>" +
//                "        </div>" +
//                "        <!-- 自訂連結 -->" +
//                "        <div class=\"top-link-wrap\">" +
//                "                            <a href=\"javascript:window.open('/infe/mcenter/paybitcoin/#/deposit/payfast', 'payquick').focus();\" data-color=\"#10f207|#1AFFF5\" class=\"js-article-color top-custom-link\" style=\"color: #10f207\">" +
//                "                    免登陆快速入款通道" +
//                "                </a>" +
//                "                            <a href=\"https://www.hd888d.com\" target=\"_blank\" data-color=\"#F90101|#F901DD\" class=\"js-article-color top-custom-link\" style=\"color: #F90101\">" +
//                "                    优惠办理大厅" +
//                "                </a>" +
//                "                            <a href=\"https://hb8zr.com\" target=\"_blank\" data-color=\"#E208C4|#EEE817\" class=\"js-article-color top-custom-link\" style=\"color: #E208C4\">" +
//                "                    天天抢8888元红包" +
//                "                </a>" +
//                "                            <a href=\"https://www.vip888d.com\" target=\"_blank\" data-color=\"#3ef9e7|#F6F722\" class=\"js-article-color top-custom-link\" style=\"color: #3ef9e7\">" +
//                "                    VIP俱乐部" +
//                "                </a>" +
//                "                            <a href=\"https://www.wenjuan.in/s/2i6nuix/\" target=\"_blank\" data-color=\"#FCF731|#49F73B\" class=\"js-article-color top-custom-link\" style=\"color: #FCF731\">" +
//                "                    投诉/建议中心" +
//                "                </a>" +
//                "                    </div>" +
//                "    </div>" +
//                "    <div id=\"navfixed\" class=\"header-middle-placeholder\">" +
//                "        <div class=\"header-middle-wrap clear\">" +
//                "            <div class=\"header-middle clearfix\">" +
//                "                <!-- LOGO -->" +
//                "                <div class=\"header-logo\">" +
//                "                                                                                                                        <div id=\"ele-logo-wrap\"><a href=\"/cl/?module=System&amp;method=First\" target=\"mem_index\" id=\"ele-logo-img\" title=\"888真人官网直营 网站首页\"></a></div><style>#ele-logo-wrap,#ele-logo-img {width: 292px;height: 104px;background-image: url('/cl/tpl/zr888d/ver1/image/logo.png');background-repeat: no-repeat;display: block;cursor: pointer;}#ele-logo-wrap{ background-position: 100% 100%;}#ele-logo-img { background-position: 0 0; }</style><script>$(function(){var flashvars = {},params = {wmode: 'transparent',quality: 'high'},attributes = {id: 'logo-flash',title: '888真人官网直营 网站首页',onmousedown: \"top.mem_index.location.href='/cl/?module=System&method=First'\"},rwdOpen = 'N';if (rwdOpen == 'Y' && window.innerWidth <= 960) {return;}swfobject.embedSWF('/cl/tpl/zr888d/ver1/image/logo.swf', 'ele-logo-wrap', '292', '104', '8.0.35.0', '/cl/tpl/commonFile/swf/expressInstall.swf', flashvars, params, attributes);$('#ele-logo-wrap').css('background-image','none');});</script>                </div>" +
//                "                <!-- 導覽列元件 -->" +
//                "                                                <style>/* 主選單 */.ele-navbar-wrap,.ele-navbar-wrap li {position: relative;}.ele-navbar-wrap .ele-nav-title,.ele-navbar-wrap .ele-nav-subtitle {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}.ele-navbar-wrap .ele-nav-hot {position: absolute;z-index: 1;display: block;}/* 下拉子選單與more子選單 */.ele-subnav-group,.ele-more-wrap {position: absolute;z-index: 999;margin: 0;border-radius: 6px;border: none;background: #FFF;min-width: auto;opacity: 0.95;overflow: hidden;}.ele-subnav-group::before,.ele-more-wrap::before,.ele-subnav-group::after,.ele-more-wrap::after {display: none;}.ele-subnav-wrap,.ele-more-wrap ul {margin: 10px 0;border: none !important;padding: 0;background: url('/cl/tpl/template/images/element/nav_border.png') 0 0 repeat-y !important;width: auto;}.ele-subnav-wrap::before,.ele-more-wrap ul::before,.ele-subnav-wrap::after,.ele-more-wrap ul::after {position: static;top: auto;right: auto;left: auto;margin: 0;border: none;padding: 0;background: none;height: 0;}.ele-more-icon {position: absolute;right: 0;bottom: 0;width: 15px;height: 18px;background: url('/cl/tpl/template/images/element/icon_down_light.png') 0 0 no-repeat;cursor: pointer;}.ele-subnav-group a,.ele-more-wrap a {position: relative;float: left;margin: 0;box-sizing: content-box !important;border: none !important;background: none !important;width: 82px;min-width: auto;padding: 0 9px;height: 30px;line-height: 30px;font-size: 12px !important;font-weight: normal;color: #504F4F !important;text-align: center !important;text-shadow: none !important;text-decoration: none !important;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}.ele-subnav-group a:hover,.ele-more-wrap a:hover {background: none;color: #000 !important;}.ele-subnav-group a::before,.ele-more-wrap a::before {content: '';display: none;position: absolute;top: 8px;left: 0;border-top: 6px solid transparent;border-bottom: 6px solid transparent;border-left: 6px solid transparent;width: 0;height: 0;border-left-color: #000;}.ele-subnav-group a:hover::before,.ele-more-wrap a:hover::before {display: block;}.ele-subnav-group a::after,.ele-more-wrap a::after {display: none;}.ele-more-wrap .ele-nav-subtitle,.ele-more-wrap .ele-nav-hot {display: none;}</style><div id=\"js-ele-navbar\" class=\"ele-navbar-wrap\"><ul class=\"clearfix\"><li id=\"js-ele-nav-first\" class=\"ele-nav-first ele-navnum-1\"><a class=\"ele-navlink  \" data-tag=\"first\" href=\"/cl/?module=System&amp;method=First\" target='mem_index' title=\"网站首页\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">网站首页</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">HOME</span></a></li><li id=\"js-ele-nav-game\" class=\"ele-nav-game ele-navnum-2\"><a class=\"ele-navlink drop-menu \" data-tag=\"game\" href=\"/cl/?module=System&amp;method=Game\" target='mem_index' title=\"电子游艺\"><img class=\"ele-nav-hot\" src=\"https://cdn.xf0371.com/tpl/1281/977077/images/152695613685.png\" /><span class=\"js-flashing ele-nav-title\" data-color=\"#FFFFFF|#F43D31\">电子游艺</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#FFFFFF|#F43D31\">CASINO</span></a><div id=\"js-ele-subnav-game\" class=\"ele-sidemenu-group\" data-tag=\"game\" data-order=\"2\" style=\"display: none;\"><!-- 子選單 --><a class=\"ele-subnavlink ele-first-subnavlink\" href=\"/cl/?module=System&amp;method=FishArea\" target='mem_index' title=\"捕鱼机\">捕鱼机</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=5\" target='mem_index' title=\"BB电子\">BB电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=51\" target='mem_index' title=\"Gti电子\">Gti电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=50\" target='mem_index' title=\"WM电子\">WM电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=48\" target='mem_index' title=\"BNG电子\">BNG电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=46\" target='mem_index' title=\"SW电子\">SW电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=20\" target='mem_index' title=\"PT电子\">PT电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=37\" target='mem_index' title=\"PP电子\">PP电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=42\" target='mem_index' title=\"RT电子\">RT电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=44\" target='mem_index' title=\"SG电子\">SG电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=41\" target='mem_index' title=\"大满贯电子\">大满贯电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=39\" target='mem_index' title=\"JDB电子\">JDB电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=40\" target='mem_index' title=\"AG电子\">AG电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=32\" target='mem_index' title=\"HB电子\">HB电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=23\" target='mem_index' title=\"MG电子\">MG电子</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=28\" target='mem_index' title=\"GNS电子\">GNS电子</a><a class=\"ele-subnavlink ele-last-subnavlink\" href=\"/cl/?module=System&amp;method=Game&amp;gameHall=29\" target='mem_index' title=\"ISB电子\">ISB电子</a></div></li><li id=\"js-ele-nav-live\" class=\"ele-nav-live ele-navnum-3\"><a class=\"ele-navlink drop-menu \" data-tag=\"live\" href=\"/cl/?module=System&amp;method=LiveTop&amp;args=livehall\" target='mem_index' title=\"视讯直播\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">视讯直播</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">LIVE CASINO</span></a><div id=\"js-ele-subnav-live\" class=\"ele-sidemenu-group\" data-tag=\"live\" data-order=\"3\" style=\"display: none;\"><!-- 子選單 --><a class=\"ele-subnavlink ele-first-subnavlink\" href=\"/cl/?module=System&amp;method=LiveTop&amp;args=39\" target='mem_index' title=\"BB视讯\">BB视讯</a><a class=\"ele-subnavlink \" href=\"javascript: f_com.bm('/nj/forward_game.php?game_id=47001&lang=zh-cn','evo',{width:'1200',height:'740',resizable:'yes'});\" target='mem_index' title=\"EVO视讯\">EVO视讯</a><a class=\"ele-subnavlink \" href=\"javascript: f_com.bm('/nj/forward_game.php?game_id=19001&lang=zh-cn','ag',{width:'1200',height:'740',resizable:'yes'});\"  title=\"AG视讯\">AG视讯</a><a class=\"ele-subnavlink \" href=\"javascript: f_com.bm('/nj/forward_game.php?game_id=22001&lang=zh-cn','allbet',{width:'1200',height:'740',resizable:'yes'});\"  title=\"欧博视讯\">欧博视讯</a><a class=\"ele-subnavlink \" href=\"javascript: f_com.bm('/nj/forward_game.php?game_id=27001&lang=zh-cn','gd',{width:'1200',height:'740',resizable:'yes'});\"  title=\"GD视讯\">GD视讯</a><a class=\"ele-subnavlink ele-last-subnavlink\" href=\"javascript: f_com.bm('/nj/forward_game.php?game_id=36001&lang=zh-cn','bg',{width:'1200',height:'740',resizable:'yes'});\" target='mem_index' title=\"BG视讯\">BG视讯</a></div></li><li id=\"js-ele-nav-ball\" class=\"ele-nav-ball ele-navnum-4\"><a class=\"ele-navlink drop-menu \" data-tag=\"ball\" href=\"/cl/?module=System&method=Ball\" target='mem_index' title=\"体育赛事\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">体育赛事</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">SPORTS</span></a><div id=\"js-ele-subnav-ball\" class=\"ele-sidemenu-group\" data-tag=\"ball\" data-order=\"4\" style=\"display: none;\"><!-- 子選單 --><a class=\"ele-subnavlink ele-first-subnavlink\" href=\"javascript:void window.open('/sport/new/index.html', 'nbb');\" target='mem_index' title=\"New BB体育\">New BB体育</a><a class=\"ele-subnavlink \" href=\"javascript:void window.open('/sport/new/index.html?menu_type=77_0', 'enbb');\" target='mem_index' title=\"New BB电竞\">New BB电竞</a><a class=\"ele-subnavlink \" href=\"/cl/?module=System&method=Ball\" target='mem_index' title=\"BB体育\">BB体育</a><a class=\"ele-subnavlink ele-last-subnavlink\" href=\"javascript:void window.open('/sport/sunplus/index.html', 'sunplus');\" target='mem_index' title=\"体育投注\">体育投注</a></div></li><li id=\"js-ele-nav-ltlottery\" class=\"ele-nav-ltlottery ele-navnum-5\"><a class=\"ele-navlink drop-menu current\" data-tag=\"ltlottery\" href=\"/cl/?module=System&amp;method=Ltlottery\" target='mem_index' title=\"彩票游戏\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">彩票游戏</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">LOTTERY</span></a><div id=\"js-ele-subnav-ltlottery\" class=\"ele-sidemenu-group\" data-tag=\"ltlottery\" data-order=\"5\" style=\"display: none;\"><!-- 子選單 --><a class=\"ele-subnavlink ele-first-subnavlink\" href=\"/cl/?module=System&amp;method=Ltlottery\" target='mem_index' title=\"BB彩票\">BB彩票</a><a class=\"ele-subnavlink ele-last-subnavlink\" href=\"javascript:void window.open('https://lt.888aad.com/vr/vender?lang=zh-cn', 'vrlottery');\"  title=\"VR彩票\">VR彩票</a></div></li><li id=\"js-ele-nav-card\" class=\"ele-nav-card ele-navnum-6\"><a class=\"ele-navlink drop-menu \" data-tag=\"card\" href=\"/cl/?module=System&amp;method=Card&amp;gameHall=49\" target='mem_index' title=\"棋牌游戏\"><span class=\"js-flashing ele-nav-title\" data-color=\"\">棋牌游戏</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"\"></span></a><div id=\"js-ele-subnav-card\" class=\"ele-sidemenu-group\" data-tag=\"card\" data-order=\"6\" style=\"display: none;\"><!-- 子選單 --><a class=\"ele-subnavlink ele-first-subnavlink\" href=\"/cl/?module=System&amp;method=Card&amp;gameHall=49\" target='mem_index' title=\"开元棋牌\">开元棋牌</a></div></li><li id=\"js-ele-nav-customize1\" class=\"ele-nav-customize1 ele-navnum-7\"><a class=\"ele-navlink  \" data-tag=\"customize1\" href=\"/cl/?module=System&method=MAdvertis&other=MemberExclusiveII&ExclusiveNo=0\" target='mem_index' title=\"优惠活动\"><img class=\"ele-nav-hot\" src=\"https://cdn.xf0371.com/tpl/1281/977077/images/152695623002.png\" /><span class=\"js-flashing ele-nav-title\" data-color=\"#FFFFFF|#F3DF65\">优惠活动</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#FFFFFF|#F3DF65\">PROMOTIONS</span></a></li><li id=\"js-ele-nav-customize2\" class=\"ele-nav-customize2 ele-navnum-8\"><a class=\"ele-navlink  \" data-tag=\"customize2\" href=\"###\" onclick=\"f_com.bm('/infe/rmobile', 'MOBILE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});\"  title=\"手机投注\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">手机投注</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">MOBILE BET</span></a></li><li id=\"js-ele-nav-customize3\" class=\"ele-more-nav ele-nav-customize3\"><a class=\"ele-navlink \" data-tag=\"customize3\" href=\"javascript:BBOnlineService();\"  title=\"在线客服\"><span class=\"js-flashing ele-nav-title\" data-color=\"#C7C7C7\">在线客服</span><span class=\"js-flashing ele-nav-subtitle\" data-color=\"#505050\">ONLINE SERVICE</span></a></li></ul><div id=\"js-ele-more-icon\" class=\"ele-more-icon\"></div><div id=\"js-ele-more\" class=\"ele-more-wrap\" style=\"display:none\"></div></div><script>(function(){$(function(){$('#js-ele-navbar').find('.ele-sidemenu-group').each(function() {$(this).dropDownControl('subnav',{ navIsHovered: false });});$('#js-ele-more').dropDownControl('morenav');$('.js-flashing').flashing();/* EVENT-視窗縮放立即隱藏 */$(window).on('resize', function() {$(\".ele-sidemenu-group\").css({ display: \"none\" });$(\".dropdown-active\").removeClass(\"dropdown-active\");});});$.fn.dropDownControl = function(dropDownType, dropDownOption) {if ($(this).length === 0) {return this;}var dropDownControl = {params: {memBody: (typeof(top.mem_index) === 'undefined') ? $('body') : $('body', top.mem_index.document),memDocument: (typeof(top.mem_index) === 'undefined') ? $(document) : $(top.mem_index.document),isRwdTemplate: (\"N\" === 'Y') ? true : false,rwdBreakpoints: 768,customizeParams: {/* 子選單動畫樣式【slide(default),fade】*/style: \"slide\",/* 子選單對齊主選單方式【center(default),left】*/align: \"center\",/* 子選單顯示動畫速度(單位:毫秒)【200(default)】 */timeIn: +(\"200\"),/* 子選單消失動畫速度(單位:毫秒)【300(default)】 */timeOut: +(\"300\"),/* 子選單執行動畫延遲時間(單位:毫秒)【500(default)】 */timeDelay: +(\"500\"),/* 子選單垂直位移(單位:px)【0(default)】 */posY: +(\"-24\"),/* 子選單水平位移(單位:px)【0(default)】 */posX: +(\"0\"),/* more選單垂直位移(單位:px) 【0(default)】 */morePosY: +(\"0\"),/* more選單水平位移(單位:px) 【0(default)】 */morePosX: +(\"-46\")},originalEle: $(this),controlBox: '',dropDownIsShow: false},/*** 初始化* @constructor*/init: function() {var parameter = dropDownControl.params;$.extend(dropDownControl.params, dropDownOption);/* 初始化 */dropDownControl[dropDownType + 'Init']();/* EVENT-控制項事件 */parameter.controller.on('mouseenter', function(event) {if (dropDownType === 'subnav' && parameter.isRwdTemplate && window.innerWidth <= parameter.rwdBreakpoints) {event.preventDefault();return;}dropDownControl.dropDownShow();}).on('mouseleave', function(event) {if (dropDownType === 'subnav' && parameter.isRwdTemplate && window.innerWidth <= parameter.rwdBreakpoints) {event.preventDefault();return;}dropDownControl.dropDownClose();}).on('click', function(event) {if (dropDownType === 'subnav' && parameter.isRwdTemplate && window.innerWidth <= parameter.rwdBreakpoints) {event.preventDefault();dropDownControl.dropDownRWD();return;}});/* EVENT-控制區塊事件 */parameter.controlBox.on('mouseenter', function() {clearTimeout(parameter.dropDownCloseTimer);}).on('mouseleave', function() {dropDownControl.dropDownClose();});/* EVENT-滾動重新定位 */parameter.memDocument.on('scroll', dropDownControl[dropDownType + 'PositionCount']);},/*** nav 子選單初始化*/subnavInit: function() {var parameter = dropDownControl.params,replicaHtml;/* 將控制區塊複製至body */replicaHtml = '<div id=\"js-ele-external-' + parameter.originalEle.data('tag') + '\" class=\"ele-subnav-group ele-subnavnum-' + parameter.originalEle.data('order') + '\" style=\"display: none;\">' +'<div class=\"ele-subnav-wrap clearfix\">' +parameter.originalEle.html() +'</div>' +'</div>';parameter.memBody.append(replicaHtml);/* 控制項名稱 */parameter.controllerName = parameter.originalEle.data('tag');/* 控制項 */parameter.controller = $('#js-ele-nav-' + parameter.controllerName).find('a.ele-navlink');/* 控制區塊 */parameter.controlBox = (typeof(top.mem_index) !== 'undefined') ? $('#js-ele-external-' + parameter.controllerName, top.mem_index.document) : $('#js-ele-subnav-' + parameter.controllerName);},/*** more 子選單初始化*/morenavInit: function() {var parameter = dropDownControl.params,replicaHtml;/* 將控制區塊複製至body */replicaHtml = [];$('#js-ele-navbar').find('.ele-more-nav').each(function(key) {var linkHtml = $(this).html().replace('js-flashing ', '');if (key === 0) {linkHtml = linkHtml.replace('ele-navlink ', 'ele-navlink ele-first-morenavlink');} else if (key + 1 === $('#js-ele-navbar').find('.ele-more-nav').length) {linkHtml = linkHtml.replace('ele-navlink ', 'ele-navlink ele-last-morenavlink');}replicaHtml.push('<li class=\"' + this.className.replace('ele-more-nav ', '')  + '\">' +linkHtml +'</li>');});parameter.originalEle.html('<ul class=\"clearfix\">' + replicaHtml.join('') + '</ul>');parameter.memBody.append($('<div>').append(parameter.originalEle).html());/* 控制項 */parameter.controller = $('#js-ele-more-icon');/* 控制區塊 */parameter.controlBox = (typeof(top.mem_index) !== 'undefined') ? $('#js-ele-more', top.mem_index.document) : $('#js-ele-more');},/*** 子選單 定位計算*/subnavPositionCount: function() {var parameter = dropDownControl.params,itemNumber = parameter.controlBox.find('a').length,itemWidth = parameter.controlBox.find('a').innerWidth(),limitNumber = 5;/* 先設定寬度 */parameter.controlBox.width(itemNumber < limitNumber ? itemWidth : itemWidth * (limitNumber - 1));var customizeParams = dropDownControl.params.customizeParams,mainWidth = parameter.controller.outerWidth(),mainHeight = parameter.controller.outerHeight(),mainPosition = parameter.controller.offset(),subWidth = parameter.controlBox.width(),cssSetting = {};cssSetting = {top: mainPosition.top + mainHeight + customizeParams.posY,left: mainPosition.left - ((subWidth / 2) - (mainWidth / 2)) + customizeParams.posX};if (customizeParams.align === 'left') {cssSetting.left = mainPosition.left + customizeParams.posX;} else if (customizeParams.align === 'right') {cssSetting.left = mainPosition.left + (mainWidth - subWidth) + customizeParams.posX;}/* 判斷是否超過瀏覽器左邊，則靠瀏覽器左邊對齊 */if (cssSetting.left < 0) {cssSetting.left = 0;}/* 判斷是否超過瀏覽器右邊，則靠瀏覽器右邊對齊 */if (parameter.memDocument.width() < cssSetting.left + subWidth) {cssSetting.left = parameter.memDocument.width() - subWidth;}/* 控制區塊定位設定 */parameter.controlBox.css(cssSetting);},/*** more選單 定位計算*/morenavPositionCount: function() {var parameter = dropDownControl.params,itemNumber = parameter.controlBox.find('a').length,itemWidth = parameter.controlBox.find('a').innerWidth(),limitNumber = 5;/* 先設定寬度 */parameter.controlBox.width(itemNumber < limitNumber ? itemWidth : itemWidth * (limitNumber - 1));var customizeParams = parameter.customizeParams,iconWidth = parameter.controller.outerWidth(),iconHeight = parameter.controller.outerHeight(),iconPosition = parameter.controller.offset(),subWidth = parameter.controlBox.width(),cssSetting = {};cssSetting = {top: iconPosition.top + iconHeight + customizeParams.morePosY,left: iconPosition.left + customizeParams.morePosX};/* 判斷是否超過瀏覽器左邊，則靠瀏覽器左邊對齊 */if (cssSetting.left < 0) {cssSetting.left = 0;}/* 判斷是否超過瀏覽器右邊，則靠瀏覽器右邊對齊 */if (parameter.memDocument.width() < cssSetting.left + subWidth) {cssSetting.left = iconPosition.left + iconWidth - subWidth;}/* 控制區塊定位設定 */parameter.controlBox.css(cssSetting);},dropDownShow: function() {var parameter = dropDownControl.params,customizeParams = dropDownControl.params.customizeParams;/* 避免控制項及控制區塊相互切換問題 */if (parameter.dropDownIsShow) {clearTimeout(parameter.dropDownCloseTimer);return;}parameter.dropDownIsShow = true;/* 控制區塊定位設定 */dropDownControl[dropDownType + 'PositionCount']();/* 控制區塊顯示動畫設定 */if (customizeParams.style === 'fade') {parameter.controlBox.stop(true, true).fadeIn(customizeParams.timeIn);} else {parameter.controlBox.stop(true, true).slideDown(customizeParams.timeIn);}/* 設定current效果 */if (dropDownType === 'subnav' && parameter.controller.hasClass(\"current\")) {parameter.navIsHovered = false;}if (dropDownType === 'subnav' && !parameter.controller.hasClass(\"current\")) {parameter.navIsHovered = true;parameter.controller.addClass(\"current\");}},dropDownClose: function() {var parameter = dropDownControl.params,customizeParams = dropDownControl.params.customizeParams;parameter.dropDownCloseTimer = setTimeout(function() {parameter.dropDownIsShow = false;/* 子選單關閉動畫設定 */if (customizeParams.style === 'fade') {parameter.controlBox.stop(true, true).fadeOut(customizeParams.timeOut);} else {parameter.controlBox.stop(true, true).slideUp(customizeParams.timeOut);}/* 設定current效果 */if (dropDownType === 'subnav' && parameter.navIsHovered) {parameter.navIsHovered = false;parameter.controller.removeClass(\"current\");}}, customizeParams.timeDelay);},dropDownRWD: function() {var parameter = dropDownControl.params;if (!parameter.controller.hasClass(\"dropdown-active\")) {parameter.controller.find(\".ele-sidemenu-group\").stop(true, true).delay(200).slideDown();}else {parameter.controller.find(\".ele-sidemenu-group\").stop(true, true).delay(200).slideUp();}}};dropDownControl.init();return this;};})();</script>            </div>" +
//                "        </div>" +
//                "    </div>" +
//                "        <div id=\"loginfixed\" class=\"login-wrap-placeholder\">" +
//                "        <div class=\"login-wrap-bg\">" +
//                "            <div class=\"login-wrap-align\">" +
//                "                <!-- 登入 -->" +
//                "                                <div class=\"mem-info\">" +
//                "                                                            <style>" +
//                ".ele-accinfo{" +
//                "    display: inline-block;" +
//                "    padding-right: 5px;" +
//                "    }" +
//                ".ele-accinfo .fa{" +
//                "    padding: 0 2px;" +
//                "    font-size: 14px;" +
//                "}" +
//                ".ele-first-balance{" +
//                "    display: inline-block;" +
//                "}" +
//                ".ele-acc-unit {" +
//                "    display: inline-block;" +
//                "}" +
//                ".ele-obalance-wrap{" +
//                "    position: relative;" +
//                "    display: inline-block;" +
//                "}" +
//                ".ele-other-balance{" +
//                "    cursor: pointer;" +
//                "}" +
//                "</style>" +
//                "" +
//                "<div class=\"ele-accinfo ele-acc-name\"><span>帐号：</span><strong>freebuf002</strong></div>" +
//                "<div class=\"ele-acc-unit\">" +
//                "        <div id=\"_bbsportBalance\" class=\"ele-accinfo ele-first-balance\">" +
//                "        <span>BBIN 余额：</span>" +
//                "        <strong>0.04</strong>" +
//                "    </div>" +
//                "                                                                                                <div id=\"js-ele-obalance-wrap2\" class=\"ele-obalance-wrap\">" +
//                "    <div class=\"ele-accinfo ele-other-balance\">" +
//                "        <i class=\"fa fa-plus-square\"></i>" +
//                "    </div>" +
//                "    <div id=\"js-ele-obalance-item-wrap2\" class=\"ele-obalance-item-wrap ele-item-style-cover\">" +
//                "        <div class=\"ele-obalance-item\">" +
//                "                                                                        <div id=\"_AGBalance2\" class=\"ele-obalance\" ><span>AG视讯余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_ABBalance2\" class=\"ele-obalance\" ><span>欧博视讯余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_GDBalance2\" class=\"ele-obalance\" ><span>GD视讯余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_BGBalance2\" class=\"ele-obalance\" ><span>BG视讯余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_EVOBalance2\" class=\"ele-obalance\" ><span>EVO视讯余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_PTBalance2\" class=\"ele-obalance\" ><span>PT电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_MGBalance2\" class=\"ele-obalance\" ><span>MG电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_GNSBalance2\" class=\"ele-obalance\" ><span>GNS电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_ISBBalance2\" class=\"ele-obalance\" ><span>ISB电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_HBBalance2\" class=\"ele-obalance\" ><span>HB电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_PPBalance2\" class=\"ele-obalance\" ><span>PP电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_JDBBalance2\" class=\"ele-obalance\" ><span>JDB电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_AGSLOTBalance2\" class=\"ele-obalance\" ><span>AG电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_MWBalance2\" class=\"ele-obalance\" ><span>大满贯电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_RTBalance2\" class=\"ele-obalance\" ><span>RT电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_SGBalance2\" class=\"ele-obalance\" ><span>SG电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_SWBalance2\" class=\"ele-obalance\" ><span>SW电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_BNGBalance2\" class=\"ele-obalance\" ><span>BNG电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_WMBalance2\" class=\"ele-obalance\" ><span>WM电子余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_GtiBalance2\" class=\"ele-obalance\" ><span>Gti电子余额：</span><strong><img src=\"/cl/tpl/template/images/loading_icon.gif\"></strong></div>" +
//                "                                                            <div id=\"_sunplueBalance2\" class=\"ele-obalance\" ><span>体育投注余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_VRBalance2\" class=\"ele-obalance\" ><span>VR彩票余额：</span><strong></strong></div>" +
//                "                                                            <div id=\"_KYBalance2\" class=\"ele-obalance\" ><span>开元棋牌余额：</span><strong></strong></div>" +
//                "                                    </div>" +
//                "                <div class=\"ele-balance-tool clearfix\">" +
//                "            <a href=\"javascript: f_com.MGetPager('moneyView');\">额度转换</a>" +
//                "        </div>" +
//                "                <style>" +
//                "        /*clear float*/" +
//                "        .clearfix:before, .clearfix:after { content:\"\"; display:table;}" +
//                "        .clearfix:after { clear:both;}" +
//                "        .clearfix { *zoom:1;}" +
//                "        .ele-obalance-item-wrap{" +
//                "            display: none;" +
//                "            position: absolute;" +
//                "            opacity: 0;" +
//                "            -ms-filter: \"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)\";" +
//                "            width: 270px;" +
//                "            -webkit-box-shadow: 0 2px 8px rgba(0,0,0,0.5);" +
//                "            -moz-box-shadow: 0 2px 8px rgba(0,0,0,0.5);" +
//                "            box-shadow: 0 2px 8px rgba(0,0,0,0.5);" +
//                "            border: 1px solid #CCC /9;" +
//                "            border-radius: 2px;" +
//                "            color: #000;" +
//                "            font-size: 12px;" +
//                "            background: #FAFAFA;" +
//                "            cursor: default;" +
//                "            z-index: 9999;" +
//                "            left: 0;" +
//                "        }" +
//                "        .ele-obalance-item{" +
//                "            padding: 16px;" +
//                "            border: 1px solid #EEE;" +
//                "        }" +
//                "        .ele-obalance-item strong{" +
//                "            font-weight: normal;" +
//                "        }" +
//                "        .ele-obalance{" +
//                "            padding-bottom: 2px;" +
//                "            color: #444;" +
//                "            line-height: 16px;" +
//                "        }" +
//                "        /* 額度轉換 */" +
//                "        .ele-balance-tool{" +
//                "            padding: 4px;" +
//                "            background: #F4F4F4;" +
//                "        }" +
//                "        .ele-balance-tool a{" +
//                "            float: right;" +
//                "            padding: 4px 8px;" +
//                "            color: #FFF;" +
//                "            background: #555;" +
//                "            -o-transition: background-color .20s linear;" +
//                "            -webkit-transition: background-color .20s linear;" +
//                "            -moz-transition: background-color .20s linear;" +
//                "            transition:  background-color .20s linear;" +
//                "            border-radius: 2px;" +
//                "            text-decoration: none;" +
//                "        }" +
//                "        .ele-balance-tool a:hover{" +
//                "            background: #000;" +
//                "        }" +
//                "        </style>" +
//                "    </div>" +
//                "</div>" +
//                "</div>" +
//                "<script>" +
//                "" +
//                "$(window).load(function() {" +
//                "    \"use strict\";" +
//                "" +
//                "    var ele_obalance_item_wrap_html = $('<div>').append($('#js-ele-obalance-item-wrap2')).html()," +
//                "        obalanceCloseTimer, // 自動關閉 timer" +
//                "        $obalanceWrap,      // 額度包裹物件" +
//                "        obalanceWrapH,      // 額度包裹高度" +
//                "        obalanceWrapW,      // 額度包裹寬度" +
//                "        balanceSwitch = true,      // 額度載入開關" +
//                "        $miBody = top.mem_index?$('body',top.mem_index.document):$('body');" +
//                "" +
//                "    $miBody.prepend(ele_obalance_item_wrap_html);" +
//                "" +
//                "    $obalanceWrap = top.mem_index?$('#js-ele-obalance-item-wrap2', top.mem_index.document):$('#js-ele-obalance-item-wrap');" +
//                "    obalanceWrapH = $obalanceWrap.height();" +
//                "    obalanceWrapW = $obalanceWrap.width();" +
//                "" +
//                "    $obalanceWrap.css({ display: 'none', height: '0'});" +
//                "" +
//                "    obalanceCloseTimer = setTimeout(obalanceAutoClose, 500);" +
//                "" +
//                "    function getBalance(){" +
//                "                                                                                                            if(top.mem_index){" +
//                "                            var Val_AGBalance = $(top.mem_index.document.getElementById('_AGBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_AGBalance = $('#_AGBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=19'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_AGBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_ABBalance = $(top.mem_index.document.getElementById('_ABBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_ABBalance = $('#_ABBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=22'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_ABBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_GDBalance = $(top.mem_index.document.getElementById('_GDBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_GDBalance = $('#_GDBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=27'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_GDBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_BGBalance = $(top.mem_index.document.getElementById('_BGBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_BGBalance = $('#_BGBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=36'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_BGBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_EVOBalance = $(top.mem_index.document.getElementById('_EVOBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_EVOBalance = $('#_EVOBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=47'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_EVOBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_PTBalance = $(top.mem_index.document.getElementById('_PTBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_PTBalance = $('#_PTBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=20'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_PTBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_MGBalance = $(top.mem_index.document.getElementById('_MGBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_MGBalance = $('#_MGBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=23'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_MGBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_GNSBalance = $(top.mem_index.document.getElementById('_GNSBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_GNSBalance = $('#_GNSBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=28'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_GNSBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_ISBBalance = $(top.mem_index.document.getElementById('_ISBBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_ISBBalance = $('#_ISBBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=29'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_ISBBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_HBBalance = $(top.mem_index.document.getElementById('_HBBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_HBBalance = $('#_HBBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=32'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_HBBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_PPBalance = $(top.mem_index.document.getElementById('_PPBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_PPBalance = $('#_PPBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=37'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_PPBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_JDBBalance = $(top.mem_index.document.getElementById('_JDBBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_JDBBalance = $('#_JDBBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=39'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_JDBBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_AGSLOTBalance = $(top.mem_index.document.getElementById('_AGSLOTBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_AGSLOTBalance = $('#_AGSLOTBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=40'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_AGSLOTBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_MWBalance = $(top.mem_index.document.getElementById('_MWBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_MWBalance = $('#_MWBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=41'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_MWBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_RTBalance = $(top.mem_index.document.getElementById('_RTBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_RTBalance = $('#_RTBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=42'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_RTBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_SGBalance = $(top.mem_index.document.getElementById('_SGBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_SGBalance = $('#_SGBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=44'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_SGBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_SWBalance = $(top.mem_index.document.getElementById('_SWBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_SWBalance = $('#_SWBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=46'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_SWBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_BNGBalance = $(top.mem_index.document.getElementById('_BNGBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_BNGBalance = $('#_BNGBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=48'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_BNGBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_WMBalance = $(top.mem_index.document.getElementById('_WMBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_WMBalance = $('#_WMBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=50'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_WMBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_GtiBalance = $(top.mem_index.document.getElementById('_GtiBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_GtiBalance = $('#_GtiBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=51'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_GtiBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_sunplueBalance = $(top.mem_index.document.getElementById('_sunplueBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_sunplueBalance = $('#_sunplueBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=4'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_sunplueBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_VRBalance = $(top.mem_index.document.getElementById('_VRBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_VRBalance = $('#_VRBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=45'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_VRBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                                                                        if(top.mem_index){" +
//                "                            var Val_KYBalance = $(top.mem_index.document.getElementById('_KYBalance')).find(\"strong\");" +
//                "                        }else{" +
//                "                            var Val_KYBalance = $('#_KYBalance').find(\"strong\");" +
//                "                        }" +
//                "                    " +
//                "                $.ajax({" +
//                "                    url: '?module=MGetData&method=GetDetail&args=Y&GameID=49'," +
//                "                    dataType: 'json'," +
//                "                    success: function(data) {" +
//                "                        Val_KYBalance.html(data.Balance);" +
//                "                    }" +
//                "                });" +
//                "                                        }" +
//                "" +
//                "    $('#js-ele-obalance-wrap2')" +
//                "        .on(\"mouseenter\", function() {" +
//                "            if(typeof obalanceCloseTimer != 'undefined'){" +
//                "                clearTimeout(obalanceCloseTimer);" +
//                "            }" +
//                "            if (balanceSwitch == true) {" +
//                "                balanceSwitch = false;" +
//                "                getBalance();" +
//                "            }" +
//                "            obalanceOpen($(this));" +
//                "        })" +
//                "        .on(\"mouseleave\", function() {" +
//                "            obalanceAutoClose();" +
//                "        });" +
//                "" +
//                "    $obalanceWrap" +
//                "        .on(\"mouseenter\", function() {" +
//                "            clearTimeout(obalanceCloseTimer);" +
//                "            obalanceOpen($('#js-ele-obalance-wrap2'));" +
//                "        })" +
//                "        .on(\"mouseleave\", function() {" +
//                "            obalanceAutoClose();" +
//                "        });" +
//                "" +
//                "    $(window).scroll(function(){" +
//                "        obalanceAutoClose();" +
//                "    });" +
//                "" +
//                "    function obalanceOpen(o){" +
//                "        var centerSet = $miBody.width() - $('body').width();" +
//                "            centerSet = (centerSet > 0) ? centerSet/2 : 0;" +
//                "" +
//                "        var offSet = o.offset()," +
//                "            objLeft = offSet.left + centerSet," +
//                "            objTop = offSet.top + o.height()," +
//                "            MaxLeft = offSet.left + obalanceWrapW," +
//                "            MaxBody = $('body').width() - obalanceWrapW," +
//                "                            parentHeight = $(window).height();" +
//                "            " +
//                "        if ( MaxLeft > MaxBody) {" +
//                "            objLeft = ( objLeft - obalanceWrapW ) + $('#js-ele-obalance-wrap2').width();" +
//                "        };" +
//                "" +
//                "        if(offSet.top > obalanceWrapH && (objTop + obalanceWrapH) > parentHeight + $(window).scrollTop()){" +
//                "            var objBottom = parentHeight - offSet.top;" +
//                "            $obalanceWrap" +
//                "                .stop()" +
//                "                .css({ display: 'block', 'left':objLeft, 'bottom':objBottom, 'top':'auto'})" +
//                "                .animate({ opacity: '1', height: obalanceWrapH}, 300, 'easeOutQuint');" +
//                "            return;" +
//                "        }" +
//                "" +
//                "        $obalanceWrap" +
//                "            .stop()" +
//                "            .css({ display: 'block', 'left':objLeft, 'top':objTop, 'bottom':'auto'})" +
//                "            .animate({ opacity: '1', height: obalanceWrapH}, 300, 'easeOutQuint');" +
//                "    }" +
//                "" +
//                "    function obalanceAutoClose(){" +
//                "        $obalanceWrap.stop().animate({opacity: '0', height: '0'}, 300, 'easeOutQuint', function () {" +
//                "            $obalanceWrap.css({ display: 'none' });" +
//                "        });" +
//                "    }" +
//                "});" +
//                "</script>                </div>" +
//                "                <!--  sub  -->" +
//                "                <div class=\"SU-Menual clearfix\">" +
//                "                    <ul class=\"login-Menual clearfix\">" +
//                "                                                                                <li>" +
//                "                                                                <a id=\"su-macenter\" href=\"javascript: f_com.MGetPager('memberData');\" title=\"会员中心\">会员中心</a>" +
//                "                            </li>" +
//                "                                                                                                            <li>" +
//                "                                ｜                                <a id=\"su-deposite\" href=\"javascript: f_com.MGetPager('bankSavings');\" title=\"线上存款\">线上存款</a>" +
//                "                            </li>" +
//                "                                                                                                            <li>" +
//                "                                ｜                                <a id=\"su-withdraw\" href=\"javascript: f_com.MGetPager('bankTake');\" title=\"线上取款\">线上取款</a>" +
//                "                            </li>" +
//                "                                                                                                            <li>" +
//                "                                ｜                                <a id=\"su-switch\" href=\"javascript: f_com.MGetPager('moneyView');\" title=\"一键归户\">一键归户</a>" +
//                "                            </li>" +
//                "                                                                                                                            </ul>" +
//                "                    <a class=\"logout-btn\" href=\"javascript: f_com.logoff('/infe/logout/logout');\"></a>" +
//                "                </div>" +
//                "                            </div>" +
//                "        </div>" +
//                "    </div>" +
//                "        <!-- 最新消息 -->" +
//                "    <div class=\"news-wrap clearfix\">" +
//                "        <div class=\"news-title\">最新公告：</div>" +
//                "        <div class=\"news-item\">" +
//                "                                    <marquee id=\"ele-msgNews\" behavior=\"scroll\" scrollamount=\"1\" direction=\"left\" style=\"height:100%;\"></marquee>" +
//                "<style>" +
//                ".ele-msg-cp{cursor: pointer;}" +
//                "</style>" +
//                "<script src=\"/cl/js/tools/marquee.js\"></script>" +
//                "<script>" +
//                "$(function() {" +
//                "    // 最新消息跑馬燈" +
//                "    $.ajax({" +
//                "        type:'GET'," +
//                "        url:'/infe/marquee/homeHotNews'," +
//                "        data:{}," +
//                "        cache: false," +
//                "        error: function() { return false;}," +
//                "        success: function(data) {" +
//                "            var msg_dir = $('#ele-msgNews').attr('direction');" +
//                "            if (/up|top|down|bottom/.test(msg_dir)){" +
//                "                $('#ele-msgNews').html(data);" +
//                "            }else if(/left|right/.test(msg_dir)){" +
//                "                $('#ele-msgNews').html(data.replace(new RegExp(\"<br\\s?\\/?>\" ,\"igm\") ,\"&nbsp;&nbsp;\"));" +
//                "            }" +
//                "            $('#ele-msgNews').marquee({\"kclass\" : \"ele-news-txt\" , \"speed\" : 40 })" +
//                "            .hover(function() {" +
//                "                         $(this).trigger(\"stop\");" +
//                "                     }, function() {" +
//                "                         $(this).trigger(\"start\");" +
//                "            });" +
//                "            $('.ele-news-txt').parent().addClass('ele-msg-cp').click(function(){HotNewsHistory();});" +
//                "        }" +
//                "    });" +
//                "});" +
//                "</script>" +
//                "        </div>" +
//                "    </div>" +
//                "    <!-- est -->" +
//                "    <div class=\"est-wrap\">" +
//                "            </div>" +
//                "</div>" +
//                "<!-- 導覽列英文字 -->" +
//                "<script>" +
//                "    $(function(){" +
//                "        $(\".mainnav ul li\").each(function(){" +
//                "            var tpl = ''," +
//                "                splits = $(this).attr(\"class\").split(/\\s/);" +
//                "" +
//                "            switch(splits[0]){" +
//                "                case \"LS-first\":" +
//                "                    tpl = \"HOME\";" +
//                "                    break;" +
//                "                case \"LS-game\":" +
//                "                    tpl = \"CASINO\";" +
//                "                    break;" +
//                "                case \"LS-live\":" +
//                "                    tpl = \"LIVE CASINO\";" +
//                "                    break;" +
//                "                case \"LS-ball\":" +
//                "                    tpl = \"SPORTS\";" +
//                "                    break;" +
//                "                case \"LS-ltlottery\":" +
//                "                    tpl = \"LOTTERY\";" +
//                "                    break;" +
//                "                case \"LS-memberexclusiveii\":" +
//                "                    tpl = \"PROMOTIONS\";" +
//                "                    break;" +
//                "                case \"LS-mobile\":" +
//                "                    tpl = \"MOBILE BET\";" +
//                "                    break;" +
//                "                case \"LS-service\":" +
//                "                    tpl = \"ONLINE SERVICE\";" +
//                "                    break;" +
//                "            }" +
//                "            $(this).find(\"span\").html(tpl);" +
//                "        });" +
//                "    });" +
//                "</script>" +
//                "            <div id=\"page-container\">" +
//                "    <div id=\"page-body\">" +
//                "        <style>ul,li {" +
//                "    list-style-type: none;" +
//                "}" +
//                ".ele-lotteryHALL-wrap {" +
//                "    margin: 0 auto;" +
//                "    padding: 20px 0;" +
//                "    box-sizing: border-box;" +
//                "    width: 100%;" +
//                "    max-width: 960px;" +
//                "    font-family: Arial, 'Microsoft JhengHei', sans-serif;" +
//                "}" +
//                "#spin-mask-wrap," +
//                "#js-teaching-alert {" +
//                "    display: none;" +
//                "    position: absolute;" +
//                "    top: 0;" +
//                "    left: 0;" +
//                "    background: #000;" +
//                "    width: 100%;" +
//                "    height: 100%;" +
//                "    z-index: 2;" +
//                "}" +
//                "#spin-mask-wrap {" +
//                "    opacity: 0.9;" +
//                "}" +
//                "#js-teaching-alert {" +
//                "    box-sizing: border-box;" +
//                "    padding: 3% 0;" +
//                "    background: rgba(0,0,0,0.7);" +
//                "    text-align: center;" +
//                "}" +
//                ".teaching-alert-wrap {" +
//                "    position: relative;" +
//                "    display: block;" +
//                "    margin: 0 auto;" +
//                "    width: 84%;" +
//                "}" +
//                ".teaching-alert-wrap img {" +
//                "    display: block;" +
//                "    width: 100%;" +
//                "}" +
//                "#js-teaching-alert .close-btn {" +
//                "    position: absolute;" +
//                "    top: 5px;" +
//                "    right: 5px;" +
//                "    width: 4%;" +
//                "    cursor: pointer;" +
//                "}" +
//                "#js-teaching-alert .close-btn:hover {" +
//                "    opacity: 0.8;" +
//                "}" +
//                ".ele-lottery-layout {" +
//                "    position: relative;" +
//                "    background: #333;" +
//                "    padding: 5px;" +
//                "}" +
//                "#ele-lottery-menu {" +
//                "    margin-bottom: 5px;" +
//                "    box-sizing: border-box;" +
//                "    background: #1B1B1B;" +
//                "    width: 100%;" +
//                "    height: 50px;" +
//                "}" +
//                "#ele-menu-item a {" +
//                "    float: left;" +
//                "    width: 15%;" +
//                "    line-height: 50px;" +
//                "    color: #AAA;" +
//                "    font-size: 15px;" +
//                "    font-weight: bold;" +
//                "    text-align: center;" +
//                "    text-decoration: none;" +
//                "    text-overflow: ellipsis;" +
//                "    overflow: hidden;" +
//                "    padding: 0 8px;" +
//                "    white-space: nowrap;" +
//                "}" +
//                "#ele-menu-item a.current," +
//                "#ele-menu-item a:hover {" +
//                "    color: #BF2824;" +
//                "}" +
//                "" +
//                ".ele-lotteryHALL-wrap .anythingSlider," +
//                ".ele-lotteryHALL-wrap .anythingSlider img {" +
//                "    width: 100%;" +
//                "    height: auto;" +
//                "}" +
//                "" +
//                "/* 給大廳同時載輪撥元件用，請勿移除 */" +
//                ".ele-lotteryHALL-wrap .anythingSlider {" +
//                "    position: static;" +
//                "    overflow: visible;" +
//                "}" +
//                "#js-ele-lottery-banner {" +
//                "    position: relative;" +
//                "    box-sizing: border-box;" +
//                "    width: 100%;" +
//                "}" +
//                "#js-ele-lottery-banner," +
//                ".preset-banner {" +
//                "    padding-bottom: 29.79%;" +
//                "}" +
//                "" +
//                "#js-ele-lottery-banner .panel {" +
//                "    position: absolute;" +
//                "    top: 0;" +
//                "    left: 0;" +
//                "    z-index: 0;" +
//                "}" +
//                "#js-ele-lottery-banner .activePage {" +
//                "    z-index: 1;" +
//                "}" +
//                ".entrance-wrap {" +
//                "    float: left;" +
//                "    width: 79.264%;" +
//                "    box-sizing: border-box;" +
//                "}" +
//                "#lotter-official {" +
//                "    display: none;" +
//                "}" +
//                ".entrance-wrap .ele-lottery-entrance {" +
//                "    float: left;" +
//                "    position: relative;" +
//                "    box-sizing: border-box;" +
//                "    width: 49.669%;" +
//                "}" +
//                ".entrance-wrap .entrance-left {" +
//                "    margin-right: 0.662%;" +
//                "}" +
//                ".entrance-wrap .entrance-right {" +
//                "    margin-right: 0;" +
//                "}" +
//                ".ele-lottery-hall {" +
//                "    position: relative;" +
//                "    box-sizing: border-box;" +
//                "    border-top-width: 4px;" +
//                "    border-top-style: solid;" +
//                "    border-bottom-width: 2px;" +
//                "    border-bottom-style: solid;" +
//                "    padding: 22px 0 0 16px;" +
//                "    width: 100%;" +
//                "    height: 108px;" +
//                "}" +
//                ".zh-tw .ele-lottery-hall," +
//                ".zh-cn .ele-lottery-hall {" +
//                "    letter-spacing: 2px;" +
//                "}" +
//                ".ele-lottery-hall h1 {" +
//                "    float: left;" +
//                "    font-size: 26px;" +
//                "    line-height: 35px;" +
//                "    margin-bottom: 2px;" +
//                "}" +
//                ".vi .ele-lottery-hall h1 {" +
//                "    max-width: 150px;" +
//                "    line-height: 25px;" +
//                "    font-size: 24px;" +
//                "}" +
//                ".ele-lottery-hall .more-games {" +
//                "    position: absolute;" +
//                "    top: 22px;" +
//                "    right: 16px;" +
//                "    z-index: 1;" +
//                "    padding: 0 25px;" +
//                "    border-width: 1px;" +
//                "    border-style: solid;" +
//                "    border-radius: 99em;" +
//                "    font-size: 14px;" +
//                "    max-width: 100px;" +
//                "    height: 35px;" +
//                "    line-height: 35px;" +
//                "    text-overflow: ellipsis;" +
//                "    overflow: hidden;" +
//                "    white-space: nowrap;" +
//                "    cursor: pointer;" +
//                "}" +
//                ".zh-tw .ele-lottery-hall .more-games," +
//                ".zh-cn .ele-lottery-hall .more-games {" +
//                "    letter-spacing: 1px;" +
//                "}" +
//                ".ele-lottery-hall .more-games:hover {" +
//                "    color: #333;" +
//                "}" +
//                ".ele-lottery-hall p {" +
//                "    clear: both;" +
//                "    max-width: 220px;" +
//                "    font-size: 15px;" +
//                "}" +
//                ".ja .ele-lottery-hall p," +
//                ".ko .ele-lottery-hall p {" +
//                "    font-size: 14px;" +
//                "}" +
//                ".official .ele-lottery-hall {" +
//                "    background: #232632;" +
//                "    border-top-color: #64C8F3;" +
//                "    border-bottom-color: #282B35;" +
//                "    color: #64C8F3;" +
//                "}" +
//                ".official .ele-lottery-hall .more-games:hover {" +
//                "    background: #64C8F3;" +
//                "}" +
//                ".tradition .ele-lottery-hall {" +
//                "    background: #362B1B;" +
//                "    border-top-color: #F8B865;" +
//                "    border-bottom-color: #332D23;" +
//                "    color: #F8B865;" +
//                "}" +
//                ".tradition .ele-lottery-hall .more-games:hover {" +
//                "    background: #F8B865;" +
//                "}" +
//                ".ele-lottery-game {" +
//                "    width: 100%;" +
//                "}" +
//                ".ele-lottery-game li {" +
//                "    margin-top: 2px;" +
//                "    background: #222;" +
//                "    width: 100%;" +
//                "    height: 55px;" +
//                "    line-height: 55px;" +
//                "    font-size: 17px;" +
//                "    cursor: pointer;" +
//                "}" +
//                "li.new-game-list {" +
//                "    position: relative;" +
//                "}" +
//                "li.new-game-list:before {" +
//                "    position: absolute;" +
//                "    top: 0;" +
//                "    left: 0;" +
//                "    content: \"\";" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/new.png') 0 0 no-repeat;" +
//                "    width: 29px;" +
//                "    height: 29px;" +
//                "}" +
//                ".ele-lottery-entrance .ele-lottery-game li:first-child {" +
//                "    margin-top: 0;" +
//                "}" +
//                ".ele-lottery-game .ele-item-left {" +
//                "    float: left;" +
//                "    box-sizing: border-box;" +
//                "    padding-left: 16px;" +
//                "    max-width: 76%;" +
//                "    color: #CCC;" +
//                "    white-space: nowrap;" +
//                "    text-overflow: ellipsis;" +
//                "    -ms-text-overflow: ellipsis;" +
//                "    overflow: hidden;" +
//                "}" +
//                ".ele-item-left .lotter-name," +
//                ".ele-item-left .lotter-num {" +
//                "    float: left;" +
//                "    clear: left;" +
//                "    padding-top: 12px;" +
//                "    height: 17px;" +
//                "    line-height: 17px;" +
//                "}" +
//                ".ele-item-left .lotter-num {" +
//                "    padding-top: 5px;" +
//                "    font-size: 13px;" +
//                "}" +
//                "#lotter-tradition .ele-item-left .lotter-num {" +
//                "    color: #8E7338;" +
//                "}" +
//                "#lotter-official .ele-item-left .lotter-num {" +
//                "    color: #4B80AB;" +
//                "}" +
//                ".ele-lottery-game .ele-item-rule {" +
//                "    float: right;" +
//                "    margin: 10px 16px 0 0;" +
//                "    width: 39px;" +
//                "    height: 39px;" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_quest_icon_new.png') 0 0 no-repeat;" +
//                "}" +
//                "" +
//                "/* 倒數器 */" +
//                ".ele-lottery-game .ele-item-countdown {" +
//                "    float: right;" +
//                "    padding-right: 20px;" +
//                "    width: 112px;" +
//                "}" +
//                ".ele-item-countdown .icon {" +
//                "    float: left;" +
//                "    margin-top: 14px;" +
//                "    margin-right: 10px;" +
//                "    width: 26px;" +
//                "    height: 26px;" +
//                "}" +
//                ".ele-item-countdown .js-itme-timer {" +
//                "    float: left;" +
//                "    font-size: 17px;" +
//                "}" +
//                ".ele-item-countdown.ele-countdown-end {" +
//                "    color: #555;" +
//                "}" +
//                ".ele-item-countdown.ele-countdown-end .icon {" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_timer_icon_new.png') 0 0 no-repeat;" +
//                "}" +
//                ".ele-item-countdown.ele-countdown-start {" +
//                "    color: #CCC;" +
//                "}" +
//                ".ele-item-countdown.ele-countdown-start .icon {" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_timer_icon_new.png') 0 100% no-repeat;" +
//                "}" +
//                ".ele-lottery-game li:hover {" +
//                "    background: #1E1E1E;" +
//                "}" +
//                ".ele-lottery-game li:hover .ele-item-rule{" +
//                "    background-position: 100% 0;" +
//                "}" +
//                ".ele-lottery-mobile {" +
//                "    float: left;" +
//                "    -ms-margin-left: 4px;" +
//                "    margin-left: 0.524%;" +
//                "    box-sizing: border-box;" +
//                "    width: 20.212%;" +
//                "    max-height: 450px;" +
//                "    overflow: hidden;" +
//                "}" +
//                ".ele-lottery-mobile img {" +
//                "    position: relative;" +
//                "    top: 0;" +
//                "    left: 50%;" +
//                "    margin-left: -96px;" +
//                "    max-width: none;" +
//                "}" +
//                "/*彩票遊戲廣宣*/" +
//                ".ele-lottery-hover-wrap {" +
//                "    display: none;" +
//                "    opacity: 0;" +
//                "    position: absolute;" +
//                "    top: 0;" +
//                "    z-index: 2;" +
//                "    padding-top: 8%;" +
//                "    background-color: rgba(0,0,0,.6);" +
//                "    width: 100%;" +
//                "    height: 200px;" +
//                "}" +
//                ".ele-lottery-slider {" +
//                "    margin-bottom: 5px;" +
//                "}" +
//                ".ele-lottery-slider .panel .ele-lottery-ctl-wrap {" +
//                "    position: absolute;" +
//                "    top: 0;" +
//                "    z-index: 2;" +
//                "    padding-top: 50px;" +
//                "    background-color: rgba(0,0,0,.6);" +
//                "    width: 100%;" +
//                "    height: 200px;" +
//                "    opacity: 0;" +
//                "}" +
//                ".ele-lottery-slider .ele-lottery-banner-wrap:hover .ele-lottery-ctl-wrap {" +
//                "    opacity: 1;" +
//                "}" +
//                ".ele-lottery-link {" +
//                "    display: block;" +
//                "    width: 40%;" +
//                "    margin: 0 auto 20px;" +
//                "    padding: 2% 1%;" +
//                "    color: #FFF;" +
//                "    font-size: 27px;" +
//                "    text-align: center;" +
//                "    text-decoration: none;" +
//                "}" +
//                ".link-ctl-rule," +
//                ".link-ctl-game {" +
//                "    background-color: #B5271D;" +
//                "    border: solid 1px #CC2D22;" +
//                "}" +
//                ".link-ctl-rule:hover," +
//                ".link-ctl-game:hover {" +
//                "    border: solid 1px #921C12;" +
//                "    background-color: #6E1710;" +
//                "}" +
//                ".link-ctl-gamerule {" +
//                "    border: solid 1px #FFF;" +
//                "}" +
//                ".link-ctl-gamerule:hover {" +
//                "    border: solid 1px rgba(255,255,255,.35);" +
//                "    background-color: rgba(232,232,232,.35);" +
//                "}" +
//                ".ele-lottery-slider img {" +
//                "    cursor: pointer;" +
//                "}" +
//                ".ele-lottery-slider li.preset-banner .ele-item-slidelink {" +
//                "    display: block;" +
//                "    width: 100%;" +
//                "    height: auto;" +
//                "    cursor: pointer;" +
//                "}" +
//                ".ele-lottery-slider li.preset-banner .no-cursor img {" +
//                "    cursor: auto;" +
//                "}" +
//                ".ele-lottery-banner .anythingControls {" +
//                "    position: absolute;" +
//                "    right: 14px;" +
//                "    bottom: 20px;" +
//                "    z-index: 1;" +
//                "}" +
//                ".ele-lottery-banner .anythingControls .thumbNav {" +
//                "    float: left;" +
//                "    height: 28px;" +
//                "    line-height: 28px;" +
//                "    padding: 0 6px;" +
//                "}" +
//                ".ele-lottery-banner .anythingControls .ele-tab-left-bg {" +
//                "    float: left;" +
//                "    width: 4px;" +
//                "    height: 28px;" +
//                "}" +
//                ".ele-lottery-banner .anythingControls .ele-tab-right-bg {" +
//                "    float: left;" +
//                "    width: 4px;" +
//                "    height: 28px;" +
//                "}" +
//                ".ele-lottery-banner .thumbNav li {" +
//                "    display: inline-block;" +
//                "    margin: 0 5px;" +
//                "}" +
//                ".ele-lottery-banner .thumbNav a {" +
//                "    display: block;" +
//                "    height: 10px;" +
//                "    width: 10px;" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/slider_ctrl.png') 0 0 no-repeat;" +
//                "}" +
//                ".ele-lottery-banner .thumbNav a.cur," +
//                ".ele-lottery-banner .thumbNav a:hover {" +
//                "    background-position: 0 100%;" +
//                "}" +
//                ".panel img {" +
//                "    width: 100%;" +
//                "}" +
//                ".slider-bar {" +
//                "    position: absolute;" +
//                "    bottom: 0;" +
//                "    left: 0;" +
//                "    z-index: 5;" +
//                "    display: block;" +
//                "    background: #111;" +
//                "    background: -webkit-gradient(linear, left top, right top, color-stop(50%, #111111), to(rgba(17, 17, 17, 0)));" +
//                "    background: linear-gradient(to right, #111111 50%, rgba(17, 17, 17, 0) 100%);" +
//                "    width: 100%;" +
//                "    font-size: 14px;" +
//                "}" +
//                ".slider-bar-wrap {" +
//                "    width: 100%;" +
//                "    height: 69px;" +
//                "    box-sizing: border-box;" +
//                "    padding: 17px 0 17px 16px;" +
//                "}" +
//                ".slider-bar p {" +
//                "    float: left;" +
//                "    margin-right: 6px;" +
//                "    max-width: 100px;" +
//                "    line-height: 35px;" +
//                "    color: #888;" +
//                "    font-weight: bold;" +
//                "    font-size: 18px;" +
//                "    text-overflow: ellipsis;" +
//                "    overflow: hidden;" +
//                "    white-space: nowrap;" +
//                "}" +
//                ".enter-link-wrap {" +
//                "    float: left;" +
//                "}" +
//                ".slider-bar a {" +
//                "    float: left;" +
//                "    margin-left: 10px;" +
//                "    padding: 0 15px;" +
//                "    box-sizing: border-box;" +
//                "    border-radius: 35px;" +
//                "    border: 1px solid #AAA;" +
//                "    width: 108px;" +
//                "    line-height: 33px;" +
//                "    font-size: 14px;" +
//                "    color: #AAA;" +
//                "    cursor: pointer;" +
//                "    text-align: center;" +
//                "    text-decoration: none;" +
//                "    text-overflow: ellipsis;" +
//                "    overflow: hidden;" +
//                "    white-space: nowrap" +
//                "}" +
//                ".slider-bar a:hover {" +
//                "    color: #333;" +
//                "    background: #DDD;" +
//                "}" +
//                "/* 遊戲專區 */" +
//                ".lottery-hot-game," +
//                ".lottery-betting-game {" +
//                "    margin-bottom: 3px;" +
//                "}" +
//                ".ele-game-header {" +
//                "    margin-bottom: 1px;" +
//                "    padding-left: 12px;" +
//                "    box-sizing: border-box;" +
//                "    background: #2B2B2B;" +
//                "    width: 100%;" +
//                "    height: 30px;" +
//                "    line-height: 30px;" +
//                "}" +
//                ".ele-lottery-gamebox {" +
//                "    box-sizing: border-box;" +
//                "    padding: 12px 0 12px;" +
//                "    background: #2B2B2B;" +
//                "    width: 100%;" +
//                "    height: 141px;" +
//                "}" +
//                ".ele-gamebox-item {" +
//                "    float: left;" +
//                "    margin: 0 5px;" +
//                "    width: 72px;" +
//                "    overflow: hidden;" +
//                "    text-align: center;" +
//                "    word-break: break-word;" +
//                "}" +
//                ".ele-gamebox-item .ele-game-img {" +
//                "    border-radius: 100%;" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_nogame_bg.png') 0 0 no-repeat;" +
//                "    width: 72px;" +
//                "    height: 72px;" +
//                "    background-size: 100%;" +
//                "}" +
//                ".ele-gamebox-item .ele-game-img img {" +
//                "    max-width: 100%;" +
//                "    height: auto;" +
//                "}" +
//                ".ele-gamebox-item .has-game {" +
//                "    box-sizing: border-box;" +
//                "    padding: 2px;" +
//                "    background: #5D5D5D;" +
//                "    overflow: hidden;" +
//                "}" +
//                ".ele-gamebox-item .ele-game-name {" +
//                "    display: block;" +
//                "    margin-top: 6px;" +
//                "    height: 25px;" +
//                "    line-height: 1;" +
//                "    color: #BBB;" +
//                "}" +
//                ".ele-gamebox-item .ele-game-def {" +
//                "    margin: 8px auto;" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_nogame_name.png') 0 0 no-repeat;" +
//                "    width: 28px;" +
//                "    height: 6px;" +
//                "}" +
//                ".ele-gamebox-item.js-item-enter," +
//                ".ele-gamebox-item.js-item-rule {" +
//                "    cursor: pointer;" +
//                "}" +
//                ".ele-gamebox-item.js-item-enter .ele-game-img," +
//                ".ele-gamebox-item.js-item-rule .ele-game-img {" +
//                "    opacity: 0.6;" +
//                "}" +
//                ".ele-gamebox-item.js-item-enter:hover .ele-game-img," +
//                ".ele-gamebox-item.js-item-rule:hover .ele-game-img {" +
//                "    opacity: 1;" +
//                "}" +
//                ".ele-gamebox-item.js-item-enter:hover .ele-game-name," +
//                ".ele-gamebox-item.js-item-rule:hover .ele-game-name {" +
//                "    color: #FFF;" +
//                "}" +
//                ".ele-game-header .title {" +
//                "    float: left;" +
//                "    font-size: 14px;" +
//                "    color: #CCC;" +
//                "}" +
//                ".ele-game-header .btn-wrap {" +
//                "    float: right;" +
//                "}" +
//                "" +
//                ".ele-game-header .left-btn," +
//                ".ele-game-header .right-btn {" +
//                "    float: left;" +
//                "    border: 0;" +
//                "    border-left: 1px solid #333;" +
//                "    background: url('/cl/tpl/template/images/lotteryLobby/lottery_gamebox_ctrl.png') 0 0 no-repeat;" +
//                "    width: 30px;" +
//                "    height: 30px;" +
//                "    outline: none;" +
//                "    cursor: pointer;" +
//                "}" +
//                ".ele-game-header .right-btn {" +
//                "    background-position: -30px 0;" +
//                "}" +
//                ".ele-game-header .left-btn:hover," +
//                ".ele-game-header .right-btn:hover {" +
//                "    background-color: #999;" +
//                "    background-color: rgba(98, 98, 98, 0.5);" +
//                "    background-position-y: bottom;" +
//                "}" +
//                ".ele-game-header .disable {" +
//                "    cursor: default;" +
//                "}" +
//                ".ele-game-header .disable:hover {" +
//                "    background-color: inherit;" +
//                "    background-position-y: top;" +
//                "}" +
//                ".js-game-box {" +
//                "    position: relative;" +
//                "}" +
//                ".ele-gamebox-tips {" +
//                "    position: absolute;" +
//                "    top: 118px;" +
//                "    width: 100%;" +
//                "    z-index: 2;" +
//                "}" +
//                ".zh-cn .ele-gamebox-tips," +
//                ".zh-tw .ele-gamebox-tips {" +
//                "    top: 120px;" +
//                "}" +
//                ".ele-text-wrap {" +
//                "    margin: 0 auto;" +
//                "    text-align: center;" +
//                "    max-width: 323px;" +
//                "}" +
//                ".tips-text {" +
//                "    display: inline-block;" +
//                "    vertical-align: middle;" +
//                "    padding: 0 5px;" +
//                "    background: #2B2B2B;" +
//                "    color: #666;" +
//                "    line-height: 15px;" +
//                "    font-size: 13px;" +
//                "    text-align: center;" +
//                "}" +
//                "" +
//                " @media screen and (max-width: 977px) {" +
//                "    .entrance-wrap .entrance-left {" +
//                "        margin: 0;" +
//                "        padding-right: 0.34%;" +
//                "    }" +
//                "    .entrance-wrap .entrance-right {" +
//                "        margin: 0;" +
//                "        padding-left: 0.33%;" +
//                "    }" +
//                "    .ele-lottery-mobile {" +
//                "        margin-left: 0;" +
//                "        float: right;" +
//                "    }" +
//                "    .slider-bar a {" +
//                "        width: 95px;" +
//                "    }" +
//                " }" +
//                "" +
//                " @media screen and (max-width: 768px) {" +
//                "    .teaching-alert-wrap {" +
//                "        width: 99%;" +
//                "    }" +
//                "    .slider-bar {" +
//                "        height: auto;" +
//                "    }" +
//                "    .slider-bar-wrap {" +
//                "        padding: 0;" +
//                "        height: auto;" +
//                "    }" +
//                "    .enter-link-wrap {" +
//                "        width: 100%;" +
//                "    }" +
//                "    .slider-bar p," +
//                "    .slider-bar a," +
//                "    .js-item-gamerule {" +
//                "        display: none;" +
//                "    }" +
//                "    .slider-bar a {" +
//                "        margin: 0;" +
//                "        box-sizing: border-box;" +
//                "        padding: 0;" +
//                "        border: 0;" +
//                "        border-radius: 0;" +
//                "        background: #222;" +
//                "        width: 33.3%;" +
//                "        height: 44px;" +
//                "        line-height: 44px;" +
//                "        text-align: center;" +
//                "    }" +
//                "    .slider-bar a.list-btn-1," +
//                "    .slider-bar a.list-btn-2," +
//                "    .slider-bar a.list-btn-3 {" +
//                "        display: block;" +
//                "    }" +
//                "    .slider-bar a.list-btn-1," +
//                "    .slider-bar a.list-btn-2 {" +
//                "        border-right: 2px solid #333333;" +
//                "    }" +
//                "    .slider-bar .item-quantity-1 a {" +
//                "        width: 100%;" +
//                "    }" +
//                "    .slider-bar .item-quantity-2 a {" +
//                "        width: 50%;" +
//                "    }" +
//                "    .slider-bar .item-quantity-3 a {" +
//                "        width: 33.33%;" +
//                "    }" +
//                "    .slider-bar .item-quantity-1 a.list-btn-1," +
//                "    .slider-bar .item-quantity-2 a.list-btn-2 {" +
//                "        border-right: 0;" +
//                "    }" +
//                "    .ele-lottery-banner .anythingControls {" +
//                "        bottom: 45px;" +
//                "    }" +
//                "    .ele-lotteryHALL-wrap {" +
//                "        padding: 0;" +
//                "    }" +
//                "    .entrance-wrap," +
//                "    .ele-lottery-mobile {" +
//                "        width: 100%;" +
//                "    }" +
//                "    .entrance-wrap .ele-lottery-entrance {" +
//                "        margin-bottom: 5px;" +
//                "    }" +
//                "    .entrance-wrap .entrance-right {" +
//                "        margin-right: 0;" +
//                "        padding-left: 0;" +
//                "    }" +
//                "    .ele-lottery-game .ele-item-left {" +
//                "        max-width: 50%;" +
//                "    }" +
//                "    .ele-lottery-game .has-timer .ele-item-left {" +
//                "        max-width: 37%;" +
//                "    }" +
//                "    .ele-lottery-mobile {" +
//                "        margin-left: 0;" +
//                "        max-width: none;" +
//                "        width: 100%;" +
//                "    }" +
//                "    .ele-lottery-mobile img {" +
//                "        position: inherit;" +
//                "        margin-left: 0;" +
//                "        width: 100%;" +
//                "    }" +
//                " }" +
//                " @media screen and (max-width: 480px) {" +
//                "     .slider-bar a {" +
//                "         height: 35px;" +
//                "         line-height: 35px;" +
//                "     }" +
//                "     .ele-lottery-banner .anythingControls {" +
//                "        right: 3px;" +
//                "        bottom: 28px;" +
//                "     }" +
//                "    .ele-lotteryHALL-wrap {" +
//                "        min-width: 320px;" +
//                "    }" +
//                "    .entrance-wrap .ele-lottery-entrance {" +
//                "        padding-right: 0;" +
//                "        width: 100%;" +
//                "    }" +
//                "    .ele-lottery-hall .more-games {" +
//                "        margin-top: -19px;" +
//                "        top: 50%;" +
//                "        right: 7%;" +
//                "    }" +
//                "    .ele-game-header {" +
//                "        height: 44px;" +
//                "        line-height: 44px;" +
//                "    }" +
//                "    .ele-game-header .title {" +
//                "        font-size: 16px;" +
//                "    }" +
//                "    .ele-game-header .left-btn," +
//                "    .ele-game-header .right-btn {" +
//                "        background: url('/cl/tpl/template/images/lotteryLobby/lottery_gamebox_ctrl_m.png') 0 0 no-repeat;" +
//                "        width: 44px;" +
//                "        height: 44px;" +
//                "    }" +
//                "    .ele-game-header .right-btn {" +
//                "        background-position: 100% 0;" +
//                "    }" +
//                "    .ele-gamebox-item {" +
//                "        width: 89px;" +
//                "    }" +
//                "    .ele-gamebox-item .ele-game-img {" +
//                "        width: 89px;" +
//                "        height: 89px;" +
//                "    }" +
//                "    .ele-lottery-gamebox {" +
//                "        height: 154px;" +
//                "    }" +
//                "    .ele-gamebox-tips {" +
//                "        top: 148px;" +
//                "    }" +
//                " }</style><body><div id=\"ele-lottery-antehall-wrap\" class=\"ele-lotteryHALL-wrap clearfix\"><!-- 彩票頁面 --><div id=\"ele-lottery-layout\" class=\"ele-lottery-layout clearfix\"><div id=\"ele-lottery-menu\" class=\"ele-lottery-menu\"><div id=\"ele-menu-item\"><a  href=\"/cl/?module=System&amp;method=Ltlottery\" title=\"BB彩票\">BB彩票</a><a  href=\"javascript:void window.open('https://lt.888aad.com/vr/vender?lang=zh-cn', 'vrlottery');\" title=\"VR彩票\">VR彩票</a></div></div><div id=\"js-ele-lottery-banner\" class=\"ele-lottery-slider ele-lottery-banner\"><ul id=\"js-ele-lottery-slider\" className=\"ele-lottery-slider\"></ul></div><div class=\"entrance-wrap\"><div id=\"lotter-official\" class=\"official ele-lottery-entrance entrance-left\"><div class=\"ele-lottery-hall\"><h1>官方版</h1><div class=\"more-games\" data-ga=\"更多游戏\" data-type=\"OFFICIAL\" title=\"更多游戏\">更多游戏</div><p>群组投注，少走弯路。</p></div><div class=\"ele-lottery-game\"><ul></ul></div></div><div id=\"lotter-tradition\" class=\"tradition ele-lottery-entrance entrance-right\"><div class=\"ele-lottery-hall\"><h1>传统版</h1><div class=\"more-games\" data-ga=\"更多游戏\" data-type=\"TRADITIONAL\" title=\"更多游戏\">更多游戏</div><p>彩种齐全，历久不衰。</p></div><div class=\"ele-lottery-game\"><ul></ul></div></div><div id=\"lottery-gamebox\" class=\"ele-lottery-entrance\"><!-- 熱門遊戲 --><div class=\"js-game-box lottery-hot-game clearfix\" id=\"lottery_hots\"><div class=\"ele-game-header\"><span class=\"title\">热门游戏</span><div class=\"btn-wrap\"><input type=\"button\" class=\"left-btn\"></input><input type=\"button\" class=\"right-btn\"></input></div></div><div class=\"ele-lottery-gamebox\"><div class=\"ele-gamebox-wrap\"></div></div></div><!-- 最近下注 --><div class=\"js-game-box lottery-betting-game  clearfix\" id=\"lottery_latest_bet\"><div class=\"ele-game-header\"><span class=\"title\">最近下注</span><div class=\"btn-wrap\"><input type=\"button\" class=\"left-btn\"></input><input type=\"button\" class=\"right-btn\"></input></div></div><div class=\"ele-lottery-gamebox\"><div class=\"ele-gamebox-wrap\"></div></div></div><!-- 我的最愛 --><div class=\"js-game-box lottery-love-game  clearfix\" id=\"lottery_favorites\"><div class=\"ele-game-header clearfix\"><span class=\"title\">我的最爱</span><div class=\"btn-wrap\"><input type=\"button\" class=\"left-btn\"></input><input type=\"button\" class=\"right-btn\"></input></div></div><div class=\"ele-lottery-gamebox\"><div class=\"ele-gamebox-wrap\"></div></div></div></div></div><a class=\"ele-lottery-mobile\" href=\"###\" onclick=\"f_com.bm('/infe/rmobile', 'MOBLILE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});\"><img src=\"/cl/tpl/template/images/lotteryLobby/lang/zh-cn/lottery_mobile_l.jpg\" alt=\"\"></a><!-- 遮罩Mask_Loadding --><div id=\"spin-mask-wrap\"></div><!-- 投注入門 ALERT --><div id=\"js-teaching-alert\" class=\"teaching-alert-bg\"><div class=\"teaching-alert-wrap\"><img id=\"js-teaching-pic\" class=\"teaching-image\" src=\"\"/><img id=\"js-close-teaching\" class=\"close-btn\" src=\"/cl/tpl/template/images/element/lottery_banner/gamerule_btn_close.png\" href=\"###\"/></div></div></div></div></body><!--未登入彈跳視窗--><script src=\"/cl/js/pluging/spin.min.js\"></script><script src=\"/cl/js/pluging/jquery.spin.js\"></script><script src=\"/cl/js/pluging/jquery.iosslider.min.js\"></script><script>window.jQuery.anythingSlider || document.write('<script src=\"/cl/js/pluging/jquery.anythingslider1.9.4.js?v=ver112.138\"><\\/script>')</script><script>/* 參數設定 */var loginStatus = \"Y\",lang = \"zh-cn\",lt_link = \"https://lt.888aad.com\",identifyID = (loginStatus === \"Y\") ? \"341049084\" : \"3820179\",lottery_login = \"请先登入\",is_mobile = \"1\",ls_api = \"\",is_open_teaching = false,mobile_web_link = \"/infe/rmobile\",mobile_phone_link = \"/infe/rule/mobile/check\",dictionary = {S_BET_REAL_ORDER: \"进入游戏\",S_LTLOTTER_HOW: \"投注入门\",S_BM_GAME_RULE: \"游戏规则\",S_VER_OFFICIAL: \"官方版\",S_VER_TRADITIONAL: \"传统版\",S_LOTTERY_BAT1: \"试试手气蹭钱去\",S_LOTTERY_BAT2: \"长龙路纸财靠谱\",S_LOTTERY_LOVE1: \"标记我的最爱\",S_LOTTERY_LOVE2: \"随点随上你的菜\"};/* 如果被登出就重整 */setInterval(function() {if(!$.cookie('LOGINCHK') || $.cookie('LOGINCHK') == \"N\" ) {location.reload(true);}}, 5000);</script><script src=\"/cl/js/tools/lottery-antehall.min.js?v=ver112.138\"></script><script type=\"text/javascript\">$(function() {/* ChangeToggle 大版面為true、小版面為false */var ChangeToggle = !(window.innerWidth < 769);/* RWD change 手機下注圖片 */mobileChange = function() {if(window.innerWidth < 769 && ChangeToggle) {var imgMobile = is_mobile ? 'lottery_mobile' : 'lottery';$('.ele-lottery-mobile img').attr({src: '/cl/tpl/template/images/lotteryLobby/lang/zh-cn/' + imgMobile + '.jpg'});ChangeToggle = false;}if(window.innerWidth >= 769 && !ChangeToggle) {var imgMobile = is_mobile ? 'lottery_mobile_l' : 'lottery_l';$('.ele-lottery-mobile img').attr({src: '/cl/tpl/template/images/lotteryLobby/lang/zh-cn/'+ imgMobile + '.jpg'});ChangeToggle = true;}};mobileChange();$( window ).resize(function() {mobileChange();});});</script>    </div>" +
//                "</div>            <div id=\"page-footer\">" +
//                "    <div class=\"footer clearfix\">" +
//                "        <div class=\"footer-top-text clearfix\">" +
//                "            <span class=\"footer-tel\">00853-63068555</span>" +
//                "            <span class=\"footer-mail\">help888d@gmail.com</span>" +
//                "            <span class=\"footer-qq\">1226663338</span>" +
//                "            <span class=\"footer-service\">7×24小时在线客服</span>" +
//                "        </div>" +
//                "        <div class=\"footer-logo-wrap clearfix\">" +
//                "            <a id=\"bblogo\">" +
//                "                <img src=\"https://p1.xf0371.com/cl/tpl/commonFile/images/bbinlogo/white.png?v=ver112.138\" border=\"0\" width=\"80\" />" +
//                "            </a>" +
//                "            <a id=\"browser-logo\" href=\"javascript:f_com.bm('/infe/ub2/index.html', 'UB_BROWSE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});\"></a>" +
//                "        </div>" +
//                "        <div class=\"article-menu\">" +
//                "                            <a href='/cl/?module=System&method=MAdvertis&other=AT1' target='mem_index' data-color=\"\" class=\"js-article-color\">" +
//                "                    关于我们" +
//                "                </a>" +
//                "                /                            <a href='/cl/?module=System&method=MAdvertis&other=AT2' target='mem_index' data-color=\"\" class=\"js-article-color\">" +
//                "                    联系我们" +
//                "                </a>" +
//                "                /                            <a href='/cl/?module=System&method=MAdvertis&other=AT3' target='mem_index' data-color=\"#FF0A0A|#FEF025\" class=\"js-article-color\">" +
//                "                    合作伙伴" +
//                "                </a>" +
//                "                /                            <a href='/cl/?module=System&method=MAdvertis&other=AT4' target='mem_index' data-color=\"\" class=\"js-article-color\">" +
//                "                    存款幫助" +
//                "                </a>" +
//                "                /                            <a href='/cl/?module=System&method=MAdvertis&other=AT5' target='mem_index' data-color=\"\" class=\"js-article-color\">" +
//                "                    取款幫助" +
//                "                </a>" +
//                "                /                            <a href='/cl/?module=System&method=MAdvertis&other=AT6' target='mem_index' data-color=\"\" class=\"js-article-color\">" +
//                "                    常见问题" +
//                "                </a>" +
//                "                                    </div>" +
//                "        <div class=\"copyright\">Copyright &copy; 888真人官网直营 Reserved</div>" +
//                "        <div class=\"footer-info\"></div>" +
//                "    </div>" +
//                "</div>" +
//                "        </div>" +
//                "        " +
//                "" +
//                "    <ul id=\"TplFloatPic_0\" class=\"TplFloatSet\" style=\"position:absolute;cursor:pointer;display:none;\" picfloat=\"left\" class=\"png_fix\">" +
//                "        <li><a  href=\"/cl/?module=System&method=Game&gameHall=23\" target=\"mem_index\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986742311.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986742311.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a  href=\"https://www.hb8zr.com/\" target=\"_blank\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/917838/images/152016102142.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/917838/images/152016102142.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a href=\"javascript:window.open('/infe/mcenter/paybitcoin/#/deposit/payfast', 'payquick').focus();\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/610353/images/148345088871.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/610353/images/148345088871.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a href=\"javascript:downloadvwin();\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986750391.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986750391.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a href=\"###\" onclick=\"FloatClose(this);\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986752999.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986752999.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "    </ul>" +
//                "    <ul id=\"TplFloatPic_1\" class=\"TplFloatSet\" style=\"position:absolute;cursor:pointer;display:none;\" picfloat=\"right\" class=\"png_fix\">" +
//                "        <li><a  href=\"https://messenger3.providesupport.com/messenger/0loqkm6dbwn5s083zoft54cukx.html\" target=\"_blank\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986757661.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986757661.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a  href=\"http://www.hd888d.com\" target=\"_blank\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986760015.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986760015.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a  href=\"https://messenger3.providesupport.com/messenger/0loqkm6dbwn5s083zoft54cukx.html\" target=\"_blank\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/835576/images/151149360733.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/835576/images/151149360733.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "        <li><a href=\"###\" onclick=\"FloatClose(this);\">" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986764065.png?877420\" align=\"center\" alt=\"\" class=\"png_fix\"/>" +
//                "        <img src=\"https://cdn.xf0371.com/tpl/1281/513839/images/146986764065.png?877420\" align=\"center\" style=\"display:none;\" alt=\"\" class=\"png_fix\"/>" +
//                "    </a></li>" +
//                "    </ul>" +
//                "<style>" +
//                "    .TplFloatSet a{display:block;margin:0 auto;text-align:center;}" +
//                "    .TplFloatSet img{vertical-align:bottom;}" +
//                "    .TplFloatSet li{list-style: none;font-size:0px;}" +
//                "</style>" +
//                "<script>" +
//                "    //關閉效果" +
//                "    function FloatClose(t){ event.cancelBubble = true;$(t).parents('.TplFloatSet').hide(); }" +
//                "    var left_top = 150, right_top = 150, float_list = [], float_side = 5;" +
//                "    $(window).load(function() {" +
//                "        // 廳主自改 - 浮動圖V2 -2013.7.19" +
//                "                    float_list['0'] = $('#TplFloatPic_0');" +
//                "                    float_list['1'] = $('#TplFloatPic_1');" +
//                "                for (var i in float_list) {" +
//                "            if (float_list[i].attr == undefined) {" +
//                "                continue;" +
//                "            }" +
//                "            var self = float_list[i], " +
//                "                picfloat = (self.attr('picfloat') == 'right') ? 1 : 0;" +
//                "            self.show().Float({'floatRight' : picfloat, 'topSide' : ((picfloat == 1) ? right_top : left_top), side: float_side});" +
//                "            var w = 0;        " +
//                "            $.each(self.find('img'), function(){" +
//                "                var width = $(this).width();" +
//                "                w = (width > w) ? width : w;//取圖片最大寬度" +
//                "                $(this).attr({" +
//                "                    'width' : width," +
//                "                    'height': $(this).height()" +
//                "                });" +
//                "            });" +
//                "            self.css('width', w);" +
//                "            if (picfloat) {" +
//                "                right_top = right_top + 10 + (self.height() || 250);" +
//                "            } else {" +
//                "                left_top = left_top + 10 + (self.height() || 250);" +
//                "            }" +
//                "" +
//                "            $('a', self).each(function(){" +
//                "                $(this).css({'width' : $(this).find('img:first').width(),'height' : $(this).find('img:first').height()});" +
//                "                $(this).hover(function() {" +
//                "                $(this).find('img:first').hide();" +
//                "                    $(this).find('img:last').show();" +
//                "                }, function() {" +
//                "                $(this).find('img:last').hide();" +
//                "                    $(this).find('img:first').show();" +
//                "                });" +
//                "            });" +
//                "        }" +
//                "    });" +
//                "</script>" +
//                "                <style>#ele-float-top-wrap {position: fixed;right: 5px;bottom: 51px;min-width: 40px;z-index: 20;}#ele-float-top{position: absolute;left: 0px;top: 0px;width: 40px;display: none;}.ele-float-top-btn {margin-top: 2px;display: block;position: relative;height: 40px;border-radius: 3px;transition: opacity 0.6s ease;background-color: white;background-position: 50% 0;background-repeat: no-repeat;-ms-filter: progid:DXImageTransform.Microsoft.Alpha(opacity=80);filter: alpha(opacity=80);opacity: 0.8;}#ele-float-top-up {display: none;cursor: pointer;margin-top: -40px;background-image: url('/cl/tpl/template/images/element/float_top/black/float_top_up.png');}.ele-float-top-btn:hover {-ms-filter: progid:DXImageTransform.Microsoft.Alpha(opacity=100);filter: alpha(opacity=100);opacity: 1;background-position: 50% 100%;}.ele-float-top-code {position: relative;background-image: url('/cl/tpl/template/images/element/float_top/black/float_top_code.png');}.float-top-service {background-image: url('/cl/tpl/template/images/element/float_top/black/float_top_service.png');}.float-top-qq {background-image: url('/cl/tpl/template/images/element/float_top/black/float_top_qq.png');}.float-top-custom {}/* 懸浮框 */.ele-float-box-wrap {display: none;position: absolute;right: 40px;bottom: 0;padding-right: 10px;width: 150px;}.ele-float-top-code-box {height: 185px;background: #FFF url() 50% 50% no-repeat;border-radius: 3px;}.ele-float-top-qq-box {height: 185px;background: #FFF url() 50% 50% no-repeat;border-radius: 3px;}.ele-float-top-code-box:after,.ele-float-top-qq-box:after {content: '';position: absolute;right: -6px;bottom: 8px;border: 8px solid transparent;border-left: 8px solid #FFF;}.ele-float-top-code-box:before,.ele-float-top-qq-box:before {content: '';position: absolute;bottom: 18px;display: block;width: 100%;line-height: 18px;color: #000;font-size: 14px;font-family: arial;text-align: center;}#ele-float-btn-vip.ele-float-top-code-box,#ele-float-btn-vip.ele-float-top-qq-box {position: absolute;bottom: -16px;right: -1px;width: 146px;height: 300px;background: url(/cl/tpl/template/images/element/float_top/lang/zh-cn/float_vip_bg.png);}.ele-float-vip-code {margin: 65px 0 0 5px;width: 130px;height: 108px;background-image: url(/cl/?module=MCache&method=vip_qrcode&args=2);background-position: 50% 50%;background-repeat: no-repeat;}.ele-float-top-code-box#ele-float-btn-vip:after,.ele-float-top-qq-box#ele-float-btn-vip:after,.ele-float-top-code-box#ele-float-btn-vip:before,.ele-float-top-qq-box#ele-float-btn-vip:before {display: none;}</style><div id=\"ele-float-top-wrap\"><div id=\"ele-float-top\"><div id=\"ele-float-top-up\" class=\"ele-float-top-btn\"></div></div></div><!-- 新版廣宣 --><!-- 3820327因不顯示bbin字樣,所以不顯示右下角廣宣 --><!-- 右下角廣宣-START --><style>" +
//                "    /* BBin資訊站 */" +
//                "    @keyframes hoverEff{" +
//                "        0%   { transform: scale(1); }" +
//                "        50%  { transform: scale(1.2); }" +
//                "        100% { transform: scale(1); }" +
//                "    }" +
//                "    @-webkit-keyframes hoverEff{" +
//                "        0%   { transform: scale(1); }" +
//                "        50%  { transform: scale(1.2); }" +
//                "        100% { transform: scale(1); }" +
//                "    }" +
//                "    .bbininfo-wrap {" +
//                "        position: fixed;" +
//                "                right: -256px;" +
//                "                bottom: 3px;" +
//                "        z-index: 999;" +
//                "    }" +
//                "    .btn-bbininfo {" +
//                "        display: block;" +
//                "        position: relative;" +
//                "        right: 0;" +
//                "    }" +
//                "    .bbin-toppic {" +
//                "        display: none;" +
//                "        width: 301px;" +
//                "        height: 48px;" +
//                "        cursor: pointer;" +
//                "    }" +
//                "    a.bbin-toppic.no-link {" +
//                "        cursor: default;" +
//                "    }" +
//                "" +
//                "    @keyframes bbinactive" +
//                "    {" +
//                "        0%   { margin-bottom: 0; }" +
//                "        25%  { margin-bottom: 3px; }" +
//                "        50%  { margin-bottom: 0; }" +
//                "        75%  { margin-bottom: 3px; }" +
//                "        100% { margin-bottom: 0; }" +
//                "    }" +
//                "" +
//                "    @-moz-keyframes bbinactive /* Firefox */" +
//                "    {" +
//                "        0%   { margin-bottom: 0; }" +
//                "        25%  { margin-bottom: 3px; }" +
//                "        50%  { margin-bottom: 0; }" +
//                "        75%  { margin-bottom: 3px; }" +
//                "        100% { margin-bottom: 0; }" +
//                "    }" +
//                "" +
//                "    @-webkit-keyframes bbinactive /* Safari 和 Chrome */" +
//                "    {" +
//                "        0%   { margin-bottom: 0; }" +
//                "        25%  { margin-bottom: 3px; }" +
//                "        50%  { margin-bottom: 0; }" +
//                "        75%  { margin-bottom: 3px; }" +
//                "        100% { margin-bottom: 0; }" +
//                "    }" +
//                "" +
//                "    @-o-keyframes bbinactive /* Opera */" +
//                "    {" +
//                "        0%   { margin-bottom: 0; }" +
//                "        25%  { margin-bottom: 3px; }" +
//                "        50%  { margin-bottom: 0; }" +
//                "        75%  { margin-bottom: 3px; }" +
//                "        100% { margin-bottom: 0; }" +
//                "    }" +
//                "    .bbin-jump .bbininfo-slide-active {" +
//                "        animation: bbinactive 1s;" +
//                "        -moz-animation: bbinactive 1s; /* Firefox */" +
//                "        -webkit-animation: bbinactive 1s;  /* Safari 和 Chrome */" +
//                "        -o-animation: bbinactive 1s;   /* Opera */" +
//                "    }" +
//                "    .bbininfo-slide-active {" +
//                "        display: block;" +
//                "    }" +
//                "    .bbininfo-close {" +
//                "        position: absolute;" +
//                "        width: 20px;" +
//                "        height: 20px;" +
//                "        top: 8px;" +
//                "        right: 4px;" +
//                "        z-index: 3;" +
//                "        cursor: pointer;" +
//                "        background: url(/cl/tpl/template/images/BBinInfo/bbin_close.png) 50% 50% no-repeat;" +
//                "    }" +
//                "    .bbininfo-close:hover {" +
//                "        animation: hoverEff .8s linear;" +
//                "        -webkit-animation: hoverEff .8s linear;" +
//                "    }" +
//                "</style>" +
//                "" +
//                "" +
//                "<div class=\"bbininfo-wrap\">" +
//                "    <div class=\"btn-bbininfo bbin-downpic bbin-jump\">" +
//                "        <div id=\"bbininfo-btn-close\" class=\"bbininfo-close\"></div>" +
//                "        <div id=\"bbininfo-slidebox\"></div>" +
//                "    </div>" +
//                "</div>" +
//                "<script>" +
//                "    $(function() {" +
//                "        // 語系" +
//                "        var lang = 'zh-cn';" +
//                "        // 頁面名稱" +
//                "        var pageSite = 'ltlottery';" +
//                "        // moblie Switch" +
//                "        var mobile_switch = '1'" +
//                "" +
//                "        var wrap=$(\".bbininfo-wrap\"),bbinBtn=$(\".btn-bbininfo\");function picIn(){wrap.stop().animate({right:\"-256px\"},1500,function(){bbinBtn.addClass(\"bbin-jump\")})}function picOut(){bbinBtn.removeClass(\"bbin-jump\"),wrap.stop().animate({right:$(this).css(\"right\")},750)}function bbfadeOut(){$(\".bbin-toppic\").stop().animate({opacity:0},1e3,bbfadeIn)}function bbfadeIn(){$(\".bbin-toppic\").stop().animate({opacity:1},1e3,bbfadeOut)}function togglePic(i,n,t,e){var a=this;a._i=0,a._timer=null,x=n[0],y=n[1],a.run=function(){n[a._i]&&$(i).css(t,n[a._i]),0==a._i?a._i++:a._i=0,a._timer=setTimeout(function(){a.run(i,n,e)},e)},a.run()}function bbinfoSlider(){if($(\".bbin-toppic\").eq(0).addClass(\"bbininfo-slide-active\"),!($(\".bbin-toppic\").length<=1)){var i,n=1e3;/msie\\s[1-8][^\\d]/i.test(navigator.userAgent)&&(n=1),setInterval(function(){0===(i=$(\".bbininfo-slide-active\").next(\".bbin-toppic\")).length&&(i=$(\".bbin-toppic\").eq(0)),$(\".bbininfo-slide-active\").fadeOut(n),i.css({position:\"absolute\",bottom:0,left:0,\"z-index\":2}).fadeIn(n,function(){$(this).css({position:\"static\",display:\"block\",\"z-index\":1}),$(\".bbininfo-slide-active\").removeClass(\"bbininfo-slide-active\"),$(this).addClass(\"bbininfo-slide-active\")})},5e3)}}\"first\"===pageSite&&setTimeout(function(){picIn()},1e3),bbinBtn.hover(picOut,picIn),$(\"#bbininfo-btn-close\").click(function(){wrap.css({display:\"none\"})}),$.ajax({url:\"/infe/rest/fig/advertise/common.json\",data:{mobile_open:mobile_switch},success:function(i){if(\"Y\"===i.status){if(200===i.code){for(var n,t,e,a=[],o=i.data.length,s=0;s<o;s++){switch(t=[\"bbininfo-box\",\"bbin-toppic\"],e=void 0===i.data[s].image.size301X48[lang]?i.data[s].image.size301X48.en:i.data[s].image.size301X48[lang],i.data[s].openType){case\"defaultAd\":t.push(\"default-ad\");case\"none\":t.push(\"no-link\"),n='href=\"###\"';break;case\"self\":n='href=\"'+i.data[s].openLink+\"\\\" target=\\\"mem_index\\\" onclick=\\\"bbinAnalytics('廣宣', '右下角廣宣', '\"+i.data[s].title+\"');\\\"\";break;case\"top\":n='href=\"'+i.data[s].openLink+\"\\\" target=\\\"_top\\\" onclick=\\\"bbinAnalytics('廣宣', '右下角廣宣', '\"+i.data[s].title+\"');\\\"\";break;case\"blank\":n='href=\"'+i.data[s].openLink+'\" target=\"'+(\"\"===i.data[s].openOption.name?\"tabWin\":i.data[s].openOption.name)+\"\\\" onclick=\\\"bbinAnalytics('廣宣', '右下角廣宣', '\"+i.data[s].title+\"');\\\"\";break;default:var b={analytics:!0,analyticsLocation:\"右下角廣宣\",analyticsName:i.data[s].title,link:i.data[s].openLink,name:i.data[s].openOption.name,openOption:{width:i.data[s].openOption.width,height:i.data[s].openOption.height}};n='href=\"###\" onclick=\\'f_com.advertise('+JSON.stringify(b)+\")'\"}a.push('<a class=\"'+t.join(\" \")+'\" '+n+'><img class=\"default-style\" src=\"'+e+'\" /></a>')}$(\"#bbininfo-slidebox\").html(a.join(\"\"))}}else console.log(i.code,i.message)},error:function(i,n,t){console.log(\"ad lowerright api error\")},complete:function(){bbinfoSlider()}});    });" +
//                "</script><!-- 右下角廣宣-END --><script src=\"/cl/js/pluging/jquery.easing.1.3.min.js?v=ver112.138\"></script><script type=\"text/javascript\">if ('undefined' != typeof($)) {$(function(){var btnNum = $('#ele-float-top').children().length,wrap = $('#ele-float-top-wrap'),wrapHeight = (btnNum - 1) * (40 + 2),gotop = $('#ele-float-top-up'),speedSet = 300,thebox = $('.ele-float-box-wrap'),boxwrap = '',goTopSwitch = \"N\";/*if(navigator.userAgent.indexOf(\"MSIE\") != -1) {}*/wrap.height(wrapHeight);if(wrap.height() == wrapHeight && goTopSwitch !== 'Y'){$('#ele-float-top').show();}$('.ele-float-top-code').hover(function(){$(this).children(thebox).stop(true, true).fadeIn(speedSet);},function(){$(this).children(thebox).stop(true, true).fadeOut(speedSet);});$('.float-top-qq').hover(function(){$(this).children(thebox).stop(true, true).fadeIn(speedSet);},function(){$(this).children(thebox).stop(true, true).fadeOut(speedSet);});$(\"#ele-float-top-up\").click(function(){$('html,body').animate( {scrollTop:0}, 1000, 'easeOutExpo' );});$(window).scroll(function() {if(navigator.userAgent.indexOf(\"MSIE\") != -1) {var fadeSec = 200;}else{var fadeSec = 300;}if ( $(this).scrollTop() > 300){$('#ele-float-top-up').fadeIn(fadeSec);} else {$('#ele-float-top-up').stop().fadeOut(fadeSec);}});});}</script>        <script src=\"/cl/js/tools/common.min.js?v=ver112.138\"></script>" +
//                "    <script>function cancelMouse() {return false;}" +
//                "document.oncontextmenu = cancelMouse;" +
//                "" +
//                "$(function(){" +
//                "    //固定主選單" +
//                "    $(\"#navfixed\").navFixed();" +
//                "    //固定登入框" +
//                "    $(\"#loginfixed\").navFixed({fixedTop:111});" +
//                "});" +
//                "// 下載版JS" +
//                "function downloadvwin() {" +
//                "    f_com.BBinEnterPager('BBinInfo', 'outDrug');" +
//                "}" +
//                "" +
//                "// 優惠傳值開指定序號" +
//                "f_com.getMemberExclusiveNo = function(no) {" +
//                "    top.mem_index.location.href = '/cl/?module=System&method=MAdvertis&other=MemberExclusiveII&ExclusiveNo='+no;" +
//                "};" +
//                "" +
//                "    </script>" +
//                "</body>" +
//                "</html>" +
//                "" +
//                "<!--[if (IE 7)|(IE 6)]>" +
//                "<script>var downloadNewIE;if('undefined'!=typeof downloadvwin){downloadNewIE=downloadvwin}else{downloadNewIE=function(){window.open('http://windows.microsoft.com/en-us/internet-explorer/downloads/ie-8')}}</script><div id=\"ie6-alertBox\"> <div id=\"ie6-infoBar\">  系统侦测到您使用旧版浏览器,<span class=\"alert\">本站预计于 2014/1/1 停止对 IE6 , IE7 维护与支援</span>,为了体验最佳的浏览品质与效果,建议立即至<a href=\"javascript:downloadNewIE();\">「下载区」</a>升级您的浏览器。  </div> <a href=\"javascript:closeDialog();\" id=\"ie6-alertBoxClose\"> 關閉  </a> </div> <div id=\"ie6-overlay\"></div><style type=\"text/css\">html{overflow-y:hidden}.alert{color:red}#ie6-overlay{background:#777;filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=50);-ms-filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=50);-moz-opacity:.5;opacity:.5;position:absolute;top:0;left:0;z-index:10}#ie6-alertBox{position:absolute;font-size:13px;width:300px;height:auto;padding:10px 10px 30px;left:50%;top:40%;line-height:25px;margin-left:-160px;z-index:11;color:#000;border:1px solid #777;background-color:#CCC;background-image:-moz-linear-gradient(top,white,#CCC);background-image:-webkit-gradient(linear,0 0,0 100%,from(white),to(#CCC));background-image:-webkit-linear-gradient(top,white,#CCC);background-image:-o-linear-gradient(top,white,#CCC);background-image:linear-gradient(to bottom,white,#CCC);background-repeat:repeat-x;-webkit-box-shadow:0 1px 4px rgba(0,0,0,0.065);-moz-box-shadow:0 1px 4px rgba(0,0,0,0.065);box-shadow:0 1px 4px rgba(0,0,0,0.065);border:1px solid #D4D4D4;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFFFF',endColorstr='#CCCCCC',GradientType=0);display:none}#ie6-infoBar a,#ie6-alertBoxClose{color:#F57900;text-decoration:none}#ie6-infoBar a:hover,#ie6-alertBoxClose:hover{color:#FF9A37}#ie6-alertBoxClose{position:absolute;right:5px;bottom:5px;display:none}</style><script>function closeDialog(target){$(\"#ie6-alertBox,#ie6-overlay\").hide();$('html').css('overflow-y','auto');if('undefined'==typeof($.cookie)){document.cookie=\"ie6close=on;path=/;\"}else{$.cookie('ie6close','on',{path:'/',expires:''})}}function showalert(){$(\"#ie6-overlay\").height($(window).height()).width($(window).width());$(\"#ie6-alertBox\").slideToggle(1000,function(){setTimeout('$(\"#ie6-alertBoxClose\").fadeIn();',3000)})}$(function(){if('undefined'==typeof($.cookie)){if(!/ie6close/.test(document.cookie)){showalert()}}else{if($.cookie('ie6close')!='on'){showalert()}}});</script>" +
//                "<!--><!--<![endif]-->" +
//                "" +
//                "<!--IE11提示訊息 2015/12/31 -->" +
//                "<!--[if IE 8]>" +
//                "<style>.ie11-alert-wrap{position:fixed;top:0;left:0;z-index:5000;width:100%;height:100%;color:#FFF;text-align:center;font-size:12px;font-family:\"Microsoft YaHei\",\"微软雅黑\",arial;background:url(/cl/tpl/template/images/ie11alert/bg_ie_full.png) repeat center top}.zh-cn .ie11-alert-wrap{font-family:\"Microsoft YaHei\",\"微软雅黑\",arial}.zh-tw .ie11-alert-wrap{font-family:\"Microsoft JhengHei\",\"微軟正黑體\",arial}.ie11-alert-bg{width:100%;height:100%;background:url(/cl/tpl/template/images/ie11alert/bg_ie_logo.png) no-repeat 50% 10%}.ie11-alert-easing{position:absolute;top:30%;left:50%;text-align:center;width:600px;margin:0 0 0 -300px}.ie11-alert-container-title{color:#06BDF7;font-size:30px}.ie11-alert-container-middle{line-height:30px;color:#FFF;font-size:16px;margin:20px 0 50px}.ie11-alert-message{display:none}.ie11-alert-btn-wrap{font-size:0}.ie11-alert-btn{display:inline-block;vertical-align:top;cursor:pointer;width:256px;height:115px;color:#FFF;font-size:12px;text-align:left;box-sizing:border-box;padding:24px 14px 34px 95px}.ie11-alert-btn:hover{background-position:left bottom}.ie11-alert-btn-ie{display:none;font-size:34px;font-family:arial;background:url(/cl/tpl/template/images/ie11alert/btn_IE.png) no-repeat left top;padding:19px 14px 34px 108px}.ie11-alert-btn-ub{font-size:25px;background:url(/cl/tpl/template/images/ie11alert/btn_UB.png) no-repeat left top}.en .ie11-alert-btn-ub,.vi .ie11-alert-btn-ub,.ko .ie11-alert-btn-ub,.es .ie11-alert-btn-ub,.id .ie11-alert-btn-ub{padding:9px 14px 34px 95px}</style><div id=\"js-ie11-alert-wrap\" class=\"ie11-alert-wrap\"> <div class=\"ie11-alert-bg\"> <div class=\"ie11-alert-easing\"> <div id=\"js-ie11-alert-container\" class=\"ie11-alert-container clearfix\"> <div class=\"ie11-alert-container-title\"> 系統偵測到您使用舊版瀏覽器! </div> <div class=\"clear\"></div> <div class=\"ie11-alert-container-middle\"> <span id=\"js-ie11-alert-message-win7\" class=\"ie11-alert-message ie11-alert-message-win7\">  系统侦测到您使用旧版浏览器，本站预计于 2016/1/1 停止对 IE8 维护与支援，<br/> 为加速浏览体验，提供最严密安全防护，建议升级至 IE11 或安装寰宇浏览器。  </span> <span id=\"js-ie11-alert-message-xp\" class=\"ie11-alert-message ie11-alert-message-xp\">  系统侦测到您使用旧版浏览器，本站预计于 2016/1/1 停止对 IE8 维护与支援，<br/> 为加速浏览体验，提供最严密安全防护，建议安装寰宇浏览器。  </span> </div> </div> <div class=\"clear\"></div> <div class=\"ie11-alert-btn-wrap\"> <div id=\"js-ie11-alert-btn-ie\" class=\"ie11-alert-btn ie11-alert-btn-ie\" onclick=\"window.open('http://windows.microsoft.com/en-us/internet-explorer/downloads/ie','download','top=0,left=0,width=1000,height=600,location=yes,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');\"> IE 11 </div> <div class=\"ie11-alert-btn ie11-alert-btn-ub\" onclick=\"window.open('javascript:f_com.bm('/infe/ub2/index.html', 'UB_BROWSE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});')\">  寰宇浏览器  </div> </div> </div> </div></div><script>(function(){function b(){$(\"#js-ie11-alert-wrap\");var a=navigator.userAgent,b=\"Win32\"===navigator.platform||\"Windows\"===navigator.platform,c=-1<a.indexOf(\"Windows NT 5.1\")||-1<a.indexOf(\"Windows XP\"),a=-1<a.indexOf(\"Windows NT 6.1\")||-1<a.indexOf(\"Windows 7\");b&&(a&&$(\"#js-ie11-alert-message-win7, #js-ie11-alert-btn-ie\").css(\"display\",\"inline-block\"),c&&$(\"#js-ie11-alert-message-xp\").siblings().css(\"display\",\"none\").end().css(\"display\",\"inline-block\"))}void 0===$.cookie?$.getScript(\"/cl/js/pluging/jquery.cookie.js?v=ver112.138\",b):b()})();</script><![endif]-->" +
//                "<!--IE11提示訊息-END-->" +
//                "" +
//                "<!--停止維護ie9,ie10提示訊息 2016/02/19 -->" +
//                "<style>.ie-stop-alert-wrap{display:none;position:fixed;top:0;left:0;z-index:5000;width:100%;height:100%;color:#FFF;text-align:center;font-size:12px;font-family:\"Microsoft YaHei\",\"微软雅黑\",arial;background:url(/cl/tpl/template/images/ie11alert/bg_ie_full.png) repeat center top}.zh-cn .ie-stop-alert-wrap{font-family:\"Microsoft YaHei\",\"微软雅黑\",arial}.zh-tw .ie-stop-alert-wrap{font-family:\"Microsoft JhengHei\",\"微軟正黑體\",arial}.ie-stop-alert-bg{width:100%;height:100%;background:url(/cl/tpl/template/images/ie11alert/bg_ie_logo.png) no-repeat 50% 10%}.ie-stop-alert-easing{position:absolute;top:30%;left:50%;text-align:center;width:600px;margin:0 0 0 -300px}.ie-stop-alert-container-title{color:#06BDF7;font-size:30px}.ie-stop-alert-container-middle{line-height:30px;color:#FFF;font-size:16px;margin:20px 0 50px}.ie-stop-alert-message{display:none}.ie-stop-alert-btn-wrap{font-size:0}.ie-stop-alert-btn{display:inline-block;vertical-align:top;cursor:pointer;width:256px;height:115px;color:#FFF;font-size:12px;text-align:left;box-sizing:border-box;padding:24px 14px 34px 95px}.ie-stop-alert-btn:hover{background-position:left bottom}.ie-stop-alert-btn-ie{display:none;font-size:34px;font-family:arial;background:url(/cl/tpl/template/images/ie11alert/btn_IE.png) no-repeat left top;padding:19px 14px 34px 108px}.ie-stop-alert-btn-ub{font-size:25px;background:url(/cl/tpl/template/images/ie11alert/btn_UB.png) no-repeat left top}.en .ie-stop-alert-btn-ub,.vi .ie-stop-alert-btn-ub,.ko .ie-stop-alert-btn-ub,.es .ie-stop-alert-btn-ub,.id .ie-stop-alert-btn-ub{padding:9px 14px 34px 95px}</style><div id=\"js-ie-stop-alert-wrap\" class=\"ie-stop-alert-wrap\"> <div class=\"ie-stop-alert-bg\"> <div class=\"ie-stop-alert-easing\"> <div id=\"js-ie-stop-alert-container\" class=\"ie-stop-alert-container clearfix\"> <div class=\"ie-stop-alert-container-title\"> 系統偵測到您使用舊版瀏覽器! </div> <div class=\"clear\"></div> <div class=\"ie-stop-alert-container-middle\"> <span class=\"ie-stop-alert-message ie-stop-alert-message-win7\">  系统侦测到您使用旧版浏览器，本站预计于 2016/4/1 停止对 IE9 IE10 维护与支援，<br/> 为加速浏览体验，提供最严密安全防护，建议升级至 IE11 或安装寰宇浏览器。  </span> <span class=\"ie-stop-alert-message ie-stop-alert-message-xp\">  系统侦测到您使用旧版浏览器，本站预计于 2016/4/1 停止对 IE9 IE10 维护与支援，<br/> 为加速浏览体验，提供最严密安全防护，建议安装寰宇浏览器。  </span> </div> </div> <div class=\"clear\"></div> <div class=\"ie-stop-alert-btn-wrap\"> <div id=\"js-ie-stop-alert-btn-ie\" class=\"ie-stop-alert-btn ie-stop-alert-btn-ie\" onclick=\"window.open('http://windows.microsoft.com/en-us/internet-explorer/downloads/ie','download','top=0,left=0,width=1000,height=600,location=yes,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');\"> IE 11 </div> <div class=\"ie-stop-alert-btn ie-stop-alert-btn-ub\" onclick=\"window.open('javascript:f_com.bm('/infe/ub2/index.html', 'UB_BROWSE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});')\">  寰宇浏览器  </div> </div> </div> </div></div><script>(function(){function c(){$(\"#js-ie-stop-alert-wrap\");var a=navigator.userAgent,b=\"Win32\"===navigator.platform||\"Windows\"===navigator.platform,c=-1<a.indexOf(\"Windows NT 5.1\")||-1<a.indexOf(\"Windows XP\"),a=-1<a.indexOf(\"Windows NT 6.1\")||-1<a.indexOf(\"Windows 7\");b&&(a&&$(\".ie-stop-alert-message-win7, .ie-stop-alert-btn-ie\").css(\"display\",\"inline-block\"),c&&$(\"#js-ie-stop-alert-message-xp\").siblings().css(\"display\",\"none\").end().css(\"display\",\"inline-block\"))}var b=function(){var a=navigator.userAgent.match(/MSIE\\s?(\\d+)(?:\\.(\\d+))?/i);" +
//                "        return null!==a?{major:a[1],minor:a[2]}:{major:\"-1\",minor:\"-1\"}}();if(\"10\"===b.major||\"9\"===b.major)$(\"#js-ie-stop-alert-wrap\").css(\"display\",\"block\"),c()})();</script><!--停止維護ie9,ie10提示訊息 END-->" +
//                "" +
//                "<!-- 流量統計 -->" +
//                "<script>" +
//                "    (function (window, api, hid, alias) {" +
//                "    \"use strict\";" +
//                "" +
//                "    var traceList = ['UA-77281412-10', 'UA-77281412-1', 'UA-77281412-2', 'UA-77281412-3', 'UA-77281412-4', 'UA-77281412-5', 'UA-77281412-6', 'UA-77281412-7', 'UA-77281412-8', 'UA-77281412-9']," +
//                "        traceCode = traceList[hid % 10]," +
//                "        newTraceCode = (api ? 'UA-77281412-12' : 'UA-77281412-11')," +
//                "        gtagElement = document.createElement('script');" +
//                "" +
//                "    gtagElement.async = 1;" +
//                "    gtagElement.src = 'https://www.googletagmanager.com/gtag/js';" +
//                "    document.body.appendChild(gtagElement);" +
//                "" +
//                "    window.dataLayer = window.dataLayer || [];" +
//                "" +
//                "    function gtag() {" +
//                "        dataLayer.push(arguments);" +
//                "    }" +
//                "" +
//                "    gtag('js', new Date());" +
//                "    gtag('config', traceCode, {'dimension1': alias});" +
//                "    gtag('config', newTraceCode, {" +
//                "        'dimension1': alias," +
//                "        'sample_rate': 10" +
//                "    });" +
//                "" +
//                "    window.bbinAnalytics = function (gacategory, gaactive, ganame) {" +
//                "        gtag('event', gaactive, {" +
//                "            'event_category': gacategory," +
//                "            'event_label': ganame" +
//                "        });" +
//                "    };" +
//                "" +
//                "    window.bbincasinoAnalytics = function (config) {" +
//                "        config.send_to = newTraceCode;" +
//                "        gtag('event', 'sign_up', config);" +
//                "    };" +
//                "}(window, '', '3820179', 'zr888d'));" +
//                "" +
//                "</script>" +
//                "" +
//                "<!-- 廣宣 -->" +
//                "<!-- 3820327因不顯示bbin字樣,所以不顯示左下角廣宣 -->" +
//                "" +
//                "<script>" +
//                "    /* 客端，加入我的最愛彈跳 */" +
//                "    function eleAddFavorite() {" +
//                "        if(document.all){" +
//                "            //ie8~10" +
//                "            window.external.AddFavorite('https://888aad.com', '888真人官网直营');" +
//                "        } else {" +
//                "            alert('「' + \"您使用的浏览器不支援此功能，请按“Ctrl+D”键手动加入收藏。\" + '」');" +
//                "        }" +
//                "    }" +
//                "</script>" +
//                "" +
//                "<!-- 左上角節慶 -->" +
//                "" +
//                "" +
//                "<!-- server push -->" +
//                "    <script src=\"/cl/js/tools/bootstrap-notify.js?v=ver112.138\"></script><style>.ele-member-message-wrap .animated {-webkit-animation-duration: 1s;animation-duration: 1s;-webkit-animation-fill-mode: both;animation-fill-mode: both;}.ele-member-message-wrap .fadeInUp {-webkit-animation-name: fadeInUp;animation-name: fadeInUp;}.ele-member-message-wrap .fadeOutDown {-webkit-animation-name: fadeOutDown;animation-name: fadeOutDown;}@-webkit-keyframes fadeInUp {0% {opacity: 0;-webkit-transform: translate3d(0,100%,0);transform: translate3d(0,100%,0);}100% {opacity:1;-webkit-transform:none;transform: none;}}@keyframes fadeInUp {0% {opacity: 0;-webkit-transform: translate3d(0,100%,0);transform: translate3d(0,100%,0);}100%{opacity: 1;-webkit-transform: none;transform:none;}}@-webkit-keyframes fadeOutDown {0% {opacity: 1;}100% {opacity: 0;-webkit-transform: translate3d(0,100%,0);transform: translate3d(0,100%,0);}}@keyframes fadeOutDown {0% {opacity: 1;}100% {opacity: 0;-webkit-transform: translate3d(0,100%,0);transform: translate3d(0,100%,0);}}.ele-member-message-wrap .ele-notification-item {width: 400px;font-size: 14px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;border: 1px solid transparent;border-radius: 4px;box-shadow: 0 0 15px rgba(0,0,0,.1);padding: 15px 30px 15px 15px;}.ele-member-message-wrap .ele-notification-info {color: #555;background-color: #F9F9F9;background-color: rgba(255,255,255,.95);border-color: #DDD;}.ele-member-message-wrap .fa {color: #999;font-size: 18px;margin-right: 5px;}.ele-member-message-wrap .ele-notification-close {width: 20px;height: 20px;color: #B5B5B5;cursor: pointer;font-size: 20px;font-weight: normal;outline: none;-webkit-appearance: none;background: none;border: none;margin-top: 8px;}.ele-member-message-wrap .ele-notification-close:hover {color: #9E9E9E;}@media screen and (max-width: 480px) {.ele-member-message-wrap .alert {width: 318px;}}</style><div id=\"js-member-message-wrap\" class=\"ele-member-message-wrap\"></div><script>$(function(){if (!('WebSocket' in window)) {return;}var loc = location.host,uri = 'ws://',_url,accinfo = '{\"SID\":\"63316d3350d33c5e0769577e7764c0ea8ea08e4a\",\"LV\":\"9363\"}',currentLang = 'zh-cn';if (location.protocol === 'https:') {uri = 'wss://';}_url = uri + loc + '/guava/ws';/* 預設語系為en */if (currentLang != 'zh-tw' && currentLang != 'zh-cn' && currentLang != 'en') {currentLang = 'en';}function notice_socket (){var ws = new WebSocket(_url);ws.onopen = function(evt) {ws.send(accinfo);};ws.onmessage = function(message) {var getData = JSON.parse(message.data);$.notify({icon: 'fa fa-envelope-square',message: getData[currentLang],url: \"\",},{element: document.getElementById('js-member-message-wrap'),position: 'fixed',placement: {from: 'bottom'},offset: {x: 10,y: 10},z_index: 1035,timer: 5000,mouse_over: 'pause',animate: {enter: 'animated fadeInUp',exit: 'animated fadeOutDown'},delay: 500,template:   '<div data-notify=\"container\" class=\"ele-notification-item ele-notification-{0}\" role=\"alert\">' +'<button type=\"button\" aria-hidden=\"true\" class=\"ele-notification-close\" data-notify=\"dismiss\">×</button>' +'<span data-notify=\"icon\"></span> ' +'<span data-notify=\"message\">{2}</span>' +'<a href=\"{3}\" target=\"{4}\" data-notify=\"url\" title=\"{2}\"></a>' +'</div>'});};ws.onclose = function(evt) {console.log(\"Connection closed.\");};}notice_socket();});</script>" +
//                "<!-- 問卷彈窗 -->" +
//                "" +
//                "" +
//                "<!-- 登入規則協議提示框 -->" +
//                "<script src=\"/cl/js/tools/login-agreement.min.js\"></script>" +
//                "<script>" +
//                "    $(function () {" +
//                "        if ('Y' === 'Y') { return; }" +
//                "" +
//                "        // 整合站預設設定檔" +
//                "        var config = {" +
//                "            url: '/infe/rule/rules.php?uid=guest&chk_rule=1'," +
//                "            lang: 'zh-cn'," +
//                "            isLogin: 'Y'," +
//                "            loginSubmit: '.login-submit'," +
//                "            inputEleName: 'rmNum'," +
//                "            isFirstDifferent: false," +
//                "            background: '#FFFDC0'," +
//                "            color: '#000'," +
//                "            linkColor: '#F00'," +
//                "            offset: {" +
//                "                'left': 0," +
//                "                'top': 7" +
//                "            }," +
//                "            first: {" +
//                "                inputEleName: 'rmNum'," +
//                "                offset: {" +
//                "                    'left': 0," +
//                "                    'top': 7" +
//                "                }" +
//                "            }," +
//                "            fixed: {" +
//                "                loginSubmit: '#js-fixed-submit'," +
//                "                inputEleName: 'rmNum'," +
//                "                offset: {" +
//                "                    'left': 0," +
//                "                    'top': 7" +
//                "                }" +
//                "            }," +
//                "            visibility: true" +
//                "        };" +
//                "" +
//                "        // 大球站設定檔" +
//                "        if ('1' === 'N') {" +
//                "            var ball_config = {" +
//                "                url: '/infe/rule/ballagreement?uid=guest&chk_rule=1'," +
//                "                loginSubmit: '#Submit'," +
//                "            }" +
//                "            $.extend(true, config, ball_config);" +
//                "        }" +
//                "" +
//                "        // 各站特例設定檔" +
//                "        if (typeof ele_login_agreement_conf !== 'undefined') {" +
//                "            $.extend(true, config, ele_login_agreement_conf);" +
//                "        }" +
//                "" +
//                "        // 共用登入套件設定檔" +
//                "        if (typeof common_login_agreement_conf !== 'undefined') {" +
//                "            // 當只有一個值時，型態為 string" +
//                "            if (typeof config.loginSubmit === 'string') {" +
//                "                var submitArr = config.loginSubmit.split(',');" +
//                "                submitArr.push(common_login_agreement_conf.loginSubmit);" +
//                "                config.loginSubmit = submitArr;" +
//                "            } else {" +
//                "                config.loginSubmit.push(common_login_agreement_conf.loginSubmit);" +
//                "            }" +
//                "        }" +
//                "" +
//                "        loginAgreement(config);" +
//                "    });" +
//                "" +
//                "    // 組 ckEditor 要用的連結" +
//                "    var linksList = {};" +
//                "            linksList['memberexclusive'] = \"/cl/?module=System&method=mAdvertis&other=MemberExclusiveII&ExclusiveNo=\";" +
//                "            linksList['ball'] = \"/cl/?module=System&method=ball\";" +
//                "            linksList['sunplus'] = \"javascript:window.open('/sport/sunplus/index.html', 'SunplusSport').focus();\";" +
//                "            linksList['livehall'] = \"/cl/?module=System&method=LiveTop&args=livehall\";" +
//                "            linksList['livedealer'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/livedealer', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['ultimatelive'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/ultimatelive', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['multilive'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/multilive', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['milive'] = \"javascript:window.open('/ipl/portal.php/game/livecasino#/milive', 'LiveGame', 'width=1200,height=740,resizable=yes').focus();\";" +
//                "            linksList['casino'] = \"/cl/?module=System&method=game\";" +
//                "            linksList['mgcasino'] = \"/cl/?module=System&method=game&gameHall=23\";" +
//                "            linksList['gnscasino'] = \"/cl/?module=System&method=Game&gameHall=28\";" +
//                "            linksList['lottery'] = \"/cl/?module=System&method=ltlottery\";" +
//                "            linksList['vrlottery'] = \"/cl/?module=System&method=ltlottery\";" +
//                "            linksList['joinmember'] = \"/cl/?module=System&method=mAdvertis&other=JoinMember\";" +
//                "            linksList['joinagent'] = \"/cl/?module=System&method=mAdvertis&other=JoinAgent\";" +
//                "            linksList['first'] = \"/cl/?module=System&method=first\";" +
//                "            linksList['service'] = \"javascript:BBOnlineService();\";" +
//                "            linksList['download'] = \"javascript:downloadvwin();\";" +
//                "            linksList['bbininfo'] = \"javascript:f_com.BBinGetPager('BBinInfo');\";" +
//                "            linksList['gambler_relay'] = \"javascript:f_com.bm('/cl/?module=GamblerRelay', 'GamblerRelay').focus();\";" +
//                "            linksList['goglive'] = \"javascript:f_com.bm('/ipl/portal.php/game/goglive2_entrance?GameKind=35&Ultimate=1', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['redreward'] = \"javascript:window.open('/cl/?module=EventRedReward&method=eventpage', 'EventRedReward').focus();\";" +
//                "            linksList['isbcasino'] = \"/cl/?module=System&method=Game&gameHall=29\";" +
//                "            linksList['nbbsport'] = \"javascript:window.open('/sport/new/index.html', 'NewBBSport').focus();\";" +
//                "            linksList['ptcasino'] = \"/cl/?module=System&method=Game&gameHall=20\";" +
//                "            linksList['hbcasino'] = \"/cl/?module=System&method=Game&gameHall=32\";" +
//                "            linksList['ppcasino'] = \"/cl/?module=System&method=Game&gameHall=37\";" +
//                "            linksList['fisharea'] = \"/cl/?module=System&method=FishArea\";" +
//                "            linksList['hegemony'] = \"javascript:window.open('/ipl/portal.php/event/esball_hegemony', 'EsballHegemony').focus();\";" +
//                "            linksList['jdbcasino'] = \"/cl/?module=System&method=Game&gameHall=39\";" +
//                "            linksList['agcasino'] = \"/cl/?module=System&method=Game&gameHall=40\";" +
//                "            linksList['mwcasino'] = \"/cl/?module=System&method=Game&gameHall=41\";" +
//                "            linksList['rtcasino'] = \"/cl/?module=System&method=Game&gameHall=42\";" +
//                "            linksList['sgcasino'] = \"/cl/?module=System&method=Game&gameHall=44\";" +
//                "            linksList['swcasino'] = \"/cl/?module=System&method=Game&gameHall=46\";" +
//                "            linksList['bngcasino'] = \"/cl/?module=System&method=Game&gameHall=48\";" +
//                "            linksList['wmcasino'] = \"/cl/?module=System&method=Game&gameHall=50\";" +
//                "            linksList['gticasino'] = \"/cl/?module=System&method=Game&gameHall=51\";" +
//                "            linksList['kacasino'] = \"/cl/?module=System&method=Game&gameHall=53\";" +
//                "            linksList['payquick'] = \"javascript:window.open('/infe/mcenter/paybitcoin/#/deposit/payfast', 'payquick').focus();\";" +
//                "            linksList['insport'] = \"javascript:window.open('/sport/in/index.html', 'INSport').focus();\";" +
//                "            linksList['ub_browser'] = \"javascript:f_com.bm('/infe/ub2/index.html', 'UB_BROWSE', {toolbar:'no',location:'no',directories:'no',menubar:'no',resizable:'no',top:'2',width:'1100',height:'760'});\";" +
//                "            linksList['robotlive'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['robotmultibet'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['viplive'] = \"javascript:f_com.bm('/ipl/portal.php/game/livecasino#/viplive', 'LiveGame', {width:'1200',height:'740',resizable:'yes'});\";" +
//                "            linksList['sbesports'] = \"javascript:window.open('/infe/game/sbtech?type=esports', 'sbesports').focus();\";" +
//                "            linksList['sbtech'] = \"javascript:window.open('/infe/game/sbtech', 'sbtech').focus();\";" +
//                "            linksList['8year'] = \"javascript:window.open('/ipl/events/esball8years/8years.php', 'Esball8Year').focus();\";" +
//                "            linksList['sicbobid'] = \"javascript:window.open('/events/SicBoBid/', 'SicBoBid', 'width=1200,height=740,resizable=yes').focus();\";" +
//                "            linksList['fiveleague'] = \"javascript:window.open('/cl/?module=EventFiveLeague', 'EventFiveLeague').focus();\";" +
//                "            linksList['uefa2016'] = \"javascript:f_com.OpenEventPage('uefa2016');\";" +
//                "            linksList['uefa_carnival'] = \"javascript:f_com.OpenEventPage('UEFACarnival2016');\";" +
//                "            linksList['uefa'] = \"javascript:f_com.OpenEventPage('uefa');\";" +
//                "            linksList['luckystar'] = \"javascript:f_com.OpenEventPage('luckystar');\";" +
//                "            linksList['oglive'] = \"/cl/?module=System&method=LiveTop&args=oglive\";" +
//                "            linksList['ablive'] = \"/cl/?module=System&method=LiveTop&args=ablive\";" +
//                "            linksList['evolive'] = \"/cl/?module=System&method=LiveTop&args=evolive\";" +
//                "            linksList['bglive'] = \"/cl/?module=System&method=LiveTop&args=bglive\";" +
//                "            linksList['sitemap'] = \"/cl/?module=System&method=mAdvertis&other=SiteMap\";" +
//                "            linksList['bet9video'] = \"/cl/?module=System&method=mAdvertis&other=Video\";" +
//                "            linksList['aglive'] = \"/cl/?module=System&method=liveTop&args=livehall\";" +
//                "            linksList['article'] = \"/cl/?module=System&method=mAdvertis&other=\";" +
//                "            linksList['at2'] = \"/cl/?module=System&method=mAdvertis&other=AT2\";" +
//                "            linksList['at3'] = \"/cl/?module=System&method=mAdvertis&other=AT3\";" +
//                "            linksList['at4'] = \"/cl/?module=System&method=mAdvertis&other=AT4\";" +
//                "            linksList['at5'] = \"/cl/?module=System&method=mAdvertis&other=AT5\";" +
//                "            linksList['at6'] = \"/cl/?module=System&method=mAdvertis&other=AT6\";" +
//                "            linksList['at7'] = \"/cl/?module=System&method=mAdvertis&other=AT7\";" +
//                "            linksList['at8'] = \"/cl/?module=System&method=mAdvertis&other=AT8\";" +
//                "            linksList['at9'] = \"/cl/?module=System&method=mAdvertis&other=AT9\";" +
//                "            linksList['at10'] = \"/cl/?module=System&method=mAdvertis&other=AT10\";" +
//                "            linksList['kycard'] = \"/cl/?module=System&method=Card&gameHall=49\";" +
//                "            linksList['gdlive'] = \"/cl/?module=System&method=LiveTop&args=gdlive\";" +
//                "        function ckEditorLink(link) {" +
//                "        location.href = linksList[link];" +
//                "    }" +
//                "</script>";
//
//        Document doc = Jsoup.parse(lotteryPage);
//        String money = doc.select(".ele-acc-unit strong").get(0).text();
//    }
//}
