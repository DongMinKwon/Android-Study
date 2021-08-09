package org.techtown.a2017313135_week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int i = 1;
    int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView id_name = (TextView)findViewById(R.id.textView);
        Button btn1 = (Button)findViewById(R.id.button);

        btn1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                i = 1 - i;
                if (i == 0){
                    id_name.setText("2017313135");
                }
                else{
                    id_name.setText("Dong Min Kwon");
                }
            }
        });


        Button btn2 = (Button)findViewById(R.id.button_candy);

        final ImageView candy = (ImageView)findViewById(R.id.imageView_candy);

        btn2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
              if(j == 0){
                  candy.setImageResource(R.drawable.image2);
                  j++;
              }
              else if(j == 1){
                  candy.setImageResource(R.drawable.image3);
                  j++;
              }
              else{
                  candy.setImageResource(R.drawable.image1);
                  j = 0;
              }

            }

        });
    }



}
