package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.sanphamInterface;
import com.sinfloo.modelo.sanpham;
import com.sinfloo.modeloDAO.sanphamDAO;

@Service
public class sanphamService implements sanphamInterface{

	@Autowired
	sanphamDAO dao;
	
	@Override
	public List<Map<String, Object>> listar() {
		return dao.listar();
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		return dao.listarId(id);
	}

	@Override
	public int add(sanpham p) {
		return dao.add(p);
	}

	@Override
	public int edit(sanpham p) {
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public List<Map<String, Object>> getshirt() {
		// TODO Auto-generated method stub
		return dao.getshirt();
	}

	@Override
	public List<Map<String, Object>> getpants() {
		// TODO Auto-generated method stub
		return dao.getpants();
	}

	@Override
	public List<Map<String, Object>> getdress() {
		// TODO Auto-generated method stub
		return dao.getdress();
	}

	@Override
	public List<Map<String, Object>> getshoes() {
		// TODO Auto-generated method stub
		return dao.getshoes();
	}

}
