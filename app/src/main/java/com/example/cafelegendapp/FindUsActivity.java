package com.example.cafelegendapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class FindUsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    Bundle extras;

    ImageView logoIV;
    TextView nameTV;
    TextView companyNameTV;
    TextView addressTV;

    void init(){
        logoIV = findViewById(R.id.logoIV);
        nameTV = findViewById(R.id.cafe_name);
        companyNameTV = findViewById(R.id.company_name);
        addressTV = findViewById(R.id.address);

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);

        extras = getIntent().getExtras();
    }

    void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_us);
        init();
        setupDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("username", extras.getString("username").toString());
                startActivity(intent);
                finish();
                return true;

            case R.id.nav_items:
                Intent intent1 = new Intent(this, MenuActivity.class);
                intent1.putExtra("username", extras.getString("username").toString());
                startActivity(intent1);
                finish();
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