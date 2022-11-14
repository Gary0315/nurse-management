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
		if (bean != null && bean.getNursesiteDoublePK().getEmpid() != null && !bean.getNursesiteDoublePK().getEmpid().equals(0)) {
			Optional<NurseSiteBean> data = nurseSiteRepository.findById(bean.getNursesiteDoublePK());
			if (data.isPresent()) {
				result = new ArrayList<NurseSiteBean>();
				result.add(data.get());
			}
		} else {
			result = nurseSiteRepository.findAll();
		}
		return result;
	}
	
	//查詢一個員工的站點
	public List<NurseSiteBean> selectNurse(Integer id){
		if(id!=null && id!=0) {
			List<NurseSiteBean> data = nurseSiteRepository.selectNurse(id);
			return data;
		}else{
		return null;
		}
	}
	
	//查詢一個站點的所有員工
		public List<NurseSiteBean> selectSite(Integer id){
			if(id!=null && id!=0) {
				List<NurseSiteBean> data = nurseSiteRepository.selectSite(id);
				return data;
			}else{
			return null;
			}
		}
	
	//新增
	public List<NurseSiteBean> insert(List<NurseSiteBean> bean) {
		List<NurseSiteBean> result = null;
	if (bean != null && bean.get(0).getNursesiteDoublePK() != null) {
		if (!nurseSiteRepository.existsById(bean.get(0).getNursesiteDoublePK())) {
			result = nurseSiteRepository.saveAll(bean);
		}
	}
	return result;
}
	
//	//修改
//	public NurseSiteBean update(NurseSiteBean bean) {
//		NurseSiteBean result = null;
//		if(bean!=null&& bean.getNurseBean().getEmpid()!=null) {
//			if(nurseSiteRepository.existsById(bean.getNurseBean().getEmpid())) {
//				return nurseSiteRepository.save(bean);
//			}
//		}
//		return result;
//	}
//	
//	//刪除
//		public boolean delete(NurseSiteBean bean) {
//			boolean result = false;
//			if(bean!=null&& bean.getNurseBean().getEmpid()!=null) {
//				if(nurseSiteRepository.existsById(bean.getNurseBean().getEmpid())) {
//					nurseSiteRepository.deleteById(bean.getNurseBean().getEmpid());
//					return true;
//				}
//			}
//			return result;
//		}
//	
}
