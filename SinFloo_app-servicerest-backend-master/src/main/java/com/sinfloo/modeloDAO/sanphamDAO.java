package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.sanphamInterface;
import com.sinfloo.modelo.sanpham;

@Service
public class sanphamDAO implements sanphamInterface{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> list = template.queryForList("select * from sanpham");
		return list;
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		List<Map<String, Object>> list = template.queryForList("select * from tblsanpham where idSP = ?",id);
		return null;
	}

	@Override
	public int add(sanpham p) {
		String sql = "insert into sanpham(tenSP, donViTinh, donGia, soLuongCon, tenHA, mota)values(?,?,?,?,?,?,?,?,?,?)";
		return template.update(sql, p.getTenSP(), p.getDonViTinh(),p.getDonGia(),p.getSoLuongCon(), p.getTenHA());
	}

	@Override
	public int edit(sanpham p) {
		String sql="update sanpham set tenSP=?,donViTinh=?,donGia=?,soLuongCon=?, tenHA=? mota=? where idSP=?";		
		return template.update(sql,p.getTenSP(), p.getDonViTinh(),p.getDonGia(),p.getSoLuongCon(),p.getTenHA(),p.getMota(),p.getIdSP());
	}

	@Override
	public int delete(int id) {
		String sql="delete from sanpham where idSP=?";
		return template.update(sql,id);
	}

	@Override
	public List<Map<String, Object>> getshirt() {
		List<Map<String,Object>> list = template.queryForList("select * from sanpham where sanpham.IDDM='1'");
		return list;
	}

	@Override
	public List<Map<String, Object>> getpants() {
		List<Map<String,Object>> list = template.queryForList("select * from sanpham where sanpham.IDDM='2'");
		return list;
	}

	@Override
	public List<Map<String, Object>> getdress() {
		List<Map<String,Object>> list = template.queryForList("select * from sanpham where sanpham.IDDM='3'");
		return list;
	}

	@Override
	public List<Map<String, Object>> getshoes() {
		List<Map<String,Object>> list = template.queryForList("select * from sanpham where sanpham.IDDM='4'");
		return list;
	}

}
