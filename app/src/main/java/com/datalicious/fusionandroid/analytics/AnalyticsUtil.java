package com.datalicious.fusionandroid.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;
import java.util.Map;

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

    public void pushUserId(Context context, String userId) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        firebaseAnalytics.setUserId(userId);
    }

    public void pushUserProperty(Context context, String key, String value) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        firebaseAnalytics.setUserProperty(key, value);
    }

    public void pushScreenView(Activity activity, String screenName) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity.getApplicationContext());

        // Firebase screenView
        firebaseAnalytics.setCurrentScreen(activity, screenName, "Test");

        // GTM screenView
        Bundle bundle = new Bundle();
        bundle.putString("screen_name", screenName);
        firebaseAnalytics.logEvent("generic_screen_view", bundle);
    }

    public void pushEvent(Context context, String eventName, HashMap<String, String> eventParams) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);

        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry :
                eventParams.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        firebaseAnalytics.logEvent(eventName, bundle);
    }

    public void pushEventTest(Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);

        // Firebase + GTM event
        Bundle bundle = new Bundle();
        bundle.putString("event_category", "Test");
        bundle.putString("event_action", "tap");
        bundle.putString("event_label", "dummy_tap");
        firebaseAnalytics.logEvent("generic_event", bundle);
    }

    public void pushEcomEvent(Context context,String name, Bundle item) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Bundle ecommerceBundle = new Bundle();

        ecommerceBundle.putBundle("items", item);

      // Log view_item event with ecommerce bundle

        firebaseAnalytics.logEvent(name, ecommerceBundle);
    }
}

