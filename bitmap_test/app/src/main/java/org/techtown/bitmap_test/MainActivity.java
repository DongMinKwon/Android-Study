package org.techtown.bitmap_test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bitmap> three_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        make_bitmap();
        ImageView iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageBitmap();
    }

    public void make_bitmap() {
        Bitmap muyaho = BitmapFactory.decodeResource(getResources(), R.drawable.muyaho);

        int width3 = muyaho.getWidth() / 3;
        int height3 = muyaho.getHeight() / 3;

        Bitmap sub_bitmap;
        for (int h = 0; h < 2; h++) {
            for (int w = 0; w < 2; w++) {
                sub_bitmap = Bitmap.createBitmap(muyaho, w * width3, h * height3, width3, height3);
                three_list.add(sub_bitmap);
            }
        }
    }
}
