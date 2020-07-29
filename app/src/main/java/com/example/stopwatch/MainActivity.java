package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean running;
    int seconds=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        runTimer();
        }

    public void onStart(View view) {
        running=true;
    }
    public void onStop(View view){
        running=false;
    }
    public void onLap(View view){

    }
    public void onReset(View view){
        running=false;
        seconds=0;
    }
    private void runTimer() {

        final TextView time=findViewById(R.id.seconds);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String Time = String.format("%d:%02d:%02d", hours, minutes, secs);
                time.setText(Time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
