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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Homepage extends AppCompatActivity {

    private CircularCountdownView sportLastScoreProgress;
    private CircularCountdownView scienceLastScoreProgress;
    private CircularCountdownView historyLastScoreProgress;
    private CircularCountdownView foodLastScoreProgress;

    private static final String TAG = "HomepageDebug";
    private FrameLayout currentSelectedBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Bottom Navigation Setup
        ImageView iconNav = findViewById(R.id.icon_nav);
        ImageView homeNav = findViewById(R.id.homenav);
        ImageView profileNav = findViewById(R.id.profile);

        FrameLayout iconNavContainer = findViewById(R.id.icon_nav_container);
        FrameLayout homeNavContainer = findViewById(R.id.homenav_container);
        FrameLayout profileNavContainer = findViewById(R.id.profile_container);

        homeNav.setOnClickListener(v -> setSelectedBottomNav(homeNavContainer));
        iconNav.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, Materiactivity.class));
            setSelectedBottomNav(iconNavContainer);
        });
        profileNav.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, ProfileActivity.class));
            setSelectedBottomNav(profileNavContainer);
        });

        // Default selected nav
        setSelectedBottomNav(homeNavContainer);

        // Blur Layer (Android 12+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            View blurLayer = findViewById(R.id.blur_layer);
            blurLayer.setRenderEffect(RenderEffect.createBlurEffect(20f, 20f, Shader.TileMode.CLAMP));
        }

        // Setup greeting
        TextView halloTextView = findViewById(R.id.hallo);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String userName = account.getDisplayName();
            halloTextView.setText("Hallo, " + (userName != null ? userName : "User") + "!");
            Log.d(TAG, "Google User logged in: " + userName);
        } else {
            halloTextView.setText("Hallo!");
            Log.d(TAG, "No Google user detected.");
        }

        // Firebase user check
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            Log.d(TAG, "Firebase User ID: " + currentUser.getUid());
        } else {
            Log.w(TAG, "No Firebase user logged in.");
        }

        // Circular Score Views
        sportLastScoreProgress = findViewById(R.id.sport_last_score_progress);
        scienceLastScoreProgress = findViewById(R.id.science_last_score_progress);
        historyLastScoreProgress = findViewById(R.id.history_last_score_progress);
        foodLastScoreProgress = findViewById(R.id.food_last_score_progress);

        // Quiz card click actions
        findViewById(R.id.sportquiz).setOnClickListener(v -> startQuiz("sport"));
        findViewById(R.id.sciencequiz).setOnClickListener(v -> startQuiz("science"));
        findViewById(R.id.foodquiz).setOnClickListener(v -> startQuiz("food"));
        findViewById(R.id.historyquiz).setOnClickListener(v -> startQuiz("history"));

        loadAllLastScores();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Homepage onResume called. Refreshing scores.");
        loadAllLastScores();
    }

    private void startQuiz(String quizType) {
        Intent intent = new Intent(Homepage.this, QuizActivity.class);
        intent.putExtra("QUIZ_TYPE", quizType);
        startActivity(intent);
    }

    private void loadAllLastScores() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Log.w(TAG, "User not logged in. Skipping score load.");
            sportLastScoreProgress.setProgressPercentage(0);
            scienceLastScoreProgress.setProgressPercentage(0);
            historyLastScoreProgress.setProgressPercentage(0);
            foodLastScoreProgress.setProgressPercentage(0);
            return;
        }

        Log.d(TAG, "Fetching scores for user: " + user.getUid());
        loadLastScoreFromFirestore("sport", sportLastScoreProgress);
        loadLastScoreFromFirestore("science", scienceLastScoreProgress);
        loadLastScoreFromFirestore("history", historyLastScoreProgress);
        loadLastScoreFromFirestore("food", foodLastScoreProgress);
    }

    private void loadLastScoreFromFirestore(String quizType, CircularCountdownView progressView) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            progressView.setProgressPercentage(0);
            return;
        }

        String userId = user.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("quiz_progress")
                .document(userId)
                .collection("attempts")
                .whereEqualTo("quiz_type", quizType)
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .limit(1)
                .get()
                .addOnSuccessListener(snapshots -> {
                    if (!snapshots.isEmpty()) {
                        DocumentSnapshot doc = snapshots.getDocuments().get(0);
                        Long score = doc.getLong("score");
                        Long total = doc.getLong("total_questions");

                        if (score != null && total != null && total > 0) {
                            int percentage = (int) Math.round((double) score / total * 100);
                            progressView.setProgressPercentage(percentage);
                        } else {
                            progressView.setProgressPercentage(0);
                        }
                    } else {
                        progressView.setProgressPercentage(0);
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "Error loading score for " + quizType, e);
                    progressView.setProgressPercentage(0);
                });
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
}
