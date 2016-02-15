package com.ynyes.fayl.controller.touch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdRemark;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdRemarkService;

@Controller
@RequestMapping(value = "/touch/remark")
public class TdTouchRemarkController {

	@Autowired
	private TdCommonService tdCommonService;
	
	@Autowired
	private TdRemarkService tdRemarkService;

	@RequestMapping
	public String remark(HttpServletRequest req, ModelMap map) {
		map.addAttribute("company", TdCompany.getInstance());
		tdCommonService.setHeader(req, map);
		return "/touch/remark";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> remarkSave(String remark, String phone) {
		Map<String, Object> res = new HashMap<>();
		res.put("status", -1);

		// 生成留言编码
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateFormat = sdf.format(new Date());
		Random random = new Random();
		int randomNumber = random.nextInt(900) + 100;
		String number = "LY" + dateFormat + randomNumber;

		TdRemark tdRemark = new TdRemark();
		tdRemark.setNumber(number);
		tdRemark.setPhone(phone);
		tdRemark.setContent(remark);
		tdRemarkService.save(tdRemark);

		res.put("status", 0);
		res.put("message", "操作成功");
		return res;
	}
}
