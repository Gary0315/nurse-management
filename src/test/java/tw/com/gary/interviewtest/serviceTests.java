package tw.com.gary.interviewtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.gary.interviewtest.dao.NurseRepository;
import tw.com.gary.interviewtest.dao.NurseSiteRepository;
import tw.com.gary.interviewtest.dao.SiteRepository;
import tw.com.gary.interviewtest.domain.NurseBean;
import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.domain.SiteBean;
import tw.com.gary.interviewtest.service.SiteService;

@SpringBootTest
class serviceTests {

	
	@Autowired
	private SiteService siteService;
	
	//@Autowired
	//private SiteRepository siteRepository;
	
	//@Test
	void method() {
		List<SiteBean> siteResult = siteService.select(null);
		System.out.println(siteResult);
	
	}
	
	@Test
	void method1() {
		SiteBean site = new SiteBean();
		site.setSiteid(0);
		site.setSitename("櫃台");
		
		site  =  siteService.insert(site);
		System.out.println(site);
	}
	
	//@Test
//	void method2() {
//		List<NurseSiteBean> result2 = null;
//		result2 =  nurseSiteRepository.findAll();
//		System.out.println(result2.get(0).getNursesiteDoublePK().getEmpid());
//	}

}
