package com.example.funquiz;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class Materiactivity extends AppCompatActivity {

    private TextView currentSelectedCategory = null;
    private FrameLayout currentSelectedBottomNav = null;
    private static final String TAG = "MateriactivityDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiactivity);

        // 🔹 Inisialisasi navigasi atas
        TextView navAll = findViewById(R.id.nav_quiz);
        TextView navHistory = findViewById(R.id.nav_history);
        TextView navScience = findViewById(R.id.nav_science);
        TextView navSport = findViewById(R.id.nav_sport);
        TextView navFood = findViewById(R.id.nav_food);

        navAll.setOnClickListener(v -> {
            loadFragment(new Allcoursesfragment());
            setSelectedCategory(navAll);
        });

        navHistory.setOnClickListener(v -> {
            loadFragment(new HistoryFragment());
            setSelectedCategory(navHistory);
        });

        navScience.setOnClickListener(v -> {
            loadFragment(new ScienceFragment());
            setSelectedCategory(navScience);
        });

        navSport.setOnClickListener(v -> {
            loadFragment(new SportFragment());
            setSelectedCategory(navSport);
        });

        navFood.setOnClickListener(v -> {
            loadFragment(new FoodFragment());
            setSelectedCategory(navFood);
        });

        // 🔹 Load fragment awal
        loadFragment(new Allcoursesfragment());
        setSelectedCategory(navAll);

        // 🔹 Navigasi ikon Bottom
        ImageView iconNav = findViewById(R.id.icon_nav);
        ImageView homeNav = findViewById(R.id.homenav);
        ImageView profileNav = findViewById(R.id.profile);

        FrameLayout iconNavContainer = findViewById(R.id.icon_nav_container);
        FrameLayout homeNavContainer = findViewById(R.id.homenav_container);
        FrameLayout profileNavContainer = findViewById(R.id.profile_container);

        iconNav.setOnClickListener(v -> {
            // Tetap di halaman ini
            setSelectedBottomNav(iconNavContainer);
        });

        homeNav.setOnClickListener(v -> {
            startActivity(new Intent(Materiactivity.this, Homepage.class));
            setSelectedBottomNav(homeNavContainer);
        });

        profileNav.setOnClickListener(v -> {
            startActivity(new Intent(Materiactivity.this, ProfileActivity.class));
            setSelectedBottomNav(profileNavContainer);
        });

        // 🔹 Set default bottom selected
        setSelectedBottomNav(iconNavContainer);

        // 🔹 Efek blur untuk layer
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            View blurLayer = findViewById(R.id.blur_layer);
            RenderEffect blurEffect = RenderEffect.createBlurEffect(20f, 20f, Shader.TileMode.CLAMP);
            blurLayer.setRenderEffect(blurEffect);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void setSelectedCategory(TextView selectedView) {
        TextView[] categories = {
                findViewById(R.id.nav_quiz),
                findViewById(R.id.nav_history),
                findViewById(R.id.nav_science),
                findViewById(R.id.nav_sport),
                findViewById(R.id.nav_food)
        };

        for (TextView category : categories) {
            category.setBackground(null);
            category.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        }

        selectedView.setBackgroundResource(R.drawable.bg_nav_selected);
        selectedView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        currentSelectedCategory = selectedView;
    }

    private void setSelectedBottomNav(FrameLayout selectedNav) {
        FrameLayout[] navs = {
                findViewById(R.id.icon_nav_container),
                findViewById(R.id.homenav_container),
                findViewById(R.id.profile_container)
        };

        for (FrameLayout nav : navs) {
            nav.setBackground(null);
        }

        selectedNav.setBackgroundResource(R.drawable.bg_nav_selected);
        currentSelectedBottomNav = selectedNav;
    }
}
