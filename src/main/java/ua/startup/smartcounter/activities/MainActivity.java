package ua.startup.smartcounter.activities;

import android.app.Activity;
import android.os.Bundle;
import ua.startup.smartcounter.R;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
