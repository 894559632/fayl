//创建一个对象作为命名空间
var remarker = {};

// 创建一个公共方法用户获取指定id下的元素
remarker.getE = function(id) {
	return document.getElementById(id);
}

// 提交验证的方法
remarker.check = function() {
	// 获取称呼、电话、邮箱、留言
	var name = remarker.getE("visitor_name").value;
	var phone = remarker.getE("visitor_phone").value;
	var email = remarker.getE("visitor_email").value;
	var content = remarker.getE("visitor_remark").value;

	// 验证称呼不能为空
	if ("" == name) {
		alert("请填写您的称呼");
		return false;
	}

	// 验证电话不能为空，同时格式也要满足要求
	if ("" == phone) {
		alert("请填写您的电话");
		return false;
	}

	var phone_reg = /^1\d{10}$/;
	if (!phone_reg.test(phone)) {
		alert("请填写正确的手机号码");
		return false;
	}

	// 验证邮箱不能为空，同时格式也要符合要求
	if ("" == email) {
		alert("请填写您的邮箱地址");
		return false;
	}

	var email_reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!email_reg.test(email)) {
		alert("请填写正确的邮箱地址");
		return false;
	}

	// 验证留言不能为空
	if ("" == content) {
		alert("请填写您的留言");
		return false;
	}

	// 发送异步请求
	$.ajax({
		type : "post",
		url : "/remark/save",
		data : {
			name : name,
			phone : phone,
			email : email,
			content : content
		},
		error : function() {
			alert("操作失败，请稍后重试");
		},
		success : function(res) {
			alert(res.message);
		}
	});

	return false;
}