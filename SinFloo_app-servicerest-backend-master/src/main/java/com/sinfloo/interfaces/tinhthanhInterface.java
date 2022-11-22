package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;
import com.sinfloo.modelo.tinhthanh;

public interface tinhthanhInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(tinhthanh p);
	public int edit(tinhthanh p);
	public int delete(int id);
}
