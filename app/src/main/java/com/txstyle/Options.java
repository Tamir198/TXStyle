package com.txstyle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

public class Options extends AppCompatActivity {
    ImageView pickYourBackground;
    ImageButton colorPickBtn;
    ImageButton galleryBtn;
    ImageButton cameraBtn;
    ImageView imageFromStorage;

    permissionsHandler permissionsHandler;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        permissionsHandler = new permissionsHandler();
        pickYourBackground = findViewById(R.id.pick_your_background);
        colorPickBtn = findViewById(R.id.choose_color_picker_background);
        galleryBtn = findViewById(R.id.choose_gallery_background);
        cameraBtn = findViewById(R.id.choose_camera_background);

        colorPickBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        colorPickBtn.setImageResource(R.drawable.color_picker_on);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        colorPickBtn.setImageResource(R.drawable.color_picker);
                        view.invalidate();
                        changeActivityToTesting();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        colorPickBtn.setImageResource(R.drawable.color_picker);
                        view.invalidate();
                        break;
                    }
                }
                return true;
            }
        });

        galleryBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        galleryBtn.setImageResource(R.drawable.gallry_on);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        galleryBtn.setImageResource(R.drawable.gallry);
                        view.invalidate();
                       // permissionsHandler.getPermissionForStorage(Options.this);
                        ImagePicker.create(Options.this) // Activity or Fragment
                                .imageDirectory("TXStyle Photos")
                                .single()
                                .folderMode(true)
                                .start();


                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        galleryBtn.setImageResource(R.drawable.gallry);
                        view.invalidate();
                        break;
                    }
                }
                return true;
            }
        });


        cameraBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        cameraBtn.setImageResource(R.drawable.camera_on);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        cameraBtn.setImageResource(R.drawable.camera);
                        view.invalidate();
                        ImagePicker.cameraOnly().start(Options.this);
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        cameraBtn.setImageResource(R.drawable.camera);
                        view.invalidate();
                        break;
                    }
                }
                return true;
            }
        });


    };
    public void changeActivityToTesting() {
        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            // or get a single image only
            Image image = ImagePicker.getFirstImageOrNull(data);
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(image.getPath(),bmOptions);
            bitmap = Bitmap.createScaledBitmap(bitmap,100,100,true);
            pickYourBackground.setImageBitmap(bitmap);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
