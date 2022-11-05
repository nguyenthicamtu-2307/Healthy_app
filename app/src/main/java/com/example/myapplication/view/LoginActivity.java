package com.example.myapplication.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.Serverce.Client;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;
import com.example.myapplication.view.APP.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private EditText nameEdit, passEdit;
    private TextView signUpText;
    private Button signInBtn;
    private SignupViewModel viewModel;
    public SessionManager sessionManager;
    public SharedPreferences sharedPreferences;
    private List<User> khachHang;
    APIService apiService;
    User kh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        sessionManager= new SessionManager(this);




        viewModel = new SignupViewModel(getApplication());

        if (viewModel.getUserData() != null){
                viewModel.getUserData().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null || s != "") {
                            sessionManager.createSession(nameEdit.getText().toString().trim());
                            Intent myIntent = new Intent(LoginActivity.this, BMIActivity.class);
                            startActivity(myIntent);
                        }
                    }
                });
        }
        apiService= Client.getAPIService();
        Login();
        nameEdit = findViewById(R.id.email);
        passEdit = findViewById(R.id.pass);
        signInBtn = findViewById(R.id.btnSignIn);
        signUpText = findViewById(R.id.signUpText);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(nameEdit.getText().toString())||
                        TextUtils.isEmpty(passEdit.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Username/Password in required", Toast.LENGTH_LONG).show();
                }else{
                    checkLogin();
                }
            }
        });


    }

    public void checkLogin() {
        String strUserName = nameEdit.getText().toString().trim();
        String strPassword = passEdit.getText().toString().trim();
        AlertDialog.Builder alter = new AlertDialog.Builder(LoginActivity.this);
        alter.setTitle("Nhập thiếu thông tin");
        alter.setMessage("Bạn nhập thiếu thông tin. Vui lòng nhập lại!");
        alter.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alter.setCancelable(true);
            }
        });
        if (strUserName.isEmpty() || strPassword.isEmpty()) {
            alter.show();
        } else {
            if (khachHang == null || khachHang.isEmpty()) {
                return;
            }
            boolean isHasUser = false;
            for (User khachHang1 : khachHang) {
                if (strUserName.equals(khachHang1.getTaiKhoan()) && strPassword.equals(khachHang1.getMatKhau())) {
                    isHasUser = true;
                    kh = khachHang1;
                    break;
                }
            }
            if (isHasUser) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user", kh);
                intent.putExtras(bundle);
                Toast.makeText(getApplicationContext(), "" + kh.getId(), Toast.LENGTH_SHORT).show();
                startActivity(intent);

            } else {
                alter.setTitle("Đăng nhập thất bại");
                alter.setMessage("Bạn nhập sai tên đăng nhập hoặc tài khoản. Vui lòng nhập lại");
                alter.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alter.setCancelable(true);
                    }
                });
                alter.show();
            }
        }
    }


    public void  Login(){
        Call<List<User>> call = apiService.khachhang();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                khachHang=response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}