package com.txstyle;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        //Intent i = new Intent(this,splahScreenActivity.class);
        //startActivity(i);

    }

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


}
