package com.direct2guests.d2g_tv.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.direct2guests.d2g_tv.NonActivity.Variable;
import com.direct2guests.d2g_tv.R;

import java.util.Random;


public class MainLangActivity extends LangSelectActivity implements View.OnClickListener {

    public final static String LANG_SELECT_FROM = "com.direct2guests.d2g_tv.LangSelectActivity.LANG_SELECT_FROM";

    Variable vdata = new Variable();

    private FrameLayout frenchFrame;
    private FrameLayout englishFrame;
    private FrameLayout koreanFrame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang_select);

        findViewById(R.id.LangEnglish).setOnClickListener(this);
        findViewById(R.id.LangKorean).setOnClickListener(this);
        findViewById(R.id.LangFrench).setOnClickListener(this);
        frenchFrame = findViewById(R.id.LangFrench);
        englishFrame = findViewById(R.id.LangEnglish);
        koreanFrame = findViewById(R.id.LangKorean);



//        changeBackground();
        onFocusFrames();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.LangEnglish) {
            setLanguage("en");
            Intent i = new Intent(MainLangActivity.this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.LangFrench) {
            setLanguage("fr");
            Intent i = new Intent(MainLangActivity.this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.LangKorean) {
            setLanguage("ko");
            Intent i = new Intent(MainLangActivity.this, MainActivity.class);
            startActivity(i);
        }
    }


    public void onFocusFrames() {
        frenchFrame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view, hasFocus, getApplicationContext(), MainLangActivity.this);
            }
        });

        englishFrame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view, hasFocus, getApplicationContext(), MainLangActivity.this);
            }
        });
        koreanFrame.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                vdata.focusAnim(view, hasFocus, getApplicationContext(), MainLangActivity.this);

            }
        });
    }




    public void changeBackground(){
        //Dynamic Background

        final RelativeLayout background = (RelativeLayout) findViewById(R.id.langSelectLayout);
        Resources res = getResources();
        final TypedArray myImages = res.obtainTypedArray(R.array.myImages);
        final Random random = new Random();
        int randomInt = random.nextInt(myImages.length());
        int drawableID = myImages.getResourceId(randomInt, -1);
        background.setBackgroundResource(drawableID);

    }

    // End of Dynamic Background



}
