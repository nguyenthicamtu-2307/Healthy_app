package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;

import com.sinfloo.modelo.phuongxa;

public interface phuongxaInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(phuongxa p);
	public int edit(phuongxa p);
	public int delete(int id);
}
