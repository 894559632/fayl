// 创建一个命名空间
var touch = {};

// 创建一个用于获取DOM对象的函数
touch.getE = function(id) {
	return document.getElementById(id);
}

// 提交留言的方法
touch.submit = function() {
	var visitor_remark = touch.getE("visitor_remark").value;
	var visitor_phone = touch.getE("visitor_phone").value;

	// 开始进行验证
	if ("" == visitor_phone) {
		alert("请填写您的电话");
		return false;
	}

	var phone_reg = /^1\d{10}$/;
	if (!phone_reg.test(visitor_phone)) {
		alert("请填写正确的手机号码");
		return false;
	}

	if ("" == visitor_remark) {
		alert("请填写您的留言");
		return false;
	}

	$.ajax({
		type : "post",
		url : "/touch/remark/save",
		data : {
			remark : visitor_remark,
			phone : visitor_phone
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
