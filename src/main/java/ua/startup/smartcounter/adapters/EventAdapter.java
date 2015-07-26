package ua.startup.smartcounter.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import ua.startup.smartcounter.R;
import ua.startup.smartcounter.entities.ActivityEvent;
import ua.startup.smartcounter.entities.DateEvent;
import ua.startup.smartcounter.entities.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class EventAdapter extends ArrayAdapter<ActivityEvent> {

    public EventAdapter(Context context, List<ActivityEvent> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ActivityEvent activityEvent = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_adapter, parent, false);
        }

        Button increaseButton = (Button) convertView.findViewById(R.id.activity_increase);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<DateEvent> dateEvents = activityEvent.getEventsDates() == null ? new ArrayList<DateEvent>() : activityEvent.getEventsDates();
                DateEvent dateEvent = new DateEvent(activityEvent.getEvent().getId());
                dateEvents.add(dateEvent);
                activityEvent.setEventsDates(dateEvents);
                dateEvent.save();
                notifyDataSetChanged();
            }
        });

        // Lookup view for data population
        TextView activityName = (TextView) convertView.findViewById(R.id.activity_name);
        TextView activityNumber = (TextView) convertView.findViewById(R.id.activity_number);
        // Populate the data into the template view using the data object
        activityName.setText(activityEvent.getEvent().getEventName());
        activityNumber.setText(String.valueOf(activityEvent.getEventsDates() == null ? 0 : activityEvent.getEventsDates().size()));

        // Return the completed view to render on screen
        return convertView;
    }
}
