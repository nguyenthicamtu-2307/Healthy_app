package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.quanhuyenInterface;
import com.sinfloo.modelo.quanhuyen;
import com.sinfloo.modeloDAO.quanhuyenDAO;

@Service
public class quanhuyenService implements quanhuyenInterface{
	
	@Autowired
	quanhuyenDAO dao;

	@Override
	public List<Map<String, Object>> listar() {
		return dao.listar();
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(quanhuyen p) {
		return dao.add(p);
	}

	@Override
	public int edit(quanhuyen p) {
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

}
