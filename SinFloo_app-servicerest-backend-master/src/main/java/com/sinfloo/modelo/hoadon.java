package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hoadon")
@Entity
public class hoadon {
	@Id
	@Column
	private int idhd;
	@Column
	private int idkh;
	@Column
	private String hinhthucthanhtoan;
	public int getIdhd() {
		return idhd;
	}
	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}
	public int getIdkh() {
		return idkh;
	}
	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}
	public String getHinhthucthanhtoan() {
		return hinhthucthanhtoan;
	}
	public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
		this.hinhthucthanhtoan = hinhthucthanhtoan;
	}
}
