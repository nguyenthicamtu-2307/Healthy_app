package com.example.myapplication.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText emailEdit, passEdit, passfirmEdit, nameEdit;
    private Button signUp;
    private TextView signIn;
    private SignupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        signUp = (Button) findViewById(R.id.btnSignUp);
        nameEdit = (EditText) findViewById(R.id.name);
        emailEdit = (EditText) findViewById(R.id.email);
        passEdit = (EditText) findViewById(R.id.pass);
        passfirmEdit = (EditText) findViewById(R.id.passconfirm);
        signIn = (TextView) findViewById(R.id.btnSignIn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_tendn, text_mknl, text_pass;
                text_tendn=(nameEdit.getText()).toString();
                text_pass=(passEdit.getText()).toString().trim();
                text_mknl= (passfirmEdit.getText()).toString().trim();
                AlertDialog.Builder alert = new AlertDialog.Builder(SignupActivity.this);
                alert.setTitle("Nhập Thiếu Thông Tin");
                alert.setMessage("Bạn nhập thiếu thông tin. Vui lòng nhập lại");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alert.setCancelable(true);
                    }
                });
                if(text_mknl.isEmpty()||text_tendn.isEmpty()||text_pass.isEmpty()){
                    alert.show();
                }
                else {
                    if(!text_pass.equals(text_mknl)){
                        alert.setTitle("Mật Khẩu Không Trùng Nhau");
                        alert.setMessage("Vui lòng kiểm tra lại mật khẩu của bạn. Mật khẩu nhập lại cần phải giống với mật khẩu ban đầu");
                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alert.setCancelable(true);
                            }
                        });
                        alert.show();
                    }
                    else {
                        createnewUser();
                    }
                }

            }
        });



    }
    private void createnewUser(){
        User khachHang = new User(nameEdit.getText().toString(),passEdit.getText().toString(),nameEdit.getText().toString());
        APIService.apiService.createUser(khachHang).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(SignupActivity.this, "Registerfail", Toast.LENGTH_SHORT).show();

            }



            @Override
            public void onFailure(Call<User> call, Throwable t) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SignupActivity.this);
                alert.setTitle("Đăng Ký Thành Công");
                alert.setMessage("Bạn đăng ký tài khoản thành công! Vui lòng nhấn OK để đi đến trang đăng nhập!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    }
                });
                alert.show();
            }
        });
    }

}
