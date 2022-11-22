package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="phuongxa")
@Entity
public class phuongxa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idPX;
	@Column
	private String tenPX;
	@Column
	private String phancap;
	@Column
	private int idTT;
	@Column
	private int idQH;
	public phuongxa() {
	}
	public int getIdPX() {
		return idPX;
	}
	public void setIdPX(int idPX) {
		this.idPX = idPX;
	}
	public String getTenPX() {
		return tenPX;
	}
	public void setTenPX(String tenPX) {
		this.tenPX = tenPX;
	}
	public String getPhancap() {
		return phancap;
	}
	public void setPhancap(String phancap) {
		this.phancap = phancap;
	}
	public int getIdTT() {
		return idTT;
	}
	public void setIdTT(int idTT) {
		this.idTT = idTT;
	}
	public int getIdQH() {
		return idQH;
	}
	public void setIdQH(int idQH) {
		this.idQH = idQH;
	}
}
