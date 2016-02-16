<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>编辑车库提现</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.queue.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.handlers.js"></script>
<script type="text/javascript" src="/mag/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
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
    

});
</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="/Verwalter/order/setting/deposit/save" id="form1">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}">
<input name="id" type="text" value='${deposit_diy.id?c}' style="display:none">
<input name="diyId" type="text" value='<#if deposit_diy.diyId??>${deposit_diy.diyId?c}</#if>' style="display:none">
</div>

<!--导航栏-->
<div class="location">
  <a href="/Verwalter/order/setting/depositDiy/list" class="back"><i></i><span>返回列表页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i>
  <a href="/Verwalter/order/setting/depositDiy/list"><span>车库提现</span></a>
  <i class="arrow"></i>
  <span>编辑车库提现</span>
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
	    	<input type="hidden" name="diyName" value="${deposit_diy.diyName!""}" />
	        <span>${deposit_diy.diyName!""}</span>
    </dd>
  </dl>
  <dl>
    <dt>金额</dt>
    <dd>
	    	<input type="hidden" name="money" value="<#if deposit_diy.money??>${deposit_diy.money?string('0.00')}<#else>0.00</#if>" />
	        <span style="color:#C30000;">￥<#if deposit_diy.money??>${deposit_diy.money?string('0.00')}<#else>0.00</#if></span>
    </dd>
  </dl>
  <dl>
    <dt>提现单号</dt>
    <dd>
	    	<input type="hidden" name="num" value="${deposit_diy.num!''}" />
	        <span>${deposit_diy.num!''}</span>
    </dd>
  </dl>
    <dl>
    <dt>提现时间</dt>
    <dd>
	    	<input type="hidden" name="depositDate" value="${deposit_diy.depositDate!''}" />
	        <span>${deposit_diy.depositDate!''}</span>
    </dd>
  </dl>

  <dl>
    <dt>是否同意</dt>
    <dd>
      <div class="rule-multi-radio multi-radio">
        <span id="rblStatus" style="display: none;">
            <input type="radio" name="isOperate" value="1" <#if deposit_diy.isOperate?? && deposit_diy.isOperate>checked="checked"</#if>>
            <label>是</label>
            <input type="radio" name="isOperate" value="0" <#if  !deposit_diy.isOperate?? || deposit_diy.isOperate?? && !deposit_diy.isOperate>checked="checked"</#if>>
            <label>否</label>
        </span>
      </div>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
    <dl <#if deposit_diy.isOperate??&&deposit_diy.isOperate><#else>style="display:none;"</#if>>
    <dt>处理时间</dt>
    <dd>
	    	<input type="hidden" name="operateTime" value="${deposit_diy.operateTime!''}" />
	        <span>${deposit_diy.operateTime!''}</span>
    </dd>
  </dl>
  
    <dl>
    <dt>是否打款</dt>
    <dd>
      <div class="rule-multi-radio multi-radio">
        <span id="rblStatus" style="display: none;">
            <input type="radio" name="isRemit" value="1" <#if deposit_diy?? && deposit_diy.isRemit?? && deposit_diy.isRemit>checked="checked"</#if>>
            <label>是</label>
            <input type="radio" name="isRemit" value="0" <#if  !deposit_diy?? || !deposit_diy.isRemit?? ||deposit_diy?? && deposit_diy.isRemit?? && !deposit_diy.isRemit>checked="checked"</#if>>
            <label>否</label>
        </span>
      </div>
      <span class="Validform_checktip"></span>
    </dd>
  </dl>
    <dl <#if deposit_diy.isRemit??&&deposit_diy.isRemit><#else>style="display:none;"</#if>>
    <dt>打款时间</dt>
    <dd>
	    	<input type="hidden" name="remitTime" value="${deposit_diy.remitTime!''}" />
	        <span>${deposit_diy.remitTime!''}</span>
    </dd>
  </dl>
  
  <#if deposit_diy.bankName??>
	  <dl>
	    <dt>银行名称</dt>
	    <dd>
		    	<input type="hidden" name="bankName" value="${deposit_diy.bankName!''}" />
		        <span>${deposit_diy.bankName!''}</span>
	    </dd>
	  </dl>  
  </#if>
  <#if deposit_diy.cardName??>
	  <dl>
	    <dt>持卡人姓名</dt>
	    <dd>
		    	<input type="hidden" name="cardName" value="${deposit_diy.cardName!''}" />
		        <span>${deposit_diy.cardName!''}</span>
	    </dd>
	  </dl>  
  </#if>  
  <#if deposit_diy.cardNum??>
	  <dl>
	    <dt>银行卡号</dt>
	    <dd>
		    	<input type="hidden" name="cardNum" value="${deposit_diy.cardNum!''}" />
		        <span>${deposit_diy.cardNum!''}</span>
	    </dd>
	  </dl>  
  </#if>
  <#-- 车库提现 -->
    <#if deposit_diy.belongBegin??>
	  <dl>
	    <dt>提现金额所属起始时间</dt>
	    <dd>
		    	<input type="hidden" name="cardNum" value="${deposit_diy.belongBegin!''}" />
		        <span>${deposit_diy.belongBegin!''}</span>
	    </dd>
	  </dl>  
  </#if>
    <#if deposit_diy.belongFinish??>
	  <dl>
	    <dt>提现金额所属结束时间</dt>
	    <dd>
		    	<input type="hidden" name="belongFinish" value="${deposit_diy.belongFinish!''}" />
		        <span>${deposit_diy.belongFinish!''}</span>
	    </dd>
	  </dl>  
  </#if>
    
  <dl>
    <dt>备注</dt>
    <dd>
      <textarea name="remark" rows="2" cols="20" class="input normal"><#if deposit_diy??>${deposit_diy.remark!""}</#if></textarea>
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