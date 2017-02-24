package com.merkey.dracula;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

/*
 * This will be used for settings throught the app. There is a way to maintain settings, check it out.
 * They have to be loaded if they already exist, default values if they don't.
 *
 * Setting #1: Request Timeout
 * ie how long do we wait between checks for whether or not we have to start the app and do the wifi-direct stuff?
 *
 * Setting #2: Registered Data
 * to change name, email, and phone #. Do not show the secret thing. You can request the data from
 * the backend.
 *
 */
public class SettingsActivity extends AppCompatActivity {

    Manager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        manager = Manager.getInstance();
        SeekBar mSeekBar;
        SharedPreferences pre = getSharedPreferences("pre_name", Context.MODE_PRIVATE);
        pre.edit().putInt("KEY_PROGRESS_VALUE", 3).commit();
        int progress = pre.getInt("KEY_PROGRESS_VALUE",0); // 0: default value
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mSeekBar.setProgress(progress);




    }
}
