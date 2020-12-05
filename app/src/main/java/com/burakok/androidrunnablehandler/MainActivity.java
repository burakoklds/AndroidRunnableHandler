package com.burakok.androidrunnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    TextView textView;
    int number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtTime);
        button = findViewById(R.id.btnStart);
        number = 0;
    }

    public void  start(View view) {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : " + number);
                number++;
                textView.setText("Time : " + number);

                handler.postDelayed(runnable,1000); /* Her 1 saniye'de bu işlemi yap */

            }
        };
        handler.post(runnable); /* runnable'ı start et */
        button.setEnabled(false); /* Bir kere tıklandığında pasife geçer */
    }

    public void  stop(View view) {
        button.setEnabled(true); /* start butonu Aktif olur */

        handler.removeCallbacks(runnable); /* runnable sıfırlanır */
        number = 0;
        textView.setText("Time : " + number);
    }
}