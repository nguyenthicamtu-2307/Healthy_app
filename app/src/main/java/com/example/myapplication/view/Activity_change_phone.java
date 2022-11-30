package com.example.myapplication.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Activity_change_phone extends AppCompatActivity {

    public int sdt;
    public TextView text_phone;
    public Button btnsubmitSDT;
    SharedPreferences sharedPreferences;
    SessionManager sessionManager;
    APIService apiService;
    public User kh = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);
        anhxa();
        btnsubmitSDT.setOnClickListener(this::Onclick);
    }

    public void Onclick(View v){
        switch (v.getId()) {
            case R.id.submitSDT:
                update_phone_csdl();
                Intent setting = new Intent(this, ProfileActivity.class);
                startActivity(setting);
                break;
        }

    }

    public void anhxa(){
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            kh = (User) bundleRecevie.get("user");
        }

        sdt = kh.getSdt();
        text_phone = (TextView) findViewById(R.id.text_phone);
        btnsubmitSDT = (Button) findViewById(R.id.submitSDT);

        if (sdt == 0){
            text_phone.setText(" ");
        }else{
            text_phone.setText(String.valueOf(sdt));
        }
    }

    public void update_phone_app(){
        int sodienthoai =Integer.valueOf(text_phone.getText().toString().trim());
        kh.setSdt(sodienthoai);
    }

    public void update_phone_csdl(){
        update_phone_app();
        APIService.apiService.updateKhachhang(kh,kh.getTaikhoan()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Activity_change_phone.this,"Cập nhật ko thành công!!!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Activity_change_phone.this,"Cập nhật thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = new Intent(Activity_change_phone.this, Activity_Setting.class);


    }

}
