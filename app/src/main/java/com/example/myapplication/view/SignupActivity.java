package com.example.myapplication.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText emailEdit, passEdit, passfirmEdit, nameEdit;
    private Button signUp;
    private TextView signIn;
    private SignupViewModel viewModel;
    public static String unameGlobal ="";
    APIService apiService;
    User  account;
    private List<User> khachHangs;
    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";
    // key for storing email.
    public static final String EMAIL_KEY = "email_key";
    // key for storing password.
    public static final String PASSWORD_KEY = "password_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
                alert.setTitle("Nh???p Thi???u Th??ng Tin");
                alert.setMessage("B???n nh???p thi???u th??ng tin. Vui l??ng nh???p l???i");
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
                        alert.setTitle("M???t Kh???u Kh??ng Tr??ng Nhau");
                        alert.setMessage("Vui l??ng ki???m tra l???i m???t kh???u c???a b???n. M???t kh???u nh???p l???i c???n ph???i gi???ng v???i m???t kh???u ban ?????u");
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
        SharedPreferences sharedpreferences;
        String uname,upass;
        String password =passEdit.getText().toString();
        String username =nameEdit.getText().toString();
        unameGlobal = nameEdit.getText().toString();

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        uname = sharedpreferences.getString(EMAIL_KEY, null);
        upass = sharedpreferences.getString(PASSWORD_KEY, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(SignupActivity.this);
//        User account = new User1( username, pasword);
        User khachHang = new User(username,password, username);
        APIService.apiService.createUser(khachHang).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(SignupActivity.this, "Registerfail", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                // below two lines will put values for
                // email and password in shared preferences.
                editor.putString(EMAIL_KEY, nameEdit.getText().toString());
                editor.putString(PASSWORD_KEY, passEdit.getText().toString());
                // to save our data with key and value.
                editor.apply();
                AlertDialog.Builder alert = new AlertDialog.Builder(SignupActivity.this);
                alert.setTitle("????ng K?? Th??nh C??ng");
                alert.setMessage("B???n ????ng k?? t??i kho???n th??nh c??ng! Vui l??ng nh???n OK ????? ??i ?????n trang ti???p theo!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(SignupActivity.this, BMIActivity.class).putExtra("object_user", khachHang));
                    }
                });
                alert.show();
            }
        });
    }

}
