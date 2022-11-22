package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.tinhthanhInterface;
import com.sinfloo.modelo.tinhthanh;

@Service
public class tinhthanhDAO implements tinhthanhInterface{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> list = template.queryForList("select * from tinhthanh");
		return list;
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(tinhthanh p) {
		String sql = "insert into tinhthanh(tenTT,codeTT)values(?,?)";
		return template.update(sql, p.getTenTT(), p.getCodeTT());
	}

	@Override
	public int edit(tinhthanh p) {
		String sql="update tinhthanh set tenTT=?,codeTT=? where idTT=?";		
		return template.update(sql,p.getTenTT(),p.getCodeTT(),p.getIdTT());
	}

	@Override
	public int delete(int id) {
		String sql="delete from tinhthanh where idTT=?";
		return template.update(sql,id);
	}

}
