<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>编辑车库</title>
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
        <#if diy_site?? && diy_site.province??>prov: "${diy_site.province!''}",</#if>
        <#if diy_site?? && diy_site.city??>city: "${diy_site.city!''}",</#if>
        <#if diy_site?? && diy_site.disctrict??>dist: "${diy_site.disctrict!''}",</#if>
        required:false
    }); 
});
</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="/Verwalter/order/setting/diysite/save" id="form1">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}">
<input name="diySiteId" type="text" value='<#if diy_site??>${diy_site.id?c}</#if>' style="display:none">
</div>

<!--导航栏-->
<div class="location">
  <a href="/Verwalter/order/setting/diysite/list" class="back"><i></i><span>返回列表页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i>
  <a href="/Verwalter/order/setting/diysite/list"><span>车库</span></a>
  <i class="arrow"></i>
  <span>编辑车库</span>
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
    <dt>车库名称</dt>
    <dd>
        <input name="title" type="text" value="<#if diy_site??>${diy_site.title!""}</#if>" class="input normal" datatype="*2-100" sucmsg=" "> 
        <span class="Validform_checktip">*车库名称</span>
    </dd>
  </dl>
  <dl>
    <dt>登录名</dt>
    <dd>
	    <#if diy_site??>
	        <span>${diy_site.username!""}</span>
	    <#else>
        	<input name="username" type="text" value="<#if diy_site??>${diy_site.username!""}</#if>" class="input normal" ajaxurl="/Verwalter/order/setting/diysite/check <#if diy_site??>?id=${diy_site.id?c}</#if>" datatype="*6-100" sucmsg=" "> 
        </#if>
        <span class="Validform_checktip"></span>
    </dd>
  </dl>
  <dl>
    <dt>登录密码</dt>
    <dd>
        <input name="password" type="password" value="<#if diy_site??>${diy_site.password!""}</#if>" class="input normal" datatype="*6-20" sucmsg=" "> 
        <span class="Validform_checktip">*</span>
    </dd>
  </dl>
  <dl>
    <dt>重复密码</dt>
    <dd>
        <input type="password" value="<#if diy_site??>${diy_site.password!""}</#if>" class="input normal" datatype="*" recheck="password" sucmsg=" "> 
        <span class="Validform_checktip">*</span>
    </dd>
  </dl>
  <dl>
    <dt>手机号</dt>
    <dd>
        <input name="mobile" type="text" value="<#if diy_site??>${diy_site.mobile!""}</#if>" class="input normal" datatype="m" sucmsg=" "> 
        <span class="Validform_checktip">*用于提取现金通知</span>
    </dd>
  </dl>
  
  <dl>
    <dt>车库详细位置</dt>
    <dd>
      <input name="address" type="text" value="<#if diy_site??>${diy_site.address!""}</#if>" class="input normal"  errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>车库类型</dt>
    <dd>
      <input name="parkingType" type="text" value="<#if diy_site?? && diy_site.parkingType??>${diy_site.parkingType!''}</#if>" class="input normal"  errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>车位类型</dt>
    <dd>
      <input name="parkingClassification" type="text" value="<#if diy_site?? && diy_site.parkingClassification??>${diy_site.parkingClassification!''}</#if>" class="input normal"  errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>车位个数</dt>
    <dd>
      <input name="parkingTotalNumber" type="text" value="<#if diy_site?? && diy_site.longitude??>${diy_site.parkingTotalNumber!'0'}</#if>" class="input normal" datatype="*" errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>经度</dt>
    <dd>
      <input name="longitude" type="text" value="<#if diy_site?? && diy_site.longitude??>${diy_site.longitude?string("#.######")}</#if>" class="input normal" datatype="/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,6})?$/" errormsg="" sucmsg=" ">
      <a href="http://lbs.amap.com/console/show/picker" target="_blank">坐标拾取</a>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>纬度</dt>
    <dd>
      <input name="latitude" type="text" value="<#if diy_site?? && diy_site.latitude??>${diy_site.latitude?string("#.######")}</#if>" class="input normal" datatype="/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,6})?$/" errormsg="" sucmsg=" ">
      <a href="http://lbs.amap.com/console/show/picker" target="_blank">坐标拾取</a>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  <#--
  <dl>
    <dt>付款方式</dt>
    <dd>
      <input name="payType" type="text" value="<#if diy_site??>${diy_site.payType!""}</#if>" class="input normal" datatype="*" errormsg="" sucmsg=" ">
      <span class="Validform_checktip">现金/刷卡</span>
    </dd>
  </dl>
  -->
  <dl>
    <dt>营业时间</dt>
    <dd>
      <input name="openTimeSpan" type="text" value="<#if diy_site??>${diy_site.openTimeSpan!""}</#if>" class="input normal" datatype="*" errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  
  <dl>
    <dt>客服电话</dt>
    <dd>
      <input name="serviceTele" type="text" value="<#if diy_site??>${diy_site.serviceTele!""}</#if>" class="input normal" datatype="*" errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  <#--
  <dl>
    <dt>投诉电话</dt>
    <dd>
      <input name="complainTele" type="text" value="<#if diy_site??>${diy_site.complainTele!""}</#if>" class="input normal" datatype="*" errormsg="" sucmsg=" ">
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
  -->
  <dl>
    <dt>是否启用</dt>
    <dd>
      <div class="rule-multi-radio multi-radio">
        <span id="rblStatus" style="display: none;">
            <input type="radio" name="isEnable" value="1" <#if !diy_site?? || !diy_site.isEnable?? || diy_site?? && diy_site.isEnable?? && diy_site.isEnable>checked="checked"</#if>>
            <label>是</label>
            <input type="radio" name="isEnable" value="0" <#if diy_site?? && diy_site.isEnable?? && !diy_site.isEnable>checked="checked"</#if>>
            <label>否</label>
        </span>
      </div>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
    <dl>
    <dt>车牌识别系统</dt>
    <dd>
      <div class="rule-multi-radio multi-radio">
        <span id="rblStatus" style="display: none;">
            <input type="radio" name="isCamera" value="1" <#if !diy_site??||(diy_site??&&diy_site.isCamera??&&diy_site.isCamera)>checked="checked"</#if>>
            <label>是</label>
            <input type="radio" name="isCamera" value="0" <#if diy_site??&&diy_site.isCamera??&&!diy_site.isCamera>checked="checked"</#if>>
            <label>否</label>
        </span>
      </div>
      <span class="Validform_checktip"></span>
    </dd>
  <dl>
    <dt>排序数字</dt>
    <dd>
      <input name="sortId" type="text" value="<#if diy_site??>${diy_site.sortId!""}<#else>99</#if>" class="input small" datatype="n" sucmsg=" ">
      <span class="Validform_checktip">*数字，越小越向前</span>
    </dd>
  </dl>
  
  <dl>
    <dt>描述说明</dt>
    <dd>
      <textarea name="info" rows="2" cols="20" class="input normal"><#if diy_site??>${diy_site.info!""}</#if></textarea>
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