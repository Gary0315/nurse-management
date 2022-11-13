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

@SpringBootTest
class DaoTests {

	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private SiteRepository siteRepository;
	
	@Autowired
	private NurseSiteRepository nurseSiteRepository;
	
	//@Test
	void method() {
		List<NurseBean> result = null;
		result =  nurseRepository.findAll();
		System.out.println(result);
	}
	
	//@Test
	void method1() {
		List<SiteBean> result1 = null;
		result1 =  siteRepository.findAll();
		System.out.println(result1);
	}
	
	@Test
	void method2() {
		List<NurseSiteBean> result2 = null;
		result2 =  nurseSiteRepository.findAll();
		System.out.println(result2.get(0).getNursesiteDoublePK().getEmpid());
		System.out.println(result2.get(0).getAddtime());
		System.out.println(result2.get(0).getNursesiteDoublePK());
		System.out.println(result2.get(0).getNursesiteDoublePK().getSiteid());
	}

}
