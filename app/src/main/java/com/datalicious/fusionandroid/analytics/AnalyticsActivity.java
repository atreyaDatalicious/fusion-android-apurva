package com.datalicious.fusionandroid.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.datalicious.fusionandroid.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class AnalyticsActivity extends AppCompatActivity implements View.OnClickListener {

    Button BtnSV1, BtnSV2, BtnSV3, BtnSV4, BtnSV5,
            BtnSV6, BtnSV7, BtnSV8, BtnSV9, BtnSV10;
    Button Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7,
            Btn8, Btn9, Btn10, Btn11, Btn12;

    Button BtnEV1, BtnEV2, BtnEV3, BtnEV4, BtnEV5;

    ArrayList<Bundle> productList;

    ArrayList<String> loginType = new ArrayList<>(Arrays.asList("phone_number", "email", "google+", "facebook"));
    ArrayList<String> login_status = new ArrayList<>(Arrays.asList("success", "fail"));
    ArrayList<String> languages = new ArrayList<>(Arrays.asList("english", "hindi", "spanish", "chinese", "french"));
    ArrayList<String> orderStatus = new ArrayList<>(Arrays.asList("pending_confirmation", "confirmed"));
    private Random randomGenerator;

    int productIndex=0;
    int loginTypeindex=0;
    int loginStatusIndex=0;
    int orderStatusIndex=0;
    int languageIndex=0;
    int clickPos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        initViews();
        initData();
        getProducts();

    }

    private void initData() {
        randomGenerator = new Random();
        productList = new ArrayList<>();
    }

    private void getProducts() {

        //product 1
        Bundle product1 = new Bundle();
        product1.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1234"); // ITEM_ID or ITEM_NAME is required
        product1.putString(FirebaseAnalytics.Param.ITEM_NAME, "Donut Friday Scented T-Shirt");
        product1.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product1.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "Blue");
        product1.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product1.putDouble(FirebaseAnalytics.Param.PRICE, 29.99);
        product1.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product1.putLong(FirebaseAnalytics.Param.QUANTITY, 1);

        productList.add(product1);

        //product 2

        Bundle product2 = new Bundle();
        product2.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1235"); // ITEM_ID or ITEM_NAME is required
        product2.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product2.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product2.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "white");
        product2.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product2.putDouble(FirebaseAnalytics.Param.PRICE, 20.09);
        product2.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product2.putLong(FirebaseAnalytics.Param.QUANTITY, 3);

        productList.add(product2);

        //product 3

        Bundle product3 = new Bundle();
        product3.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1236"); // ITEM_ID or ITEM_NAME is required
        product3.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product3.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product3.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "white");
        product3.putString(FirebaseAnalytics.Param.ITEM_BRAND, "datalicious");
        product3.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
        product3.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product3.putLong(FirebaseAnalytics.Param.QUANTITY, 2);

        productList.add(product3);

        //product 4

        Bundle product4 = new Bundle();
        product4.putString(FirebaseAnalytics.Param.ITEM_ID, "sku12387"); // ITEM_ID or ITEM_NAME is required
        product4.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product4.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product4.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "black");
        product4.putString(FirebaseAnalytics.Param.ITEM_BRAND, "fb");
        product4.putDouble(FirebaseAnalytics.Param.PRICE, 50.99);
        product4.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product4.putLong(FirebaseAnalytics.Param.QUANTITY, 1);

        productList.add(product4);


        //product 5

        Bundle product5 = new Bundle();
        product5.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1238"); // ITEM_ID or ITEM_NAME is required
        product5.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product5.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product5.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "blue");
        product5.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product5.putDouble(FirebaseAnalytics.Param.PRICE, 50.99);
        product5.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product5.putLong(FirebaseAnalytics.Param.QUANTITY, 5);

        productList.add(product5);


        //product 6
        Bundle product6 = new Bundle();
        product6.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1239"); // ITEM_ID or ITEM_NAME is required
        product6.putString(FirebaseAnalytics.Param.ITEM_NAME, "Donut Friday Scented T-Shirt");
        product6.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product6.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "Blue");
        product6.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product6.putDouble(FirebaseAnalytics.Param.PRICE, 29.99);
        product6.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product6.putLong(FirebaseAnalytics.Param.QUANTITY, 1);

        productList.add(product6);

        //product 7

        Bundle product7 = new Bundle();
        product7.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1241"); // ITEM_ID or ITEM_NAME is required
        product7.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product7.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Women/Shirts");
        product7.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "red");
        product7.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product7.putDouble(FirebaseAnalytics.Param.PRICE, 20.09);
        product7.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product7.putLong(FirebaseAnalytics.Param.QUANTITY, 3);

        productList.add(product7);

        //product 8

        Bundle product8 = new Bundle();
        product8.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1226"); // ITEM_ID or ITEM_NAME is required
        product8.putString(FirebaseAnalytics.Param.ITEM_NAME, "Batman T-Shirt");
        product8.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Women/Shirts");
        product8.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "gray");
        product8.putString(FirebaseAnalytics.Param.ITEM_BRAND, "datalicious");
        product8.putDouble(FirebaseAnalytics.Param.PRICE, 10.00);
        product8.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product8.putLong(FirebaseAnalytics.Param.QUANTITY, 2);

        productList.add(product8);

        //product 9

        Bundle product9 = new Bundle();
        product9.putString(FirebaseAnalytics.Param.ITEM_ID, "sku12357"); // ITEM_ID or ITEM_NAME is required
        product9.putString(FirebaseAnalytics.Param.ITEM_NAME, " T-Shirt");
        product9.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Women/Shirts");
        product9.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "yellow");
        product9.putString(FirebaseAnalytics.Param.ITEM_BRAND, "fb");
        product9.putDouble(FirebaseAnalytics.Param.PRICE, 45.99);
        product9.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product9.putLong(FirebaseAnalytics.Param.QUANTITY, 1);

        productList.add(product9);


        //product 10

        Bundle product10 = new Bundle();
        product10.putString(FirebaseAnalytics.Param.ITEM_ID, "sku1298"); // ITEM_ID or ITEM_NAME is required
        product10.putString(FirebaseAnalytics.Param.ITEM_NAME, "apple T-Shirt");
        product10.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Apparel/Women/Shirts");
        product10.putString(FirebaseAnalytics.Param.ITEM_VARIANT, "orange");
        product10.putString(FirebaseAnalytics.Param.ITEM_BRAND, "Google");
        product10.putDouble(FirebaseAnalytics.Param.PRICE, 5.99);
        product10.putString(FirebaseAnalytics.Param.CURRENCY, "USD"); // Item-level currency unused today
        product10.putLong(FirebaseAnalytics.Param.QUANTITY, 5);

        productList.add(product10);


    }

    private void initViews() {

        BtnSV1 = (Button) findViewById(R.id.BtnSV1);
        BtnSV2 = (Button) findViewById(R.id.BtnSV2);
        BtnSV3 = (Button) findViewById(R.id.BtnSV3);
        BtnSV4 = (Button) findViewById(R.id.BtnSV4);
        BtnSV5 = (Button) findViewById(R.id.BtnSV5);
        BtnSV6 = (Button) findViewById(R.id.BtnSV6);
        BtnSV7 = (Button) findViewById(R.id.BtnSV7);
        BtnSV8 = (Button) findViewById(R.id.BtnSV8);
        BtnSV9 = (Button) findViewById(R.id.BtnSV9);
        BtnSV10 = (Button) findViewById(R.id.BtnSV10);

        BtnSV1.setOnClickListener(this);
        BtnSV2.setOnClickListener(this);
        BtnSV3.setOnClickListener(this);
        BtnSV4.setOnClickListener(this);
        BtnSV5.setOnClickListener(this);
        BtnSV6.setOnClickListener(this);
        BtnSV7.setOnClickListener(this);
        BtnSV8.setOnClickListener(this);
        BtnSV9.setOnClickListener(this);
        BtnSV10.setOnClickListener(this);

        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn3 = (Button) findViewById(R.id.Btn3);
        Btn4 = (Button) findViewById(R.id.Btn4);
        Btn5 = (Button) findViewById(R.id.Btn5);
        Btn6 = (Button) findViewById(R.id.Btn6);
        Btn7 = (Button) findViewById(R.id.Btn7);
        Btn8 = (Button) findViewById(R.id.Btn8);
        Btn9 = (Button) findViewById(R.id.Btn9);
        Btn10 = (Button) findViewById(R.id.Btn10);
        Btn11 = (Button) findViewById(R.id.Btn11);
        Btn12 = (Button) findViewById(R.id.Btn12);

        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        Btn6.setOnClickListener(this);
        Btn7.setOnClickListener(this);
        Btn8.setOnClickListener(this);
        Btn9.setOnClickListener(this);
        Btn10.setOnClickListener(this);
        Btn11.setOnClickListener(this);
        Btn12.setOnClickListener(this);

        BtnEV1 = (Button) findViewById(R.id.BtnEV1);
        BtnEV2 = (Button) findViewById(R.id.BtnEV2);
        BtnEV3 = (Button) findViewById(R.id.BtnEV3);
        BtnEV4 = (Button) findViewById(R.id.BtnEV4);
        BtnEV5 = (Button) findViewById(R.id.BtnEV5);

        BtnEV1.setOnClickListener(this);
        BtnEV2.setOnClickListener(this);
        BtnEV3.setOnClickListener(this);
        BtnEV4.setOnClickListener(this);
        BtnEV5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        productIndex = randomGenerator.nextInt(productList.size()-1);
        loginTypeindex = randomGenerator.nextInt(loginType.size())-1;
        loginStatusIndex = randomGenerator.nextInt(login_status.size()-1);
        orderStatusIndex = randomGenerator.nextInt(orderStatus.size())-1;
        languageIndex = randomGenerator.nextInt(languages.size()-1);

        HashMap<String, String> map = new HashMap<>();

        switch (v.getId()) {

            //Screenview triggers
            case R.id.BtnSV1:
                AnalyticsUtil.getInstance().pushScreenView(this, "SplashScreen");
                break;
            case R.id.BtnSV2:
                AnalyticsUtil.getInstance().pushScreenView(this, "HomeScreen");
                break;
            case R.id.BtnSV3:
                AnalyticsUtil.getInstance().pushScreenView(this, "LoginScreen");
                break;
            case R.id.BtnSV4:
                AnalyticsUtil.getInstance().pushScreenView(this, "CategoryScreen");
                break;
            case R.id.BtnSV5:
                AnalyticsUtil.getInstance().pushScreenView(this, "ProductDetailScreen");
                break;
            case R.id.BtnSV6:
                AnalyticsUtil.getInstance().pushScreenView(this, "AddToCartScreen");
                break;
            case R.id.BtnSV7:
                AnalyticsUtil.getInstance().pushScreenView(this, "CheckoutScreen");
                break;
            case R.id.BtnSV8:
                AnalyticsUtil.getInstance().pushScreenView(this, "OrderConfirmationScreen");
                break;
            case R.id.BtnSV9:
                AnalyticsUtil.getInstance().pushScreenView(this, "OrderHistoryScreen");
                break;
            case R.id.BtnSV10:
                AnalyticsUtil.getInstance().pushScreenView(this, "SettingsScreen");
                break;


            //Custom Events triggers
            case R.id.BtnEV1:
                map.put("login_type",loginType.get(productIndex));
                map.put("login_status",login_status.get(loginStatusIndex) );
                AnalyticsUtil.getInstance().pushEvent(this, "Login", map);
                break;
            case R.id.BtnEV2:
                map.put("login_type",loginType.get(productIndex));
                map.put("login_status",login_status.get(loginStatusIndex) );
                AnalyticsUtil.getInstance().pushEvent(this, "Register", map);
                break;
            case R.id.BtnEV3:
                Bundle xyz=productList.get(productIndex);
                map.put("product_id",xyz.get(FirebaseAnalytics.Param.ITEM_ID.toString()).toString());
                map.put("product_name",xyz.get(FirebaseAnalytics.Param.ITEM_NAME.toString()).toString() );
                map.put("revenue",xyz.get(FirebaseAnalytics.Param.PRICE.toString()).toString() );
                map.put("order_status",orderStatus.get(orderStatusIndex));
                map.put("in_transit","yes");
                map.put("delivered",orderStatus.get(orderStatusIndex) );
                map.put("delivery_failed",login_status.get(loginStatusIndex) );
                AnalyticsUtil.getInstance().pushEvent(this, "TrackOrder", map);
                break;
            case R.id.BtnEV4:
                map.put("selected_language",languages.get(languageIndex));
                AnalyticsUtil.getInstance().pushEvent(this, "LanguageChange", map);
                break;
            case R.id.BtnEV5:
                Bundle xyzz=productList.get(productIndex);
                map.put("product_id",xyzz.get(FirebaseAnalytics.Param.ITEM_ID.toString()).toString());
                map.put("product_name",xyzz.get(FirebaseAnalytics.Param.ITEM_NAME.toString()).toString());
                AnalyticsUtil.getInstance().pushEvent(this, "Favourite", map);
                break;

            //E COM Events triggers
            case R.id.Btn1:
                for (int i=0;i<8;i++)
                {
                    final int min = 0;
                    final int max = productList.size()-1;
                    final int random = new Random().nextInt((max - min) + 1) + min;
                    AnalyticsUtil.getInstance().pushEcomEvent(this, "Impressions", productList.get(random));

                }
                break;
            case R.id.Btn2:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "Click", productList.get(productIndex));
                clickPos=productIndex;
                break;
            case R.id.Btn3:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "Detail", productList.get(clickPos));
                break;
            case R.id.Btn4:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "AddToCart", productList.get(clickPos));
                break;
            case R.id.Btn5:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "CheckoutStep1", productList.get(clickPos));
                break;
            case R.id.Btn6:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "CheckoutStep2", productList.get(clickPos));
                break;
            case R.id.Btn7:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "CheckoutStep3", productList.get(clickPos));
                break;
            case R.id.Btn8:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "Purchase", productList.get(clickPos));
                break;
            case R.id.Btn9:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "Refund", productList.get(clickPos));
                break;
            case R.id.Btn10:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "RemoveFromCart", productList.get(clickPos));
                break;
            case R.id.Btn11:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "PromotionImpressions", productList.get(clickPos));
                break;
            case R.id.Btn12:
                AnalyticsUtil.getInstance().pushEcomEvent(this, "PromotionClick", productList.get(clickPos));
                break;
        }
    }
}
