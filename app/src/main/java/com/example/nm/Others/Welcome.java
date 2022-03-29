package com.example.nm.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.nm.MainActivity;
import com.example.nm.R;

public class Welcome extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView textlogo;
    TextView mototext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);


        /** Initialize Animators  */
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.buttom_animation);

        /** Initialize variables */
        image = findViewById(R.id.leafimage);
        textlogo = findViewById(R.id.textleaf);
        mototext = findViewById(R.id.moto);

        /** set welcome animation on image and texts  */
        image.setAnimation(topAnim);
        textlogo.setAnimation(bottomAnim);
        mototext.setAnimation(bottomAnim);

        /** set Action just in case user goes to the welcome screen when back button is pressed on the main menu */



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startMainActivity();
            }
        }, 5000);   //5 seconds
    }
    //method to start main activity.Takes you to the menu
    public void startMainActivity(){
        Intent mainIntent = new Intent(Welcome.this, MainActivity.class);
        startActivity(new Intent(this, MainActivity.class));
        Animatoo.animateCard(this);
    }

}
