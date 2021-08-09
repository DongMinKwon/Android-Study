package org.techtown.week7_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView url_text;
    TextView data;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_text = (TextView)findViewById(R.id.textView);
        data = (TextView)findViewById(R.id.textView2);
        button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();

                DataModel postData = new DataModel();
                postData.setName("sam");
                postData.setJob("programmer");

                HttpUrl.Builder urlBuilder = HttpUrl.parse("https://reqres.in/api/users").newBuilder();
                urlBuilder.addQueryParameter("page", "2");
                String url = urlBuilder.build().toString();
                url_text.setText(url);

                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(postData);

                Request req = new Request.Builder()
                        .url(url)
                        .post(RequestBody.create(MediaType.parse("application/json"), json))
                        .build();

                client.newCall(req).enqueue(new Callback(){
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final String myResponse = response.body().string();

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                data.setText(myResponse);
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }
                });



            }
        });



    }
}
