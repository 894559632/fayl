<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>编辑车库账户</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.queue.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.handlers.js"></script>
<script type="text/javascript" src="/mag/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script src="/client/js/jquery.cityselect.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function () {
    //初始化表单验证
    $("#form1").initValidform();
    
    //初始化上传控件
    $(".upload-img").each(function () {
        $(this).InitSWFUpload({ 
            sendurl: "/Verwalter/upload", 
            flashurl: "/mag/js/swfupload.swf"
        });
    });
    
    //（缩略图）
    var txtPic = $("#txtImgUrl").val();
    if (txtPic == "" || txtPic == null) {
        $(".thumb_ImgUrl_show").hide();
    }
    else {
        $(".thumb_ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + txtPic + "' bigsrc='" + txtPic + "' /></div></li></ul>");
        $(".thumb_ImgUrl_show").show();
    }
    
    $(".upload-show360").each(function () {
        $(this).InitSWFUpload_show360({ 
            btntext: "批量上传", 
            btnwidth: 66, 
            single: false, 
            water: true, 
            thumbnail: true, 
            filesize: "5120", 
            sendurl: "/Verwalter/upload", 
            flashurl: "/mag/js/swfupload.swf", 
            filetypes: "*.jpg;*.jpge;*.png;*.gif;" 
        });
    });
    
    $("#address").citySelect({
        nodata:"none",
        <#if diy_user?? && diy_user.province??>prov: "${diy_user.province!''}",</#if>
        <#if diy_user?? && diy_user.city??>city: "${diy_user.city!''}",</#if>
        <#if diy_user?? && diy_user.disctrict??>dist: "${diy_user.disctrict!''}",</#if>
        required:false
    }); 
});
</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="/Verwalter/order/setting/diyuser/save" id="form1">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}">
<input name="id" type="text" value='<#if diy_user??>${diy_user.id?c}</#if>' style="display:none">
</div>

<!--导航栏-->
<div class="location">
  <a href="/Verwalter/order/setting/diyuser/list" class="back"><i></i><span>返回列表页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i>
  <a href="/Verwalter/order/setting/diyuser/list"><span>车库</span></a>
  <i class="arrow"></i>
  <span>编辑车库账户</span>
</div>
<div class="line10"></div>
<!--/导航栏-->

<!--内容-->
<div class="content-tab-wrap">
  <div id="floatHead" class="content-tab">
    <div class="content-tab-ul-wrap">
      <ul>
        <li><a href="javascript:;" onclick="tabs(this);" class="selected">编辑信息</a></li>
      </ul>
    </div>
  </div>
</div>

<div class="tab-content">
	<dl>
	    <dt>车库</dt>
	    <dd>
	        <div class="rule-single-select single-select">
	        <select name="diyId" datatype="*" sucmsg=" "  <#if diy_user??&&diy_user.roleId??&&diy_user.roleId==0>disabled=""</#if>>
	            <option value="" <#if !diy_user??>selected="selected"</#if>>请选择</option>
	            <#if diy_site_list??>
	                <#list diy_site_list as site>
	                    <option value="${site.id?c}" <#if diy_user?? && diy_user.diyId == site.id>selected="selected"</#if>>${site.title!''}</option>
	                </#list>
	            </#if>
	        </select>
	        </div>
	    </dd>
	</dl>
  <dl>
    <dt>登录名</dt>
    <dd>
	    <#if diy_user??>
	    	<input type="hidden" name="username" value="${diy_user.username!""}" />
	        <span>${diy_user.username!""}</span>
	    <#else>
        	<input name="username" type="text" value="" class="input normal" ajaxurl="/Verwalter/order/setting/diyuser/check" datatype="*6-100" sucmsg=" "> 
        </#if>
        <span class="Validform_checktip"></span>
    </dd>
  </dl>
  <dl>
    <dt>登录密码</dt>
    <dd>
        <input name="password" type="password" value="<#if diy_user??>${diy_user.password!""}</#if>" class="input normal" datatype="*6-20" sucmsg=" "> 
        <span class="Validform_checktip">*</span>
    </dd>
  </dl>
  <dl>
    <dt>重复密码</dt>
    <dd>
        <input type="password" value="<#if diy_user??>${diy_user.password!""}</#if>" class="input normal" datatype="*" recheck="password" sucmsg=" "> 
        <span class="Validform_checktip">*</span>
    </dd>
  </dl>
  
  <dl>
    <dt>角色</dt>
    <dd>
      <span>
      	<#if diy_user??&&diy_user.roleId == 0>
      		<input type="hidden" name="roleId" value="0" />
      		车库老板
      	<#elseif diy_user??&&diy_user.roleId==1||!diy_user??>
      		<input type="hidden" name="roleId" value="1" />
      		泊车员
      	</#if>		
      </span>
    </dd>
  </dl>
    <dl>
    <dt>姓名</dt>
    <dd>
      <input name="realName" type="text" value="<#if diy_user?? && diy_user.realName??>${diy_user.realName!''}</#if>" class="input normal" datatype="*"  errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  <dl>
    <dt>是否启用</dt>
    <dd>
      <div class="rule-multi-radio multi-radio">
        <span id="rblStatus" style="display: none;">
            <input type="radio" name="isEnable" value="1" <#if !diy_user?? || !diy_user.isEnable?? || diy_user?? && diy_user.isEnable?? && diy_user.isEnable>checked="checked"</#if>>
            <label>是</label>
            <input type="radio" name="isEnable" value="0" <#if diy_user?? && diy_user.isEnable?? && !diy_user.isEnable>checked="checked"</#if>>
            <label>否</label>
        </span>
      </div>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
    
</div>
<!--/内容-->


<!--工具栏-->
<div class="page-footer">
  <div class="btn-list">
    <input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btn">
    <input name="btnReturn" type="button" value="返回上一页" class="btn yellow" onclick="javascript:history.back(-1);">
  </div>
  <div class="clear"></div>
</div>
<!--/工具栏-->
</form>


</body></html>