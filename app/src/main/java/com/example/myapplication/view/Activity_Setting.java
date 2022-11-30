package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity_Setting extends AppCompatActivity {

    private BottomNavigationView navigationView;
    public TextView btn_profile, btn_thongtin, btn_trogiup, btn_doimatkhau, btn_dangxuat;
    public ImageButton image_profile, image_thongtin, image_trogiup, image_doimatkhau, image_dangxuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        nav();
        anhxa();
        btn_profile.setOnClickListener(this::Onclick);
        btn_doimatkhau.setOnClickListener(this::Onclick);
    }


    public void nav(){
        navigationView = findViewById(R.id.bottom_nav);
        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.action_setting);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_home:
                        Intent home = new Intent(Activity_Setting.this,HomeActivity.class);
                        startActivity(home);
                        break;
                    case R.id.action_menu:
                        Intent menu = new Intent(Activity_Setting.this,Activity_Menu.class);
                        startActivity(menu);
                        break;
                    case R.id.action_setting:

                }

                return true;
            }
        });
    }

    public void anhxa(){
        btn_profile = (TextView) findViewById(R.id.btn_btnprofile);
        btn_thongtin = (TextView) findViewById(R.id.btn_btndieukhoan);
        btn_trogiup = (TextView) findViewById(R.id.btn_btnptrungtam);
        btn_doimatkhau = (TextView) findViewById(R.id.btn_btndoimatkhau);
        btn_dangxuat = (TextView) findViewById(R.id.btn_btnlogout);

        image_profile = (ImageButton) findViewById(R.id.image_profile);
        image_thongtin = (ImageButton) findViewById(R.id.image_dieukhoan);
        image_trogiup = (ImageButton) findViewById(R.id.image_trogiup);
        image_doimatkhau = (ImageButton) findViewById(R.id.image_doimatkhau);
        image_dangxuat = (ImageButton) findViewById(R.id.image_dangxuat);
    }

    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.btn_btnprofile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.image_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.btn_btndoimatkhau:
                startActivity(new Intent(this, Activity_change_password.class));
                break;
            case R.id.image_doimatkhau:
                startActivity(new Intent(this, Activity_change_password.class));
                break;
        }
    }
}