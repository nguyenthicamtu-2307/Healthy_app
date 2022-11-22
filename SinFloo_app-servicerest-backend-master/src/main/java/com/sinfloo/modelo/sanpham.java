package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sanpham")
@Entity
public class sanpham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idSP;
	@Column
	private String tenSP;
	@Column
	private String donViTinh;
	@Column
	private String donGia;
	@Column
	private int soLuongCon;
	@Column
	private int idDM;
	@Column
	private String tenHA;
	@Column
	private String mota;
	
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public sanpham() {
		super();
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public int getSoLuongCon() {
		return soLuongCon;
	}
	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}
	public int getIdDM() {
		return idDM;
	}
	public void setIdDM(int idDM) {
		this.idDM = idDM;
	}
	public String getTenHA() {
		return tenHA;
	}
	public void setTenHA(String tenHA) {
		this.tenHA = tenHA;
	}
	
}
