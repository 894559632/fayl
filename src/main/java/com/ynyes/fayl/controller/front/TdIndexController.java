package com.ynyes.fayl.controller.front;

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
import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.entity.TdSetting;
import com.ynyes.fayl.entity.TdSiteLink;
import com.ynyes.fayl.service.TdAdService;
import com.ynyes.fayl.service.TdAdTypeService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdCompanyInfoService;
import com.ynyes.fayl.service.TdSampleCategoryService;
import com.ynyes.fayl.service.TdSampleService;
import com.ynyes.fayl.service.TdSiteLinkService;

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

	@Autowired
	private TdSampleCategoryService tdSampleCategoryService;
	
	@Autowired
	private TdSiteLinkService tdSiteLinkService;

	@RequestMapping
	public String index(HttpServletRequest req, ModelMap map, Device device) {
		if (device.isMobile() || device.isTablet()) {
			return "redirect:/touch";
		}
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

		// 查找所有的案例分类
		List<TdSampleCategory> sample_category_list = tdSampleCategoryService.findAll();
		map.addAttribute("sample_category_list", sample_category_list);

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
		List<TdSample> bsjg_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("BSJG0001");
		map.addAttribute("bsjg_sample_page", bsjg_sample_list);

		// 查找首页推荐旅游区案例
		List<TdSample> lyq_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("LYQ0001");
		map.addAttribute("lyq_sample_page", lyq_sample_list);

		// 查找首页推荐公园景观案例
		List<TdSample> gyjg_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("GYJG0001");
		map.addAttribute("gyjg_sample_page", gyjg_sample_list);

		// 查找首页推荐居住区景观案例
		List<TdSample> jzqjg_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("JZQJG0001");
		map.addAttribute("jzqjg_sample_page", jzqjg_sample_list);

		// 查找首页推荐道路景观案例
		List<TdSample> dljg_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("DLJG0001");
		map.addAttribute("dljg_sample_page", dljg_sample_list);

		// 查找首页推荐公共商业案例
		List<TdSample> ggsy_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("GGSY0001");
		map.addAttribute("ggsy_sample_page", ggsy_sample_list);

		// 查找首页推荐农业景观案例
		List<TdSample> nyjg_sample_list = tdSampleService
				.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc("NYJG0001");
		map.addAttribute("nyjg_sample_page", nyjg_sample_list);

		//查找公司新闻（分页）
		Page<TdArticle> gsxw_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc("GSXW0001", 0, 5);
		map.addAttribute("gsxw_page", gsxw_page);
		
		//查找行业动态（分页）
		Page<TdArticle> hydt_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc("HYDT0001", 0, 5);
		map.addAttribute("hydt_page", hydt_page);
		
		//查找媒体报道（分页）
		Page<TdArticle> mtbd_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc("MTBD0001", 0, 5);
		map.addAttribute("mtbd_page", mtbd_page);
		
		// 获取所有的友情链接
		List<TdSiteLink> link_list = tdSiteLinkService.findAll();
		map.addAttribute("link_list", link_list);
		return "/front/index_temp";
	}
}
