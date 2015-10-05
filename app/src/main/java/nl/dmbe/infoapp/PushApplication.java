package nl.dmbe.infoapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

/**
 * Created by Henk-Roel van Zijl on 3-10-2015.
 */
public class PushApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "GVZx8cIJMEtALRFk8lQYdvtdhLVQWit5WIQAbKI3", "7A1GZz184qxWKQXFcTN0C1GAFfRhnzXhfKqIvHTF");
        ParseInstallation.getCurrentInstallation().saveInBackground();


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
