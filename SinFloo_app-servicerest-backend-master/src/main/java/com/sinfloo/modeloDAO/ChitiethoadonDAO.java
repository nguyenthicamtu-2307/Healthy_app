package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinfloo.interfaces.ChitiethoadonInterface;
import com.sinfloo.modelo.Chitiethoadon;



@Repository
public class ChitiethoadonDAO implements ChitiethoadonInterface{
	@Autowired
	JdbcTemplate template;
	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> list = template.queryForList("select * from chitiethoadon");
		return list;
	}

	@Override
	public List<Map<String, Object>> listId(int id) {
		List<Map<String, Object>> list = template.queryForList("select * from chitiethoadon where idkh = ?",id);
		return list;
	}

	@Override
	public int add(Chitiethoadon p) {
		String sql = "INSERT INTO chitiethoadon (idhd, idsp, soluong)"
				+ " VALUES (?, ?, ?);";
		return template.update(sql, p.getIdhd(),p.getIdsp(),p.getSoluong());
	}

	@Override
	public int edit(Chitiethoadon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



}

