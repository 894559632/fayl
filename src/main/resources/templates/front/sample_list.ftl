<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if sampleCategory??>{sampleCategory.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if sampleCategory??>{sampleCategory.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <title><#if setting??>${setting.title!''}-</#if>经典案例</title>    <link rel="stylesheet" href="/client/css/global.css"/>    <link rel="stylesheet" href="/client/css/site.css"/>    <link rel="stylesheet" href="/client/css/idangerous.swiper.css">    <script type="text/javascript" src="/client/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/client/js/ftt.js"></script>    <script type="text/javascript" src="/client/js/idangerous.swiper.min.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");            //加载分页            $(".page").createPage({                pageCount: <#if sample_page??>${sample_page.totalPages!'0'}<#else>0</#if>,                current: <#if page??>${page + 1}<#else>1</#if>,                backFn: function (p) {                    <#-- 分页跳转 -->                    window.location.href = "/sample/category/${number!'0'}?page=" + (p - 1);                }            });        });    </script></head><body><!--  header Start  --><#include "/client/common/common_header.ftl"><!--  header End    --><!--  content Start  --><div class="sitebanner"></div><div class="sitecontent">    <div class="wrapper">        <div class="siteguide">            <a href="/" title="<#if setting??>${setting.title!''}-</#if>首页">首页</a> &gt; <label><#if sample_category??>${sample_category.title!''}</#if></label>        </div>        <script>            $(function () {                newstoggle('.aboutusguide a', 'current', "#listitem");                $('.caselist ul li').hover(function () {                    $(this).find('a').stop(true, false).animate({'opacity': '1'}, 300);                }, function () {                    $(this).find('a').stop(true, false).animate({'opacity': '0'}, 300);                });            });        </script>        <div class="aboutusguide caseguide">        	<#if sample_category_list??>            	<#list sample_category_list as item>            		<#if item??>			            <a href="/sample/category/{item.number!'0'}" title="${item.title!''}" <#if item.number??&&number??&&number==item.number>class="current"</#if>>${item.title!''}</a>            		</#if>            	</#list>            </#if>        </div>        <div id="listitem">            <div class="caseitem">            	<#if sample_category??>	                <div class="casedesc">	                    <span>${sample_category.title!''}</span>	                    <p>${sample_category.description!''}</p>	                </div>				</#if>                <div class="caselist">                	<#if sample_page??>	                	<#if sample_page.content??&&sample_page.content?size gt 0>		                    <ul>		                    	<#list sample_page.content as item>		                    		<#if item??>				                        <li>				                            <img src="${item.coverImgUri!''}" alt="${item.seoTitle!''}">				                            <a href="/sample/detail/${item.number!''}" title="${item.seoTitle!''}" class="title">				                                <span>${item.title!''}</span>				                                <p>简介：${item.introduction!''}</p>				                            </a>				                        </li>		                        	</#if>		                        </#list>	                    	</ul>                    	</#if>					</#if>                    <div class="page"></div>                </div>            </div>        </div>    </div></div><!--  content end  --><!--  footer Start  --><#include "/client/common/common_footer.ftl"><!--  footer End    --></body></html>