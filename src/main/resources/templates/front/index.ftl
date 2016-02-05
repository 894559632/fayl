<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="description" content="<#if setting??>${setting.title!''}-</#if><#if setting??>${setting.seoDescription!''}</#if>"/>    <meta name="keywords" content="<#if setting??>${setting.title!''}-</#if><#if setting??>${setting.seoKeywords!''}</#if>"/>    <meta name="author" content="ynyes_cqhome_Mr.D"/>    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>    <!--[if lt IE 9]>    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>    <![endif]-->    <title><#if setting??>${setting.title!''}-</#if>首页</title>    <link rel="stylesheet" href="/front/css/global.css"/>    <link rel="stylesheet" href="/front/css/responsiveslides.css">    <link rel="stylesheet" href="/front/css/idangerous.swiper.css">    <link rel="stylesheet" href="/front/css/themes.css">    <link rel="stylesheet" href="/front/css/index.css"/>    <script type="text/javascript" src="/front/js/jquery-1.11.0.js"></script>    <script src="/front/js/responsiveslides.min.js"></script>    <script src="/front/js/idangerous.swiper.min.js"></script>    <script src="/front/js/ftt.js"></script>    <script>        $(function () {            $("#topnav li").topnav(".childnav");        });    </script></head><body><!--  header Start  --><#include "/front/common/common_header.ftl"><!--  header End    --><!--  indexbanner Start  --><#if ad_list??&&ad_list?size gt 0>	<div class="indexbanner">	    <div class="rslides_container">	        <ul class="rslides" id="slider">	        	<#list ad_list as item>	        		<#if item??>		            	<li><a><img src="${item.imgUri!''}" alt="${item.introduce!''}"></a></li>		            </#if>	            </#list>	        </ul>	        	        <script>	            $(function () {	                $("#slider").responsiveSlides({	                    auto: true,	                    pager: true,	                    nav: true,	                    speed: 500,	                    namespace: "transparent-btns"	                });	            });	        </script>	    </div>	</div></#if><!--  indexbanner End  --><!--  center Start  --><!--  Who we are  --><div class="wwr wrapper">    <div class="content">        <h1>WHO WE ARE</h1>        <h2>关于泛奥</h2>        <div class="text-wrap">            <p><#if info??>${info.content!''}</#if></p>        </div>    </div></div><!--  What can we do  --><div class="wcwd wrapper">    <div class="content">        <h1>WHAT CAN WE DO</h1>        <h2>热点产品</h2>        <ul class="function-wrap">            <script>                $(function () {                    $('.wcwd .function-wrap li').hover(function () {                        $(this).find('img').stop(true, false).animate({'opacity': '1'}, 300);                    }, function () {                        $(this).find('img').stop(true, false).animate({'opacity': '0'}, 300);                    });                });            </script>            <li class="func01"><a href="#" title="<#if setting??>${setting.title!''}-</#if>滨水景观">滨水景观<img alt="滨水景观" src="/front/images/product1-2.png"></a></li>            <li class="func02"><a href="#" title="<#if setting??>${setting.title!''}-</#if>道路景观">道路景观<img alt="道路景观" src="/front/images/product2-2.png"></a></li>            <li class="func03"><a href="#" title="<#if setting??>${setting.title!''}-</#if>旅游区">旅游区<img alt="旅游区" src="/front/images/product3-2.png"></a></li>            <li class="func04"><a href="#" title="<#if setting??>${setting.title!''}-</#if>公共商业">公共商业<img alt="公共商业" src="/front/images/product4-2.png"></a></li>            <li class="func05"><a href="#" title="<#if setting??>${setting.title!''}-</#if>公园景观">公园景观<img alt="公园景观" src="/front/images/product5-2.png"></a></li>            <li class="func06"><a href="#" title="<#if setting??>${setting.title!''}-</#if>农业景观">农业景观<img alt="农业景观" src="/front/images/product6-2.png"></a></li>            <li class="func07"><a href="#" title="<#if setting??>${setting.title!''}-</#if>居住区景观">居住区景观<img alt="居住区景观" src="/front/images/product7-2.png"></a></li>        </ul>    </div></div><!--  what we have done  --><div class="wwhd">    <div class=" wrapper">        <div class="content">            <h1>WHAT WE HAVE DONE</h1>            <h2>案例赏析</h2>            <div class="function-wrap" id="caseitem">                <div class="case_nav1">                    <label>旅游规划</label>                    <div class="innav">                        <span id="casenav2" class="frml">旅游区</span>                        <span id="casenav1" class="frml current">滨水景观</span>                    </div>                </div>                <div class="case_nav2">                    <label>风景园林</label>                    <div class="innav">                        <span id="casenav3" class="flml">公园景观</span>                        <span id="casenav4" class="flml">居住区景观</span>                        <span id="casenav5" class="flml">道路景观</span>                    </div>                </div>                <div class="case_nav3">                    <label>景观建筑</label>                    <div class="innav">                        <span id="casenav6" class="flmr">公共商业</span>                        <span id="casenav7" class="flmr">农业景观</span>                    </div>                </div>                <#if bsjg_sample_page??>                	<#if bsjg_sample_page.content??&&bsjg_sample_page.content?size gt 0>			                <div class="case_item" id="case_item0">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer0">		                            <div class="swiper-wrapper">		                            	<#list bsjg_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>			                                </#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right0" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left0" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <#if lyq_sample_page??>                	<#if lyq_sample_page.content??&&lyq_sample_page.content?size gt 0>		                <div class="case_item" id="case_item1" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer1">		                            <div class="swiper-wrapper">		                            	<#list lyq_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>			                                </#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right1" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left1" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <#if gyjg_sample_page??>                	<#if gyjg_sample_page.content??&&gyjg_sample_page.content?size gt 0>		                <div class="case_item" id="case_item2" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer2">		                            <div class="swiper-wrapper">		                            	<#list gyjg_sample_page as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>		                                	</#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right2" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left2" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <#if jzqjg_sample_page??>                	<#if jzqjg_sample_page.content??&&jzqjg_sample_page.content?size gt 0>		                <div class="case_item" id="case_item3" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer3">		                            <div class="swiper-wrapper">		                            	<#list jzqjg_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>			                                </#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right3" title="" href="javascript:;"></a>		                        <a class="arrow-left" id="left3" title="" href="javascript:;"></a>		                    </div>		                </div>	                </#if>	            </#if>	            <#if dljg_sample_page??>	            	<#if dljg_sample_page.content??&&dljg_sample_page.content?size gt 0>		                <div class="case_item" id="case_item4" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer4">		                            <div class="swiper-wrapper">		                            	<#list dljg_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>			                                </#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right4" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left4" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <#if ggsy_sample_page??>                	<#if ggsy_sample_page.content??&&ggsy_sample_page.content?size gt 0>		                <div class="case_item" id="case_item5" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer5">		                            <div class="swiper-wrapper">		                            	<#list ggsy_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>		                                	</#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right5" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left5" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <#if nyjg_sample_page??>                	<#if nyjg_sample_page.content??&&nyjg_sample_page.content?size gt 0>		                <div class="case_item" id="case_item6" style="display: none;">		                    <div class="initem">		                        <div class="swiper-container" id="swipercontainer6">		                            <div class="swiper-wrapper">		                            	<#list nyjg_sample_page.content as item>		                            		<#if item??>				                                <div class="swiper-slide">				                                    <img alt="${item.seoTitle!''}" src="${item.coverImgUri!''}">				                                </div>		                                	</#if>		                                </#list>		                            </div>		                        </div>		                        <a class="arrow-right" id="right6" title="下一页" href="javascript:;"></a>		                        <a class="arrow-left" id="left6" title="上一页" href="javascript:;"></a>		                    </div>		                </div>	                </#if>                </#if>                <script>                    $(function () {                        var mySwiper1 = new Swiper(".swiper-container", {                            pagination: false,                            paginationClickable: false,                            slidesPerView: 4,                            slidesPerGroup: 4,                            loop: true                        });                        $(".arrow-left").on('click', function (e) {                            e.preventDefault();                            mySwiper1.swipePrev();                        });                        $(".arrow-right").on('click', function (e) {                            e.preventDefault();                            mySwiper1.swipeNext();                        });                        casehover("#caseitem .innav span",'case_item','current');                    });                    function casehover(casenav,idname,currentclass){                        $(casenav).hover(function(){                            $(casenav).removeClass(currentclass);                            $(this).addClass(currentclass);                            var id=$(this).attr('id').substring(7)-1;                            $("."+idname).css('display','none');                            $("#"+idname+id).css('display','block');                            var mySwiper1 = new Swiper("#"+idname+id+" .swiper-container", {                                pagination: false,                                paginationClickable: false,                                slidesPerView: 4,                                slidesPerGroup: 4,                                loop: true                            });                            $("#"+idname+id+" .arrow-left").on('click', function (e) {                                e.preventDefault();                                mySwiper1.swipePrev();                            });                            $("#"+idname+id+" .arrow-right").on('click', function (e) {                                e.preventDefault();                                mySwiper1.swipeNext();                            });                        });                    }                </script>            </div>        </div>    </div></div><!--  what's news  --><div class="whatnews wrapper">    <div class="content">        <h1>WHAT'S NEWS</h1>        <h2>最新动态</h2>        <div class="function-wrap">			<#if article_page??>				<#if article_page.content??&&article_page.content?size gt 0>		            <dl class="newslist">		            	<#-- 创建一个变量用于表示是否获取到了第一个有图片的新闻 -->		            	<#assign isHave=false>		            	<#list article_page.content as item>	            			<#if item_index==0>			            		<#if item??>					                <dt>					                    <a href="#" title="${item.seoTitle!''}">${item.title!''}</a>					                    <label><#if item.createTime??>${item.createTime?string("yyyy-MM-dd")}</#if></label>						                <p>${item.content!''}</p>				                    </dt>		                    	</#if>	                    	<#else>	                    		<#if item??>					                <dd>					                    <a href="#" title="${item.seoTitle!''}">${item.title!''}</a>					                    <label><#if item.createTime??>${item.createTime?string("yyyy-MM-dd")}</#if></label>					                </dd>				                </#if>		                	</#if>		                	<#if item.imgUri??&&isHave??&&!isHave>		                		<#assign singleArticle=item>		                		<#assign isHave=true>		                	</#if>		                </#list>		            </dl>	            </#if>            </#if>        	<#if singleArticle??>	            <div class="newsimg">	                <a href="#" title="${singleArticle.seoTitle!''}">	                    <img src="${singleArticle.imgUri!''}" alt="${singleArticle.seoTitle!''}">	                    <span>${singleArticle.title!''}</span>	                </a>	            </div>            </#if>            <div class="a_morenews">                <a href="/article/category" title="<#if setting??>${setting.title!''}-</#if>更多动态">更多动态 >></a>            </div>        </div>    </div></div><!--  center End    --><!--  footer Start  --><#include "/front/common/common_footer.ftl"><!--  footer End    --></body></html>