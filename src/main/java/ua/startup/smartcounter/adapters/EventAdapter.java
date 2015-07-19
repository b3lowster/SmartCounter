package ua.startup.smartcounter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ua.startup.smartcounter.R;
import ua.startup.smartcounter.entities.Event;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, List<Event> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Event event = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_adapter, parent, false);
        }

        // Lookup view for data population
        TextView activityName = (TextView) convertView.findViewById(R.id.activity_name);
        TextView activityNumber = (TextView) convertView.findViewById(R.id.activity_number);
        // Populate the data into the template view using the data object
        activityName.setText(event.getName());
        activityNumber.setText(String.valueOf(event.getDateEvents() == null ? 0 : event.getDateEvents().size()));

        // Return the completed view to render on screen
        return convertView;
    }
}
