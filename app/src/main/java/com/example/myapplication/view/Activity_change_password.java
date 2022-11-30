package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_change_password extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SessionManager sessionManager;
    public TextView txt_pass, txt_newpass;
    String getTaiKhoan, getPassword;
    Button btnsubmitPassword;
    private List<User> khachHang;
    APIService apiService;
    public User kh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        anhxa();
        getdatakhachhang();


        btnsubmitPassword.setOnClickListener(this::Onclick);


    }

    public void Onclick(View v){
        switch (v.getId()) {
            case R.id.submitPassword:
                String old_pass = txt_pass.getText().toString().trim();
                String new_pass = txt_newpass.getText().toString().trim();
                checkpass(new_pass, old_pass);
                break;
        }

    }

    public void anhxa(){

        txt_pass = (TextView) findViewById(R.id.oldPassword);
        txt_newpass = (TextView) findViewById(R.id.newPassword);
        btnsubmitPassword = (Button) findViewById(R.id.submitPassword);

        apiService = Client.getAPIService();
        sessionManager = new SessionManager(this);
        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        HashMap<String,String> user = sessionManager.getUserDetail();
        getTaiKhoan = user.get(sessionManager.USERNAME);
        getPassword = user.get(sessionManager.PASSWORD);

    }

    public void checkpass(String pass,String oldpass){

        if(!oldpass.equals(getPassword)){
            txt_pass.setError("Nhập sai mật khẩu");
            return;
        }

        if(pass.equals(oldpass)){
            txt_newpass.setError("Bạn đã sữ dụng mật khẩu này rồi!");
            return;
        }
        if(txt_newpass.length() < 6){
            txt_newpass.setError("password phải có ít nhất 6 kí tự");
            return;
        }

        update_pass_CSDL();


    }

    public void getdatakhachhang(){
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
                    }
                } else {

                }
            }
            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                Toast.makeText(Activity_change_password.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void update_pass_app(){
        kh.setMatkhau(txt_newpass.getText().toString().trim());
    }

    public void update_pass_CSDL(){
        update_pass_app();
        APIService.apiService.updateKhachhang(kh,kh.getTaikhoan()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_change_password.this, "Cập nhật  thành công!!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Activity_change_password.this, "Cập nhật không thành công!!!", Toast.LENGTH_LONG).show();
                Log.e("error", t.getMessage());
            }
        });
        Intent setting = new Intent(this, Activity_Setting.class);
        startActivity(setting);
    }
}