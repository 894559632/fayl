<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if research??>${research.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if research??>${research.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <title><#if setting??>${setting.title!''}-</#if>泛奥研究</title>    <link rel="stylesheet" href="/front/css/global.css"/>    <link rel="stylesheet" href="/front/css/site.css"/>    <script type="text/javascript" src="/front/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/front/js/ftt.js"></script>    <link rel="stylesheet" type="text/css" href="/front/css/jquery.ad-gallery.css">    <script type="text/javascript" src="/front/js/jquery.ad-gallery.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");            //图片详情js            $('.ad-gallery').adGallery();        });    </script></head><body><!--  header Start  --><#include "/front/common/common_header.ftl"><!--  header End    --><!--  content Start  --><div class="sitebanner"></div><div class="sitecontent">    <div class="wrapper">        <div class="siteguide">            <a href="/" title="<#if setting??>${setting.title!''}-</#if>首页">首页</a> &gt; <a href="/research/list" title="<#if setting??>${setting.title!''}-</#if>泛奥研究">泛奥研究</a> &gt; <label><#if research??>${research.title!''}</#if></label>        </div>        <div class="news-wrapper">        	<#if research??>	            <span class="casename">${research.title!''}</span>		            <div class="ad-gallery">	                <div class="ad-image-wrapper"></div>	                <div class="ad-nav">	                	<#if research.imgUriList??>		                    <div class="ad-thumbs">		                        <ul class="ad-thumb-list">			                    	<#list research.imgUriList?split(",") as item>		                    			<#if item??&&""!=item>				                            <li>				                                <a href="${item}" title="${research.seoTitle!''}">				                                    <img src="${item}" alt="${research.seoTitle!''}">				                                </a>				                            </li>		                        		</#if>			                        </#list>		                        </ul>		                    </div>	                    </#if>	                </div>	            </div>		            <div class="newscontent">	                <p>${research.content!''}</p>	            </div>	            <div class="newsguide">	            	<#if pre_research??>	                	<a href="/research/detail/${pre_research.number!'0'}" title="${pre_research.seoTitle!''}">上一篇：${pre_research.title!''}</a> 	                <#else>	                	<a href="" title="">上一篇：无</a> 	                </#if>	                	                <#if next_research??>	                	<a href="/research/detail/${next_research.number!'0'}" title="${next_research.seoTitle!''}">下一篇：${next_research.title!''}</a>	                <#else>	                	<a href="#" title="">下一篇：无</a>	                </#if>	            </div>            </#if>        </div>    </div></div><!--  content end  --><!--  footer Start  --><#include "/front/common/common_footer.ftl"><!--  footer End    --><#-- qrcode --><#include "/front/common/common_qrcode.ftl"></body></html>