/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.datalicious.fusionandroid.view.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.datalicious.fusionandroid.R;
import com.datalicious.fusionandroid.analytics.AnalyticsActivity;
import com.datalicious.fusionandroid.analytics.AnalyticsUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

import java.util.HashMap;


public class SplashActivity extends FragmentActivity {

    private Animation animation;
    private ImageView logo;
    private TextView appTitle;
    private TextView appSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        Log.d("Apurva DL", "action: " + action);
        if (data != null) {
            Log.d("Apurva DL", "data: " + data.toString());
        }

        logo = (ImageView) findViewById(R.id.logo_img);
        appTitle = (TextView) findViewById(R.id.track_txt);
        appSlogan = (TextView) findViewById(R.id.pro_txt);

        // Font path
        String fontPath = "font/CircleD_Font_by_CrazyForMusic.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        appTitle.setTypeface(tf);
        appSlogan.setTypeface(tf);

        if (savedInstanceState == null) {
            flyIn();
        }

        AnalyticsUtil.getInstance().pushUserId(this, "u12345id12345");
        AnalyticsUtil.getInstance().pushUserProperty(this, "custom_user_id", "u12345id12345");
//        sendAnalyticsData();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                endSplash();
            }
        }, 10000);
    }

    protected void sendAnalyticsData() {
        AnalyticsUtil.getInstance().pushUserId(this, "u12345id12345");
        AnalyticsUtil.getInstance().pushUserProperty(this, "custom_user_id", "u12345id12345");
        AnalyticsUtil.getInstance().pushScreenView(this, "Splash Screen");
        AnalyticsUtil.getInstance().pushEventTest(this);

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("login_type", "login_normal");
        map1.put("login_status", "success");
        AnalyticsUtil.getInstance().pushEvent(this, "login", map1);

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("product_name", "t_shirt");
        map2.put("product_id", "p12345");
        map2.put("product_price", "500");
        AnalyticsUtil.getInstance().pushEvent(this, "addToCart", map2);
    }

    private void flyIn() {
        animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,
                R.anim.app_name_animation);
        appTitle.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this, R.anim.pro_animation);
        appSlogan.startAnimation(animation);
    }

    private void endSplash() {
        animation = AnimationUtils.loadAnimation(this,
                R.anim.logo_animation_back);
        logo.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,
                R.anim.app_name_animation_back);
        appTitle.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,
                R.anim.pro_animation_back);
        appSlogan.startAnimation(animation);

        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {

                Intent intent = new Intent(getApplicationContext(),
                        AnalyticsActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            }
        });

    }

    public void createDynamicLink() {
        DynamicLink dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse("https://www.apurva.com/test/?dgid=abc&email=xyz"))  // link
                .setDynamicLinkDomain("apurva.page.link")   //
                .setAndroidParameters(
                        new DynamicLink.AndroidParameters.Builder("com.datalicious.fusionandroid")  // apn
                                .setMinimumVersion(1)     // amv
                                .build())
                .setIosParameters(
                        new DynamicLink.IosParameters.Builder("com.example.ios")    // ibi
                                .setAppStoreId("123456789")     // isi
                                .setMinimumVersion("1.0.1")     // imv
                                .build())
                .setGoogleAnalyticsParameters(
                        new DynamicLink.GoogleAnalyticsParameters.Builder()
                                .setSource("gaSource")      // utm_source
                                .setMedium("gaMedium")      // utm_medium
                                .setCampaign("gaCampaign")  // utm_campaign
                                .build())
                .setItunesConnectAnalyticsParameters(
                        new DynamicLink.ItunesConnectAnalyticsParameters.Builder()
                                .setProviderToken("123456")     // pt
                                .setCampaignToken("iosCampaignToken")   // ct
                                .build())
                .setSocialMetaTagParameters(
                        new DynamicLink.SocialMetaTagParameters.Builder()
                                .setTitle("socialTitle")    // st
                                .setDescription("socialDescription")    // sd
                                .build())
                .buildDynamicLink();

        Uri dynamicLinkUri = dynamicLink.getUri();

        Log.d("Apurva DL", "Initial: " + dynamicLinkUri.toString());

        Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse("https://www.apurva.com/test/?dgid=abc&email=xyz"))
                .setDynamicLinkDomain("apurva.page.link")
                .setAndroidParameters(
                        new DynamicLink.AndroidParameters.Builder("com.datalicious.fusionandroid")
                                .setMinimumVersion(1)
                                .build())
                .setIosParameters(
                        new DynamicLink.IosParameters.Builder("com.example.ios")
                                .setAppStoreId("123456789")
                                .setMinimumVersion("1.0.1")
                                .build())
                .setGoogleAnalyticsParameters(
                        new DynamicLink.GoogleAnalyticsParameters.Builder()
                                .setSource("gaSource")
                                .setMedium("gaMedium")
                                .setCampaign("gaCampaign")
                                .build())
                .setItunesConnectAnalyticsParameters(
                        new DynamicLink.ItunesConnectAnalyticsParameters.Builder()
                                .setProviderToken("123456")
                                .setCampaignToken("iosCampaignToken")
                                .build())
                .setSocialMetaTagParameters(
                        new DynamicLink.SocialMetaTagParameters.Builder()
                                .setTitle("socialTitle")
                                .setDescription("socialDescription")
                                .build())
                .buildShortDynamicLink(ShortDynamicLink.Suffix.SHORT)
                .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
                    @Override
                    public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                        if (task.isSuccessful()) {
                            // Short link created
                            Uri shortLink = task.getResult().getShortLink();
                            Uri flowchartLink = task.getResult().getPreviewLink();

                            Log.d("Apurva DL", "Short Link: " + shortLink);
                            Log.d("Apurva DL", "Flowchart Link: " + flowchartLink);
                        } else {
                            // Error
                            // ...
                            Log.d("Apurva DL", "error in task");
                        }
                    }
                });
    }
}
