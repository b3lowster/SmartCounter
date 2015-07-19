package ua.startup.smartcounter.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import ua.startup.smartcounter.R;
import ua.startup.smartcounter.adapters.EventAdapter;
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

        List<Event> events = Event.listAll(Event.class);

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, getArrayEventsForListView(events));

        final EventAdapter adapter = new EventAdapter(this, events);

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
                        Event event = new Event(textField.getText().toString());
                        event.save();

                        adapter.add(event);
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

    private List<String> getArrayEventsForListView(List<Event> events) {
        List<String> array = new ArrayList<>(events.size());

        for (Event event : events) {
            array.add(event.getName());
        }

        return array;
    }

}
