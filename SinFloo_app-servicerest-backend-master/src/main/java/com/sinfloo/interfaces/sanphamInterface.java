package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;

import com.sinfloo.modelo.sanpham;

public interface sanphamInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(sanpham p);
	public int edit(sanpham p);
	public int delete(int id);
	public List<Map<String, Object>>getshirt();
	public List<Map<String, Object>>getpants();
	public List<Map<String, Object>>getdress();
	public List<Map<String, Object>>getshoes();
}
