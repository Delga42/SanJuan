package com.albaitdevs.programasanjuan;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.albaitdevs.programasanjuan.utils.Time;

import java.util.Timer;
import java.util.TimerTask;

public class LandingActivity extends Activity {
    private Handler handler = new Handler();
    Timer timer = new Timer();

    TextView daysText;
    TextView secondsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_landing);

        daysText = (TextView) findViewById(R.id.landing_days);
        secondsText = (TextView) findViewById(R.id.landing_seconds);

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                // 2015
                handler.post(updateTime);
            }
        }, 0, 1000);

        //Prepare textViews for animation
        TextView textAnimation_days = (TextView) findViewById(R.id.landing_animation_days);
        TextView textAnimation_seconds = (TextView) findViewById(R.id.landing_animation_seconds);
        TextView textAnimation_seconds_2 = (TextView) findViewById(R.id.landing_animation_seconds_2);

        //Add animations
        Animation anim_days = AnimationUtils.loadAnimation(this, R.anim.animation_days);
        Animation anim_secs = AnimationUtils.loadAnimation(this, R.anim.animation_seconds);
        Animation anim_secs_2 = AnimationUtils.loadAnimation(this, R.anim.animation_seconds_2);

        textAnimation_days.startAnimation(anim_days);
        textAnimation_seconds.startAnimation(anim_secs);
        textAnimation_seconds_2.startAnimation(anim_secs_2);

    }



    private Runnable updateTime = new Runnable() {

        Long secondsInDay = Long.parseLong("86400");
        Long secondsInHour = Long.parseLong("3600");
        Long secondsInMinute = Long.parseLong("60");

        public void run() {

            // Get GMT Time
            Long time = Time.getTime();
            Long nextDate = Time.nextBeginningDate();

            //Calculate days, hours, minutes and seconds
            Long days = (nextDate-time)/secondsInDay;
            time += days * secondsInDay;
            Long hours = (nextDate-time)/secondsInHour;
            time += hours * secondsInHour;
            Long minutes = (nextDate-time)/secondsInMinute;
            time += minutes * secondsInMinute;
            Long seconds = nextDate-time;

            //Edit textView
            if (Time.areWeOnPartiesNow()) {
                daysText.setText(getResources().getString(R.string.felices_fiestas));
            } else {
                daysText.setText(days.toString() + " " + getResources().getString(R.string.word_dias));
            }

            String hours_minutes_secs = hours.toString() + "h " + minutes.toString() + "m " + seconds + "s";
            if (Time.areWeOnPartiesNow()) {
                //Si ya estamos en fiestas no pintamos nada
                secondsText.setText("");
            } else {
                secondsText.setText(hours_minutes_secs);
            }

            //Animation times
            TextView textAnimation_days = (TextView) findViewById(R.id.landing_animation_days);
            TextView textAnimation_seconds = (TextView) findViewById(R.id.landing_animation_seconds);
            TextView textAnimation_seconds_2 = (TextView) findViewById(R.id.landing_animation_seconds_2);

            if (Time.areWeOnPartiesNow()) {
                //Texto si estamos en fiestas
                textAnimation_days.setText("");
                textAnimation_seconds.setText(getResources().getString(R.string.felices_fiestas));
                textAnimation_seconds_2.setText(getResources().getString(R.string.felices_fiestas));
            } else {
                textAnimation_days.setText(Time.getRemainingDays());
                textAnimation_seconds.setText(hours_minutes_secs);
                textAnimation_seconds_2.setText(hours_minutes_secs);
            }

        }
    };

    @Override
    public void onBackPressed(){
        MainActivity.setShowLandingPage(false);
        timer.cancel();
        finish();
    }

    public void closeLandingPage (View view){
        MainActivity.setShowLandingPage(false);
        timer.cancel();
        finish();
    }





}
