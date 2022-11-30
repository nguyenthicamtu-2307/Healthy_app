package com.example.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private NavigationView nav_view;
    private ImageView home,setting,menu;
    private  LinearLayout catogory;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        nav();
        home=(ImageView) findViewById(R.id.home);
        setting=findViewById(R.id.setting);
        menu=findViewById(R.id.menutd);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Activity_Setting.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,HienThiThucDonActivity.class);
                startActivity(intent);
            }
        });
        catogory=findViewById(R.id.catogory);
        catogory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,Choose_MenuActivity.class);
                startActivity(intent);
            }
        });
    }

//    public void nav(){
//
//
//
//
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this,Activity_Setting.class);
//                startActivity(intent);
//            }
//        });
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
//                startActivity(intent);
//            }
//        });
////        NavigationView nav_view = findViewById(R.id.nav_view);
////        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
////            @Override
////            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////                switch (item.getItemId()){
////                    case R.id.action_home:
////
////                        break;
////                    case R.id.action_setting:
////                        Intent setting = new Intent(HomeActivity.this,Activity_Setting.class);
////                        startActivity(setting);
////                        break;
////                }
////
////                return true;
////            }
////        });
//
//        LinearLayout nav= findViewById(R.id.nav);
////        bt.setSelectedItemId(R.id.action_home);
////        nav.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                switch (v.getId()){
////                    case R.id.home:
////                        break;
////                    case R.id.menu:
//////                        Intent setting = new Intent(HomeActivity.this,Activity_Setting.class);
//////                        startActivity(setting);
////                        break;
////                    case R.id.setting:
////                        Intent intent = new Intent(HomeActivity.this,Activity_Setting.class);
////                        startActivity(intent);
////                        break;
////                }
////            }
////        });
//    }
}