package org.techtown.a2017313135_week6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rate = (TextView) findViewById(R.id.rate);
        final Context context = this;

        @SuppressLint("StaticFieldLeak") AsyncTask<Integer, Double, String> findpi = new AsyncTask<Integer, Double, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                Toast.makeText(context, "start calculation", Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Toast.makeText(context, "end calculation", Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onProgressUpdate(Double... values) {
                super.onProgressUpdate(values);

                rate.setText(Double.toString(values[0]));
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }

            @Override
            protected String doInBackground(Integer... integers) {

                int total = 0;
                int incurcle = 0;

                double rate = 0;

                for(int i = 0; i < integers[0]; i++){
                    //try{
                      //  Thread.sleep(100);

                        double x = Math.random();
                        double y = Math.random();

                        double value = Math.pow(x, 2) + Math.pow(y, 2);
                        if(value <= 1) incurcle += 1;
                        total += 1;

                        rate = (double) incurcle / total;
                        publishProgress(rate*4);

                    //}catch(InterruptedException e){
                      //  e.printStackTrace();
                    //}

                    double error = Math.PI - rate*4;

                    if (error < 0.000001 && error > -0.000001) {
                        System.out.println("finish!!!!!!!!!!!!!!!!!!!!!");
                        break;
                    }
                    System.out.println("count :"+i+"  error : "+error);
                }
                return null;
            }
        };

        findpi.execute(Integer.MAX_VALUE);
    }
}
