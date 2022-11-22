package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nav();
    }

    public void nav(){
        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:

                        break;
                    case R.id.action_setting:
                        Intent setting = new Intent(HomeActivity.this,Activity_Setting.class);
                        startActivity(setting);
                        break;
                }

                return true;
            }
        });

        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.action_home);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_home:

                        break;
                    case R.id.action_menu:
                        Intent menu = new Intent(HomeActivity.this,Activity_Menu.class);
                        startActivity(menu);
                        break;
                    case R.id.action_setting:
                        Intent setting = new Intent(HomeActivity.this,Activity_Setting.class);
                        startActivity(setting);
                        break;
                }

                return true;
            }
        });
    }
}