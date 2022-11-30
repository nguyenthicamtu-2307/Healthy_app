package com.example.myapplication.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.view.APP.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Change_name extends AppCompatActivity {

    public String tenuser;
    public TextView text_username;
    public Button btnsubmitFullname;
    public ImageButton btn_back;
    SharedPreferences sharedPreferences;
    SessionManager sessionManager;
    APIService apiService;
    public User kh = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        anhxa();
        btnsubmitFullname.setOnClickListener(this::Onclick);
        btn_back.setOnClickListener(this::Onclick);
    }


    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.submitFullname:
                update_user_csdl();
                Intent setting = new Intent(this, ProfileActivity.class);
                startActivity(setting);
                break;
            case R.id.btn_back:
                Intent back = new Intent(this, ProfileActivity.class);
                startActivity(back);
                break;
        }

    }

    public void anhxa() {

        btn_back = findViewById(R.id.btn_back);
        Bundle bundleRecevie = getIntent().getExtras();
        if (bundleRecevie != null) {
            kh = (User) bundleRecevie.get("user");
        }

        tenuser = kh.getTenuser();
        text_username = (TextView) findViewById(R.id.text_tenuser);
        btnsubmitFullname = (Button) findViewById(R.id.submitFullname);

        if (tenuser == null) {
            text_username.setText(" ");
        } else {
            text_username.setText(tenuser);
        }
    }

    public void update_user_app() {
        kh.setTenuser(text_username.getText().toString().trim());
    }

    public void update_user_csdl() {
        update_user_app();

        APIService.apiService.updateKhachhang(kh,kh.getTaikhoan()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Activity_Change_name.this,"Cập nhật  thành công!!!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Activity_Change_name.this,"Cập khong thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = new Intent(Activity_Change_name.this, Activity_Setting.class);

    }
}