package com.example.myapplication.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class HienThiThucDonActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<HienThi> arrayList;
    Adapter adapter;
    private Button button1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthithucdon);
        listView = (ListView) findViewById(R.id.listviewtt);
        arrayList = new ArrayList<>();
        arrayList.add(new HienThi("Trứng Chiên", R.drawable.tc));
        arrayList.add(new HienThi("Lẩu bò", R.drawable.lb));
        arrayList.add(new HienThi("Gà Ác Hầm Thuốc Bắc", R.drawable.ga));
        adapter = new Adapter(HienThiThucDonActivity.this, R.layout.activity_listviewhienthi, arrayList);
        listView.setAdapter(adapter);

    }
}
