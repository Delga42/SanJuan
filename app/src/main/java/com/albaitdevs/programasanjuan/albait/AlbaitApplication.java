package com.albaitdevs.programasanjuan.albait;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class AlbaitApplication extends Application {
    public static GoogleAnalytics analytics;
    public static Tracker tracker;
    private static Context context;

    public static Tracker getTracker(){
        return tracker;
    }

    public static GoogleAnalytics getAnalytics() {
        return analytics;
    }

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);

        tracker = analytics.newTracker("");
        tracker.enableExceptionReporting(true);
        tracker.enableAdvertisingIdCollection(true);
        tracker.enableAutoActivityTracking(true);

    }
}
