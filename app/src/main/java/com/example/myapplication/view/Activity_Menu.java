package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity_Menu extends AppCompatActivity {

    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nav();

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
                        Intent home = new Intent(Activity_Menu.this,HomeActivity.class);
                        startActivity(home);
                        break;
                    case R.id.action_menu:

                    case R.id.action_setting:
                        Intent setting = new Intent(Activity_Menu.this ,Activity_Setting.class);
                        startActivity(setting);

                }

                return true;
            }
        });
    }
}