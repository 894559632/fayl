<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if job??>${job.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if settting??>${setting.title!''}-</#if><#if job??>${job.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <title><#if setting??>${setting.title!''}-</#if>企业招聘</title>    <link rel="stylesheet" href="/front/css/global.css"/>    <link rel="stylesheet" href="/front/css/site.css"/>    <link rel="stylesheet" href="/front/css/idangerous.swiper.css">    <script type="text/javascript" src="/front/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/front/js/ftt.js"></script>    <script src="/front/js/idangerous.swiper.min.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");        });    </script></head><body><!--  header Start  --><#include "/front/common/common_header.ftl"><!--  header End    --><!--  content Start  --><div class="sitebanner"></div><div class="sitecontent">    <div class="wrapper">    			<#if job??>	        <div class="news-wrapper">	            <div class="title">	                <span class="titlename">${job.title!''}</span>	                <span class="author"><label><#if job.createTime??>${job.createTime?string("yyyy-MM-dd")}</#if></label><label></label></span>	            </div>	            <div class="newscontent">	                <p>${job.content!''}</p>	            </div>	        </div>        </#if>    </div></div><!--  content end  --><!--  footer Start  --><#include "/front/common/common_footer.ftl"><!--  footer End    --><#-- qrcode --><#include "/front/common/common_qrcode.ftl"></body></html>