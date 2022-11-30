package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;

public class update_BMI extends AppCompatActivity {


        public EditText edit_age, edit_height, edit_weight;
        public ImageButton image_back;
        public Button button_update;
        public User kh = new User();

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_bmi);
            anhxa();

//            image_back.setOnClickListener(this::Onclick);
//            button_update.setOnClickListener(this::Onclick);
            button_update = (Button) findViewById(R.id.next1);
            button_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    insertBmi();
                }
            });

        }

//
        public void anhxa(){
            edit_age = (EditText) findViewById(R.id.editAge);
            edit_height = (EditText) findViewById(R.id.updateheight);
            edit_weight = (EditText) findViewById(R.id.updateweight);

            image_back = (ImageButton) findViewById(R.id.imageButton_back);

            Bundle bundleRecevie = getIntent().getExtras();
            if (bundleRecevie != null) {
                kh = (User) bundleRecevie.get("user");
            }


                edit_height.setText(String.valueOf(kh.getChieucao()));
                edit_weight.setText(String.valueOf(kh.getCannang()));


        }
    public void insertBmi () {
            String weightstring = edit_weight.getText().toString().trim();
            String heightstring = edit_height.getText().toString().trim();
            if (weightstring.isEmpty()) {
                edit_weight.setError("weight is required");
                edit_weight.requestFocus();
                return;
            }

            if (heightstring.isEmpty()) {
                edit_height.setError("height is required");
                edit_height.requestFocus();
                return;
            }
            Double weight = Double.parseDouble(edit_weight.getText().toString().trim());
            Double height = Double.parseDouble(edit_height.getText().toString().trim());


            Double heightt = height / 100;
            Double BMI = weight / (heightt * heightt);

            Drawable drawable = getDrawable(R.drawable.vienbotron);
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;

            if (BMI < 18.5) {
                gradientDrawable.setStroke(50, Color.BLUE);
            } else {
                if (BMI < 25) {
                    gradientDrawable.setStroke(50, Color.GREEN);
                } else {
                    if (BMI < 30) {
                        gradientDrawable.setStroke(50, Color.YELLOW);
                    } else {
                        gradientDrawable.setStroke(50, Color.RED);
                    }
                }
            }
            Intent myIntent = new Intent(update_BMI.this, BIMActivity_02.class);
            myIntent.putExtra("weight", weight);
            myIntent.putExtra("height", height);
            startActivity(myIntent);
        }
//        public void update_app(){
//            if(edit_weight.getText().toString().trim() ==  null) {
//                edit_weight.setError("Cân Nặng không được để trống");
//                return;
//            }
//            if(edit_height.getText().toString().trim() ==  null) {
//                edit_height.setError("Chiều cao không được để trống");
//                return;
//            }
//            int weightt = Integer.valueOf(edit_weight.getText().toString().trim());
//            int heightt = Integer.valueOf(edit_height.getText().toString().trim());
//            kh.setCannang(weightt);
//            kh.setChieucao(heightt);
//        }
    }
