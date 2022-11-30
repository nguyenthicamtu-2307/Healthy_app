package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.Serverce.APIService;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_change_tt extends AppCompatActivity {

    public EditText edit_age, edit_height, edit_weight;
    public ImageButton image_back;
    public Button button_update;
    public User kh = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_tt);
        anhxa();

        image_back.setOnClickListener(this::Onclick);
        button_update.setOnClickListener(this::Onclick);

    }

    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_back:
                Intent setting = new Intent(this, ProfileActivity.class);
                startActivity(setting);
                break;
            case R.id.Button_update:
                update_csdl();
                break;
        }

    }
    public void anhxa(){
        edit_age = (EditText) findViewById(R.id.editAge);
        edit_height = (EditText) findViewById(R.id.editHeight);
        edit_weight = (EditText) findViewById(R.id.editWeight);

        image_back = (ImageButton) findViewById(R.id.imageButton_back);
        button_update = (Button) findViewById(R.id.Button_update);

        Bundle bundleRecevie = getIntent().getExtras();
        if (bundleRecevie != null) {
            kh = (User) bundleRecevie.get("user");
        }


        if (kh.getCannang() == 0) {
            edit_weight.setText(" ");
        } else {
            edit_weight.setText(String.valueOf(kh.getCannang()));
        }
        if (kh.getChieucao() == 0) {
            edit_height.setText(" ");
        } else {
            edit_height.setText(String.valueOf(kh.getChieucao()));
        }

    }
    public void update_app(){
        if(edit_weight.getText().toString().trim() ==  null) {
            edit_weight.setError("Cân Nặng không được để trống");
            return;
        }
        if(edit_height.getText().toString().trim() ==  null) {
            edit_height.setError("Chiều cao không được để trống");
            return;
        }
        int weightt = Integer.valueOf(edit_weight.getText().toString().trim());
        int heightt = Integer.valueOf(edit_height.getText().toString().trim());
        kh.setCannang(weightt);
        kh.setChieucao(heightt);
    }

    public void update_csdl(){
        update_app();
        APIService.apiService.updateKhachhang(kh,kh.getTaikhoan()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Activity_change_tt.this,"Cập nhật  thành công!!!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Activity_change_tt.this,"Cập khong thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = new Intent(Activity_change_tt.this, ProfileActivity.class);
        startActivity(intent);
    }

}
