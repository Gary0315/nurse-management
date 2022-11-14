package tw.com.gary.interviewtest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.service.NurseSiteService;

@RestController
@RequestMapping(path = {"/api/nursesite"})
public class NurseSiteApiController {
	@Autowired
	private NurseSiteService nurseSiteService;
	
	@GetMapping
	public ResponseEntity<List<NurseSiteBean>> findAll() {
		List<NurseSiteBean> result = nurseSiteService.select(null);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/nurse/{id}")
	public ResponseEntity<List<NurseSiteBean>> findByEmpId(@PathVariable("id") Integer id) {
		List<NurseSiteBean> result = nurseSiteService.selectNurse(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/site/{id}")
	public ResponseEntity<List<NurseSiteBean>> findBySiteId(@PathVariable("id") Integer id) {
		List<NurseSiteBean> result = nurseSiteService.selectSite(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody List<NurseSiteBean> bean) {
		List<NurseSiteBean> result = nurseSiteService.insert(bean);
		if(result!=null) {
			URI uri = URI.create("/api/orders/"+result.get(0).getNursesiteDoublePK().getEmpid());
			return ResponseEntity.created(uri).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> remove(@PathVariable("id") Integer id){
//		NurseSiteBean bean = new NurseSiteBean();
//		NurseBean nurseBean = new NurseBean();
//		bean.set;
//		boolean result = nurseSiteService.delete(bean);
//		if(result) {
//			return ResponseEntity.noContent().build();
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//	
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody NurseSiteBean bean){
//		NurseSiteBean result = nurseSiteService.update(bean);
//		if(result!=null) {
//			return ResponseEntity.ok(result);
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	
}
