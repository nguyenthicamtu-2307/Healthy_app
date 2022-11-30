package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.Serverce.Client;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.view.APP.SessionManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SessionManager sessionManager;
    public TextView text_taikhoan, text_hoten, text_ngaysinh, text_email, text_gioiting, text_sdt, text_cannang, text_chieucao;
    String getTaiKhoan;
    ImageButton image_change_name, image_change_phone, image_change_cannang, image_change_gioitinh, image_change_chieucao, image_back;

    private List<User> khachHang;
    APIService apiService;
    public User kh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        anhxa();
        apiService = Client.getAPIService();
        sessionManager = new SessionManager(this);
        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        HashMap<String,String> user = sessionManager.getUserDetail();
        getTaiKhoan = user.get(sessionManager.USERNAME);
        getdata();

        image_change_name.setOnClickListener(this::Onclick);
        image_change_phone.setOnClickListener(this::Onclick);
        image_change_chieucao.setOnClickListener(this::Onclick);
        image_change_gioitinh.setOnClickListener(this::Onclick);
        image_change_cannang.setOnClickListener(this::Onclick);
        image_back.setOnClickListener(this::Onclick);


    }

    public void Onclick(View v){
        switch (v.getId()) {
            case R.id.image_back:
                Intent back = new Intent(this,Activity_Setting.class);
                startActivity(back);
                break;
            case R.id.image_changename:
                Intent changename = new Intent(this, Activity_Change_name.class);
                Bundle bundle_name = new Bundle();
                bundle_name.putSerializable("user", kh);
                changename.putExtras(bundle_name);
                startActivity(changename);
                break;
            case R.id.image_changephone:
                Intent changephone = new Intent(this, Activity_change_phone.class);
                Bundle bundle_phone = new Bundle();
                bundle_phone.putSerializable("user", kh);
                changephone.putExtras(bundle_phone);
                startActivity(changephone);
                break;
            case R.id.image_changegioitinh:
            case R.id.image_changechieucao:
            case R.id.image_changecanang:
                Intent change = new Intent(this, Activity_change_tt.class);
                Bundle bundle_change = new Bundle();
                bundle_change.putSerializable("user", kh);
                change.putExtras(bundle_change);
                startActivity(change);
                break;

        }

    }

    public void anhxa(){

        text_taikhoan = (TextView) findViewById(R.id.text_taikhoan);
        text_hoten = (TextView) findViewById(R.id.text_ten);
        text_ngaysinh = (TextView) findViewById(R.id.text_ngaysinh);
        text_email = (TextView) findViewById(R.id.text_email);
        text_gioiting = (TextView) findViewById(R.id.text_gioitinh);
        text_sdt = (TextView) findViewById(R.id.text_sdt);
        text_cannang = (TextView) findViewById(R.id.text_cannang);
        text_chieucao = (TextView) findViewById(R.id.text_chieucao);

        image_change_name = (ImageButton) findViewById(R.id.image_changename);
        image_change_phone = (ImageButton) findViewById(R.id.image_changephone);
        image_change_gioitinh = (ImageButton) findViewById(R.id.image_changegioitinh);
        image_change_cannang = (ImageButton) findViewById(R.id.image_changecanang);
        image_change_chieucao = (ImageButton) findViewById(R.id.image_changechieucao);
        image_back = (ImageButton) findViewById(R.id.image_back);
    }

    public void getdata() {
        kh=new User();
        khachHang = new ArrayList<>();
        Call<List<User>> call = apiService.idkhachhang(getTaiKhoan);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                khachHang = response.body();
                if (khachHang != null && khachHang.size() > 0) {
                    for (User khachHang1 : khachHang) {
                        kh = khachHang1;
                        setdata(kh);
                    }
                } else {

                }
            }
            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                Toast.makeText(ProfileActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setdata(User kh){
        text_taikhoan.setText(kh.getTaikhoan());
        if (kh.getTenuser() == null){
            text_hoten.setText("Cập Nhập");
        }else {
            text_hoten.setText(kh.getTenuser());
        }

        if (kh.getDob() == null){
            text_ngaysinh.setText("Cập Nhập");
        }else {
            text_ngaysinh.setText(kh.getDob());
        }

        if (kh.getGioitinh() == null){
            text_gioiting.setText("Cập Nhập");
        }else {
            text_gioiting.setText(kh.getGioitinh());
        }

        if (kh.getSdt() == 0){
            text_sdt.setText("Cập Nhập");
        }else {
            text_sdt.setText(String.valueOf(kh.getSdt()));
        }

        text_cannang.setText(String.valueOf(kh.getCannang()));
        text_chieucao.setText(String.valueOf(kh.getChieucao()));
    }


}