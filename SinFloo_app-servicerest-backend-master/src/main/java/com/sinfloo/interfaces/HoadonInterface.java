package com.sinfloo.interfaces;

import com.sinfloo.modelo.hoadon;

import java.util.List;
import java.util.Map;

public interface HoadonInterface {
	public List<Map<String, Object>>list();
	public List<Map<String, Object>>listId(int id);
	public List<Map<String, Object>>listNewest();
	public int add(hoadon p);
	public int edit(hoadon p);
	public int delete(int id);
}
