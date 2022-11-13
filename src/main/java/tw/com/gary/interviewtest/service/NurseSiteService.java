package tw.com.gary.interviewtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.gary.interviewtest.dao.NurseSiteRepository;
import tw.com.gary.interviewtest.domain.NurseSiteBean;


@Service
@Transactional
public class NurseSiteService {
	@Autowired
	private NurseSiteRepository nurseSiteRepository;
	
	//查詢
	public List<NurseSiteBean> select(NurseSiteBean bean) {
		List<NurseSiteBean> result = null;
		if (bean != null && bean.getNurseBean().getEmpid() != null && !bean.getNurseBean().getEmpid().equals(0)) {
			Optional<NurseSiteBean> data = nurseSiteRepository.findById(bean.getNurseBean().getEmpid());
			if (data.isPresent()) {
				result = new ArrayList<NurseSiteBean>();
				result.add(data.get());
			}
		} else {
			result = nurseSiteRepository.findAll();
		}
		return result;
	}
	
//	//新增
//	public NurseBean insert(NurseBean bean) {
//		NurseBean result = null;
//	if (bean != null && bean.getEmpid() != null) {
//		if (!nurseRepository.existsById(bean.getEmpid())) {
//			result = nurseRepository.save(bean);
//		}
//	}
//	return result;
//}
//	
//	//修改
//	public NurseBean update(NurseBean bean) {
//		NurseBean result = null;
//		if(bean!=null&& bean.getEmpid()!=null) {
//			if(nurseRepository.existsById(bean.getEmpid())) {
//				return nurseRepository.save(bean);
//			}
//		}
//		return result;
//	}
//	
//	//刪除
//		public boolean delete(NurseBean bean) {
//			boolean result = false;
//			if(bean!=null&& bean.getEmpid()!=null) {
//				if(nurseRepository.existsById(bean.getEmpid())) {
//					nurseRepository.deleteById(bean.getEmpid());
//					return true;
//				}
//			}
//			return result;
//		}
	
}
