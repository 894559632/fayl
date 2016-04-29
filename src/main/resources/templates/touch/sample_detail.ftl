<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if sample??>${sample.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if sample??>${sample.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">    <title><#if setting??>${setting.title!''}-</#if>经典案例</title>    <link rel="stylesheet" href="/touch/css/global.css"/>    <link rel="stylesheet" href="/touch/css/swiper.min.css">    <script type="text/javascript" src="/touch/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/touch/js/swiper.min.js"></script></head><body><header>    <img src="/touch/images/logo.png" alt="泛奥园林"/></header><h1 class="h1key">泛奥园林</h1><#if sample??&&sample.imgUriList??&&""!=sample.imgUriList>	<div class="banner casebanner">	    <div class="swiper-container">	        <div class="swiper-wrapper">	        	<#list sample.imgUriList?split(",") as item>	        		<#if item??&&""!=item>	            		<div class="swiper-slide"><img src="${item}" alt="<#if setting??>${setting.title!''}-</#if><#if sample??>${sample.title!''}</#if>"/></div>	            	</#if>	            </#list>	        </div>	        <!-- 页标 -->	        <div class="swiper-pagination"></div>	        <script>	            var swiper = new Swiper('.swiper-container', {	                pagination: '.swiper-pagination',	                paginationClickable: true,	                spaceBetween: 30,	                centeredSlides: true,	                autoplay: 2500,	                autoplayDisableOnInteraction: false,	                loop:true	            });	        </script>	    </div>	</div></#if><#if sample??>	<div class="wrap">	    <span class="casetitle">${sample.title!''}</span>	    <div class="casecontent">	        <p>${sample.content!''}</p>	    </div>	</div></#if><script>var _hmt = _hmt || [];(function() {  var hm = document.createElement("script");  hm.src = "//hm.baidu.com/hm.js?4acd9e6133d8b062eeddb1123aec68e8";  var s = document.getElementsByTagName("script")[0];   s.parentNode.insertBefore(hm, s);})();</script></body></html>