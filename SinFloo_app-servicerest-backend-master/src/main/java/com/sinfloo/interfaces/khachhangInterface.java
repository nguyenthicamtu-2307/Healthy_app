package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;

import com.sinfloo.modelo.khachhang;

public interface khachhangInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(khachhang p);
	public int edit(khachhang p);
	public int delete(int id);
	public List<Map<String, Object>>getLogin();
	

}
