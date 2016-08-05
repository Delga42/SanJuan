package com.albaitdevs.programasanjuan;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MyMapActivity extends FragmentActivity implements OnMapReadyCallback{
    Toolbar toolbar;
    int toolbarColor;
    int itemPosition;

    private void setUpToolbar(){
        String mode;


        switch (toolbarColor){
            case 0:
            case 3:
            case 4:
            case 6:
                mode = "WHITE"; break;
            default:
                mode = "BLACK";
        }
        switch (toolbarColor){
            case 0: toolbar.setBackgroundColor(getResources().getColor(R.color.dark_green_toolbar)); break;
            case 1: toolbar.setBackgroundColor(getResources().getColor(R.color.orange_toolbar)); break;
            case 2: toolbar.setBackgroundColor(getResources().getColor(R.color.green_pager)); break;
            case 3: toolbar.setBackgroundColor(getResources().getColor(R.color.black_toolbar)); break;
            case 4: toolbar.setBackgroundColor(getResources().getColor(R.color.wine_toolbar)); break;
            case 5: toolbar.setBackgroundColor(getResources().getColor(R.color.yellow_toolbar)); break;
            case 6: toolbar.setBackgroundColor(getResources().getColor(R.color.blue_toolbar)); break;

        }

        //Colors
        if (mode == "BLACK"){
            toolbar.inflateMenu(R.menu.main_activity_actions);
            toolbar.setTitleTextColor(Color.BLACK);
            toolbar.setSubtitleTextColor(Color.BLACK);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        } else {
            toolbar.inflateMenu(R.menu.main_activity_actions_white);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setSubtitleTextColor(Color.WHITE);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        }

        //Configuration
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                switch (item.getItemId()) {
                    case R.id.action_share:
                        openShare();
                        return true;
                    case R.id.action_feedback:
                        openFeedback();
                        return true;
                    default:
                        return false;
                }
            }
        });
        toolbar.setNavigationOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
        ArrayList<Schedule> list = new ArrayList<>();
        switch(toolbarColor){
            case 0: list = SchedulesStatics.getStaticScheduleLaCompra(); break;
            case 1: list = SchedulesStatics.getStaticScheduleElPregon(); break;
            case 2: list = SchedulesStatics.getStaticScheduleLaSaca(); break;
            case 3: list = SchedulesStatics.getStaticScheduleLosToros(); break;
            case 4: list = SchedulesStatics.getStaticScheduleLosAges(); break;
            case 5: list = SchedulesStatics.getStaticScheduleLasCalderas(); break;
            case 6: list = SchedulesStatics.getStaticScheduleLasBailas(); break;
            default:
        }
        toolbar.setSubtitle(getResources().getString(list.get(itemPosition).getPlace()));
        toolbar.setTitle(R.string.app_name);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Get extra information
        toolbarColor = getIntent().getExtras().getInt("com.albaitdevs.programasanjuan.pagerPosition");
        itemPosition = getIntent().getExtras().getInt("com.albaitdevs.programasanjuan.listPosition");

        toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        setUpToolbar();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {

        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        map.setMyLocationEnabled(true);

        ArrayList<Schedule> list = new ArrayList<>();
        switch(toolbarColor){
            case 0: list = SchedulesStatics.getStaticScheduleLaCompra(); break;
            case 1: list = SchedulesStatics.getStaticScheduleElPregon(); break;
            case 2: list = SchedulesStatics.getStaticScheduleLaSaca(); break;
            case 3: list = SchedulesStatics.getStaticScheduleLosToros(); break;
            case 4: list = SchedulesStatics.getStaticScheduleLosAges(); break;
            case 5: list = SchedulesStatics.getStaticScheduleLasCalderas(); break;
            case 6: list = SchedulesStatics.getStaticScheduleLasBailas(); break;
            default:
        }

        ArrayList<LatLng> locationList = list.get(itemPosition).getMapMarksLatLong();
        ArrayList<String> locationNameList = list.get(itemPosition).getMapMarksNames();

        LatLngBounds.Builder builder = new LatLngBounds.Builder();


        for (int i = 0; i < locationList.size(); i++) {
            map.addMarker(new MarkerOptions()
                    .title(locationNameList.get(i))
                    .position(locationList.get(i)));
            builder.include(locationList.get(i));

        }

        //Center map
        LatLng center = list.get(itemPosition).getMapCenter();
        float zoom = list.get(itemPosition).getMapZoom();

        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(center, zoom);
        map.animateCamera(cu);


    }

    private void openShare() {
        Tracker tracker = com.albaitdevs.programasanjuan.albait.AlbaitApplication.getTracker();
        if (tracker!=null) {
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory("Buttons")
                    .setAction("Share App")
                    .setLabel("Share App")
                    .build());
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.text_share_app));
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.word_share)));
    }

    //Click en sugerencias
    private void openFeedback() {
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        intent.putExtra("pager_position", toolbarColor);
        startActivity(intent);
    }
}
