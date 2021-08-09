package org.techtown.study_listview_custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class custom_Adapter extends BaseAdapter {

    private item_data data;

    public custom_Adapter(item_data item){
        data = item;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return data;
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        };

        ImageView face = (ImageView)convertView.findViewById(R.id.imageView);
        TextView name = (TextView)convertView.findViewById(R.id.textView);
        TextView number = (TextView)convertView.findViewById(R.id.textView2);

        face.setImageResource(data.get_face());
        name.setText(data.get_name());
        number.setText(data.get_number());

        //item_data data_view = data.get(pos);

        //face.setImageDrawable(data_view.get_face());
        //name.setText(data_view.get_name());
        //number.setText(data_view.get_number());


        return convertView;
    }
}
