package com.example.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<HienThi> arraylist;

    public Adapter(Context context, int layout, List<HienThi> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        HienThi hienthi = arraylist.get(position);

        TextView text1 = view.findViewById(R.id.name);
        ImageView imageV = view.findViewById(R.id.image);

        text1.setText(hienthi.getTenmon());
        imageV.setImageResource(hienthi.getHinh());

        return view;
    }
}
