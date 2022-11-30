package com.example.myapplication.Model;
import java.io.Serializable;
public class User implements Serializable {
    private  int id;
    private String taikhoan;
    private String matkhau;
    private  String tenuser;
    private  String dob;
    private  String gioitinh;
    private String diachi;
    private int sdt;
    private String quyen;
    private  String anhdaidien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public int getChieucao() {
        return chieucao;
    }

    public void setChieucao(int chieucao) {
        this.chieucao = chieucao;
    }

    public int getCannang() {
        return cannang;
    }

    public void setCannang(int cannang) {
        this.cannang = cannang;
    }

    private  int chieucao;
    private  int cannang;

public User(String TaiKhoan,String MatKhau,String TenUser){
    this.taikhoan=TaiKhoan;
    this.matkhau=MatKhau;
    this.tenuser=TenUser;
}

    public User() {
    }

    @Override
    public String toString() {
        return "tbluser{" +
                "Id=" + id +
                ", TaiKhoan='" + taikhoan + '\'' +
                ", MatKhau='" + matkhau + '\'' +
                ", TenUser='" + tenuser + '\'' +
                ", Dob=" + dob +
                ", GioiTinh='" + gioitinh + '\'' +
                ", DiaChi='" + diachi + '\'' +
                ", SDT='" + sdt + '\'' +
                ", Quyen='" + quyen + '\'' +
                ", AnhDaiDien'" + anhdaidien + '\'' +
                ", ChieuCao'" + chieucao + '\'' +
                ", CanNang'" + cannang + '\'' +
                '}';
    }
}
