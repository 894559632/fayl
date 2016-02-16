<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>提现列表</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<script type="text/javascript" src="/mag/js/WdatePicker.js"></script>
<link href="/mag/style/pagination.css" rel="stylesheet" type="text/css">
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
</head>

<body class="mainbody">
<form name="form1" method="post" action="/Verwalter/order/setting/depositDiy/list" id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="${__EVENTTARGET!""}">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="${__EVENTARGUMENT!""}">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}">
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
  <a href="/Verwalter/order/setting/depositDiy/list" class="back"><i></i><span>返回列表页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i>
  <span>车库提现</span>
</div>
<!--/导航栏-->

<!--工具栏-->
<div class="toolbar-wrap">
  <div id="floatHead" class="toolbar">
    <div class="l-list">
      <ul class="icon-list">
        <li><a class="all" href="javascript:;" onclick="checkAll(this);"><i></i><span>全选</span></a></li>
        <#--<li><a id="btnSave" class="save" href="javascript:__doPostBack('btnSave','')"><i></i><span>保存</span></a></li>-->
        <li><a onclick="return ExePostBack('btnDelete');" id="btnDelete" class="del" href="javascript:__doPostBack('btnDelete','')"><i></i><span>删除</span></a></li>
      </ul>
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
		    <input name="keywords" type="text" class="keyword" value="${keywords!''}">
		    <a id="lbtnSearch" class="btn-search" href="javascript:__doPostBack('btnSearch','')">查询</a>
	    </div>      
    </div>

  </div>
</div>
<!--/工具栏-->

<!--列表-->

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ltable">
  <tbody>
  <tr class="odd_bg">
    <th width="8%">选择</th>
    <th align="left">车库名称</th>
    <th align="left">金额</th>
    <th align="left">提现单号</th>
    <th align="left">提现时间</th>
    <th width="8%">是否同意</th>
    <th width="8%">是否打款</th>
    <th width="10%">操作</th>
  </tr>

    <#if deposit_diy_page??>
        <#list deposit_diy_page.content as item>
            <tr>
                <td align="center">
                    <span class="checkall" style="vertical-align:middle;">
                        <input id="listChkId" type="checkbox" name="listChkId" value="${item_index}" >
                    </span>
                    <input type="hidden" name="listId" id="listId" value="${item.id?c}">
                </td>
                <td><a href="/Verwalter/order/setting/depositDiy/edit?id=${item.id?c}">${item.diyName!""}</a></td>
                <td>￥<span style="color:#C30000;"><#if item.money??>${item.money?string("0.00")}<#else>0.00</#if></span></td>
                <td>${item.num!''}</td>
                <td>${item.depositDate!''}</td>
                <td align="center"><#if item.isOperate?? && item.isOperate>是<#else>否</#if></td>
                <td align="center"><#if item.isRemit?? && item.isRemit>是<#else>否</#if></td>
                <td align="center">
                    <a href="/Verwalter/order/setting/depositDiy/edit?id=${item.id?c}">修改</a>
                </td>
              </tr>
        </#list>
    </#if>
 
</tbody></table>

<!--/列表-->

<!--内容底部-->
<#assign PAGE_DATA=deposit_diy_page />
<#include "/site_mag/list_footer.ftl" />
<!--/内容底部-->
</form>

</body></html>