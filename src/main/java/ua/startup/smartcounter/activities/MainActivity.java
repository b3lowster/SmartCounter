package ua.startup.smartcounter.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import ua.startup.smartcounter.R;
import ua.startup.smartcounter.entities.Event;
import android.view.ViewGroup.LayoutParams;

import java.util.List;

public class MainActivity extends Activity {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        listView = (ListView) findViewById(R.id.actions);

        List<Event> events = Event.listAll(Event.class);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getArrayEventsForListView(events));

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        final Button btnAddAction = (Button)findViewById(R.id.add_action_button);
        btnAddAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.popup_layout, null);

                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);

                Button saveButton = (Button)popupView.findViewById(R.id.save_button);
                saveButton.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        EditText textField = (EditText)popupView.findViewById(R.id.action_field);
                        Event event = new Event(textField.getText().toString());
                        event.save();

                        adapter.add(textField.getText().toString());
                        adapter.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }});

                Button cancelButton = (Button)popupView.findViewById(R.id.cancel_button);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private String[] getArrayEventsForListView(List<Event> events) {
        String[] array = new String[events.size()];

        for (int i = 0; i < events.size(); i++) {
            array[i] = events.get(i).getName();
        }

        return array;
    }

}
