package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.tinhthanhInterface;
import com.sinfloo.modelo.tinhthanh;
import com.sinfloo.modeloDAO.tinhthanhDAO;

@Service
public class tinhthanhService implements tinhthanhInterface {

	@Autowired
	tinhthanhDAO dao;

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
	public int add(tinhthanh p) {
		return dao.add(p);
	}

	@Override
	public int edit(tinhthanh p) {
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}
}
