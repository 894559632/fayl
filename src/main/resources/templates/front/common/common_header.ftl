<div class="headerclear"></div>
<div class="header">
    <div class="wrapper">

        <a href="javascript:void();"  <#if setting??>title="${setting.title!''}"</#if>  class="a_logo">
        	<img <#if setting??>alt="${setting.title!''}"</#if> <#if setting??>src="${setting.logoUri!''}"</#if>>
            <h1 class="h1key"><#if setting??>${setting.title!''}</#if></h1>
        </a>

        <ul class="top_nav" id="topnav">
            <li>
            	<a title="首页"  href="/">
	            	<p>首页</p>
	                <p>HOME</p>
            	</a>
            </li>
            <li>
            	<a title="关于泛奥"  href="/company/info">
	            	<p>关于泛奥</p>
	                <p>ABOUT</p>
                </a>
            </li>
            <li>
            	<a title="泛奥研究" href="泛奥研究.html">
	            	<p>泛奥研究</p>
	                <p>RESEARCH</p>
                </a>
            </li>
            <li>
            	<a title="经典案例">
	            	<p>经典案例</p>
	                <p>CASE</p>
                	<div class="childnav">
                		<#if sample_category_list??>
                			<#list sample_category_list as item>
                				<#if item??>
	                    			<a title="${item.seoTitle!''}"  href="/sample/category/${item.number!'0'}">${item.title!''}</a>
	                    		</#if>
                    		</#list>
	                    </#if>
	                </div>
                </a>
            </li>
            <li>
            	<a title="企业招聘"  href="/company/job">
	            	<p>企业招聘</p>
	                <p>RECRUIT</p>
                </a>
            </li>
            <li>
            	<a title="联系我们" href="联系我们.html">
	            	<p>联系我们</p>
	                <p>CONTACT</p>
                </a>
            </li>
        </ul>
    </div>
</div>