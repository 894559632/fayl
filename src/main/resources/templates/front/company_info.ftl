<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if company??>${company.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if company??>${company.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <title><#if setting??>${setting.title!''}-</#if>关于泛奥</title>    <link rel="stylesheet" href="/front/css/global.css"/>    <link rel="stylesheet" href="/front/css/site.css"/>    <link rel="stylesheet" href="/front/css/idangerous.swiper.css">    <script type="text/javascript" src="/front/js/jquery-1.11.0.js"></script>    <script type="text/javascript" src="/front/js/ftt.js"></script>    <script src="/front/js/idangerous.swiper.min.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");        });    </script></head><body><!--  header Start  --><#include "/front/common/common_header.ftl"><!--  header End    --><!--  content Start  --><div class="sitebanner"></div><div class="sitecontent">    <div class="wrapper">        <div class="siteguide">            <a href="index.html" title="">首页</a> &gt; <label>关于泛奥</label>        </div>        <div class="aboutusguide">            <a href="javascript:;" title="" onclick="hreftoitem('profile')">公司介绍</a>            <a href="javascript:;" title="" onclick="hreftoitem('team')">设计团队</a>            <a href="javascript:;" title="" onclick="hreftoitem('concept')">设计理念</a>            <a href="javascript:;" title="" onclick="hreftoitem('development')">发展景愿</a>        </div>    </div></div><div class="aboutusitem" id="profile">    <div class="wrapper">        <div class="initem">            <span class="etitle">COMPANY PROFILE</span>            <span class="ctitle">公司介绍</span>            <img style="margin-bottom: 15px;" alt="公司介绍" src="/front/images/aboutus01.png">            <p><#if introduction??>${introduction.content!''}</#if></p>        </div>    </div></div><div class="aboutusitem aboutusitem2" id="team">    <div class="wrapper">        <div class="initem">            <span class="etitle">DESIGN TEAM</span>            <span class="ctitle">设计团队</span>			<#if designers??>	            <div class="designteam">	                <div class="designlist">	                    <div class="swiper-container">	                        <div class="swiper-wrapper">	                        	<#list designers as item>		                            <#if item??>			                            <div class="swiper-slide">			                                <div onclick="window.location.href='/designer/detail?number=${item.number!'0'}'" class="peopleitem">			                                    <img src="${item.photoUri!''}" alt="<#if setting??>${setting.title!''}-</#if>${item.name!''}"/>			                                   <span>			                                       <label>${item.name!''}</label>			                                       <label>${item.position!''}</label>			                                   </span>			                                </div>			                            </div>		                            </#if>	                            </#list>	                        </div>	                    </div>	                    <a class="arrow-right" title="" href="javascript:;"></a>	                    <a class="arrow-left" title="" href="javascript:;"></a>	                </div>	                <script>	                    $(function () {	                        var mySwiper = new Swiper('.swiper-container', {	                            pagination: false,	                            paginationClickable: false,	                            slidesPerView: 5,	                            slidesPerGroup: 5,	                            loop: true	                        });	                        $('.arrow-left').on('click', function (e) {	                            e.preventDefault();	                            mySwiper.swipePrev();	                        });	                        $('.arrow-right').on('click', function (e) {	                            e.preventDefault();	                            mySwiper.swipeNext();	                        });		                        $('.designteam .swiper-slide').hover(function () {	                            $(this).find('span').stop(true, false).animate({'opacity': '1'}, 300);	                        }, function () {	                            $(this).find('span').stop(true, false).animate({'opacity': '0'}, 300);	                        });	                    });	                </script>	            </div>            </#if>        </div>    </div></div><div class="aboutusitem " id="concept">    <div class="wrapper">        <div class="designconcept">            <img src="/front/images/aboutus03.png" alt="设计理念">            <div class="designconcept-text">                <span class="etitle1">DESIGN CONCEPT</span>                <span class="ctitle1">设计理念<label></label></span>                <p><#if concept??>${concept.content!''}</#if></p>            </div>        </div>    </div></div><div class="aboutusitem aboutusitem3 " id="development">    <div class="wrapper">        <div class="designconcept">            <div class="designconcept-text">                <span class="etitle1">DEVELOPMENT VIEW</span>                <span class="ctitle1">发展景愿<label></label></span>                <P><#if delvelopment??>${delvelopment.content!''}</#if></P>            </div>            <img src="/front/images/aboutus04.png" alt="发展愿景">        </div>    </div></div><!--  content end  --><!--  footer Start  --><#include "/front/common/common_footer.ftl"><!--  footer End    --></body></html>