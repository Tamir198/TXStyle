package com.txstyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Options extends AppCompatActivity {
    ImageButton colorPickBtn;
    ImageButton galleryBtn;
    ImageButton cameraBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        colorPickBtn = findViewById(R.id.choose_color_picker_background);
        galleryBtn = findViewById(R.id.choose_gallery_background);
        cameraBtn = findViewById(R.id.choose_camera_background);
    }

    public void onColorPickerClick(View view) {
        //colorPickBtn.setImageResource(R.drawable.color_picker_on);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void onGalleryClick(View view) {
        //galleryBtn.setImageResource(R.drawable.gallry_on);
    }

    public void onCameraClick(View view) {
        //cameraBtn.setImageResource(R.drawable.camera_on);
    }
}
