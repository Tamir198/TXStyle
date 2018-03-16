package com.txstyle;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.txstyle.R.drawable.ic_launcher_background;

public class Testing extends AppCompatActivity {

    EditText test;
    ImageView imageView;
    String testChars;
    String font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
         //test = findViewById(R.id.test);
         imageView = findViewById(R.id.image);
         testChars = "this is a test";
         font = "clouds_"; // or hearts_

    }

    @Override
    protected void onStart() {
        super.onStart();
        //number of chars that i have in the word
        int numberOfChars = testChars.length();
        //LinearLayOut Setup
        //LinearLayout linearLayout= new LinearLayout(this);
        LinearLayout linearLayout=  findViewById(R.id.myInnerLayout);
       // linearLayout.setOrientation(LinearLayout.VERTICAL);

       // linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
               // LinearLayout.LayoutParams.MATCH_PARENT,
              //  LinearLayout.LayoutParams.MATCH_PARENT));

        for(int i=0 ; i<testChars.length() ; i++){
            char c = testChars.charAt(i);
            //ImageView Setup
            final ImageView imageView = new ImageView(this);
            //setting image resource
            int id = this.getResources().getIdentifier(font+""+c, "drawable", this.getPackageName());
            imageView.setImageResource(id);
            if(i>7){
                linearLayout = findViewById(R.id.myInnerLayout2);
            }

            //setting image position

            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    setImageSize(numberOfChars), setImageSize(numberOfChars)));
            //imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                   // LinearLayout.LayoutParams.WRAP_CONTENT));

            //adding view to layout
            linearLayout.addView(imageView);
            //make visible to program(if you don't have any existing layout than use bellow line)
            //setContentView(linearLayout);
        }
    }

    public void getImagePosition(){
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                System.out.println(imageView.getLeft() + "  left    " + imageView.getRight() + "    right   "); //height is ready
                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public int setImageSize(int size){
        if(size>8 && size<12){
            return 100;
        }else if(size > 12 && size<15){
            return 80;
        }else if(size > 15 && size<18){
            return 60;
        }else if(size > 18 && size<21){
            return 40;
        }else if(size > 21 && size<24){
            return 30;
        }else if(size > 24 && size<27){
            return 20;
        }else{
            return 140;
        }
    }


}
