package com.albaitdevs.programasanjuan;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.albaitdevs.programasanjuan.utils.DeviceInfo;
import com.albaitdevs.programasanjuan.utils.Time;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    private String portraitConfig = "";
    private String landscapeConfig = "";

    private TabLayout tabLayout;
    private int page = 0;
    static private boolean showLandingPage = true;

    static public void setShowLandingPage(boolean value) {
        showLandingPage = value;
    }

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create view
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.app_name);
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

        //Create View Pager
        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        FragmentPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(),getApplicationContext());
        vpPager.setAdapter(adapterViewPager);
//        vpPager.setOffscreenPageLimit(6);

        //NEW TAB LAYOUT
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vpPager);
        tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.alpha_white));
        tabLayout.setTabsFromPagerAdapter(adapterViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);


        //Set Listener
        vpPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Tracker tracker = com.albaitdevs.programasanjuan.albait.AlbaitApplication.getTracker();
                if (tracker!=null) {
                    tracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Activities")
                            .setAction("View_Pager_Page")
                            .setLabel(tab.getText().toString())
                            .build());
                }

                Button button = (Button) findViewById(R.id.button_goto_landing);
                toolbar.getMenu().clear();
                page = tab.getPosition();
                switch (page){
                    case 0:
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.dark_green_toolbar));
                        toolbar.inflateMenu(R.menu.main_activity_actions_white);
                        button.setBackgroundResource(R.drawable.round_button_dark_green);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.dark_green_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_white));
                        break;
                    case 1:
                        toolbar.setTitleTextColor(Color.BLACK);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.orange_toolbar));
                        toolbar.inflateMenu(R.menu.main_activity_actions);
                        button.setBackgroundResource(R.drawable.round_button_orange);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.orange_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_black));
                        break;
                    case 2:
                        toolbar.setTitleTextColor(Color.BLACK);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.green_toolbar));
                        toolbar.inflateMenu(R.menu.main_activity_actions);
                        button.setBackgroundResource(R.drawable.round_button_green);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.green_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_black));
                        break;
                    case 3:
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.black_toolbar));
                        toolbar.inflateMenu(R.menu.main_activity_actions_white);
                        button.setBackgroundResource(R.drawable.round_button_black);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.black_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_white));
                        break;
                    case 4:
                        toolbar.inflateMenu(R.menu.main_activity_actions_white);
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.wine_toolbar));
                        button.setBackgroundResource(R.drawable.round_button_wine);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.wine_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_white));
                        break;
                    case 5:
                        toolbar.inflateMenu(R.menu.main_activity_actions);
                        toolbar.setTitleTextColor(Color.BLACK);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.yellow_toolbar));
                        button.setBackgroundResource(R.drawable.round_button_yellow);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.yellow_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_black));
                        break;
                    case 6:
                        toolbar.inflateMenu(R.menu.main_activity_actions_white);
                        toolbar.setTitleTextColor(Color.WHITE);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.blue_toolbar));
                        button.setBackgroundResource(R.drawable.round_button_blue);
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.blue_pager));
                        button.setTextColor(getResources().getColor(R.color.pure_white));
                        break;
                    default:
                }
                if (vpPager.getCurrentItem()!=page){
                    vpPager.setCurrentItem(page);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Long time = Time.getTime();
        Button landingButton = (Button) findViewById(R.id.button_goto_landing);
        if (Time.areWeOnPartiesNow()) {
            //Si estamos en fiestas, mostramos otra info diferente
            landingButton.setText("00");
        } else {
            landingButton.setText(Time.getRemainingDays().toString());
        }

        //Default color
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.dark_green_toolbar));
        toolbar.inflateMenu(R.menu.main_activity_actions_white);
        landingButton.setBackgroundResource(R.drawable.round_button_dark_green);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.dark_green_pager));
        landingButton.setTextColor(getResources().getColor(R.color.pure_white));

        // Open Landing Page
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && showLandingPage && !Time.areWeOnPartiesNow()){
            if (Time.areWeOnPartiesNow()) {
                //Si estamos en fiestas no mostrar nada
            } else {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }
        }

    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus){
    super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            //Set each value for its orientation
            float myTabLayoutSize = 700;
            if (DeviceInfo.getWidthDP(this) >= myTabLayoutSize ){
//              The tabLayout fits
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    if (portraitConfig.equals("")) {
                        portraitConfig = "FIXED";
                    }
                } else {
                    if (landscapeConfig.equals("")) {
                        landscapeConfig = "FIXED";
                    }
                }
            } else {
                // The tablayout does not fit
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    if (portraitConfig.equals("")) {
                        portraitConfig = "SCROLLABLE";
                    }
                } else {
                    if (landscapeConfig.equals("")) {
                        landscapeConfig = "SCROLLABLE";
                    }
                }
            }
        }
        onResume();
    }

    @Override
    public void onResume(){
        super.onResume();

        //Paint coherently for each orientation
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            if (portraitConfig.equals("FIXED")){
                tabLayout.setTabMode(TabLayout.MODE_FIXED);
            } else {
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        } else {
            if (landscapeConfig.equals("FIXED")){
                tabLayout.setTabMode(TabLayout.MODE_FIXED);
            } else {
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        }
    }

    @Override
    public void onBackPressed() {
        MainActivity.setShowLandingPage(true);
        finish();
    }

    public void openLandingPage(View v){
        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);
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
        Intent share_intent = Intent.createChooser(intent, getResources().getString(R.string.word_share));
        startActivity(share_intent);
    }

    //Click en sugerencias
    private void openFeedback() {
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        intent.putExtra("pager_position", page);
        startActivity(intent);
    }

    //THIS IS FOR The viewpager ADAPTER
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 7;
        private Context context;

        public MyPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager);
            this.context = context;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment_pager to display for that page
        @Override
        public Fragment getItem(int position) {
            return PagerFragment.newInstance(position);
        }

        @Override
        public String getPageTitle(int tab){
            switch (tab){
                case 0: return context.getResources().getString(R.string.lacompra);
                case 1: return context.getResources().getString(R.string.miercoles);
                case 2: return context.getResources().getString(R.string.jueves);
                case 3: return context.getResources().getString(R.string.viernes);
                case 4: return context.getResources().getString(R.string.sabado);
                case 5: return context.getResources().getString(R.string.domingo);
                case 6: return context.getResources().getString(R.string.lunes);
            }
            return "";
        }

    }



}