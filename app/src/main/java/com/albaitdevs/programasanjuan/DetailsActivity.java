package com.albaitdevs.programasanjuan;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.util.ArrayList;



public class DetailsActivity extends Activity {
    public static int WHITE = 0;
    public static int BLACK = 1;

    private Schedule currentItem = null;

    int pagerPosition;
    Toolbar toolbar;

    int list_position;
    int pager_position;

    public int getPagerPosition() {
        return pagerPosition;
    }

    public Schedule getCurrentItem(){
        return currentItem;
    }

    public void setToolbarMode(int mode){
        if (mode == DetailsActivity.BLACK){
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        list_position = intent.getIntExtra("list_position", -1);
        pager_position = intent.getIntExtra("pager_position",-1);

        setContentView(R.layout.activity_detailed_info);
        ScrollView scrollView = (ScrollView) findViewById(R.id.detail_scrollview);

        switch (pager_position) {
            // Set the background layout for landscape and portrait
            case 0:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.lacompra_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.lacompra_portrait);
                }
                break;
            case 1:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.miercoles_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.miercoles_image_portrait);
                }
                break;
            case 2:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.jueves_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.jueves_image_portrait);
                }
                break;
            case 3:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.viernes_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.viernes_image_portrait);
                }
                break;
            case 4:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.sabado_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.sabado_image_portrait);
                }
                break;
            case 5:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.domingo_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.domingo_image_portrait);
                }
                break;
            case 6:
                if (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {
                    scrollView.setBackgroundResource(R.drawable.lunes_image_landscape);
                } else {
                    scrollView.setBackgroundResource(R.drawable.lunes_image_portrait);
                }
                break;
            default:

        }


        // Set up the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_detailed_info);
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

        pagerPosition = pager_position;
        ArrayList<Schedule> list = new ArrayList<>();
        switch(pager_position){
            case 0: list = SchedulesStatics.getStaticScheduleLaCompra(); break;
            case 1: list = SchedulesStatics.getStaticScheduleElPregon(); break;
            case 2: list = SchedulesStatics.getStaticScheduleLaSaca(); break;
            case 3: list = SchedulesStatics.getStaticScheduleLosToros(); break;
            case 4: list = SchedulesStatics.getStaticScheduleLosAges(); break;
            case 5: list = SchedulesStatics.getStaticScheduleLasCalderas(); break;
            case 6: list = SchedulesStatics.getStaticScheduleLasBailas(); break;
            default:
        }
        currentItem = list.get(list_position);


        // Create the text view for the title
        TextView textView = (TextView) findViewById(R.id.detail_title);
        int entero = list.get(list_position).getTitle();
        String resource = getResources().getString(entero);
        textView.setText(resource);

        // Create the text view for the time
        textView = (TextView) findViewById(R.id.detail_time);
        textView.setText(list.get(list_position).getTime());

        // Create the text view for the place
        textView = (TextView) findViewById(R.id.detail_place);
        textView.setText(list.get(list_position).getPlace());

        // Create the text view for the description
        textView = (TextView) findViewById(R.id.detail_information);
        entero = list.get(list_position).getInformation();
        resource = getResources().getString(entero);
        textView.setText(resource);

        // Set the button action
        Button button = (Button) findViewById(R.id.detail_place);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap(getCurrentItem().getMapLocation());
            }
        });

        //More Toolbar configuration
        toolbar.setSubtitle(list.get(0).getTitle());
        toolbar.setTitle(R.string.app_name);

        //---------------Toolbar keep color
        switch (pager_position){
            case 0:
                setToolbarMode(DetailsActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.dark_green_toolbar));
                break;
            case 1:
                setToolbarMode(DetailsActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.orange_toolbar));
                break;
            case 2:
                setToolbarMode(DetailsActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.green_toolbar));
                break;
            case 3:
                setToolbarMode(DetailsActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.black_toolbar));
                break;
            case 4:
                setToolbarMode(DetailsActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.wine_toolbar));
                break;
            case 5:
                setToolbarMode(DetailsActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.yellow_toolbar));
                break;
            case 6:
                setToolbarMode(DetailsActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.blue_toolbar));
                break;
            default:
        }

        //Analytics
        Tracker tracker = com.albaitdevs.programasanjuan.albait.AlbaitApplication.getTracker();
        if (tracker!=null) {
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory("Activities")
                    .setAction("onCreate_DetailsActivity_dia")
                    .setLabel(getResources().getString(list.get(0).getTitle()))
                    .build());
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory("Activities")
                    .setAction("onCreate_DetailsActivity_evento")
                    .setLabel(getResources().getString(list.get(list_position).getTitle()))
                    .build());
        }

    }

    private void openShare() {
        Tracker tracker = com.albaitdevs.programasanjuan.albait.AlbaitApplication.getTracker();
        tracker .send(new HitBuilders.EventBuilder()
                .setCategory("Buttons")
                .setAction("Share App")
                .setLabel("Share App")
                .build());

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.text_share_app));
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.word_share)));
    }

    //Click en sugerencias
    private void openFeedback() {
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        intent.putExtra("pager_position", getPagerPosition());
        startActivity(intent);
    }

    //Open map pointing to the place
    private void openMap(String mapUri){

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        //Check Google Play Services
        if (status==ConnectionResult.SUCCESS && pager_position!=0) {
            //If Google Play is installed, load map
            Intent intent = new Intent(getApplicationContext(), MyMapActivity.class);
            intent.putExtra("com.albaitdevs.programasanjuan.pagerPosition",pager_position);
            intent.putExtra("com.albaitdevs.programasanjuan.listPosition",list_position);
            startActivity(intent);

        } else {

            if (pager_position!=0){

                //Show toast
                CharSequence text = getResources().getString(R.string.google_play_services_not_installed);
                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
            }

            //Start external activity with the map
            Uri intentUri = Uri.parse(mapUri);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, intentUri);
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
    }
}
