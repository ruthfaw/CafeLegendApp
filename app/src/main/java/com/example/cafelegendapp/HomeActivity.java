package com.example.cafelegendapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cafelegendapp.databinding.ActivityHomeBinding;
import com.example.cafelegendapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    TextView welcomeMessageTV;
    Bundle extras;

    ActivityHomeBinding binding;
    SliderAdapter adapter;
    int currentImage;

    Handler sliderhandler = new Handler();
    ViewPager2 viewPager2;

    //TextView[] dots;
    //int realSliderPosition;

    void init() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);
        welcomeMessageTV = findViewById(R.id.welcome_message);
        viewPager2 = findViewById(R.id.vpSlider);
    }

    void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    void changeText() {
        extras = getIntent().getExtras();
        welcomeMessageTV.setText("Welcome, " + extras.getString("username").toString());
    }

    private void initSlider() {
        adapter = new SliderAdapter(this, getImages(), viewPager2);
        binding.vpSlider.setAdapter(adapter);

        initButtons();
        binding.vpSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentImage = position;
                sliderhandler.removeCallbacks(sliderRunnable);
                sliderhandler.postDelayed(sliderRunnable, 5000);
            }
        });

//        List<Integer> list = getImages();
//        dots = new TextView[list.size()];
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

//    private void transitionDots(){
//        for(int i=0;i< dots.length;i++){
//            if(i==realSliderPosition){
//                dots[i].setBackgroundResource(R.drawable.indicator1);
//            }else{
//                dots[i].setBackgroundResource(R.drawable.inidicator0);
//            }
//        }
//    }

//    private void initDotsLayout(){
//        binding.dotsLayout.removeAllViews();
//        for (int i=0;i<dots.length;i++){
//            dots[i] = new TextView(this);
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20, 20);
//            params.setMargins(4, 4, 4, 4);
//            dots[i].setLayoutParams(params);
//            dots[i].setBackgroundResource(R.drawable.inidicator0);
//            binding.dotsLayout.addView(dots[i]);
//        }
//    }

    private void initButtons() {
        currentImage = 0;
        binding.ivNextRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        binding.ivPreviousLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
    }

    private void next() {
        currentImage++;
        if(currentImage== adapter.getItemCount()){
            currentImage = 0;
        }
        binding.vpSlider.setCurrentItem(currentImage);
    }

    private void previous() {
        currentImage--;
        if(currentImage+1==0){
            binding.vpSlider.setCurrentItem(adapter.getItemCount()-1);
        }else{
            binding.vpSlider.setCurrentItem(currentImage);
        }
    }

    private List<Integer> getImages() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.slider_1);
        list.add(R.drawable.slider_2);
        list.add(R.drawable.slider_3);
        list.add(R.drawable.slider_4);
        list.add(R.drawable.slider_5);
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setupDrawer();
        changeText();
        initSlider();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_items:
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                return true;

            case R.id.nav_findUs:
                Intent intent1 = new Intent(this, FindUsActivity.class);
                startActivity(intent1);
                return true;

            case R.id.nav_logout:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                finish();
                return true;
        }
        return false;
    }
}


