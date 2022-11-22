package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "tinhthanh")
@Entity

public class tinhthanh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idTT;
	@Column
	private String tenTT;
	@Column
	private String codeTT;
	
	public tinhthanh() {
		// TODO Auto-generated constructor stub
	}
	public int getIdTT() {
		return idTT;
	}
	public void setIdTT(int idTT) {
		this.idTT = idTT;
	}
	public String getTenTT() {
		return tenTT;
	}
	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}
	public String getCodeTT() {
		return codeTT;
	}
	public void setCodeTT(String codeTT) {
		this.codeTT = codeTT;
	}
	
}
