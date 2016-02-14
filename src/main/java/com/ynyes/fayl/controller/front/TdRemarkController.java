package com.ynyes.fayl.controller.front;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdRemark;
import com.ynyes.fayl.service.TdRemarkService;

@Controller
@RequestMapping(value = "/remark")
public class TdRemarkController {

	@Autowired
	private TdRemarkService tdRemarkService;

	@RequestMapping(value = "/save")
	@ResponseBody
	public Map<String, Object> remarkSave(String name, String phone, String email, String content) {
		Map<String, Object> res = new HashMap<>();
		res.put("status", -1);
		// 生成留言编码
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateFormat = sdf.format(new Date());
		Random random = new Random();
		int randomNumber = random.nextInt(900) + 100;
		String number = "LY" + dateFormat + randomNumber;
		TdRemark remark = new TdRemark(number, name, phone, email, content);
		tdRemarkService.save(remark);
		res.put("status", 0);
		res.put("message", "操作成功");
		return res;
	}
}
