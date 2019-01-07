package com.example.alexandreblanloeil.ti;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.alpha;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView tv = (TextView) findViewById(R.id.txtHello);  //textview fait bugger les boutons (déja buggés), implémentation ultérieure
        tv.setText("Hello from the code !");*/
        ImageView imView= findViewById(R.id.bmp);
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inScaled = false;
        o.inMutable = true;
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image, o);
        imView.setImageBitmap(bmp);
        System.out.println("test");
        Log.i("TAG", "appli crée");
        final Button buttonToGray = findViewById(R.id.togray);
        final Button buttonColorize = findViewById(R.id.red);
        final Button buttonKeepRed = findViewById(R.id.green);
        final Button buttonBlue = findViewById(R.id.blue);
        final Button buttonContrast = findViewById(R.id.contrast);
        final Button buttonConvolve = findViewById(R.id.convolve);
        final Button buttonReset = findViewById(R.id.reset);
        buttonToGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toGray2(bmp);
            }
        });
        buttonColorize.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorize(bmp);
            }
        });
        buttonKeepRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                keepRed(bmp);
            }
        });
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blue(bmp);
            }
        });
        buttonConvolve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                convolve(bmp);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reset(bmp);
            }
        });
        buttonContrast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contrast(bmp);
            }
        });

    }

    protected void toGray(Bitmap bmp) {
        System.out.println("Image greyed successfully");
        for (int y = 0; y < bmp.getHeight(); y++) {
            for (int x = 0; x < bmp.getWidth(); x++) {
                int p = bmp.getPixel(x,y);
                float r = Color.red(p);
                float g = Color.green(p);
                float b = Color.blue(p);
                float a = Color.alpha(p);
                float m = ( r+g+b ) / 765;
                bmp.setPixel(x,y, Color.argb(a,m,m,m));
            }
        }
    }

    protected void toGray2(Bitmap bmp) {
        System.out.println("Image greyed successfully");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            float r = Color.red(pixels[i]);
            float g = Color.green(pixels[i]);
            float b = Color.blue(pixels[i]);
            float a = Color.alpha(pixels[i]);
            float m = (r + g + b) / 765;
            pixels[i] = Color.argb(a,m,m,m);
        }
        bmp.setPixels(pixels, 0, width, 0, 0, width, height);
    }
    protected void colorize(Bitmap bmp){
        System.out.println("Image changed to red successfully");
    }
    protected void keepRed(Bitmap bmp){
        System.out.println("Image has only red");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            float r = Color.red(pixels[i]);
            float g = Color.green(pixels[i]);
            float b = Color.blue(pixels[i]);
            float a = Color.alpha(pixels[i]);
            if(r !=0 && g ==0 && b == 0) {
                pixels[i] = Color.argb(a, r, g, b);
            }
                else{
                float m = (r + g + b) / 765;
                pixels[i] = Color.argb(a, m, m, m);
            }
        }
        bmp.setPixels(pixels, 0, width, 0, 0, width, height);
    }
    protected void blue(Bitmap bmp){
        System.out.println("Image changed to blue successfully");
    }
    protected void contrast(Bitmap bmp){
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] hist = new int[100];
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++);
               // hist[I(i, j)]++;
    }
    protected void convolve(Bitmap bmp){
        System.out.println("Image convolved successfully");
    }
    protected void reset(Bitmap bmp){
        System.out.println("Image reset successfully");
    }

    protected void onStart() {
        super.onStart();
        Log.i("CV", "appli démarrée");
    }

    protected void onResume() {
        super.onResume();
        Log.i("CV", "appli reprise");
    }

    protected void onPause() {
        super.onPause();
        Log.i("CV", "appli en pause");

    }

    protected void onRestart() {
        super.onRestart();
        Log.i("CV", "appli redémarrée");

    }

    protected void onStop() {
        super.onStop();
        Log.i("CV", "appli arrétée");

    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("CV", "appli DESTROYED !");

    }



}