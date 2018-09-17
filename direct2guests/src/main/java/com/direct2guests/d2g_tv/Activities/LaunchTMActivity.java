package com.direct2guests.d2g_tv.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.direct2guests.d2g_tv.Activities.LauncherActivity;
import com.direct2guests.d2g_tv.NonActivity.NetworkConnection;
import com.direct2guests.d2g_tv.NonActivity.Variable;
import com.direct2guests.d2g_tv.NonActivity.VolleyCallback;
import com.direct2guests.d2g_tv.R;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;

import static com.direct2guests.d2g_tv.Activities.LauncherActivity.WATCHTV_FROM;


public class LaunchTMActivity extends LangSelectActivity {
//    private NetworkConnection nc = new NetworkConnection();
//    private Variable vdata;
//    public final static String WATCHTV_FROM = "com.direct2guests.d2g_tv.WATCHTV_FROM";
//
//    private RelativeLayout weatherLayout;
//
//    private TextView  weather_description, weather_temp;
//    private int seconds, minute, hour;
//    private int timer1, timer2;
//
//    private FrameLayout tm_channel_frame;
//    private FrameLayout tm_vod_frame;
//    private TextView tm_chan_txt, tm_vod_txt;
//    private TextClock textClock;
//    private Tracker mTracker;
//    private ImageView tm_chan_img;
//    private ImageView tm_vod_img, weather_icon;;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tvmovie_launcher);
//
//
//        AnalyticsApplication application = (AnalyticsApplication) getApplicationContext();
//        mTracker = application.getDefaultTracker();
//        vdata = (Variable)getIntent().getSerializableExtra(Variable.EXTRA);
//
//        tm_channel_frame = findViewById(R.id.tm_chanFrame);
//        tm_vod_frame = findViewById(R.id.tm_vodFrame);
//        tm_chan_img = findViewById(R.id.tm_tvicon);
//        tm_vod_img = findViewById(R.id.tm_vodicon);
//
////        weather_description = findViewById(R.id.LweatherDesc);
////        weather_icon = findViewById(R.id.LweatherIcon);
////        weather_temp = findViewById(R.id.LweatherTemp);
////        weatherLayout = findViewById(R.id.weatherL);
//
////        String fontPathReg = "raleway/Raleway-Regular.ttf";
////        String fontPathRegBold = "raleway/Raleway_Bold.ttf";
////        String fontPathBold = "fonts/CaviarDreams_Bold.ttf";
////
////        Typeface fontReg = Typeface.createFromAsset(getAssets(), fontPathReg);
////        Typeface fontRegBold = Typeface.createFromAsset(getAssets(), fontPathRegBold);
////        Typeface fontBold = Typeface.createFromAsset(getAssets(), fontPathBold);
////
//////        tm_chan_txt = findViewById(R.id.watchtv_launcher_text);
//////        tm_vod_txt  = findViewById(R.id.hotelservices_launcher_text);
////
////        tm_chan_txt.setTypeface(fontReg);
////        tm_vod_txt.setTypeface(fontReg);
//
//
////        getWeatherReport();
//        onFocusFrames();
//
//    }
//
//
//    @Override
//    public void onStart(){
//        super.onStart();
//        //start code hide status bar
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//
////        mTracker.setScreenName(vdata.getHotelName()+" ~ Room No. "+vdata.getRoomNumber()+" ~ "+"Main View");
////        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
//
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        //start code hide status bar
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//
//    }
//
//    @Override
//    public void onBackPressed(){
//
////        super.onBackPressed();
//
//
////        Intent i = new Intent(LaunchTMActivity.this, LauncherActivity.class);
////        i.putExtra(Variable.EXTRA, vdata);
//////        i.putExtra(WATCHTV_FROM, "launcher");
////        startActivity(i);
//
//    }
//
////    public void tm_chan_activity(View view){
////            tm_chan_img.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    Intent i = new Intent(LaunchTMActivity.this, ChannelListActivity.class);
////                    i.putExtra(Variable.EXTRA, vdata);
////                    i.putExtra(WATCHTV_FROM, "launcher");
////                    startActivity(i);
////                }
////
////            });
//////            Intent i = new Intent(LaunchTMActivity.this, ChannelListActivity.class);
//////            startActivity(i);
////    }
////
////
//    public void tm_vod_activity(View view){
//
//        tm_vod_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = getPackageManager().getLaunchIntentForPackage("com.example.android.tvleanback");
//                startActivity(i);
//            }
//
//        });
//
//    }
//
//
//    public void onFocusFrames() {
//        tm_channel_frame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                vdata.focusAnim(view, hasFocus, getApplicationContext(), LaunchTMActivity.this);
//            }
//        });
//
//        tm_vod_frame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                vdata.focusAnim(view, hasFocus, getApplicationContext(), LaunchTMActivity.this);
//            }
//        });
//
//    }
//
//
//
//
//
//
//
//    private void getWeatherReport(){
//        String url = "http://api.openweathermap.org/data/2.5/weather?id=1701668&appid=f4d527523a8ec6989f6e543ffc16ea25&units=metric";
//        nc.getdataObject(url, getApplicationContext(), new VolleyCallback() {
//            @Override
//            public void onSuccess(JSONObject response) {
//                try {
//                    if(response.getString("cod").toString().equals("200")) {
//                        JSONArray weather = response.getJSONArray("weather");
//                        JSONObject weat = weather.getJSONObject(0);
//                        String main = weat.getString("main");
//                        String description = weat.getString("description");
//                        String icon = weat.getString("icon");
//                        JSONObject ma = response.getJSONObject("main");
//                        String temp = ma.get("temp").toString();
//
//                        String desc = main + "( " + description + " )";
//                        String icon_url = "http://openweathermap.org/img/w/" + icon + ".png";
//                        String tem = temp + "ᵒC";
//
//                        weather_description.setText(desc);
//                        weather_temp.setText(tem);
//                        Picasso.with(getApplicationContext()).load(icon_url).resize(80, 80).into(weather_icon);
//                        weatherLayout.setVisibility(View.VISIBLE);
//                    }
//                    else{
//                        weatherLayout.setVisibility(View.GONE);
//                    }
//                }catch (JSONException e){
//                    Log.d("Weather Error",e.getLocalizedMessage());
//                }
//
//            }
//
//            @Override
//            public void onError(VolleyError error) {
//
//            }
//        });
//    }


}
