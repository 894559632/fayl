<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统设置</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.queue.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.handlers.js"></script>
<script type="text/javascript" src="/mag/js/WdatePicker.js"></script>
<script type="text/javascript" charset="utf-8" src="/mag/js/kindeditor-min.js"></script>
<link href="/mag/style/WdatePicker.css" rel="stylesheet" type="text/css">
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
<link href="/mag/style/default.css" rel="stylesheet">
<script type="text/javascript">
$(function () {
    <#if status??>
        alert("修改公司信息成功");
    </#if>

    //初始化表单验证
    $("#form1").initValidform();
    
    //初始化编辑器
    var editor = KindEditor.create('.editor', {
        width: '98%',
        height: '350px',
        resizeType: 1,
        uploadJson: '/Verwalter/editor/upload?action=EditorFile',
        fileManagerJson: '/Verwalter/editor/upload?action=EditorFile',
        allowFileManager: true
    });
    
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
    
    var wxPic = $("#wxImgUrl").val();
    if (wxPic == "" || wxPic == null) {
        $(".thumb_wxImgUrl_show").hide();
    }
    else {
        $(".thumb_wxImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + wxPic + "' bigsrc='" + wxPic + "' /></div></li></ul>");
        $(".thumb_wxImgUrl_show").show();
    }
    
    var iOsPic = $("#iOsImgUrl").val();
    if (iOsPic == "" || iOsPic == null) {
        $(".thumb_iOsImgUrl_show").hide();
    }
    else {
        $(".thumb_iOsImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + iOsPic + "' bigsrc='" + iOsPic + "' /></div></li></ul>");
        $(".thumb_iOsImgUrl_show").show();
    }
    
    var androidPic = $("#androidImgUrl").val();
    if (androidPic == "" || androidPic == null) {
        $(".thumb_androidImgUrl_show").hide();
    }
    else {
        $(".thumb_androidImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + androidPic + "' bigsrc='" + androidPic + "' /></div></li></ul>");
        $(".thumb_androidImgUrl_show").show();
    }
    
    var logo1Pic = $("#logo1ImgUrl").val();
    if (logo1Pic == "" || logo1Pic == null) {
        $(".thumb_Logo1ImgUrl_show").hide();
    }
    else {
        $(".thumb_Logo1ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + logo1Pic + "' bigsrc='" + logo1Pic + "' /></div></li></ul>");
        $(".thumb_Logo1ImgUrl_show").show();
    }

    var logo2Pic = $("#logo2ImgUrl").val();
    if (logo2Pic == "" || logo2Pic == null) {
        $(".thumb_Logo2ImgUrl_show").hide();
    }
    else {
        $(".thumb_Logo2ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + logo2Pic + "' bigsrc='" + logo2Pic + "' /></div></li></ul>");
        $(".thumb_Logo2ImgUrl_show").show();
    }
    
    var logo3Pic = $("#logo3ImgUrl").val();
    if (logo3Pic == "" || logo3Pic == null) {
        $(".thumb_Logo3ImgUrl_show").hide();
    }
    else {
        $(".thumb_Logo3ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + logo3Pic + "' bigsrc='" + logo3Pic + "' /></div></li></ul>");
        $(".thumb_Logo3ImgUrl_show").show();
    }
    
    <#--
    $("#logo1ImgUrl").blur(function () {
        var logo1Pic = $("#logo1ImgUrl").val();
        if (logo1Pic == "" || logo1Pic == null) {
            $("#thumb_logo1ImgUrl_show").hide();
        }
        else {
            $("#thumb_logo1ImgUrl_show").html("<ul><li><div class='img-box1'><img src='" + logo1Pic + "' bigsrc='" + logo1Pic + "' /></div></li></ul>");
            $("#thumb_logo1ImgUrl_show").show();
        }
        
    });
    -->
});
</script>
</head>
<body class="mainbody">
<form method="post" action="/Verwalter/company/save" id="form1">
    <div>
    <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}" >
    <input type="hidden" name="id" value="<#if setting??&&setting.id??>${setting.id?c}</#if>" >
    </div>
    <!--导航栏-->
    <div class="location" style="position: static; top: 0px;">
      <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
      <i class="arrow"></i>
      <span>系统管理</span>
      <i class="arrow"></i>
      <span>系统设置</span>
    </div>
    <div class="line10"></div>
    <!--导航栏-->  
    <!--内容-->
    <div class="content-tab-wrap">
        <div id="floatHead" class="content-tab">
            <div class="content-tab-ul-wrap" >
                <ul>
                    <li><a href="javascript:;" onclick="tabs(this);" class="selected">基本信息</a></li>
                    <#--
                    <li><a href="javascript:;" onclick="tabs(this);">功能权限设置</a></li>
                    <li><a href="javascript:;" onclick="tabs(this);">网站奖励设置</a></li>
                    <li><a href="javascript:;" onclick="tabs(this);">注册用户协议</a></li>
                    -->
                </ul>
            </div>
        </div>
    </div>
    <div class="tab-content" style="display: block;">
        <dl>
            <dt>公司名称</dt>
            <dd>
                <input name="title" type="text" value="<#if setting??>${setting.title!""}</#if>" class="input normal" datatype="*0-100" sucmsg=" ">
                <span class="Validform_checktip"></span>
            </dd>
        </dl>
        <dl>
            <dt>公司介绍</dt>
            <dd>
                <div class="rule-single-select">
                    <select name="introductonNumber" id="introductonNumber" datatype="*" sucmsg=" ">
                        <#if !setting?? || !setting.id??>
                        <option value="">请选择...</option>
                        </#if>
                        <#if info_list??>
                            <#list info_list as c>
                                <option value="${c.number!'0'}" <#if goods?? && setting.introductonNumber==c.number>selected="selected"</#if>><#if c.layerCount?? && c.layerCount?? &&c.layerCount gt 1><#list 1..(c.layerCount-1) as a>　</#list>├ </#if>${c.title!""}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </dd>
        </dl>
        <dl>
            <dt>发展愿景</dt>
            <dd>
                <div class="rule-single-select">
					<select name="delvelopmentNumber" id="delvelopmentNumber" datatype="*" sucmsg=" ">
                        <#if !setting?? || !setting.id??>
                        <option value="">请选择...</option>
                        </#if>
                        <#if info_list??>
                            <#list info_list as c>
                                <option value="${c.number!'0'}" <#if goods?? && setting.delvelopmentNumber==c.number>selected="selected"</#if>><#if c.layerCount?? && c.layerCount?? &&c.layerCount gt 1><#list 1..(c.layerCount-1) as a>　</#list>├ </#if>${c.title!""}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </dd>
        </dl>
        <dl>
            <dt>设计理念</dt>
            <dd>
                <div class="rule-single-select">
                    <select name="conceptNumber" id="conceptNumber" datatype="*" sucmsg=" ">
                        <#if !setting?? || !setting.id??>
                        <option value="">请选择...</option>
                        </#if>
                        <#if info_list??>
                            <#list info_list as c>
                                <option value="${c.number!'0'}" <#if goods?? && setting.conceptNumber==c.number>selected="selected"</#if>><#if c.layerCount?? && c.layerCount?? &&c.layerCount gt 1><#list 1..(c.layerCount-1) as a>　</#list>├ </#if>${c.title!""}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </dd>
        </dl>
        <dl>
            <dt>人才战略</dt>
            <dd>
                <div class="rule-single-select">
                    <select name="jobInfoNumber" id="jobInfoNumber" datatype="*" sucmsg=" ">
                        <#if !setting?? || !setting.id??>
                        <option value="">请选择...</option>
                        </#if>
                        <#if info_list??>
                            <#list info_list as c>
                                <option value="${c.number!'0'}" <#if goods?? && setting.jobInfoNumber==c.number>selected="selected"</#if>><#if c.layerCount?? && c.layerCount?? &&c.layerCount gt 1><#list 1..(c.layerCount-1) as a>　</#list>├ </#if>${c.title!""}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </dd>
        </dl>
        <dl>
            <dt>SEO标题</dt>
            <dd>
                <input name="seoTitle" type="text" maxlength="255" id="txtSeoTitle" value="<#if goods??>${goods.seoTitle!""}</#if>" class="input normal" datatype="*0-100" sucmsg=" ">
                <span class="Validform_checktip">255个字符以内</span>
            </dd>
        </dl>
        <dl>
            <dt>SEO关健字</dt>
            <dd>
                <textarea name="seoKeywords" rows="2" cols="20" id="txtSeoKeywords" class="input" datatype="*0-255" sucmsg=" "><#if goods??>${goods.seoKeywords!""}</#if></textarea>
                <span class="Validform_checktip">以“,”逗号区分开，255个字符以内</span>
            </dd>
        </dl>
        <dl>
            <dt>SEO描述</dt>
            <dd>
                <textarea name="seoDescription" rows="2" cols="20" id="txtSeoDescription" class="input" datatype="*0-255" sucmsg=" "><#if goods??>${goods.seoDescription!""}</#if></textarea>
                <span class="Validform_checktip">255个字符以内</span>
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
</body>
</html>