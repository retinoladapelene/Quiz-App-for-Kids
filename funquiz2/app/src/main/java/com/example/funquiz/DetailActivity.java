package com.example.funquiz;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage, quitButton, btnRead;
    private TextView detailTitle, detailDescription, detailTitlehistory, detailHistory, titledetailExtra, detailExtra;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi komponen UI
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        detailDescription = findViewById(R.id.detailDescription);
        detailTitlehistory = findViewById(R.id.detailTitlehistory);
        detailHistory = findViewById(R.id.detailHistory);
        detailExtra = findViewById(R.id.detailExtra);
        titledetailExtra = findViewById(R.id.TitleDetailExtra);
        quitButton = findViewById(R.id.quitButton);
        btnRead = findViewById(R.id.btn_read);

        // Ambil data dari Intent
        Intent intent = getIntent();
        int imageRes = intent.getIntExtra("imageRes", R.drawable.pizza);
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String titleHistory = intent.getStringExtra("titleHistory");
        String titleExtra = intent.getStringExtra("titleExtra"); // Renamed variable
        String history = intent.getStringExtra("history");
        String extra = intent.getStringExtra("extra");

        // Tampilkan data ke UI
        detailImage.setImageResource(imageRes);
        detailTitle.setText(title);
        detailDescription.setText(description);
        detailTitlehistory.setText(titleHistory);
        detailHistory.setText(history);
        titledetailExtra.setText(titleExtra); // Updated to use renamed variable
        detailExtra.setText(extra);

        // Fungsi tombol Quit
        quitButton.setOnClickListener(v -> finish());

        // Inisialisasi TextToSpeech
        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setLanguage(new Locale("id", "ID")); // Bahasa Indonesia
            }
        });

        // Fungsi tombol Read Aloud membaca semua teks dari TextView
        btnRead.setOnClickListener(v -> {
            StringBuilder fullText = new StringBuilder();

            if (detailTitle.getText() != null) {
                fullText.append(detailTitle.getText().toString()).append(". ");
            }
            if (detailDescription.getText() != null) {
                fullText.append(detailDescription.getText().toString()).append(". ");
            }
            if (detailTitlehistory.getText() != null) {
                fullText.append(detailTitlehistory.getText().toString()).append(". ");
            }
            if (detailHistory.getText() != null) {
                fullText.append(detailHistory.getText().toString()).append(". ");
            }
            if (titledetailExtra.getText() != null) {
                fullText.append(titledetailExtra.getText().toString()).append(". ");
            }
            if (detailExtra.getText() != null) {
                fullText.append(detailExtra.getText().toString());
            }

            textToSpeech.speak(fullText.toString(), TextToSpeech.QUEUE_FLUSH, null, null);
        });

    }

    @Override
    protected void onDestroy() {
        // Matikan TextToSpeech saat activity ditutup
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}