package com.mokiware.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private int centiseconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null){
            centiseconds = savedInstanceState.getInt("centiseconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("centiseconds", centiseconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){
        running = false;
        centiseconds = 0;
    }

    //Runs every second
    //Converts centiseconds into minutes, seconds, centiseconds, updates TextView
    //If (running) it increments centiseconds
    private void runTimer(){
        final TextView timerView = (TextView) findViewById(R.id.timer_view);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run(){
                int minutes = centiseconds/6000;
                int secs = (centiseconds%6000)/100;
                int centisecs = (centiseconds%100)/10;

                //format the timer string to look like h:mm:ss
                String time = String.format("%02d:%02d:%d", minutes, secs, centisecs);

                timerView.setText(time);

                if (running) {
                    centiseconds+=10;
                }
                handler.postDelayed(this, 100);
            }
        });


    }
}
