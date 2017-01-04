package com.merkey.dracula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/*
 * You get to this activity when certain conditions are met, for now just implement it.
 *
 * retrivies from backend the list of all available recepients (names + emails).
 *
 * There should be a textbox near the top where you can search for a particular user (also via
 * name or email). The list should then update and show only matching users.
 *
 * Clicking any of the users will lead to a request being sent to the backend to begin delivery to
 * that user.
 */
public class DeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
    }
}
