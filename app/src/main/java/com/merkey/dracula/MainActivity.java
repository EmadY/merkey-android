package com.merkey.dracula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
 * Most important activity. It is important that timers do not interfere with each other.
 * For example, if we have a timer that is doing something, and we go to settings and come back
 * the first timer is not deleted, we need to make sure to not start a new one (and have two for the
 * same thing). Similiarity if it got deleted cz we waited in settings too long, we need to make
 * a new one when we come back.
 *
 * Most of the logic is done in the APController class, this is just for managing timers and controlling
 * APController.
 *
 * Has a button that allows to "request delivery" ie send teh drone to me I want to deliver something.
 * If backed is busy, request refuses.
 *
 * There should be a chcek on every backend request taht the internet is working, if we fail the
 * request for internet issues, we should stop everything, print an error message, and try to reconnect.
 * When reconnected, restart all timers, etc.
 *
 * Timer for checking if we are started or not yet. ie asks backed whether we should start APController
 * This timer uses the above timeout. If started, same timer will be used to check if we should stop.
 *
 * When drone is moving, should display index or infinity if not determined yet.
 */
public class MainActivity extends AppCompatActivity {

    private Manager manager;
    private APController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = Manager.getInstance();
        controller = APController.getInstance();
    }
}
