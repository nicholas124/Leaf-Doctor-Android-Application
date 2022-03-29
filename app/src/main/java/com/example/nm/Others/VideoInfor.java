package com.example.nm.Others;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.nm.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class VideoInfor extends AppCompatActivity {

    /** web variables*/
    private WebView videoWebView;

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
                DialogPopup();

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

    public void DialogPopup(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
//set icon
                .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                .setTitle("Are you sure to Exit")
//set message
                .setMessage("Exiting will call finish() method")
//set positive button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        finish();
                    }
                })
//set negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what should happen when negative button is clicked
                        Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_infor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        videoWebView = findViewById(R.id.videoWebView);

        ProgressDialog dialog = new ProgressDialog(this); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading");
        dialog.setMessage("Loading. Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(true);

            dialog.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                videoWebView.loadUrl("https://www.youtube.com/playlist?list=PLGSyN6ppM__r5B3enyCy0HDpeLSzhM0Mo");
                videoWebView.setWebViewClient(new WebViewClient());
                WebSettings webSettings = videoWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                dialog.dismiss();
            }
        }, 5000);


    }

    @Override
    public void onBackPressed() {
        if (videoWebView.canGoBack()){
            videoWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }



}
