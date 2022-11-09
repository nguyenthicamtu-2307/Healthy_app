package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity_Setting extends AppCompatActivity {

    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
}