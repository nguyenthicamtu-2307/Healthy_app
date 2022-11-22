package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.phuongxaInterface;
import com.sinfloo.modelo.phuongxa;
import com.sinfloo.modeloDAO.phuongxaDAO;

@Service
public class phuongxaService implements phuongxaInterface{

	@Autowired
	phuongxaDAO dao;
	
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
	public int add(phuongxa p) {
		return dao.add(p);
	}

	@Override
	public int edit(phuongxa p) {
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}
}
