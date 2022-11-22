package com.example.myapplication.view;

public class HienThi {
    private String tenmon;
    private int hinh;

    public HienThi(String tenmon, int hinh) {
        this.tenmon = tenmon;
        this.hinh = hinh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
