package org.techtown.week5_2017313135;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallingSearching extends AppCompatActivity {

    EditText keyword;
    EditText phoneNum;
    Button search;
    Button call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_searching);

        keyword = (EditText)findViewById(R.id.editText3);
        phoneNum = (EditText)findViewById(R.id.editText4);
        search = (Button)findViewById(R.id.button2);
        call = (Button)findViewById(R.id.button3);

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Editable findstr = keyword.getText();
                if(findstr != null){
                    Intent intent1 = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent1.putExtra(SearchManager.QUERY, findstr.toString());
                    if(intent1.resolveActivity(getPackageManager()) != null)
                        startActivity(intent1);
                }

            }
        });

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Editable number = phoneNum.getText();
                if(number != null) {
                    Uri uri = Uri.parse("tel:"+number.toString());
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    if(intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                }
            }
        });


    }
}
