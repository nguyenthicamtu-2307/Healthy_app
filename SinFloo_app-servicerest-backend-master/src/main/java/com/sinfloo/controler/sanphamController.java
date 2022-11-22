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

import com.sinfloo.modelo.sanpham;
import com.sinfloo.service.sanphamService;


@RestController
@RequestMapping("/sanpham")
public class sanphamController {

	@Autowired //sẽ tự động inject bean tương ứng vào vị trí được đánh dấu
	private sanphamService service;
	@GetMapping("/listar")//xử lý hàm bằng phương thức get
	public List<Map<String, Object>> listar(Model model) {
		return service.listar();
	}
	@PostMapping("/insert")
	public String save(@RequestBody sanpham p,Model model) {
		int idSP=service.add(p);
		if(idSP==0) {
			return "thêm không thành công";
		}
		return "Đã thêm thành công";
		
	}
	@PostMapping("/update/{idSP}")//xử  lý hàm bằng phương thức post
	public String save(@RequestBody sanpham p,@PathVariable int id,Model model) {
		p.setIdSP(id);
		int r=service.edit(p);
		if(r==0) {
			return "Không thể cập nhật";
		}
		return "câp nhật thành công";
		
	}
	@PostMapping("/delete/{idSP}")
	public String delete(@PathVariable int p,Model model) {
		int r=service.delete(p);
		if(r==0) {
			return "Xóa không thành công";
		}
		return "Đã xóa thành công";
	}
	@GetMapping("/listshirt")
	public List<Map<String,Object>> listshirt(Model model){
		return service.getshirt();
	}
	@GetMapping("/listpants")
	public List<Map<String,Object>> listpants(Model model){
		return service.getpants();
	}
	@GetMapping("/listdress")
	public List<Map<String,Object>> listdress(Model model){
		return service.getdress();
	}
	@GetMapping("/listshoes")
	public List<Map<String,Object>> listshoes(Model model){
		return service.getshoes();
	}
}
