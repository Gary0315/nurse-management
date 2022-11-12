package tw.com.gary.interviewtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.gary.interviewtest.dao.SiteRepository;
import tw.com.gary.interviewtest.domain.SiteBean;

@Service
@Transactional
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	
	//查詢
	public List<SiteBean> select(SiteBean bean) {
		List<SiteBean> result = null;
		if (bean != null && bean.getSiteid() != null && !bean.getSiteid().equals(0)) {
			Optional<SiteBean> data = siteRepository.findById(bean.getSiteid());
			if (data.isPresent()) {
				result = new ArrayList<SiteBean>();
				result.add(data.get());
			}
		} else {
			result = siteRepository.findAll();
		}
		return result;
	}
	
	//新增
	public SiteBean insert(SiteBean bean) {
		SiteBean result = null;
	if (bean != null && bean.getSiteid() != null) {
		if (!siteRepository.existsById(bean.getSiteid())) {
			result = siteRepository.save(bean);
		}
	}
	return result;
}
	
	//修改
	public SiteBean update(SiteBean bean) {
		SiteBean result = null;
		if(bean!=null&& bean.getSiteid()!=null) {
			if(siteRepository.existsById(bean.getSiteid())) {
				return siteRepository.save(bean);
			}
		}
		return result;
	}
	
	//刪除
		public boolean delete(SiteBean bean) {
			boolean result = false;
			if(bean!=null&& bean.getSiteid()!=null) {
				if(siteRepository.existsById(bean.getSiteid())) {
					siteRepository.deleteById(bean.getSiteid());
					return true;
				}
			}
			return result;
		}
	
}
