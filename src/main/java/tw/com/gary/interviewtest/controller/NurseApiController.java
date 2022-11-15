package tw.com.gary.interviewtest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.gary.interviewtest.domain.NurseBean;
import tw.com.gary.interviewtest.service.NurseService;

@RestController
@RequestMapping(path = { "/api/nurse" })
public class NurseApiController {
	@Autowired
	private NurseService nurseService;

	// 查詢所有員工資料
	@GetMapping
	public ResponseEntity<List<NurseBean>> findAll() {
		List<NurseBean> result = nurseService.select(null);
		return ResponseEntity.ok(result);
	}

	// 查詢特定ID員工資料
	@GetMapping("/{id}")
	public ResponseEntity<?> findByPrimaryKey(@PathVariable("id") Integer id) {
		NurseBean bean = new NurseBean();
		bean.setEmpid(id);
		List<NurseBean> result = nurseService.select(bean);
		if (result != null && !result.isEmpty()) {
			return ResponseEntity.ok(result.get(0));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 新增員工資料
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NurseBean bean) {
		NurseBean result = nurseService.insert(bean);
		if (result != null) {
			URI uri = URI.create("/api/orders/" + result.getEmpid());
			return ResponseEntity.created(uri).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// 刪除員工資料
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		NurseBean bean = new NurseBean();
		bean.setEmpid(id);
		boolean result = nurseService.delete(bean);
		if (result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 修改特定員工資料
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody NurseBean bean) {
		NurseBean result = nurseService.update(bean);
		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
