package com.example.nm.Others;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.nm.Adapter.SectionStatePagerAdapter;
import com.example.nm.MainActivity;
import com.example.nm.Others.fragment.Fragment_Disease;
import com.example.nm.Others.fragment.Fragment_Main;
import com.example.nm.R;

public class Information extends AppCompatActivity {

    private SectionStatePagerAdapter msectionStatePagerAdapter;
    private ViewPager mviewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this allows you to attach the fragment to the activity
        msectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        mviewPager = (ViewPager) findViewById(R.id.container);
        //setup view pager
        setupViewPager(mviewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Main(), "Main Fragment");
        adapter.addFragment(new Fragment_Disease(), "Fragment_disease");
        adapter.addFragment(new Fragment_Disease(), "Fragment_disease");
        viewPager.setAdapter(adapter);
    }

    //Method to change fragements from one fragment to another

    public void setViewPager(int fragment){
        mviewPager.setCurrentItem(fragment);
    }


    //....................................................................................................
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                Intent aboutIntent = new Intent(Information.this, About.class);
                startActivity(aboutIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateCard(this); //fire the slide left animation
    }
}
