package ua.startup.smartcounter.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.joda.time.DateTime;
import ua.startup.smartcounter.R;
import ua.startup.smartcounter.adapters.EventAdapter;
import ua.startup.smartcounter.entities.ActivityEvent;
import ua.startup.smartcounter.entities.DateEvent;
import ua.startup.smartcounter.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView listView;
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        listView = (ListView) findViewById(R.id.actions);

        List<ActivityEvent> activityEvents = getActivityEvents();

        final EventAdapter adapter = new EventAdapter(this, activityEvents);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        final Button btnAddAction = (Button) findViewById(R.id.add_action_button);
        btnAddAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setTitle(R.string.action_name_field);

                Button saveButton = (Button) dialog.findViewById(R.id.save_button);
                saveButton.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        EditText textField = (EditText) dialog.findViewById(R.id.action_field);
                        Event event = new Event(textField.getText().toString(), DateTime.now());
                        event.save();
                        ActivityEvent activityEvent = new ActivityEvent(event, new ArrayList<DateEvent>());

                        adapter.add(activityEvent);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                Button cancelButton = (Button) dialog.findViewById(R.id.cancel_button);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private List<ActivityEvent> getActivityEvents() {
        List<Event> events = Event.listAll(Event.class);
        if (events == null || events.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<ActivityEvent> activityEvents = new ArrayList<>();
            for (Event event : events) {
                ActivityEvent activityEvent = new ActivityEvent(event, DateEvent.find(DateEvent.class, "EVENT_NAME = ?", event.getEventName()));
                activityEvents.add(activityEvent);
            }
            return activityEvents;
        }
    }
}
