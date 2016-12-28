package com.merkey.dracula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * This activity is the launcher activity of the app. It tests if the device is registered, and allows
 * it to register if it's not.
 * On launch this activity tries to connect to the server, displaying an error message if a connection
 * could not be established. If a connection exists, it contacts the server using a device specific data (DSD)
 * which is unique to every device to see if it has been registered with the system. All the while
 * there should be a spinner that shows that the app has not crashed and is merely working.
 * If the DSD is not registered, then this page loads and allows the user to register with the fields
 * name, email, and phone number. Registration is then done on the server.
 * After that, the activity goes to MainActivity and is deleted from history (ie back button should
 * exit not take you back to register).
 */
public class RegisterActivity extends AppCompatActivity {
    //TODO(ghazi): figure out what that device specific data is, and make sure it is unique to every
    // device + hard to find w/o access to it
    Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        manager = Manager.getInstance();
        //TODO(ghazi): The spinner must show what we are doing, so Step 1/3: Checking Connectoin
        // step 2/3: Checking Device, step 3/3: Setting Up. 3/3
        //TODO(ghazi): connect to backend server. Pass empty string to URLData
        //if successful redirect, otherwise

        //TODO(ghazi): Fill mClickListener then uncomment below.
        //findViewById(R.id.whatever).setOnClickListener(mClickListener);

    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO(ghazi): logic for when the button is pressed.
            // make sure all data is filled, email and phone number are valid.
            // then send to manager.BACKEND_REGISTER url.
            // If everything is successful, redirect. if not successful print the error message.
            // check backed documentation for this.
        }
    };

}
