package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class Choose_MenuActivity extends AppCompatActivity {

    public  Double BMI;
    public EditText tangcan,giamcan,healthy,tangco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);
        tangcan=findViewById(R.id.tangcan);
        giamcan=findViewById(R.id.giamcan);
        healthy=findViewById(R.id.healthy);
        tangco=findViewById(R.id.tangco);


        BMI=getIntent().getDoubleExtra("BMI",0);
        if(BMI<18.5){
            giamcan.setVisibility(View.GONE);
        }else {
            if(BMI>26){
                tangcan.setVisibility(View.GONE);
            }

        }

    }
}