package com.txstyle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.io.File;

/**
 * Created by AvihaiBinder on 16/03/2018.
 */

public class imageHandler {
    public void pickFromGallery(Context context){
        ImagePicker.create((Activity) context) // Activity or Fragment
                .imageDirectory("TXStyle Photos")
                .single()
                .folderMode(true)
                .start();
    }
 /*   public Bitmap getBitmap(String path) {
        File imgFile = new File(path);
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return myBitmap;
        }
        return null;
    }*/
    public void pickFromCamera(Context context){
        ImagePicker.cameraOnly().start((Activity) context);
    }
}


