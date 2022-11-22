package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;

import com.sinfloo.modelo.quanhuyen;

public interface quanhuyenInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(quanhuyen p);
	public int edit(quanhuyen p);
	public int delete(int id);
}
