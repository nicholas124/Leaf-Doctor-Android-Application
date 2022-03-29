package com.example.nm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class CameraActivity extends AppCompatActivity {

    String cropType;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


            cropType = getIntent().getStringExtra("realtime").toString();

        Toast.makeText(this, "@@@@" + cropType, Toast.LENGTH_SHORT).show();


        /** add fragment to Activity */
        if (null == savedInstanceState) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

    public String CropTypeFun(){
        return cropType;
    }

    /** Back Button is pressed */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateCard(this); //fire the card animation

    }
}
