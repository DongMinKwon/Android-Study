package org.techtown.nonogram;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.graphics.Color;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button search;
    Button gallery;
    TextView testText;
    GridView board;
    Bitmap image;
    ArrayList<Bitmap> imgList = new ArrayList<>();
    ArrayList<Integer> bit_list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editText2);
        search = findViewById(R.id.button2);
        gallery = findViewById(R.id.button3);
        testText = findViewById(R.id.textView);
        board = findViewById(R.id.gridview);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board.setNumColumns(20);

                String query = "cat";

                //get image data from naver image searching
                ImageData imagedata = new ImageData(query);
                try {
                    imagedata.setimg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Bitmap pre_Image=imagedata.getImg();

                //resize img data
                ImgEditor editor = new ImgEditor(pre_Image);
                image = editor.resize();

                //to black and white image
                image = editor.grayScale();

                //cut image
                editor.cutImg();
                imgList = editor.getImgList();

                //to bit imglist
                bit_list = editor.getBitList();


                GridAdapter adapter = new GridAdapter(bit_list);
                board.setAdapter(adapter);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
