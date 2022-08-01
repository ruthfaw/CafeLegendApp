package com.example.cafelegendapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    TextView welcomeMessageTV;
    Bundle extras;

    void init(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);
        welcomeMessageTV = findViewById(R.id.welcome_message);
    }

    void setupDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    void changeText(){
        extras = getIntent().getExtras();
        welcomeMessageTV.setText("Welcome, " + extras.getString("username").toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        setupDrawer();
        changeText();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
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


//    private static void redirectActivity(Activity activity, Class aClass){
//        Intent intent = new Intent(activity, aClass);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        activity.startActivity(intent);
//    }
}