package com.txstyle;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Testing extends AppCompatActivity {

    EditText test;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
         //test = findViewById(R.id.test);
         imageView = findViewById(R.id.image);
    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        test.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                System.out.println(test.getHeight() + "height"); //height is ready
                System.out.println(test.getWidth() + "width"); //height is ready
                imageView.setVisibility(imageView.VISIBLE);

                //sets the size of the image = as the image of the text
                //LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(test.getWidth(),test.getHeight());
                //imageView.setLayoutParams(parms);

                LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
                for(int i=0;i<5;i++)
                {
                    //ImageView ii= new ImageView(this);
                   // ii.setBackgroundResource(R.drawable.gallry);
                    //ll.addView(ii);
                }

                test.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    */
}
