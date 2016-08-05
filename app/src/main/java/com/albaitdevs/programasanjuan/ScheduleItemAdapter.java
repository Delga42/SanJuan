package com.albaitdevs.programasanjuan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Delga on 22/04/2015.
 */
public class ScheduleItemAdapter extends ArrayAdapter<Schedule> {
    public ScheduleItemAdapter(Context context, ArrayList<Schedule> schedules) {
        super(context, 0, schedules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Schedule schedule = getItem(position);

        TextView event_time;
        TextView event_desc;

        if (schedule.isSpecial()){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bus_schedule_special, parent, false);
            event_desc = (TextView) convertView.findViewById(R.id.event_desc);
            int entero = schedule.getTitle();
            String resource = getContext().getResources().getString(entero);
            event_desc.setText(resource);
            convertView.setOnClickListener(null);

        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bus_schedule, parent, false);
            event_time = (TextView) convertView.findViewById(R.id.event_time);
            event_desc = (TextView) convertView.findViewById(R.id.event_desc);
            int entero = schedule.getTitle();
            String resource = getContext().getResources().getString(entero);
            event_desc.setText(resource);
            event_time.setText(schedule.getTime());
        }

        // Return the completed view to render on screen
        return convertView;

    }
}