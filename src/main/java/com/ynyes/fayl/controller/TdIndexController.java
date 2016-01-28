package com.ynyes.fayl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdAd;
import com.ynyes.fayl.entity.TdAdType;
import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.entity.TdSetting;
import com.ynyes.fayl.service.TdAdService;
import com.ynyes.fayl.service.TdAdTypeService;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdCompanyInfoService;
import com.ynyes.fayl.service.TdSampleService;

/**
 * 进入首页的控制器
 * 
 * @author dengxiao
 *
 */

@Controller
@RequestMapping
public class TdIndexController {

	@Autowired
	private TdArticleService tdArticleService;

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

	@RequestMapping
	public String index(HttpServletRequest req, ModelMap map) {
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
		// 初始化网站设置对象
		tdCommonService.initSetting();
		map.addAttribute("setting", TdSetting.getInstance());

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

		// 查找首页推荐滨水景观案例
		Page<TdSample> bsjg_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("BSJG0001", 0, 4);
		map.addAttribute("bsjg_sample_page", bsjg_sample_page);

		// 查找首页推荐旅游区案例
		Page<TdSample> lyq_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("LYQ0001", 0, 4);
		map.addAttribute("lyq_sample_page", lyq_sample_page);

		// 查找首页推荐公园景观案例
		Page<TdSample> gyjg_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("GYJG0001", 0, 4);
		map.addAttribute("gyjg_sample_page", gyjg_sample_page);

		// 查找首页推荐居住区景观案例
		Page<TdSample> jzqjg_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("JZQJG0001", 0, 4);
		map.addAttribute("jzqjg_sample_page", jzqjg_sample_page);

		// 查找首页推荐道路景观案例
		Page<TdSample> dljg_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("DLJG0001", 0, 4);
		map.addAttribute("dljg_sample_page", dljg_sample_page);

		// 查找首页推荐公共商业案例
		Page<TdSample> ggsy_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("GGSY0001", 0, 4);
		map.addAttribute("ggsy_sample_page", ggsy_sample_page);

		// 查找首页推荐农业景观案例
		Page<TdSample> nyjg_sample_page = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("NYJG0001", 0, 4);
		map.addAttribute("nyjg_sample_page", nyjg_sample_page);

		// 查找所有的文章，按照生成时间反序排序（分页）
		Page<TdArticle> article_page = tdArticleService.findAll(0, 5);
		map.addAttribute("article_page", article_page);
		return "/client/index";
	}
}
