<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>编辑信息</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script type="text/javascript" src="/mag/js/WdatePicker.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.queue.js"></script>
<script type="text/javascript" src="/mag/js/swfupload.handlers.js"></script>
<script type="text/javascript" charset="utf-8" src="/mag/js/kindeditor-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/mag/js/zh_CN.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<link href="/mag/style/WdatePicker.css" rel="stylesheet" type="text/css">
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
<link href="/mag/style/default.css" rel="stylesheet">
<script type="text/javascript">
    $(function () {
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
    });
</script>
</head>
<body class="mainbody">
<form method="post" action="/Verwalter/article/save" id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="${__EVENTTARGET!""}" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="${__EVENTARGUMENT!""}" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}" />
</div>
<input name="menuId" type="text" value='${mid!""}' style="display:none;">
<input name="channelId" type="text" value='${cid!""}' style="display:none">
<input name="id" type="text" value='<#if article??>${article.id?c!""}</#if>' style="display:none">
    <!--导航栏-->
    <div class="location">
        <a href="/Verwalter/content/list?cid=${cid!""}&mid=${mid!""}" class="back"><i></i><span>
            返回列表页</span></a> 
        <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
        <i class="arrow"></i>
        <a href="/Verwalter/content/list?cid=${cid!""}&mid=${mid!""}"><span>
            内容管理</span></a> <i class="arrow"></i><span>编辑信息</span>
    </div>
    <div class="line10">
    </div>
    <!--/导航栏-->
    <!--内容-->
    <div class="content-tab-wrap">
        <div id="floatHead" class="content-tab">
            <div class="content-tab-ul-wrap">
                <ul>
                    <li><a href="javascript:;" onclick="tabs(this);" class="selected">基本信息</a></li>
                    <li><a href="javascript:;" onclick="tabs(this);" class="">详细描述</a></li>
                    <li><a href="javascript:;" onclick="tabs(this);" class="">SEO选项</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="tab-content" style="display: block;">
        <dl>
            <dt>所属类别</dt>
            <dd>
                <div class="rule-single-select">
                    <select name="categoryNumber" id="ddlCategoryId" datatype="*" sucmsg=" " nullmsg="请选择！" class="Validform_error" style="display: none;">
                    	<#if article??>
                    	<#else>
                    	<option value="">请选择类别...</option>
                    	</#if>
                        <#if category_list??>
                            <#list category_list as c>
                                <option value="${c.number!""}" <#if article?? && article.categoryNumber==c.number>selected="selected"</#if>><#if c.layerCount?? && c.layerCount gt 1><#list 1..(c.layerCount-1) as a>　</#list>├ </#if>${c.title!""}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
                <#if article??>
                    <span class="Validform_checktip Validform_right"></span>
                <#else>
                    <span class="Validform_checktip Validform_wrong">请选择！</span>
                </#if>
            </dd>
        </dl>
        <#--
        <dl>
            <dt>推荐类型</dt>
            <dd>
                <div class="rule-multi-checkbox multi-checkbox">
                    <span id="cblItem" style="display: none;">
                        <input id="cblItem_0" type="checkbox" name="recommendId"><label for="cblItem_0">允许评论</label>
                        <input id="cblItem_1" type="checkbox" name="recommendId"><label for="cblItem_1">置顶</label>
                        <input id="cblItem_2" type="checkbox" name="recommendId"><label for="cblItem_2">推荐</label>
                        <input id="cblItem_3" type="checkbox" name="recommendId"><label for="cblItem_3">热门</label>
                        <input id="cblItem_4" type="checkbox" name="recommendId"><label for="cblItem_4">幻灯片</label>
                    </span>
                </div>
            </dd>
        </dl>
        -->
        <dl>
            <dt>内容标题</dt>
            <dd>
                <input name="title" type="text" value="<#if article??>${article.title!""}</#if>" id="txtTitle" class="input normal" datatype="*2-100" sucmsg=" ">
                <span class="Validform_checktip">*标题最多100个字符</span>
            </dd>
        </dl>
        
        <dl>
            <dt>封面图片</dt>
            <dd>
                <input name="imgUri" type="text" id="txtImgUrl" value="<#if article??>${article.imgUri!""}</#if>" class="input normal upload-path">
                <div class="upload-box upload-img"></div>
                <div class="photo-list thumb_ImgUrl_show" style="display: none;">
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
                <input name="sortId" type="text" value="<#if article??>${article.sortId!""}<#else>99</#if>" id="txtSortId" class="input txt100" datatype="n" sucmsg=" ">
                <span class="Validform_checktip">*数字，越小越向前</span>
            </dd>
        </dl>
    </div>
    
    <div class="tab-content" style="display: none;">
        <dl>
            <dt>文章作者</dt>
            <dd>
                <input name="author" type="text" value="<#if article??>${article.author!''}</#if>" id="txtSortId" class="input txt100" datatype="*" sucmsg=" ">
                <span class="Validform_checktip">文章的作者</span>
            </dd>
        </dl>
        <dl>
            <dt>内容摘要</dt>
            <dd>
                <textarea name="summary" rows="2" cols="20" id="txtZhaiyao" class="input" datatype="*0-255" sucmsg=" "><#if article??>${article.summary!""}</#if></textarea>
                <span class="Validform_checktip">不填写则自动截取内容前255字符</span>
            </dd>
        </dl>
        <dl>
            <dt>内容描述</dt>
            <dd>
                <textarea name="content" class="editor" style="visibility:hidden;"><#if article??>${article.content!""}</#if></textarea>
            </dd>
        </dl>
    </div>
    <div class="tab-content" style="display: none;">
        <dl>
            <dt>SEO标题</dt>
            <dd>
                <input name="seoTitle" type="text" maxlength="255" id="txtSeoTitle" value="<#if article??>${article.seoTitle!""}</#if>" class="input normal" datatype="*0-100" sucmsg=" ">
                <span class="Validform_checktip">255个字符以内</span>
            </dd>
        </dl>
        <dl>
            <dt>SEO关健字</dt>
            <dd>
                <textarea name="seoKeywords" rows="2" cols="20" id="txtSeoKeywords" class="input" datatype="*0-255" sucmsg=" "><#if article??>${article.seoKeywords!""}</#if></textarea>
                <span class="Validform_checktip">以“,”逗号区分开，255个字符以内</span>
            </dd>
        </dl>
        <dl>
            <dt>SEO描述</dt>
            <dd>
                <textarea name="seoDescription" rows="2" cols="20" id="txtSeoDescription" class="input" datatype="*0-255" sucmsg=" "><#if article??>${article.seoDescription!""}</#if></textarea>
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
        <div class="clear">
        </div>
    </div>
    <!--/工具栏-->
    </form>


</body></html>