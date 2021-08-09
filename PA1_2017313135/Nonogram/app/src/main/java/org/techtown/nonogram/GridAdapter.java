package org.techtown.nonogram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    private String num;
    private ArrayList<Integer> bitList;
    LayoutInflater inflater;

    public GridAdapter(ArrayList<Integer> bitList) {
        this.bitList = bitList;
    }

    @Override
    public int getCount() {
        return bitList.size();
    }

    @Override
    public Object getItem(int position) {
        return bitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        int num = bitList.get(position);


        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gridview_cell, null);

        }
        if(num == 1) convertView.setBackgroundColor(Color.BLACK);
        else if(num == 0) convertView.setBackgroundColor(Color.WHITE);
        else convertView.setBackgroundColor(Color.parseColor("#DFDFDF"));

        TextView showNum = (TextView)convertView.findViewById(R.id.textView);

        int textsize = 360/25;
        showNum.setTextSize(textsize);

        if(position % 20 == 19){
            showNum.setText(String.valueOf(num));
        }else
            showNum.setText("");

        return convertView;
    }
}
