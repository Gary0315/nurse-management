package tw.com.gary.interviewtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.gary.interviewtest.dao.NurseRepository;
import tw.com.gary.interviewtest.domain.NurseBean;

@Service
@Transactional
public class NurseService {
	@Autowired
	private NurseRepository nurseRepository;
	
	//查詢
	public List<NurseBean> select(NurseBean bean) {
		List<NurseBean> result = null;
		if (bean != null && bean.getEmpid() != null && !bean.getEmpid().equals(0)) {
			Optional<NurseBean> data = nurseRepository.findById(bean.getEmpid());
			if (data.isPresent()) {
				result = new ArrayList<NurseBean>();
				result.add(data.get());
			}
		} else {
			result = nurseRepository.findAll();
		}
		return result;
	}
	
	//新增
	public NurseBean insert(NurseBean bean) {
		NurseBean result = null;
	if (bean != null && bean.getEmpid() != null) {
		if (!nurseRepository.existsById(bean.getEmpid())) {
			result = nurseRepository.save(bean);
		}
	}
	return result;
}
	
	//修改
	public NurseBean update(NurseBean bean) {
		NurseBean result = null;
		if(bean!=null&& bean.getEmpid()!=null) {
			if(nurseRepository.existsById(bean.getEmpid())) {
				return nurseRepository.save(bean);
			}
		}
		return result;
	}
	
	//刪除
		public boolean delete(NurseBean bean) {
			boolean result = false;
			if(bean!=null&& bean.getEmpid()!=null) {
				if(nurseRepository.existsById(bean.getEmpid())) {
					nurseRepository.deleteById(bean.getEmpid());
					return true;
				}
			}
			return result;
		}
	
}
