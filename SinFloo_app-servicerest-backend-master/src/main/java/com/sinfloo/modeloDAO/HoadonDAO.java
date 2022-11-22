package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sinfloo.interfaces.HoadonInterface;
import com.sinfloo.modelo.hoadon;

@Repository
public class HoadonDAO implements HoadonInterface{
	@Autowired
	JdbcTemplate template;
	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> list = template.queryForList("select * from hoadon");
		return list;
	}

	@Override
	public List<Map<String, Object>> listId(int id) {
		List<Map<String, Object>> list = template.queryForList("select * from hoadon where idhd = ?",id);
		return list;
	}

	@Override
	public int add(hoadon p) {
		String sql = "INSERT INTO hoadon (idkh, hinhthucthanhtoan)"
				+ " VALUES ( ?, ?);";
		return template.update(sql, p.getIdkh(),p.getHinhthucthanhtoan());
	}

	@Override
	public int edit(hoadon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> listNewest() {
		List<Map<String, Object>> list = template.queryForList("SELECT * FROM hoadon ORDER BY idhd DESC LIMIT 1");
		return list;
	}

}
