package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="quanhuyen")
@Entity
public class quanhuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idQH;
	@Column
	private String tenQH;
	@Column
	private String phancap;
	@Column
	private int idTT;
	public quanhuyen() {
		
	}
	public int getIdQH() {
		return idQH;
	}
	public void setIdQH(int idQH) {
		this.idQH = idQH;
	}
	public String getTenQH() {
		return tenQH;
	}
	public void setTenQH(String tenQH) {
		this.tenQH = tenQH;
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
	
	
}
