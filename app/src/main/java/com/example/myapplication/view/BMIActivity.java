package com.example.myapplication.view;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.BimModel.BmiModel;
import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.BmiViewModel;
import com.example.myapplication.ViewModel.SignupViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BMIActivity extends AppCompatActivity {
    private EditText weightEdit, heightEdit;
    private Button btnBmi;
    private ImageButton logout;
    private TextView result, nx;
    APIService apiService;
    private User account = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bimbackup);
        Bundle bundleRecevie = getIntent().getExtras();
        if (bundleRecevie != null) {
            account = (User) bundleRecevie.get("object_user");
        }
        weightEdit = findViewById(R.id.editWeigh);
        heightEdit = findViewById(R.id.editHeigh);
        btnBmi = findViewById(R.id.imageButton2);
//        logout = findViewById(R.id.signOut);
//        result=findViewById(R.id.result);
//        nx=findViewById(R.id.nhan_xet);//        nhanData();
        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfor(account);
                update();
                APIService.apiService.updateKhachhang(account,account.getTaikhoan()).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(BMIActivity.this, "C???p nh???t  th??nh c??ng!!!", Toast.LENGTH_LONG).show();
//                            BMI();
                            Double weight = Double.parseDouble(weightEdit.getText().toString().trim());
                            Double height = Double.parseDouble(heightEdit.getText().toString().trim());


                            Double heightt = height / 100;
                            Double BMI = weight / (heightt * heightt);

                            Drawable drawable = getDrawable(R.drawable.vienbotron);
                            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                            if (BMI < 18.5) {
                                gradientDrawable.setStroke(50, Color.BLUE);
                            }else {
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
                            Intent myIntent = new Intent(BMIActivity.this, BIMActivity_02.class);
                            myIntent.putExtra("weight", weight);
                            myIntent.putExtra("height", height);
                            startActivity(myIntent);
                        }

//                        Intent myIntent = new Intent(BMIActivity.this, BIMActivity_02.class);
//            myIntent.putExtra("weight", weight);
//            myIntent.putExtra("height", height);
//            startActivity(myIntent);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(BMIActivity.this, "C???p nh???t kh??ng th??nh c??ng!!!", Toast.LENGTH_LONG).show();
                        Log.e("error", t.getMessage());
                    }
                });


            }
        });


//        public void insertBmi () {
//            String weightstring = weightEdit.getText().toString().trim();
//            String heightstring = heightEdit.getText().toString().trim();
//            if (weightstring.isEmpty()) {
//                weightEdit.setError("weight is required");
//                weightEdit.requestFocus();
//                return;
//            }
//
//            if (heightstring.isEmpty()) {
//                heightEdit.setError("height is required");
//                heightEdit.requestFocus();
//                return;
//            }
//            Double weight = Double.parseDouble(weightEdit.getText().toString().trim());
//            Double height = Double.parseDouble(heightEdit.getText().toString().trim());
//
//
//            Double heightt = height / 100;
//            Double BMI = weight / (heightt * heightt);
//
//            Drawable drawable = getDrawable(R.drawable.vienbotron);
//            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
//
//            if (BMI < 18.5) {
//                gradientDrawable.setStroke(50, Color.BLUE);
//            } else {
//                if (BMI < 25) {
//                    gradientDrawable.setStroke(50, Color.GREEN);
//                } else {
//                    if (BMI < 30) {
//                        gradientDrawable.setStroke(50, Color.YELLOW);
//                    } else {
//                        gradientDrawable.setStroke(50, Color.RED);
//                    }
//                }
//            }
//            Intent myIntent = new Intent(BMIActivity.this, BIMActivity_02.class);
//            myIntent.putExtra("weight", weight);
//            myIntent.putExtra("height", height);
//            startActivity(myIntent);
//        }

    }
public void BMI(){
    Double weight = Double.parseDouble(weightEdit.getText().toString().trim());
    Double height = Double.parseDouble(heightEdit.getText().toString().trim());


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
        Intent myIntent = new Intent(BMIActivity.this, BIMActivity_02.class);
        myIntent.putExtra("weight", weight);
        myIntent.putExtra("height", height);
        startActivity(myIntent);
    }
}
    public void update() {
        String weightstring = weightEdit.getText().toString().trim();
        String heightstring = heightEdit.getText().toString().trim();
        if (weightstring.isEmpty()) {
            weightEdit.setError("weight is required");
            weightEdit.requestFocus();
            return;
        }

        if (heightstring.isEmpty()) {
            heightEdit.setError("height is required");
            heightEdit.requestFocus();
            return;
        }

    }

    private void saveInfor(User khachhang) {
        khachhang.setCannang(Integer.parseInt(weightEdit.getText().toString()));
        khachhang.setChieucao(Integer.parseInt(heightEdit.getText().toString()));

        khachhang.setTaikhoan(SignupActivity.unameGlobal);
    }

    public void nhanData() {
        Bundle bundleRecevie = getIntent().getExtras();
        if (bundleRecevie != null) {
            account = (User) bundleRecevie.get("object_user");
            weightEdit.setText(account.getCannang());
            heightEdit.setText(account.getChieucao());
        }
    }
}