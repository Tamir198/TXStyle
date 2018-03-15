package com.txstyle;

import android.content.Intent;
import android.graphics.Path;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);
       // textView = findViewById(R.id.textView); use any view to check positions

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,Options.class);
                startActivity(i);
                finish();
            }
        }, 2000);


    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                System.out.println(textView.getHeight()); //height is ready
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    */


}
