package com.HishaTech.android.dayquote;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by smithkev on 1/27/2015.
 */
public class AboutActivity extends Activity {

    private TextView About_first;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Access various widgets in Application.
        About_first = (TextView) findViewById(R.id.About_first);

        // Combine appname and appversion for the label
        String appName = getString(R.string.app_name);
        String appVersion = getString(R.string.app_version);
        About_first.setText(appName + " v" + appVersion);

    }

}