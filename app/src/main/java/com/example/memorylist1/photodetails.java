package com.example.memorylist1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class photodetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photodetails);

        Intent in = getIntent();
        int position = in.getIntExtra("com.example.Item_Position", -1);

        if (position > -1) {
            int pic = getImg(position);
            ImageView img = (ImageView) findViewById(R.id.imageView) ;
            scaleImg(img, pic);

        }

    }

    private int getImg(int position) {
        switch(position) {
            case 0: return R.drawable.rotterdam;
            case 1: return R.drawable.newyork;
            case 2: return R.drawable.shanghai;
            case 3: return R.drawable.ankara;
            case 4: return R.drawable.nador;
            default: return -1;
        }
    }


    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic,options);
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;


        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg= BitmapFactory.decodeResource(getResources(), pic,options);
        img.setImageBitmap(scaledImg);


    }

}

