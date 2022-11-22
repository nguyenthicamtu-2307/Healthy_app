package com.sinfloo.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinfloo.interfaces.HoadonInterface;
import com.sinfloo.modelo.hoadon;
import com.sinfloo.service.HoadonService;


@RestController
@RequestMapping("/hoadon")
public class HoadonController implements HoadonInterface{

	@Autowired
	private HoadonService service;
	
	@GetMapping("/list")
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return service.list();
	}

	@GetMapping("/list/{id}")
	public List<Map<String, Object>> listId(int id) {
		// TODO Auto-generated method stub
		return service.listId(id);
	}

	@GetMapping("/listnewest")
	public List<Map<String, Object>> listNewest() {
		// TODO Auto-generated method stub
		return service.listNewest();
	}

	@PostMapping("/add")
	public String save(@RequestBody hoadon p, Model model) {
		int id = service.add(p);
		if (id == 0) {
			return "Them that bai!!!";
		}
		return "Them thanh cong!!!";
	}

	@PostMapping("/update/{id}")
	public String save(@RequestBody hoadon p, @PathVariable int id, Model model) {
		p.setIdhd(id);
		int r = service.edit(p);
		if (r == 0) {
			return "Cap nhat that bai!!!";
		}
		return "Cap nhat thanh cong!!!";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		int r = service.delete(id);
		if (r == 0) {
			return "Xoa that bai!!!";
		}
		return "Xoa thanh cong!!!";
	}

	@Override
	public int add(hoadon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(hoadon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
