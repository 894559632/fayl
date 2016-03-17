<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-${setting.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-${setting.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">    <title><#if setting??>${setting.title!''}-</#if>首页</title>    <link rel="stylesheet" href="/touch/css/global.css"/>    <link rel="stylesheet" href="/touch/css/swiper.min.css">    <script type="text/javascript" src="/touch/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/touch/js/swiper.min.js"></script></head><body><header>    <img src="/touch/images/logo.png" alt="泛奥园林"/></header><h1 class="h1key"></h1><#if ad_list??>	<div class="banner">	    <div class="swiper-container">	        <div class="swiper-wrapper">	        	<#list ad_list as item>	        		<#if item??>	            		<div class="swiper-slide"><img src="${item.imgUri!''}" alt="${item.introduce!''}"/></div>	            	</#if>	            </#list>	        </div>	        <!-- 页标 -->	        <div class="swiper-pagination"></div>	        <script>	            var swiper = new Swiper('.swiper-container', {	                pagination: false,	                paginationClickable: true,	                spaceBetween: 30,	                centeredSlides: true,	                autoplay: 2500,	                autoplayDisableOnInteraction: false,	                loop:true	            });	        </script>	    </div>	</div></#if><section class="wrap">	<#if info??>	    <div class="title">	        <label class="lbltitle">公司介绍</label>	        <a href="/touch/company/detail" class="more" title="<#if setting??>${setting.title!''}-</#if><#if company??>${company.seoTitle!''}</#if>">more</a>	    </div>	    <div class="content">	        <p>${info.content!''}</p>	    </div>    </#if>		<#if sample_page??&&sample_page.content??&&sample_page.content?size gt 0>	    <div class="title">	        <label class="lbltitle">经典案例</label>	        <a href="/touch/sample/list" class="more" title="<#if setting??>${setting.title!''}-</#if>经典案例">more</a>	    </div>	    <div class="content">	        <div class="swiper-container" id="swiper1">	            <div class="swiper-wrapper">	            	<#list sample_page.content as item>	            		<#if item??>			                <div class="swiper-slide">			                	<a href="/touch/sample/detail?number=${item.number!'0'}" title="${item.title!''}">				                	<img src="${item.coverImgUri!''}" alt="<#if setting??>${setting.title!''}-</#if>${item.seoTitle!''}"/>				                    <span class="imgtitle">${item.title!''}</span>			                	</a>		                	</div>	                	</#if>                	</#list>	            </div>	            <!-- 页标 -->	            <div class="swiper-pagination"></div>	            <script>	                var swiper1 = new Swiper('#swiper1', {	                    pagination: false,	                    paginationClickable: true,	                    spaceBetween: 10,	                    slidesPerView :2,	                    loop:true	                });	            </script>	        </div>	    </div>    </#if>        <!-- 泛奥研究 -->    <#if research_page??&&research_page.content??&&research_page.content?size gt 0>	    <div class="title">	        <label class="lbltitle">泛奥研究</label>	        <a href="/touch/research/list" class="more" title="<#if setting??>${setting.title!''}-</#if>泛奥研究">more</a>	    </div>	    <div class="content">	        <div class="swiper-container" id="swiper2">	            <div class="swiper-wrapper">	            	<#list research_page.content as item>	            		<#if item??>			                <div class="swiper-slide">			                	<a href="/touch/research/detail?number=${item.number!'0'}" title="${item.title!''}">				                	<img src="${item.coverImgUri!''}" alt="<#if setting??>${setting.title!''}-</#if>${item.seoTitle!''}"/>				                    <span class="imgtitle">${item.title!''}</span>			                	</a>		                	</div>	                	</#if>                	</#list>	            </div>	            <!-- 页标 -->	            <div class="swiper-pagination"></div>	            <script>	                var swiper1 = new Swiper('#swiper2', {	                    pagination: false,	                    paginationClickable: true,	                    spaceBetween: 10,	                    slidesPerView :2,	                    loop:true	                });	            </script>	        </div>	    </div>    </#if>    <!-- 泛奥研究结束 -->		<#if article_category_list??>		<#list article_category_list as item>			<#if item??>			    <div class="title">			        <label class="lbltitle">${item.title!''}</label>			        <a href="/touch/article/list?number=${item.number!'0'}" class="more" title="<#if setting??>${setting.title!''}-</#if>${item.seoTitle!''}">more</a>			    </div>			    <#if item.number??>			    	<#if (item.number + "article_page")?eval??>			    		<#if (item.number + "article_page")?eval.content??&&(item.number + "article_page")?eval.content?size gt 0>						    <div class="content">						    	<#list (item.number + "article_page")?eval.content as article>							        <div class="newsitem">							        	<#if article.imgUri??&&""!=article.imgUri>								            <a href="/touch/article/detail/${article.number!'0'}" class="a-img" title="<#if setting??>${setting.title!''}-</#if>${article.seoTitle!''}">								                <img src="${article.imgUri!''}" alt="<#if setting??>${setting.title!''}-</#if>${article.seoTitle!''}"/>								            </a>							            </#if>							            <a href="/touch/article/detail/${article.number!'0'}" class="a-title" title="<#if setting??>${setting.title!''}-</#if>${article.seoTitle!''}">							                <span>${article.title!''}</span>							                <p>${article.summary!''}</p>							            </a>							        </div>						        </#list>						    </div>					    </#if>				    </#if>		    	</#if>		    </#if>	    </#list>    </#if></section><footer>	<div class="footerclear"></div>	<div class="footer_site">	    <a class="home current" href="/touch">首页</a>	    <a class="case" href="/touch/sample/list">案例展示</a>	    <a class="us" href="/touch/company/detail">关于我们</a>	</div></footer></body></html>