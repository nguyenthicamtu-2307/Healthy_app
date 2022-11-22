package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbluser")

public class khachhang {
	@Id
	@Column
	public int id;
	@Column (name="taiKhoan")
	public String taiKhoan;
	@Column
	public String MatKhau;
	@Column
	public String TenUser;
	@Column
	public String Dob;
	@Column
	public String GioiTinh;
	@Column
	public String Diachi;
	@Column
	public int SDT;
	@Column
	public int Quyen;
	@Column 
	public String AnhDaidien;
	@Column(name="chieuCao")
	public int chieuCao;
	@Column(name="canNang")
	public int canNang;
	
	public khachhang() {
		
	}

	public int getId() {
		return id;
	}

	
	public String getMatKhau() {
		return MatKhau;
	}

	public String getTenUser() {
		return TenUser;
	}

	public String getDob() {
		return Dob;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public String getDiachi() {
		return Diachi;
	}

	public int getSDT() {
		return SDT;
	}

	public int getQuyen() {
		return Quyen;
	}

	public String getAnhDaidien() {
		return AnhDaidien;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public void setTenUser(String tenUser) {
		TenUser = tenUser;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public void setQuyen(int quyen) {
		Quyen = quyen;
	}

	public void setAnhDaidien(String anhDaidien) {
		AnhDaidien = anhDaidien;
	}



	public int getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(int chieuCao) {
		this.chieuCao = chieuCao;
	}

	public int getCanNang() {
		return canNang;
	}

	public void setCanNang(int canNang) {
		this.canNang = canNang;
	}

	public String getTaikhoan() {
		return taiKhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taiKhoan = taikhoan;
	}

	public String toString() {
		return "" + this.id;
	}
	
}

