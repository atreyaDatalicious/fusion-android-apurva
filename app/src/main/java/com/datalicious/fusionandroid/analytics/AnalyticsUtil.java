package com.datalicious.fusionandroid.analytics;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by datalicious on 07/06/18.
 */

public class AnalyticsUtil {

    private FirebaseAnalytics firebaseAnalytics;

    private static AnalyticsUtil singleton;

    public static AnalyticsUtil getInstance() {
        if (singleton == null) {
            singleton = new AnalyticsUtil();
        }
        return singleton;
    }

    public void pushScreenView(Activity activity, String screenName) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity.getApplicationContext());

        firebaseAnalytics.setUserId("12345");

        // Firebase screenView
        firebaseAnalytics.setCurrentScreen(activity, screenName, "Test");

        // GTM screenView
        Bundle bundle = new Bundle();
        bundle.putString("screen_name", screenName);
        firebaseAnalytics.logEvent("generic_screen_view", bundle);
    }

    public void pushEventTest() {
        // Firebase + GTM event
        Bundle bundle1 = new Bundle();
        bundle1.putString("event_category", "Test");
        bundle1.putString("event_action", "tap");
        bundle1.putString("event_label", "dummy_tap");
        firebaseAnalytics.logEvent("generic_event", bundle1);
    }
}
