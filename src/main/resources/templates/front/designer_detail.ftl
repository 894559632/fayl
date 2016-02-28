<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if desinger??>${designer.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if designer??>${designer.seoKeywords!''}</#if>"/>    <meta name="author" content="cqhome_ynyes_Mr.D"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <title><#if setting??>${setting.title!''}-</#if>设计师</title>    <link rel="stylesheet" href="/front/css/global.css"/>    <link rel="stylesheet" href="/front/css/site.css"/>    <script type="text/javascript" src="/front/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/front/js/ftt.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");        });    </script></head><body><!--  header Start  --><#include "/front/common/common_header.ftl"><!--  header End    --><!--  content Start  --><div class="sitebanner"></div><div class="sitecontent">    <div class="wrapper">        <div class="siteguide">            <a href="/" title="<#if setting??>${setting.title!''}-</#if>首页">首页</a> &gt; <label>设计师详情</label>        </div>        <div class="news-wrapper">        	<#if designer??>	            <div class="designerwrap">                <img src="${designer.photoUri!''}" class="designeravater" alt="<#if setting??>${setting.title!''}-</#if>${designer.seoTitle!''}"/>                <div class="designerinfo">                    <p>姓名：${designer.name!''}</p>                    <p>职务：${designer.position!''}</p>                </div>            </div>            <div class="newscontent">                <p>${designer.description!''}</p>            </div>            </#if>        </div>    </div></div><!--  content end  --><!--  footer Start  --><#include "/front/common/common_header.ftl"><!--  footer End    --></body></html>