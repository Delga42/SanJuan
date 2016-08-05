package com.albaitdevs.programasanjuan;

/**
 * Created by Delga on 27/04/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PagerFragment extends ListFragment {
    private int page;
    private ScheduleItemAdapter adapter;

    // newInstance constructor for creating fragment_pager with arguments
    public static PagerFragment newInstance(int page) {
        PagerFragment fragmentFirst = new PagerFragment();

        fragmentFirst.page = page;

        //Save values and do not lose them on Destroy activity
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        fragmentFirst.setArguments(args);

        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set adapter and list
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        adapter = new ScheduleItemAdapter(getActivity().getApplicationContext(), scheduleList);
        setListAdapter(adapter);

        //Load list and populate
        page = getArguments().getInt("someInt");
        switch (page){
            case 0: scheduleList = SchedulesStatics.getStaticScheduleLaCompra(); break;
            case 1: scheduleList = SchedulesStatics.getStaticScheduleElPregon(); break;
            case 2: scheduleList = SchedulesStatics.getStaticScheduleLaSaca(); break;
            case 3: scheduleList = SchedulesStatics.getStaticScheduleLosToros(); break;
            case 4: scheduleList = SchedulesStatics.getStaticScheduleLosAges(); break;
            case 5: scheduleList = SchedulesStatics.getStaticScheduleLasCalderas(); break;
            case 6: scheduleList = SchedulesStatics.getStaticScheduleLasBailas(); break;
            default:
        }

        //Populate adapter
        for (Schedule schedule : scheduleList){
            adapter.add(schedule);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment_pager
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id){
        ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vpPager);

        //If the item is not special, open detail
        if (!adapter.getItem(position).isSpecial()) {
            Intent intent = new Intent(getActivity().getApplicationContext(), DetailsActivity.class);
            intent.putExtra("list_position", position);
            intent.putExtra("pager_position", vp.getCurrentItem());
            startActivity(intent);
        }

    }

}