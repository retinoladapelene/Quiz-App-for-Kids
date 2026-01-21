package com.example.funquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Finalscore extends AppCompatActivity {

    private ProgressBar scoreProgressBar;
    private TextView percentageTextView, correctTextView, wrongTextView;
    private String quizType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        quizType = getIntent().getStringExtra("Quiztype");

        scoreProgressBar = findViewById(R.id.scoreProgressBar);
        percentageTextView = findViewById(R.id.percentageTextView);
        correctTextView = findViewById(R.id.correctTextView);
        wrongTextView = findViewById(R.id.wrongTextView);
        ImageView playAgainButton = findViewById(R.id.playAgainButton);
        ImageView backhomeButton = findViewById(R.id.backhomeButton);

        // Tombol main lagi
        playAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(Finalscore.this, QuizActivity.class);
            intent.putExtra("QUIZ_TYPE", quizType);
            startActivity(intent);
            finish();
        });

        // Tombol kembali ke homepage
        backhomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Finalscore.this, Homepage.class);
            startActivity(intent);
            finish();
        });

        loadScoreFromFirestore();
    }

    private void loadScoreFromFirestore() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) return;

        String userId = user.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("quiz_progress")
                .document(userId)
                .collection("attempts")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .limit(1)
                .get()
                .addOnSuccessListener(querySnapshots -> {
                    if (!querySnapshots.isEmpty()) {
                        DocumentSnapshot doc = querySnapshots.getDocuments().get(0);

                        Long scoreLong = doc.getLong("score");
                        Long correctLong = doc.getLong("correct");
                        Long wrongLong = doc.getLong("wrong");

                        int score = (scoreLong != null) ? scoreLong.intValue() : 0;
                        int correct = (correctLong != null) ? correctLong.intValue() : 0;
                        int wrong = (wrongLong != null) ? wrongLong.intValue() : 0;
                        int total = correct + wrong;
                        if (total == 0) total = 1;

                        int percentage = (int) Math.round(((double) score / total) * 100);

                        // Update UI
                        correctTextView.setText("BENAR \n\n     " + correct);
                        wrongTextView.setText("SALAH \n\n     " + wrong);
                        percentageTextView.setText(percentage + "%");
                        scoreProgressBar.setProgress(percentage);

                        animatePercentagePosition(percentage);
                    } else {
                        showEmptyScore();
                    }
                })
                .addOnFailureListener(e -> {
                    showEmptyScore();
                });
    }

    private void showEmptyScore() {
        correctTextView.setText("Benar: -");
        wrongTextView.setText("Salah: -");
        percentageTextView.setText("0%");
        scoreProgressBar.setProgress(0);
        animatePercentagePosition(0);
    }

    private void animatePercentagePosition(int percentage) {
        scoreProgressBar.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        scoreProgressBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        float bias = Math.min(1f, Math.max(0f, percentage / 100f));
                        ConstraintLayout.LayoutParams params =
                                (ConstraintLayout.LayoutParams) percentageTextView.getLayoutParams();
                        params.horizontalBias = bias;
                        percentageTextView.setLayoutParams(params);
                    }
                });
    }
}
