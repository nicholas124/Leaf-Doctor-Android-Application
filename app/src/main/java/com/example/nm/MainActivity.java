package com.example.nm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseBuilder;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseSequence;
import com.example.nm.Others.About;
import com.example.nm.Others.CategoryDiseaseMenu;
import com.example.nm.Others.Information;
import com.example.nm.Others.VideoInfor;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUESTS = 0;
    /** CardView initialization */
    private LinearLayout general_scan_btn;
    private LinearLayout category_btn;
    private LinearLayout vegi_infor_btn;
    private LinearLayout savedResult;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    /** onOptionItemSelected enables selecting of menu options  */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.help:
                help();
                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About.class));
                Animatoo.animateCard(this);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraPermission();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /** @param* initialization */
//        general_scan_btn = (LinearLayout) findViewById(R.id.general_scan_btn);
        category_btn = (LinearLayout) findViewById(R.id.category_btn);
        vegi_infor_btn = (LinearLayout) findViewById(R.id.Vegi_infor_btn);
        savedResult = (LinearLayout) findViewById(R.id.savedResults);



//        general_scan_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toRealTime = new Intent(MainActivity.this, CameraActivity.class);
//                toRealTime.putExtra("realtime", "general");
//                startActivity(toRealTime);
//                Animatoo.animateCard(MainActivity.this);
//            }
//        });

        category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CategoryDiseaseMenu.class));
                Animatoo.animateCard(MainActivity.this);
            }
        });

        vegi_infor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Information.class));
                Animatoo.animateCard(MainActivity.this);
                Toast.makeText(MainActivity.this, "clicked vegi", Toast.LENGTH_SHORT).show();
            }
        });

        savedResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideoInfor.class));
                Animatoo.animateCard(MainActivity.this);
                Toast.makeText(MainActivity.this, "clicked to video", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean cameraPermission() {
        if (ContextCompat.checkSelfPermission(this , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, Manifest.permission.CAMERA))
            {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setCancelable(true);
                alertBuilder.setTitle("Permission necessary");
                alertBuilder.setMessage("CAMERA is necessary");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions((MainActivity.this) ,
                                new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
            } else {
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
            }
            return false;
        } else {
            return true;
        }
    }

    public void help(){
        new BubbleShowCaseSequence()
//                .addShowCase(
//                        new BubbleShowCaseBuilder(this)
//                        .title("Medium accuracy")
//                        .description("Click here if you want to check for disease on an unknown leaf")
//                        .targetView(findViewById(R.id.general_scan_btn))
//                )
                .addShowCase(
                new BubbleShowCaseBuilder(this)
                        .title("High accuracy")
                        .description("Click here to pick the type of plant to be scanned  ")
                        .targetView(findViewById(R.id.category_btn)) )


                .addShowCase(
                        new BubbleShowCaseBuilder(this)
                        .title("Information")
                        .description("Click here to know more about vegetable farming")
                        .targetView(findViewById(R.id.Vegi_infor_btn)) )

                .addShowCase(
                        new BubbleShowCaseBuilder(this)
                        .title("About this app")
                        .description("Click here to know more about the application")
                        .targetView(findViewById(R.id.savedResults)) )
                .show();
    }

    /** When back button is initialized by the user */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateCard(this); //fire the slide left animation

    }
}
