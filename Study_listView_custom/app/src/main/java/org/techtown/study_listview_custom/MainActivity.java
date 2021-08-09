package org.techtown.study_listview_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView my_list = (ListView) findViewById(R.id.list1);
        item_data data1 = new item_data();

        data1.set_face(R.drawable.ic_launcher_background);
        data1.set_name("Mark");
        data1.set_number("010-0101-0010");

        custom_Adapter adapter;

        adapter = new custom_Adapter(data1);
        my_list.setAdapter(adapter);
    }
}
