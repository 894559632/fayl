package com.ynyes.fayl.controller.touch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdAd;
import com.ynyes.fayl.entity.TdAdType;
import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.service.TdAdService;
import com.ynyes.fayl.service.TdAdTypeService;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdCompanyInfoService;
import com.ynyes.fayl.service.TdSampleService;
import com.ynyes.fayl.util.ClientConstant;

/**
 * 触屏端首页
 * 
 * @author DengXiao
 */
@Controller
@RequestMapping(value = "/touch")
public class TdTouchIndexController {

	@Autowired
	private TdCommonService tdCommonService;

	@Autowired
	private TdAdTypeService tdAdTypeService;

	@Autowired
	private TdAdService tdAdService;

	@Autowired
	private TdCompanyInfoService tdCompanyInfoService;

	@Autowired
	private TdSampleService tdSampleService;

	@Autowired
	private TdArticleCategoryService tdArticleCategoryService;

	@Autowired
	private TdArticleService tdArticleService;

	@RequestMapping
	public String index(HttpServletRequest req, ModelMap map, Device device) {
		if (!(device.isMobile() || device.isTablet())) {
			return "redirect:/";
		}
		// 初始化网站设置对象
		tdCommonService.initSetting();
		// 初始化公司对象
		tdCommonService.initCompany();
		// 获取公司介绍的信息编号
		TdCompany company = TdCompany.getInstance();
		if (null != company) {
			String number = company.getIntroductonNumber();
			// 根据获取的公司介绍信息编号获取指定的公司信息实体类
			TdCompanyInfo info = tdCompanyInfoService.findByNumber(number);
			map.addAttribute("info", info);
		}

		// 查找首页顶部广告图
		TdAdType adType = tdAdTypeService.findByTitle("首页顶部广告图");
		if (null != adType) {
			// 根据广告位的编号查找其下所有启动的未过期的广告图
			List<TdAd> ad_list = tdAdService
					.findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
							adType.getNumber());
			if (null != ad_list && ad_list.size() > 0) {
				map.addAttribute("ad_list", ad_list);
			}
		}

		// 查找首页推荐案例
		Page<TdSample> sample_page = tdSampleService.findByIsIndexRecommendTrueOrderBySortIdAsc(0,
				ClientConstant.pageSize);
		map.addAttribute("sample_page", sample_page);

		// 查找所有的文章分类
		List<TdArticleCategory> article_category_list = tdArticleCategoryService.findAll();
		if (null != article_category_list && article_category_list.size() > 0) {
			map.addAttribute("article_category_list", article_category_list);
			for (TdArticleCategory category : article_category_list) {
				if (null != category && null != category.getNumber()) {
					Page<TdArticle> article_page = tdArticleService
							.findByCategoryNumberOrderByCreateDateDesc(category.getNumber(), 0, 3);
					map.addAttribute(category.getNumber() + "article_page", article_page);
				}
			}
		}

		tdCommonService.setHeader(req, map);
		return "/touch/index";
	}
}
