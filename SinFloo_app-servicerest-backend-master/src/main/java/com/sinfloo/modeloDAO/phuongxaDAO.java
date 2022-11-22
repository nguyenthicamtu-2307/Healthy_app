package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.phuongxaInterface;
import com.sinfloo.modelo.phuongxa;

@Service
public class phuongxaDAO implements phuongxaInterface{

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> list = template.queryForList("select * from phuongxa");
		return list;
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(phuongxa p) {
		String sql = "insert into phuongxa(tenPX,phancap,idTT,idQH)values(?,?,?,?)";
		return template.update(sql, p.getTenPX(), p.getPhancap(),p.getIdTT(),p.getIdQH());
	}

	@Override
	public int edit(phuongxa p) {
		String sql="update phuongxa set tenPX=?,phancap=?,idTT=?,idQH=? where idPX=?";		
		return template.update(sql,p.getTenPX(),p.getPhancap(),p.getIdTT(),p.getIdQH(),p.getIdPX());
	}

	@Override
	public int delete(int id) {
		String sql="delete from phuongxa where idPX=?";
		return template.update(sql,id);
	}
}
