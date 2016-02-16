<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>待付款订单</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<script type="text/javascript" src="/mag/js/WdatePicker.js"></script>
<link href="/mag/style/pagination.css" rel="stylesheet" type="text/css">
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">

</head>
<body class="mainbody">
<form name="form1" method="post" action="/Verwalter/user/recharge/list" id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}" >
</div>

<script type="text/javascript">
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}

   document.onkeydown = function(event){
	    if((event.keyCode || event.which) == 13){
	    	__doPostBack('btnSearch','')
	    }
   }
</script>

    <!--导航栏-->
    <div class="location">
        <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
        <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
        <i class="arrow"></i>
        <a><span>会员管理</span></a>
        <i class="arrow"></i>
        <a><span>充值记录</span></a>
    </div>
    <!--/导航栏-->
    <!--工具栏-->
    <div class="toolbar-wrap">
        <div id="floatHead" class="toolbar">
            <div class="l-list">
                <div class="menu-list">
                	<span style="margin:9px 5px 0 5px;float:left; font-size:12px;">筛选查找：</span>
				      <div class="input-date" style="width:204px;">
				      	<span style="margin:9px 5px 0 5px;float:left; font-size:12px;" >从</span>
				        <input  name="date_1" type="text" style="font-size:12px;" value="<#if date_1??>${date_1}</#if>" class="input date" onfocus="WdatePicker({dateFmt:&#39;yyyy-MM-dd&#39;})" datatype="/^\s*$|^\d{4}\-\d{1,2}\-\d{1,2}$/" errormsg="请选择正确的日期" sucmsg=" ">
				        <i>日期</i>
				      </div>		
			      		
				      <div class="input-date" style="width:204px;">
				      	<span style="margin:9px 5px 0 5px;float:left; font-size:12px;" >至</span>
				        <input  name="date_2" type="text" style="font-size:12px;" value="<#if date_2??>${date_2}</#if>" class="input date" onfocus="WdatePicker({dateFmt:&#39;yyyy-MM-dd&#39;})" datatype="/^\s*$|^\d{4}\-\d{1,2}\-\d{1,2}$/" errormsg="请选择正确的日期" sucmsg=" ">
				        <i>日期</i>
				      </div>			      
			    </div>
			<div class="r-list">
				<span style="float:left;font-size:12px;margin:9px 0 0 10px;">关键字：</span>
                <input value="<#if keywords??>${keywords}</#if>" style="margin-left:5px;" name="keywords" type="text" class="keyword">
                <a title="查询" id="lbtnSearch" class="btn-search" href="javascript:__doPostBack('btnSearch','')">查询</a>
            </div>
            </div>

        </div>
    </div>
    <!--/工具栏-->
    <!--列表-->
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ltable">
        <tbody>
            <tr class="odd_bg">
                <th align="center">充值单号</th>
                <th align="center" width="25%">会员账号</th>
                <th align="center" width="15%">充值时间</th>
                <th align="center" width="15%">充值金额</th>
                <th align="center" width="15%">是否成功</th>
            </tr>
        
            <#if log_page??>
                <#list log_page.content as item>
                    <tr>
                        <td align="center"> 
                            <a>${item.num!""}</a>
                        </td>
                        <td align="center">
                            <a>${item.username!""}</a>
                        </td>
                        <td align="center">
                            <a><#if item.rechargeDate??>${item.rechargeDate?string("yyyy-MM-dd HH:mm:ss")}</#if></a>
                        </td>
                        <td align="center">
                            ￥<span style="color:#C30000;"><#if item.money??>${item.money?string("0.00")}</#if></span>
                        </td>
                        <td align="center">
                            <a>
                                <#if item.statusId??&&item.statusId==0>
                                    <font color="green">成功</font>
                                <#else>
                                    <font color="red">失败</font>
                                </#if>
                            </a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </tbody>
    </table>
        
<!--/列表-->
<!--内容底部-->
<#assign PAGE_DATA=log_page />
<#include "/site_mag/list_footer.ftl" />
<!--/内容底部-->
</form>


</body></html>
