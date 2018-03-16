package com.txstyle;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.txstyle.Adapters.MyRecyclerViewAdapter;

import java.util.ArrayList;

import java.io.File;

/**
 * Created by admin on 16/03/2018.
 */

public class EditActivity extends AppCompatActivity {

    TextView textView;
    RelativeLayout myBackground;
    ImageView colorPicker;
    ImageView textEfects;
    ImageView background;
    Image imageFromOptions,imageTo;
    imageHandler imageHandler;
    private int xDelta;
    private int yDelta;
    int width;
    int height;

    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "got to EditActivity", Toast.LENGTH_LONG)
                .show();
        colorPicker = findViewById(R.id.main_color_picker);
        myBackground = findViewById(R.id.main_background);
        background = findViewById(R.id.background);
        textEfects = findViewById(R.id.main_text_effect);
        textView = findViewById(R.id.textView);
        imageHandler = new imageHandler();
        imageFromOptions = getIntent().getParcelableExtra("KEY_TEXT");
        if (imageFromOptions != null) {
            changeBackgroundPicture(imageFromOptions,imageFromOptions.getPath());
        }
//        Intent i = new Intent(this,splahScreenActivity.class);
//        startActivity(i);

        textView.setOnTouchListener(onTouchListener());


        textEfects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(EditActivity.this);

                View textEfectView = inflater.inflate(R.layout.dialog_text_effect, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);

                builder.setView(textEfectView);


//                final EditText contactName = (EditText) textEfectView.findViewById(R.id.contact_name);
//                final EditText contactPhone = (EditText) textEfectView.findViewById(R.id.contact_phone);


                builder
                        .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                builder.show();

                ArrayList<EfectObject> efectObject = new ArrayList<>();
                efectObject.add(new EfectObject(R.drawable.hearts, "Hearts"));
                efectObject.add(new EfectObject(R.drawable.clouds, "Clouds"));
                efectObject.add(new EfectObject(R.drawable.balloons, "Balloons"));
                efectObject.add(new EfectObject(R.drawable.ice, "Ice"));
                efectObject.add(new EfectObject(R.drawable.cheese, "Cheese"));
                efectObject.add(new EfectObject(R.drawable.gel, "Gel"));
                efectObject.add(new EfectObject(R.drawable.smoke, "Smoke"));
                efectObject.add(new EfectObject(R.drawable.steam, "Steam"));
                efectObject.add(new EfectObject(R.drawable.coco, "Coco"));
                efectObject.add(new EfectObject(R.drawable.flower, "Flower"));
                efectObject.add(new EfectObject(R.drawable.leaf, "Leaf"));
                efectObject.add(new EfectObject(R.drawable.water, "Water"));

                recyclerView = textEfectView.findViewById(R.id.efects_recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(EditActivity.this, LinearLayoutManager.HORIZONTAL, false));

                adapter = new MyRecyclerViewAdapter(EditActivity.this, efectObject );
                //adapter.setClickListener((MyRecyclerViewAdapter.ItemClickListener) EditActivity.this);
                recyclerView.setAdapter(adapter);



            }
        });


        colorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.TRANSPARENT;
                Drawable background = myBackground.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();

                ColorPickerDialogBuilder
                        .with(EditActivity.this)
                        .setTitle("Choose color")
                        .initialColor(color)
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
//                        toast("onColorSelected: 0x" + Integer.toHexString(selectedColor));
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                changeBackgroundColor(selectedColor);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();

            }
        });


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

    public void changeBackgroundColor(int selectedColor) {
        myBackground.setBackgroundColor(selectedColor);

    }


    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:

                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                myBackground.invalidate();
                return true;
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            // or get a single image only
            Image image = ImagePicker.getFirstImageOrNull(data);
            changeBackgroundPicture(image,image.getPath());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onEditGalleryClick(View view) {
        imageHandler.pickFromGallery(EditActivity.this);
    }

    public void changeBackgroundPicture(Image image,String path) {
        File imgFile = new File(image.getPath());
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            background.setImageBitmap(myBitmap);
        }
    }

    public void onEditCameraClick(View view) {
        imageHandler.pickFromCamera(EditActivity.this);
    }
}
