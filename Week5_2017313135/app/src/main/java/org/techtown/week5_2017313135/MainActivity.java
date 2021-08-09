package org.techtown.week5_2017313135;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText id;
    EditText password;

    final String loginID = "MAP";
    final String loginPW = "weloveprofessor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        id = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(loginID.equals(id.getText().toString()) && loginPW.equals(password.getText().toString())){
                     Intent intent = new Intent(MainActivity.this, CallingSearching.class);
                     startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
