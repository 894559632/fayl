<div class="footer">
	<#if setting??>
	    <div class="wrapper">
	        <dl>
	            <dt class="contractus">
	                <span>联系我们</span>
	            <p>地址：${setting.address!''}</p>
	
	            <p>电话：${setting.telephone!''}</p>
	
	            <p>邮箱：${setting.adminEmail!''}</p>
	
	            <p>Q Q：${setting.qq!''}</p>
	            </dt>
	
				<form method="post" onsubmit="return remarker.check();">
		            <dd class="messagetous">
		                <span>在线留言</span>
		                <div class="message-item">
		                    <div class="fl">
		                        <div class="inputitem"><label>称呼</label><input id="visitor_name" name="name" type="text"></div>
		                        <div class="inputitem"><label>电话</label><input id="visitor_phone" name="phone" type="text"></div>
		                        <div class="inputitem"><label>邮箱</label><input id="visitor_email" name="email" type="text"></div>
		                    </div>
		                    <div class="fl">
		                        <div class="textareaitem">
		                            <label>留言内容</label>
		                            <textarea id="visitor_remark" name="remark"></textarea>
		                        </div>
		                        <input type="submit" class="btnsubmit" value="留言"/>
		                    </div>
		                </div>
		            </dd>
	            </form>
	            <dd class="friendship-link">友情链接：
		            <#if link_list??&&link_list?size gt 0>
		                <div class="linkitem">
		                	<#list link_list as item>
			                	<#if item??>
			                    	<a target="_Blank" href="${item.linkUri!''}" title="<#if setting??>${setting.title!''}-</#if>${item.title!''}">	${item.title!''}</a>
			                    </#if>
		                    </#list>
		                </div>
	                </#if>
	                <div class="copyright"><#if setting??>${setting.icpNumber!''}</#if></div>
    			</dd>
	        </dl>
	    </div>
	</#if>
</div>
<script type="text/javascript" src="/front/js/Mr.D/remark.js"></script>