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

import tw.com.gary.interviewtest.domain.SiteBean;
import tw.com.gary.interviewtest.service.SiteService;

@RestController
@RequestMapping(path = { "/api/site" })
public class SiteApiController {
	@Autowired
	private SiteService siteService;

//取得所有站點資料
	@GetMapping
	public ResponseEntity<List<SiteBean>> findAll() {
		List<SiteBean> result = siteService.select(null);
		return ResponseEntity.ok(result);
	}

//取得特定站點ID資料
	@GetMapping("/{id}")
	public ResponseEntity<?> findByPrimaryKey(@PathVariable("id") Integer id) {
		SiteBean bean = new SiteBean();
		bean.setSiteid(id);
		List<SiteBean> result = siteService.select(bean);
		if (result != null && !result.isEmpty()) {
			return ResponseEntity.ok(result.get(0));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//新增站點
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SiteBean bean) {
		SiteBean result = siteService.insert(bean);
		if (result != null) {
			URI uri = URI.create("/api/orders/" + result.getSiteid());
			return ResponseEntity.created(uri).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

//刪除站點資料
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		SiteBean bean = new SiteBean();
		bean.setSiteid(id);
		boolean result = siteService.delete(bean);
		if (result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 修改特定站點資料
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SiteBean bean) {
		SiteBean result = siteService.update(bean);
		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
