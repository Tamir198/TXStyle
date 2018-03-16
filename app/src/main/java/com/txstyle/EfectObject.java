package com.txstyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gal on 16/03/2018.
 */

public class EfectObject {

    private int imageID;
    private String text = "";

    EfectObject(int imageID, String text) {
        this.imageID = imageID;
        this.text = text;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
