package org.techtown.a2017313135_week7_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText inputTitle;
    TextView title;
    TextView year;
    TextView date;
    TextView runtime;
    TextView director;
    TextView genre;
    TextView imdb;
    TextView metascore;
    Button btn;
    DataModel data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTitle = (EditText)findViewById(R.id.editText);
        title = (TextView)findViewById(R.id.textView);
        year = (TextView)findViewById(R.id.textView2);
        date = (TextView)findViewById(R.id.textView3);
        runtime = (TextView)findViewById(R.id.textView4);
        director = (TextView)findViewById(R.id.textView5);
        genre = (TextView)findViewById(R.id.textView6);
        imdb = (TextView)findViewById(R.id.textView7);
        metascore = (TextView)findViewById(R.id.textView8);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();

                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://www.omdbapi.com/").newBuilder();
                urlBuilder.addQueryParameter("apikey", "123ee981");
                urlBuilder.addQueryParameter("t", inputTitle.getText().toString());

                String url = urlBuilder.build().toString();

                Request req = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final String myResponse = response.body().string();

                        Gson gson = new GsonBuilder().create();
                        data1 = gson.fromJson(myResponse, DataModel.class);


                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                title.setText("Title : "+data1.getTitle());
                                year.setText("Year : "+data1.getYear());
                                date.setText("Released Date : "+data1.getReleased());
                                runtime.setText("Runtime : "+data1.getRuntime());
                                director.setText("Director : "+data1.getDirector());
                                genre.setText("Genre : "+data1.getGenre());
                                imdb.setText("IMDB Rates : "+data1.getImdbRating());
                                metascore.setText("Metascore : "+data1.getMetascore());
                            }
                        });
                    }
                });
            }
        });



    }
}
