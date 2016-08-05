package com.albaitdevs.programasanjuan;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class FeedbackActivity extends Activity {
    //Toolbar Modes
    public static int WHITE = 0;
    public static int BLACK = 1;

    Toolbar toolbar;

    public void setToolbarMode(int mode){
        if (mode == FeedbackActivity.BLACK){
            toolbar.inflateMenu(R.menu.feedback_activity_actions);
            toolbar.setTitleTextColor(Color.BLACK);
            toolbar.setSubtitleTextColor(Color.BLACK);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        } else {
            toolbar.inflateMenu(R.menu.feedback_activity_actions_white);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setSubtitleTextColor(Color.WHITE);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the text view as the activity layout
        setContentView(R.layout.activity_feedback);

        // Set up the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_feedback);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                switch (item.getItemId()) {
                    case R.id.action_share:
                        openShare();
                        return true;
                    case R.id.action_send:
                        sendMessage();
                        return true;
                    default:
                        return false;
                }
            }
        });
        toolbar.setTitle(R.string.app_name);
        toolbar.setSubtitle(R.string.feedback_title_toolbar);
        toolbar.setNavigationOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });

        // Get the message from the intent
        Intent intent = getIntent();
        int pager_position = intent.getIntExtra("pager_position", -1);

        //---------------Toolbar keep color
        switch (pager_position){
            case 0:
                setToolbarMode(FeedbackActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.dark_green_toolbar));
                break;
            case 1:
                setToolbarMode(FeedbackActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.orange_toolbar));
                break;
            case 2:
                setToolbarMode(FeedbackActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.green_toolbar));
                break;
            case 3:
                setToolbarMode(FeedbackActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.black_toolbar));
                break;
            case 4:
                setToolbarMode(FeedbackActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.wine_toolbar));
                break;
            case 5:
                setToolbarMode(FeedbackActivity.BLACK);
                toolbar.setBackgroundColor(getResources().getColor(R.color.yellow_toolbar));
                break;
            case 6:
                setToolbarMode(FeedbackActivity.WHITE);
                toolbar.setBackgroundColor(getResources().getColor(R.color.blue_toolbar));
                break;
            default:
        }

    }

    //+++++++++++++ MY MEHTODS

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

    private void sendMessage() {
        //Get message
        EditText editText = (EditText) findViewById(R.id.feedback_edittext);

        //Create intent
        Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
        intent.setType("message/rfc822");
        intent.setData(Uri.parse(getResources().getString(R.string.feedback_email)));
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.feedback_subject));
        intent.putExtra(Intent.EXTRA_TEXT, editText.getText());
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.word_feedback)));

    }

}
