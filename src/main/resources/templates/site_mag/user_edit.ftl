<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>编辑会员信息</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script type="text/javascript" src="/mag/js/WdatePicker.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.queue.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.handlers.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
<link href="/mag/style/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function () {
    //初始化表单验证
    $("#form_user").initValidform();

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

    $("#txtImgUrl").blur(function () {
        var txtPic = $("#txtImgUrl").val();
        if (txtPic == "" || txtPic == null) {
            $(".thumb_ImgUrl_show").hide();
        }
        else {
            $(".thumb_ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + txtPic + "' bigsrc='" + txtPic + "' /></div></li></ul>");
            $(".thumb_ImgUrl_show").show();
        }
    });  
    
    //设置封面图片的样式
    $(".photo-list ul li .img-box img").each(function () {
        if ($(this).attr("src") == $("#hidFocusPhoto").val()) {
            $(this).parent().addClass("selected");
        }
    });
    
    $("#btnEditRemark").click(function () { EditOrderRemark(); });    //修改粮草备注 
});   

   //修改粮草备注
        function EditOrderRemark() {
            var dialog = $.dialog({
                title: '修改粮草备注',
                content: '<input type="checkbox" name="showtype" id="showtype" checked="checked"/><label> 仅后台显示</label> </br><textarea id="pointRemark" name="txtPointRemark" rows="2" cols="20" class="input"></textarea>',
                min: false,
                max: false,
                lock: true,
                ok: function () {
                    var showtype = $("#showtype", parent.document).is(':checked');                    
                    var remark = $("#pointRemark", parent.document).val();                   
                    if (remark == "") {
                        $.dialog.alert('对不起，请输入备注内容！', function () { }, dialog);
                        return false;
                    }
                    var userId = eval(document.getElementById("userId")).value;
                    var point = eval(document.getElementById("totalPoints")).value;
                    var postData = { "userId": userId, "totalPoints": point, "data": remark, "type":"editPoint", "isBackgroundShow": showtype};
                    //发送AJAX请求
                    sendAjaxUrl(dialog, postData, "/Verwalter/user/param/edit");
                    return false;
                },
                cancel: true
            });
        }
    //发送AJAX请求
        function sendAjaxUrl(winObj, postData, sendUrl) {
            $.ajax({
                type: "post",
                url: sendUrl,
                data: postData,
                dataType: "json",
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.dialog.alert('尝试发送失败，错误信息：' + errorThrown, function () { }, winObj);
                },
                success: function (data) {
                    if (data.code == 0) {
                        winObj.close();
                        $.dialog.tips(data.msg, 2, '32X32/succ.png', function () { location.reload(); }); //刷新页面
                    } else {
                        $.dialog.alert('错误提示：' + data.message, function () { }, winObj);
                    }
                }
            });
        }     
</script>
</head>

<body class="mainbody">
<form name="form_user" method="post" action="/Verwalter/user/save" id="form_user">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}" >
<input type="hidden" id="userId" name="id" value="<#if user??>${user.id?c!""}</#if>" >
</div>
<!--导航栏-->
<div class="location" style="position: static; top: 0px;">
  <a href="/Verwalter/user/list?roleId=${roleId!""}"><i></i><span>返回列表页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i>
  <span>会员管理</span>
  <i class="arrow"></i>
  <span>编辑会员信息</span>
</div>
<div class="line10"></div>
<!--/导航栏-->

<!--内容-->
<div class="content-tab-wrap">
  <div id="floatHead" class="content-tab" style="position: static; top: 52px;">
    <div class="content-tab-ul-wrap">
      <ul>
        <li><a href="javascript:;" onclick="tabs(this);" class="selected">基本资料</a></li>
        <#--<li><a href="javascript:;" onclick="tabs(this);">安全设置</a></li>
        <li><a href="javascript:;" onclick="tabs(this);">账户信息</a></li>
        -->
      </ul>
    </div>
  </div>
</div>

<!--基本资料-->
<div class="tab-content">
  <dl>
    <dt>姓名</dt>
    <dd><input name="name" type="text" value="<#if user??>${user.name!""}</#if>" id="txtEmail" class="input normal" ignore="ignore" datatype="*" sucmsg=" " > <span class="Validform_checktip">*设计师姓名</span></dd>
  </dl>
  <dl>
    <dt>职务</dt>
    <dd><input name="position" type="text" value="<#if user??>${user.position!""}</#if>" class="input normal" ignore="ignore" datatype="*" sucmsg=" " ><span class="Validform_checktip">*设计师职务</span></dd>
  </dl>
  <dl>
    <dt>上传头像</dt>
    <dd>
        <input id="txtImgUrl" name="photoUri" type="text" value="<#if user??>${user.photoUri!""}</#if>" class="input normal upload-path">
        <div class="upload-box upload-img"></div>
        <div class="photo-list thumb_ImgUrl_show">
            <ul>
                <li>
                    <div class="img-box1"></div>
                </li>
            </ul>
        </div>
    </dd>
  </dl>
  <dl>
    <dt>排序数字</dt>
    <dd>
        <input name="sortId" type="text" value="<#if user??>${user.sortId!""}<#else>99</#if>" id="txtSortId" class="input txt100" datatype="n" sucmsg=" ">
        <span class="Validform_checktip">*数字，越小越向前</span>
    </dd>
</dl>
</div>
<!--/基本资料-->

<!--安全设置-->
<div class="tab-content" style="display:none;">  

  <#--
  <dl>
    <dt>用户等级</dt>
    <dd><input name="userLevelId" type="text" value="<#if user??>${user.userLevelId!""}</#if>" class="input normal" datatype="n0-2" errormsg="请输入正确的等级" sucmsg=" " > <span class="Validform_checktip"></span></dd>
  </dl>
  <dl>
    <dt>用户等级名称</dt>
    <dd><span><#if user??>${user.userLevelTitle!""}</#if></span></dd>
  </dl>
 
  <dl>
    <dt>咨询总数</dt>
    <dd><span><#if user??>${user.totalConsults!""}</#if></span></dd>
  </dl>
  <dl>
    <dt>评论总数</dt>
    <dd><span><#if user??>${user.totalComments!""}</#if></span></dd>
  </dl>
  <dl>
    <dt>退换货总数</dt>
    <dd><span><#if user??>${user.totalReturns!""}</#if></span></dd>
  </dl>-->
</div>
<!--/安全设置-->
<#--
<div class="tab-content" style="display:none;">
  <dl>
    <dt>下级用户总数</dt>
    <dd><input name="totalLowerUsers" type="text" id="txtPay_Password" class="input normal" nullmsg="请设置支付密码" errormsg="支付密码范围在6-20位之间" sucmsg=" " value=""> <span class="Validform_checktip">*平台内支付的密码，至少6位</span></dd>
  </dl>
  <dl>
    <dt>用户返现总数</dt>
    <dd><input name="totalCashRewards" type="text" id="txtPay_Password" class="input normal" nullmsg="请设置支付密码" errormsg="支付密码范围在6-20位之间" sucmsg=" " value=""> <span class="Validform_checktip">*平台内支付的密码，至少6位</span></dd>
  </dl>
  <dl>
    <dt>银行卡号</dt>
    <dd><input name="bankCardCode" type="text" id="txtPay_Password" class="input normal" nullmsg="请设置支付密码" errormsg="支付密码范围在6-20位之间" sucmsg=" " value=""> <span class="Validform_checktip">*平台内支付的密码，至少6位</span></dd>
  </dl>
  <dl>
    <dt>银行名称</dt>
    <dd><input name="bankTitle" type="text" id="txtPay_Password" class="input normal" nullmsg="请设置支付密码" errormsg="支付密码范围在6-20位之间" sucmsg=" " value=""> <span class="Validform_checktip">*平台内支付的密码，至少6位</span></dd>
  </dl>
  <dl>
    <dt>银行卡已验证</dt>
    <dd><input name="txtPay_Password" type="text" id="txtPay_Password" class="input normal" nullmsg="请设置支付密码" errormsg="支付密码范围在6-20位之间" sucmsg=" " value=""> <span class="Validform_checktip">*平台内支付的密码，至少6位</span></dd>
  </dl>
</div>
-->
<!--/账户信息-->


<!--借款标的-->

<!--/借款标的-->

<!--投资标的-->

<!--/投资标的-->

<!--资金明细-->

<!--/资金明细-->

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