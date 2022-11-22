package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.quanhuyenInterface;
import com.sinfloo.modelo.quanhuyen;

@Service
public class quanhuyenDAO implements quanhuyenInterface{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> list = template.queryForList("select * from quanhuyen");
		return list;
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(quanhuyen p) {
		String sql = "insert into quanhuyen(tenQH,phancap,idTT)values(?,?,?)";
		return template.update(sql, p.getTenQH(), p.getPhancap(),p.getIdTT());
	}

	@Override
	public int edit(quanhuyen p) {
		String sql="update quanhuyen set tenQH=?,phancap=?,idTT=? where idQH=?";		
		return template.update(sql,p.getTenQH(),p.getPhancap(),p.getIdTT(),p.getIdQH());
	}

	@Override
	public int delete(int id) {
		String sql="delete from quanhuyen where idQH=?";
		return template.update(sql,id);
	}

}
