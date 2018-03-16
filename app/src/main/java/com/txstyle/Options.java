package com.txstyle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

public class Options extends AppCompatActivity {
    ImageView pickYourBackground;
    ImageButton colorPickBtn;
    ImageButton galleryBtn;
    ImageButton cameraBtn;
    ImageView imageFromStorage;

    permissionsHandler permissionsHandler;
    imageHandler imageHandler;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        permissionsHandler = new permissionsHandler();
        imageHandler = new imageHandler();
        pickYourBackground = findViewById(R.id.pick_your_background);
        colorPickBtn = findViewById(R.id.choose_color_picker_background);
        galleryBtn = findViewById(R.id.choose_gallery_background);
        cameraBtn = findViewById(R.id.choose_camera_background);
    };
    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            // or get a single image only
            Image image = ImagePicker.getFirstImageOrNull(data);
            Intent intent = new Intent(this,EditActivity.class);
            intent.putExtra("KEY_TEXT",image);
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void onGalleryClick(View view) {
        imageHandler.pickFromGallery(Options.this);
    }

    public void onCameraClick(View view) {
        imageHandler.pickFromCamera(Options.this);
    }

    public void onColorPicker(View view) {
        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);
    }
}
