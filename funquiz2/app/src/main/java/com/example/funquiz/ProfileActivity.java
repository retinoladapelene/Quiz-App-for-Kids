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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivityDebug";
    private FrameLayout currentSelectedBottomNav;
    private TextView currentSelectedCategory;
    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        // Bottom Navigation
        FrameLayout iconNavContainer = findViewById(R.id.icon_nav_container);
        FrameLayout homeNavContainer = findViewById(R.id.homenav_container);
        FrameLayout profileNavContainer = findViewById(R.id.profile_container);

        findViewById(R.id.icon_nav).setOnClickListener(v -> {
            startActivity(new Intent(this, Materiactivity.class));
            finish();
        });

        findViewById(R.id.homenav).setOnClickListener(v -> {
            startActivity(new Intent(this, Homepage.class));
            finish();
        });

        findViewById(R.id.profile).setOnClickListener(v -> {
            setSelectedBottomNav(profileNavContainer);
            replaceFragment(new ProfileFragment());
        });

        setSelectedBottomNav(profileNavContainer);

        // Blur
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            View blurLayer = findViewById(R.id.blur_layer);
            if (blurLayer != null) {
                blurLayer.setRenderEffect(RenderEffect.createBlurEffect(20f, 20f, Shader.TileMode.CLAMP));
            }
        }

        // Tab Navigasi
        TextView profileTab = findViewById(R.id.profile_tab);
        TextView aboutTab = findViewById(R.id.about);

        profileTab.setOnClickListener(v -> {
            setSelectedCategory(profileTab);
            replaceFragment(new ProfileFragment());
        });

        aboutTab.setOnClickListener(v -> {
            setSelectedCategory(aboutTab);
            replaceFragment(new AboutAppFragment());
        });

        // Fragment default
        replaceFragment(new ProfileFragment());
        setSelectedCategory(profileTab);

        // Sign Out
        ImageView signOutButton = findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(v -> signOut());
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        googleSignInClient.signOut().addOnCompleteListener(this, task -> {
            Intent intent = new Intent(ProfileActivity.this, Loginpage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void setSelectedCategory(TextView selectedView) {
        TextView[] tabs = {
                findViewById(R.id.profile_tab),
                findViewById(R.id.about)
        };

        for (TextView tab : tabs) {
            tab.setBackground(null);
            tab.setTextColor(ContextCompat.getColor(this, android.R.color.black));
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

        if (selectedNav != null) {
            selectedNav.setBackgroundResource(R.drawable.bg_nav_selected);
            currentSelectedBottomNav = selectedNav;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelectedBottomNav(findViewById(R.id.profile_container));
    }
}
