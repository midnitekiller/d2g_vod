package com.direct2guests.d2g_tv.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
<<<<<<< HEAD
import android.content.DialogInterface;
import android.content.Intent;
=======
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.VolleyError;
import com.direct2guests.d2g_tv.NonActivity.NetworkConnection;
import com.direct2guests.d2g_tv.NonActivity.Variable;
import com.direct2guests.d2g_tv.NonActivity.VolleyCallback;
import com.direct2guests.d2g_tv.R;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


<<<<<<< HEAD
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.Random;
import java.util.concurrent.TimeUnit;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646

import static android.view.View.VISIBLE;


public class LauncherActivity extends LangSelectActivity {
    private NetworkConnection nc = new NetworkConnection();
    private Variable vdata;
    public final static String WATCHTV_FROM = "com.direct2guests.d2g_tv.WATCHTV_FROM";


    /* ========== Housekeeping Modal ========== */
<<<<<<< HEAD
    private Button HKToday, HKWhole, HKRequest;
=======
    private Button exitButton, extendButton, checkoutButton;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
    private TextView HKDate, HKStatus, HKCancelHouseKeeping, HKTitle, HKKeeping;
    private String urlCancelToday, urlCancelWhole, urlRequestHK, urlGetStatus, chatFrom;
    private int HKFocus = 0;


    // Font path
    String fontPathRegRale = "raleway/Raleway-Regular.ttf";
    String fontPathBoldRale = "raleway/Raleway_Bold.ttf";
    String fontPathRegCav = "fonts/CaviarDreams.ttf";
    String fontPathBoldCav = "fonts/CaviarDreams_Bold.ttf";
<<<<<<< HEAD
=======
    String message;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646

    private String currentDateString, lastClick;
    /* ========== End ========== */




    private int seconds, minute, hour;
    private int timer1, timer2;

    private FrameLayout watchtv_frame;
    private FrameLayout hotelservices_frame;
    private FrameLayout checkout_frame;

    private FrameLayout tm_chanFrame;
    private FrameLayout tm_vodFrame;


    private RelativeLayout weatherLayout, selectBack;

<<<<<<< HEAD
    private TextView currentTime, consumeTime;
=======
    private TextView currentTime, consumeTime, testTime;
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
    private TextView guestname_txtview;
    private TextView date_txtview;
    private TextView watctv_txt_launcher, weather_description, weather_temp;
    private TextView hotelservices_txt_launcher;

    private ImageView hotellogo_imgview, weather_icon;
    private TextClock textClock;

    private Button channelButton, vodclickButton;
<<<<<<< HEAD
=======
    private String qlcheckURL11, qlcheckURL12, qlcheckURL13, qlcheckURL14, qlcheckURL15, qlcheckURL16;

>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646


    private Tracker mTracker;


    private SharedPreferences preferenceSettings, preferenceSettingsTime;
    private SharedPreferences.Editor preferenceEditor, preferenceEditorTime;
    private static final int PREFERENCE_MODE_PRIVATE = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //start code hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //end code hide status bar
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.d("Error", "UncaughtException!!!");
                System.exit(2);
            }
        });
        Bundle configBundle = new Bundle();
        try {
            setContentView(R.layout.activity_launcher2nd);
        }catch (RuntimeException e){
            onCreate(configBundle);
        }

        AnalyticsApplication application = (AnalyticsApplication) getApplicationContext();
        mTracker = application.getDefaultTracker();

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        currentDateString = dateFormat.format(date);
        vdata = (Variable)getIntent().getSerializableExtra(Variable.EXTRA);

        //init widgets
        date_txtview = findViewById(R.id.dateTxtmain);
        watchtv_frame = findViewById(R.id.watchtvframe);
        hotelservices_frame = findViewById(R.id.hotelservicesframe);
        checkout_frame = findViewById(R.id.checkoutFrame);

<<<<<<< HEAD

=======
        exitButton = findViewById(R.id.exitBttn);
//        extendButton = findViewById(R.id.extendBttn);
//        checkoutButton = findViewById(R.id.checkoutBttn);
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646



        guestname_txtview = findViewById(R.id.tm_welcomeTxt);
        hotellogo_imgview = findViewById(R.id.hotelLogo);
        watctv_txt_launcher = findViewById(R.id.watchtv_launcher_text);
        hotelservices_txt_launcher = findViewById(R.id.hotelservices_launcher_text);
        watctv_txt_launcher = findViewById(R.id.watchtv_launcher_text);
        hotelservices_txt_launcher = findViewById(R.id.hotelservices_launcher_text);
        weather_description = findViewById(R.id.LweatherDesc);
        weather_icon = findViewById(R.id.LweatherIcon);
        weather_temp = findViewById(R.id.LweatherTemp);
        weatherLayout = findViewById(R.id.weatherL);
        // Font path
        String fontPathReg = "raleway/Raleway-Regular.ttf";
        String fontPathRegBold = "raleway/Raleway_Bold.ttf";
        String fontPathBold = "fonts/CaviarDreams_Bold.ttf";

        // text view label
        date_txtview = findViewById(R.id.dateTxt);
        textClock = findViewById(R.id.textClock);
<<<<<<< HEAD
        currentTime = findViewById(R.id.shadowTime);
=======
        currentTime = findViewById(R.id.textView7);
        consumeTime = findViewById(R.id.shadowTime);
        testTime = findViewById(R.id.textView8);
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646




//        currentTime.setText((CharSequence) textClock);




        // Loading Font Face
        Typeface fontReg = Typeface.createFromAsset(getAssets(), fontPathReg);
        Typeface fontRegBold = Typeface.createFromAsset(getAssets(), fontPathRegBold);
        Typeface fontBold = Typeface.createFromAsset(getAssets(), fontPathBold);

        //Applying font
        watctv_txt_launcher.setTypeface(fontReg);
        hotelservices_txt_launcher.setTypeface(fontReg);
        date_txtview.setTypeface(fontBold);
        textClock.setTypeface(fontBold);
        guestname_txtview.setTypeface(fontRegBold);

        date_txtview.setText(currentDateString);
        guestname_txtview.setText("Welcome "+vdata.getGuestFirstName()+" !");



//        Picasso.with(getApplicationContext()).load(vdata.getServerURL()+vdata.getHotelLogo()).into(hotellogo_imgview);

        onFocusFrames();
        videoViewPlay();


        // Set current and consume time
        Thread myThread = null;

//        Runnable runnable = new CountDownRunner();
        Runnable runnable = new CountDownRunner1();
        myThread= new Thread(runnable);
        myThread.start();

        // End current and consume time




        preferenceSettings = getSharedPreferences("occupied", MODE_PRIVATE);
        preferenceSettingsTime = getSharedPreferences("checkintime", MODE_PRIVATE);






        // Set current and consume time
        Thread myThread = null;

        Runnable runnable = new CountDownRunner();
        myThread= new Thread(runnable);
        myThread.start();

        // End current and consume time







    }

    @Override
    public void onStart(){
        super.onStart();
        //start code hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //end code hide status bar
//        getWeatherReport();

        mTracker.setScreenName(vdata.getHotelName()+" ~ Room No. "+vdata.getRoomNumber()+" ~ "+"Main View");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

<<<<<<< HEAD
//        checkin_timer();



=======

        videoViewPlay();
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
    }

    @Override
    public void onResume(){
        super.onResume();
        //start code hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //end code hide status bar


//        videoViewPlay();
    }

    @Override
    public void onBackPressed(){

//        super.onBackPressed();
<<<<<<< HEAD


        Intent i = new Intent(LauncherActivity.this, LauncherActivity.class);
        i.putExtra(Variable.EXTRA, vdata);
        i.putExtra(WATCHTV_FROM, "launcher");
        startActivity(i);

=======
        launcher_activity();
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
    }




    public void watchtv_activity(View view){

<<<<<<< HEAD
=======

>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
        setContentView(R.layout.view_choices);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        channelButton = findViewById(R.id.chanBttn);
<<<<<<< HEAD

        //Hide Channel button Temporarily
//        channelButton.setVisibility(View.GONE);


=======
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
        vodclickButton = findViewById(R.id.vodBttn);
        channelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent i = new Intent(LauncherActivity.this, ChannelListActivity.class);
                i.putExtra(Variable.EXTRA, vdata);
                i.putExtra(WATCHTV_FROM, "launcher");
                startActivity(i);
            }

        });
=======
                channel_activity();
            }

        });

        channelButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                    HKFocus = 0;
                } else{
                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                }

            }
        });


>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
        vodclickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.android.tvleanback");
                startActivity(launchIntent);
<<<<<<< HEAD
            }
        });


=======

            }
        });
        vodclickButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                    HKFocus = 0;
                } else{
                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                }

            }
        });

    }



    public void channel_activity(){
        Intent i = new Intent(LauncherActivity.this, ChannelListActivity.class);
        i.putExtra(Variable.EXTRA, vdata);
        i.putExtra(WATCHTV_FROM, "launcher");
        startActivity(i);
    }


    public void main_activity(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(Variable.EXTRA, vdata);
        i.putExtra(WATCHTV_FROM, "launcher");
        startActivity(i);
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
    }

    public void hotelservices_activity(View view){
        Intent i = new Intent(this, HotelServicesActivity.class);
        i.putExtra(Variable.EXTRA, vdata);
        i.putExtra(WATCHTV_FROM, "launcher");
        startActivity(i);
    }

    public void launcher_activity(){
        Intent i = new Intent(this, LauncherActivity.class);
        i.putExtra(Variable.EXTRA, vdata);
        i.putExtra(WATCHTV_FROM, "launcher");
        startActivity(i);
    }

//    public void extendbutton_activity(View view){
//        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra(Variable.EXTRA, vdata);
//        startActivity(i);
//    }

    public void onFocusFrames(){
        watchtv_frame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view,hasFocus,getApplicationContext(),LauncherActivity.this);
            }
        });
        hotelservices_frame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view,hasFocus,getApplicationContext(),LauncherActivity.this);
            }
        });
        checkout_frame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view,hasFocus,getApplicationContext(),LauncherActivity.this);
            }
        });

    }

    private void getWeatherReport(){
        String url = "http://api.openweathermap.org/data/2.5/weather?id=1701668&appid=f4d527523a8ec6989f6e543ffc16ea25&units=metric";
        nc.getdataObject(url, getApplicationContext(), new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject response) {
                try {
                    if(response.getString("cod").toString().equals("200")) {
                        JSONArray weather = response.getJSONArray("weather");
                        JSONObject weat = weather.getJSONObject(0);
                        String main = weat.getString("main");
                        String description = weat.getString("description");
                        String icon = weat.getString("icon");
                        JSONObject ma = response.getJSONObject("main");
                        String temp = ma.get("temp").toString();

                        String desc = main + "( " + description + " )";
                        String icon_url = "http://openweathermap.org/img/w/" + icon + ".png";
                        String tem = temp + "ᵒC";

                        weather_description.setText(desc);
                        weather_temp.setText(tem);
                        Picasso.with(getApplicationContext()).load(icon_url).resize(80, 80).into(weather_icon);
                        weatherLayout.setVisibility(VISIBLE);
                    }
                    else{
                        weatherLayout.setVisibility(View.GONE);
                    }
                }catch (JSONException e){
                    Log.d("Weather Error",e.getLocalizedMessage());
                }

            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }


<<<<<<< HEAD
//    private void checkin_timer(){
//        new CountDownTimer(30000, 1000){
//            public void onTick(long millisUntilFinished){
//                checkin_timer_txt.setText(String.valueOf(millisUntilFinished/1000));
//            }
//            public  void onFinish(){
//                checkin_timer_txt.setText("FINISH!!");
//            }
//        }.start();
//    }


































=======

    public void openCheckoutActivity(View view){

            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.checkin_extend_activity);
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);

            extendButton = dialog.findViewById(R.id.extendBttn);
            checkoutButton = dialog.findViewById(R.id.checkoutBttn);

            extendButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                        HKFocus = 0;
                    } else {
                        view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                    }

                }
            });


            checkoutButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                        HKFocus = 0;
                    } else {
                        view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                    }

                }
            });

            dialog.show();


    }



    public void onExtendActivity(View view) {
        qlcheckURL11 = vdata.getApiUrl() + "extendroomactivity.php?room_id=" + vdata.getQLroomID();
        new AlertDialog.Builder(LauncherActivity.this)
                .setTitle("EXTEND STAY")
                .setMessage("Are you sure you want to EXTEND?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        HttpAsyncTask hat = new HttpAsyncTask();
                        hat.execute(qlcheckURL11);

                        preferenceSettingsTime.edit().clear().commit();
                        preferenceEditorTime = preferenceSettingsTime.edit();
                        preferenceEditorTime.putLong("checkintime", System.currentTimeMillis());
                        preferenceEditorTime.commit();

                        launcher_activity();

                    }
                })
                .setNegativeButton(android.R.string.no, null).show();

    }



    public void onCheckoutActivity(View view) {
        qlcheckURL12 = vdata.getApiUrl() + "outroomactivity.php?room_id=" + vdata.getQLroomID();
        new AlertDialog.Builder(LauncherActivity.this)
                .setTitle("CHECK-OUT")
                .setMessage("Are you sure you want to CHECKOUT?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        HttpAsyncTask hat = new HttpAsyncTask();
                        hat.execute(qlcheckURL12);
                        main_activity();
                    }
                })
                .setNegativeButton(android.R.string.no, null).show();
    }


    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            return httpRequestResponse(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

        }
    }

    //For HttpAsync Functions: sending requests and receiving responses
    public static String httpRequestResponse(String url){
        InputStream inputStream = null;
        String result = "";
        try {
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert InputStream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "InputStream did not work";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;
    }
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646




<<<<<<< HEAD





    public void openHousekeeping(final View view){
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.checkin_extend_activity);

        //start code hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //end code hide status bar

        // Loading Font Face
        Typeface fontReg = Typeface.createFromAsset(getAssets(), fontPathRegCav);
        Typeface fontBold = Typeface.createFromAsset(getAssets(), fontPathBoldCav);


        HKToday = dialog.findViewById(R.id.TodayHKBtnS);
        HKWhole = dialog.findViewById(R.id.WholeHKBtnS);
        HKRequest = dialog.findViewById(R.id.RequestHKBtnS);

        HKDate = dialog.findViewById(R.id.HousekeepingDateS);
        HKStatus = dialog.findViewById(R.id.HousekeepingStatusS);
        HKCancelHouseKeeping = dialog.findViewById(R.id.CancelHouseKeepingS);
        HKTitle = dialog.findViewById(R.id.HousekeepingTitleS);
        HKKeeping = dialog.findViewById(R.id.RequestHouseKeepingS);

        //Applying font
        HKToday.setTypeface(fontReg);
        HKWhole.setTypeface(fontReg);
        HKRequest.setTypeface(fontReg);
        HKStatus.setTypeface(fontReg);
        HKKeeping.setTypeface(fontReg);
        HKCancelHouseKeeping.setTypeface(fontReg);

        HKTitle.setTypeface(fontBold);
        HKWhole.setVisibility(View.GONE);
        HKToday.setVisibility(View.VISIBLE);


        HKDate.setText(currentDateString);

        urlCancelToday = vdata.getApiUrl() + "canceltodayhousekeeping.php?hotel_id=" + vdata.getHotelID() + "&guest_id=" + vdata.getGuestID();
        urlCancelWhole = vdata.getApiUrl() + "cancelwholehousekeeping.php?hotel_id=" + vdata.getHotelID() + "&guest_id=" + vdata.getGuestID();
        urlRequestHK = vdata.getApiUrl() + "requesthousekeeping.php?hotel_id=" + vdata.getHotelID() + "&guest_id=" + vdata.getGuestID();
        urlGetStatus = vdata.getApiUrl() + "housekeepingstatus.php?hotel_id=" + vdata.getHotelID() + "&guest_id=" + vdata.getGuestID();
        nc.getdataObject(urlGetStatus, getApplicationContext(), new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject response) {
//                try {
//                    String status = response.getString("status");
//                    if(status.equals("Requested Housekeeping")){
//                        HKStatus.setText("Status : Checkout");
//                    }else if(status.equals("Cancel Housekeeping Today")){
//                        HKStatus.setText("Status : Extend Stay");
//                    }else if(status.equals("Cancel Housekeeping Whole Stay")){
//                        HKStatus.setText("Status : Extend Stay");
//                    }else{
//                        HKStatus.setText("Status : Extend Stay");
//                    }
//                }catch (JSONException e){
//                    Log.d("HK Status", e.getLocalizedMessage());
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        });

        HKToday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(LauncherActivity.this)
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to extend?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                nc.getdataObject(urlCancelToday, getApplicationContext(), new VolleyCallback() {
                                    @Override
                                    public void onSuccess(JSONObject response) {
                                        HKStatus.setText("Status : Extend Stay");
                                        HKWhole.setVisibility(View.GONE);

                                        Intent i = new Intent(LauncherActivity.this, LauncherActivity.class);
                                        i.putExtra(Variable.EXTRA, vdata);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onError(VolleyError error) {
                                        Log.d("Cancel Today", error.getLocalizedMessage());
                                        error.printStackTrace();
                                    }
                                });
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
        HKWhole.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(LauncherActivity.this)
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to exit?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                nc.getdataObject(urlCancelWhole, getApplicationContext(), new VolleyCallback() {
                                    @Override
                                    public void onSuccess(JSONObject response) {
//                                        HKStatus.setText("Status : Cancelled HouseKeeping for Whole Stay");


                                        Intent i = new Intent(LauncherActivity.this, MainActivity.class);
                                        i.putExtra(Variable.EXTRA, vdata);
                                        startActivity(i);


                                    }

                                    @Override
                                    public void onError(VolleyError error) {
                                        Log.d("Cancel WholeStay", error.getLocalizedMessage());
                                        error.printStackTrace();
                                    }
                                });
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
        HKRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(LauncherActivity.this)
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to checkout?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                nc.getdataObject(urlRequestHK, getApplicationContext(), new VolleyCallback() {
                                    @Override
                                    public void onSuccess(JSONObject response) {
                                        HKStatus.setText("Status : Checkout");
//                                        HKWhole.setVisibility(View.VISIBLE);
//                                        HKToday.setVisibility(View.GONE);

                                        Intent i = new Intent(LauncherActivity.this, MainActivity.class);
                                        i.putExtra(Variable.EXTRA, vdata);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onError(VolleyError error) {
                                        Log.d("Request CE", error.getLocalizedMessage());
                                        error.printStackTrace();
                                    }
                                });
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });


        HKToday.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                    HKFocus = 0;
                } else{
                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                }

            }
        });
        HKWhole.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                    HKFocus = 1;
                } else{
                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                }
            }
        });
        HKRequest.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                    HKFocus = 2;
                } else{
                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                }
            }
        });

        dialog.setOnKeyListener(new Dialog.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface arg0, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.dismiss();
                    //start code hide status bar
                    View decorView = getWindow().getDecorView();
                    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(uiOptions);
                    //end code hide status bar
                }
                return false;
            }
        });
        dialog.show();
    }



    // Setting check in time and consume time

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{
                    TextView txtCurrentTime= (TextView)findViewById(R.id.tm_currentTime);
                    Date dt = new Date();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    int seconds = dt.getSeconds();
                    String curTime = hours + ":" + minutes + ":" + seconds;
//                    String curTime = String.valueOf(times);
                    txtCurrentTime.setText(curTime);

                }catch (Exception e) {}
            }
        });
    }


    class CountDownRunner implements Runnable{
        // @Override
=======
    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {

                    long millis = System.currentTimeMillis();

                    int seconds = (int) (millis / 1000) % 60 ;
                    int minutes = (int) ((millis / (1000*60)) % 60);
                    int hours   = (int) ((millis / (1000*60*60)) % 12);

                    long oldtime = preferenceSettingsTime.getLong("checkintime", 0);

                    int oldhours = (int) ((oldtime / (1000*60*60)) % 12);
                    int oldminutes = (int) ((oldtime / (1000*60)) % 60);
                    int oldseconds = (int) (oldtime / 1000) % 60 ;



                    currentTime.setText(String.valueOf("Checked In Time:"));
                    consumeTime.setText(String.valueOf(oldhours + ":" + oldminutes + ":" + oldseconds));

                    long longdate = 10811000; // 3 hrs value
                    testTime.setText("Current Time:");
                    TextView txtCurrentTime = (TextView)findViewById(R.id.tm_currentTime);

                    txtCurrentTime.setText(String.valueOf(hours + ":" + minutes + ":" + seconds));
//                    txtCurrentTime.setText(  );

                    if (System.currentTimeMillis() - oldtime > longdate) {


                        final Dialog dialog = new Dialog(LauncherActivity.this);
                        dialog.setCancelable(true);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setContentView(R.layout.checkin_extend_activity);
                        View decorView = getWindow().getDecorView();
                        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                        decorView.setSystemUiVisibility(uiOptions);

                        extendButton = dialog.findViewById(R.id.extendBttn);
                        checkoutButton = dialog.findViewById(R.id.checkoutBttn);

                        extendButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View view, boolean hasFocus) {
                                if (hasFocus) {
                                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                                    HKFocus = 0;
                                } else {
                                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                                }

                            }
                        });


                        checkoutButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View view, boolean hasFocus) {
                                if (hasFocus) {
                                    view.setBackgroundTintList(getColorStateList(R.color.hkfocustint));
                                    HKFocus = 0;
                                } else {
                                    view.setBackgroundTintList(getColorStateList(R.color.quantitybuttoncartblur));
                                }

                            }
                        });

                        dialog.show();


                    }

                } catch (Exception e) {
                }
            }
        });
    }

    class CountDownRunner1 implements Runnable{
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    doWork();
<<<<<<< HEAD
                    Thread.sleep(1000);
=======
                    Thread.sleep(10000);
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }

<<<<<<< HEAD
    // End of check in and consume time






=======
    public void videoViewPlay(){

        Resources res = getResources();
        String[] ADS = res.getStringArray(R.array.myADS);
        String randomStr = ADS[new Random().nextInt(ADS.length)];

        VideoView videoView = findViewById(R.id.videoViewLauncher);

        videoView.setVideoPath(String.valueOf(randomStr));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });


    }
>>>>>>> 80e011ef5dd6f80c65b159266b5919b56e970646





}
