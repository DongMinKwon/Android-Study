package org.techtown.week4_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView fListview;
    TextView top;
    Button btn1, btn2, btn3;

    ArrayAdapter<String> f_adapter;
    ArrayAdapter<String> s_adapter;
    ArrayAdapter<String> t_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top = findViewById(R.id.textView6);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        fListview = findViewById(R.id.f_list);

        ArrayList<String> data1 = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        ArrayList<String> data3 = new ArrayList<>();

        for(int i = 0; i<=10; i++){
            data1.add(Integer.toString(i));
        }

        int num = 1;

        for(int i = 0; i<10; i++){
            num *= 2;
            data2.add(Integer.toString(num));
        }

        data3.add("2017313135");
        data3.add("DongMin Kwon");
        data3.add("Department of Software");
        data3.add("College of Software");
        data3.add("SunKunKwan University");

        f_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data1);
        s_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data2);
        t_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data3);
        fListview.setAdapter(f_adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                top.setText(getResources().getString(R.string.first));
                fListview.setAdapter(f_adapter);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                top.setText(getResources().getString(R.string.second));
                fListview.setAdapter(s_adapter);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                top.setText(getResources().getString(R.string.third));
                fListview.setAdapter(t_adapter);
            }
        });
    }

}
