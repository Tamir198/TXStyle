package com.txstyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.EditText;

public class Testing extends AppCompatActivity {

    EditText test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
         test = findViewById(R.id.test);
    }

    @Override
    protected void onStart() {
        super.onStart();
        test.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                System.out.println(test.getHeight() + "height"); //height is ready
                System.out.println(test.getWidth() + "width"); //height is ready

                test.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
