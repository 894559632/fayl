<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mag/style/idialog.css" rel="stylesheet" id="lhgdialoglink">
<title>内容列表</title>
<script type="text/javascript" src="/mag/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/mag/js/jquery.lazyload.min.js"></script>
<script type="text/javascript" src="/mag/js/lhgdialog.js"></script>
<script type="text/javascript" src="/mag/js/layout.js"></script>
<link href="/mag/style/style.css" rel="stylesheet" type="text/css">
<link href="/mag/style/pagination.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    $(function () {
        imgLayout();
        $(window).resize(function () {
            imgLayout();
        });
        //图片延迟加载
        $(".pic img").lazyload({ load: AutoResizeImage, effect: "fadeIn" });
        //点击图片链接
        $(".pic img").click(function () {
            //$.dialog({ lock: true, title: "查看大图", content: "<img src=\"" + $(this).attr("src") + "\" />", padding: 0 });
            var linkUrl = $(this).parent().parent().find(".foot a").attr("href");
            if (linkUrl != "") {
                location.href = linkUrl; //跳转到修改页面
            }
        });
    });
    //排列图文列表
    function imgLayout() {
        var imgWidth = $(".imglist").width();
        var lineCount = Math.floor(imgWidth / 222);
        var lineNum = imgWidth % 222 / (lineCount - 1);
        $(".imglist ul").width(imgWidth + Math.ceil(lineNum));
        $(".imglist ul li").css("margin-right", parseFloat(lineNum));
    }
    //等比例缩放图片大小
    function AutoResizeImage(e, s) {
        var img = new Image();
        img.src = $(this).attr("src")
        var w = img.width;
        var h = img.height;
        var wRatio = w / h;
        if ((220 / wRatio) >= 165) {
            $(this).width(220); $(this).height(220 / wRatio);
        } else {
            $(this).width(165 * wRatio); $(this).height(165);
        }
    }
    
    //创建改价窗口
    function showDialogChangePrice(goodsId) {
        $.dialog({
            id: 'giftDialogId',
            lock: true,
            max: false,
            min: false,
            title: "改价",
            content: 'url:/Verwalter/goods/price?goodsId=' + goodsId,
            width: 600,
            height: 200
        });
    }
    
    // 改价记录
    function showDialogPriceLog(goodsId) {
        $.dialog({
            id: 'giftDialogId',
            lock: true,
            max: false,
            min: false,
            title: "改价记录",
            content: 'url:/Verwalter/goods/price/log?goodsId=' + goodsId,
            width: 800,
            height: 500
        });
    }
    
    function confirmCopy(id)
    {
        $.dialog.confirm("确定复制该商品吗？", function () {
            window.location.href = "/Verwalter/goods/copy?id=" + id;
        });
    }
</script>
</head>

<body class="mainbody">
<div style="left: 0px; top: 0px; visibility: hidden; position: absolute;" class=""><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"></div><div class="ui_title_buttons"><a class="ui_min" href="javascript:void(0);" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_max" href="javascript:void(0);" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="javascript:void(0);" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="javascript:void(0);" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon" style="display: none;"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div>
<form name="form1" method="post" action="/Verwalter/job/list" id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="${__EVENTTARGET!""}" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="${__EVENTARGUMENT!""}" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="${__VIEWSTATE!""}" />
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
</script>

<!--导航栏-->
<div class="location">
  <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
  <a href="/Verwalter/center" class="home"><i></i><span>首页</span></a>
  <i class="arrow"></i
  <span>内容列表</span>
</div>
<!--/导航栏-->

<!--工具栏-->
<div class="toolbar-wrap">
  <div id="floatHead" class="toolbar">
    <div class="l-list">
      <ul class="icon-list">
        <li><a class="add" href="/Verwalter/job/edit?__VIEWSTATE=${__VIEWSTATE!""}"><i></i><span>新增</span></a></li>
        <li><a id="btnSave" class="save" href="javascript:__doPostBack('btnSave','')"><i></i><span>保存</span></a></li>
        <li><a class="all" href="javascript:;" onclick="checkAll(this);"><i></i><span>全选</span></a></li>
        <li><a onclick="return ExePostBack('btnDelete');" id="btnDelete" class="del" href="javascript:__doPostBack('btnDelete','')"><i></i><span>删除</span></a></li>
      </ul>
    </div>
    <div class="r-list">
      <input name="keywords" type="text" class="keyword" value="${keywords!''}">
      <a id="lbtnSearch" class="btn-search" href="javascript:__doPostBack('lbtnSearch','')">查询</a>
    </div>
  </div>
</div>
<!--/工具栏-->

<!--文字列表-->

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ltable">
<tbody>
    <tr class="odd_bg">
        <th width="10%">选择</th>
        <th align="left" width="20%">序号</th>
        <th align="left" width="25%">标题</th>
        <th align="left" width="25%">编号</th>
        <th align="left" width="65">排序</th>
        <th width="8%">操作</th>
    </tr>
    
    <#if content_page?? && content_page.content??>
    <#list content_page.content as content>
        <tr>
            <td align="center">
                <span class="checkall" style="vertical-align:middle;">
                    <input id="listChkId" type="checkbox" name="listChkId" value="${content_index}" >
                </span>
                <input type="hidden" name="listId" id="listId" value="${content.id?c}">
            </td>
            <td>${content.id?c}</td>
            <td><a href="/Verwalter/job/edit?id=${content.id?c}&__VIEWSTATE=${__VIEWSTATE!""}">${content.title!""}</a></td>
            <td>${content.number!''}</td>
            <td>
                <input name="listSortId" type="text" value="${content.sortId!""}" id="listSortId" class="sort" onkeydown="return checkNumber(event);">
            </td>
            <td align="center">
                <a href="/Verwalter/job/edit?id=${content.id?c}&__VIEWSTATE=${__VIEWSTATE!""}">修改</a>
            </td>
        </tr>
    </#list>
    </#if>
</tbody>
</table>

<!--/文字列表-->

<!--图片列表-->

<!--/图片列表-->

<!--内容底部-->
<#assign PAGE_DATA=content_page />
<#include "/site_mag/list_footer.ftl" />
<!--/内容底部-->
</form>
</body>
</html>