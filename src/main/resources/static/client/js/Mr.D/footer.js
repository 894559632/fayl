//创建一个对象作为命名空间
var footer = {};

// 创建一个公共方法用户获取指定id下的元素
footer.getE = function(id) {
	return document.getElementById(id);
}

// 提交验证的方法
footer.check = function() {
	// 获取称呼、电话、邮箱、留言
	var name = footer.getE("visitor_name").value;
	var phone = footer.getE("visitor_phone").value;
	var email = footer.getE("visitor_email").value;
	var remark = footer.getE("visitor_remark").value;

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
	
	//验证留言不能为空
	if("" == remark){
		alert("请填写您的留言");
		return false;
	}
	
	return true;
}