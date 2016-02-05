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
	
				<form action="/remark/save" method="post" onsubmit="return footer.check();">
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
	        </dl>
	    </div>
	</#if>
</div>
<script type="text/javascript" src="/client/js/Mr.D/footer.js"></script>