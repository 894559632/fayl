<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if company??>${company.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if company??>${company.seoDescription!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">    <title><#if setting??>${setting.title!''}-</#if>留言</title>    <link rel="stylesheet" href="/touch/css/global.css"/>    <script type="text/javascript" src="/touch/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/touch/js/ftt.js"></script></head><body style="background: #f2f2f2;"><header>    <img src="/touch/images/logo.png" alt="泛奥园林"/></header><h1 class="h1key"></h1><form onsubmit="return touch.submit();">	<div class="wrap">	    <textarea class="txtmessage" placeholder="请留下您的宝贵留言，们将竭诚为您服务" id="visitor_remark"></textarea>	    <div class="phonewrap">	        <span>请留下您的联系方式</span>	        <input id="visitor_phone" type="text" placeholder="请留下您的手机号码"/>	    </div>	    <input type="submit" class="btnsubmit" value="提交"/>	</div></form></body><script type="text/javascript" src="/touch/js/Mr.D/touch_remark.js"></script></html>