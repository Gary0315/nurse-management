package tw.com.gary.interviewtest.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.gary.interviewtest.domain.NurseSiteBean;
import tw.com.gary.interviewtest.domain.NurseSiteDoublePK;
import tw.com.gary.interviewtest.service.NurseSiteService;

@RestController
@RequestMapping(path = { "/api/nursesite" })
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
		if (result != null) {
			URI uri = URI.create("/api/orders/" + result.get(0).getNursesiteDoublePK().getEmpid());
			return ResponseEntity.created(uri).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// 刪除一個分配站點
	@DeleteMapping("/{empid}/{siteid}")
	public ResponseEntity<?> remove(@PathVariable("empid") Integer empid, @PathVariable("siteid") Integer siteid) {
		NurseSiteBean bean = new NurseSiteBean();
		NurseSiteDoublePK PK = new NurseSiteDoublePK();
		PK.setEmpid(empid);
		PK.setSiteid(siteid);
		bean.setNursesiteDoublePK(PK);
		boolean result = nurseSiteService.delete(bean);
		if (result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 刪除部門 刪除已分配站點
	@DeleteMapping("/allsite/{siteid}")
	public ResponseEntity<?> removeAllSite(@PathVariable("siteid") Integer siteid) {
		boolean result = nurseSiteService.deleteAllSite(siteid);
		if (result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 刪除員工 刪除已分配站點
	@DeleteMapping("/allemp/{empid}")
	public ResponseEntity<?> removeAllEmp(@PathVariable("empid") Integer empid) {
		boolean result = nurseSiteService.deleteAllEmp(empid);
		if (result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
