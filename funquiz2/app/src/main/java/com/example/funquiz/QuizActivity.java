package com.example.funquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.Map;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private ImageView questionImageview, quitButton;
    private RadioGroup answerGroup;
    private CircularCountdownView countdownView;

    private int questionIndex = 0;
    private int score = 0;
    private int correctCount = 0;
    private int wrongCount = 0;
    private static final int COUNTDOWN_SECONDS = 10;
    private int currentCountdownTime = COUNTDOWN_SECONDS;

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable questionEndRunnable;
    private Runnable countdownUpdateRunnable;

    private String[] questions;
    private String[][] options;
    private String[] correctAnswers;
    private int[] questionImages;
    private String quizType;

    private MediaPlayer bgMusicPlayer;
    private MediaPlayer correctSoundPlayer;
    private MediaPlayer wrongSoundPlayer;

    private static final String TAG = "QuizActivityDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.quizactivity);

        countdownView = findViewById(R.id.countdownView);
        questionImageview = findViewById(R.id.questionImage);
        questionTextView = findViewById(R.id.questionTextView);
        answerGroup = findViewById(R.id.answerGroup);
        quitButton = findViewById(R.id.quitButton);

        quizType = getIntent().getStringExtra("QUIZ_TYPE");
        if (quizType == null || quizType.isEmpty()) {
            Toast.makeText(this, "Kesalahan: Jenis kuis tidak ditemukan.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // 🔊 Inisialisasi musik dan efek suara
        bgMusicPlayer = MediaPlayer.create(this, R.raw.bgmusic);
        bgMusicPlayer.setLooping(true);
        bgMusicPlayer.start();

        correctSoundPlayer = MediaPlayer.create(this, R.raw.correct);
        wrongSoundPlayer = MediaPlayer.create(this, R.raw.wrong);

        loadQuizData(quizType);
        if (questions == null || questions.length == 0) {
            Toast.makeText(this, "Kesalahan: Data kuis tidak tersedia.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        loadQuestion();

        quitButton.setOnClickListener(v -> showQuitConfirmationDialog());
    }

    private void loadQuestion() {
        cancelCountdown();

        if (questionIndex >= questions.length) {
            showFinalScore();
            return;
        }

        questionImageview.setImageResource(questionImages[questionIndex]);
        questionTextView.setText(questions[questionIndex]);
        questionTextView.setGravity(Gravity.START);

        answerGroup.clearCheck();
        answerGroup.removeAllViews();

        for (String option : options[questionIndex]) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setPadding(0, 17, 0, 20);
            radioButton.setTextSize(20);
            radioButton.setTextColor(ContextCompat.getColor(this, android.R.color.black));
            radioButton.setButtonDrawable(android.R.color.transparent);
            radioButton.setBackgroundResource(R.drawable.radiobutton2);

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, (int) (30 * getResources().getDisplayMetrics().density));
            radioButton.setLayoutParams(params);

            answerGroup.addView(radioButton);
        }

        answerGroup.setOnCheckedChangeListener((group, checkedId) -> {
            group.setOnCheckedChangeListener(null);
            cancelCountdown();

            for (int i = 0; i < group.getChildCount(); i++) {
                RadioButton rb = (RadioButton) group.getChildAt(i);
                String answerText = rb.getText().toString();

                if (rb.getId() == checkedId) {
                    if (answerText.equals(correctAnswers[questionIndex])) {
                        rb.setBackgroundResource(R.drawable.buttonbenar);
                        rb.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                        score++;
                        correctCount++;
                        if (correctSoundPlayer != null) correctSoundPlayer.start();
                    } else {
                        rb.setBackgroundResource(R.drawable.buttonsalah);
                        rb.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                        wrongCount++;
                        if (wrongSoundPlayer != null) wrongSoundPlayer.start();
                    }
                    rb.setTextSize(24);
                    rb.setAlpha(0.9f);
                } else if (answerText.equals(correctAnswers[questionIndex])) {
                    rb.setBackgroundResource(R.drawable.buttonbenar);
                    rb.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                    rb.setTextSize(24);
                    rb.setAlpha(0.9f);
                    rb.setVisibility(View.VISIBLE);
                } else {
                    rb.setVisibility(View.GONE);
                }
            }

            handler.postDelayed(this::nextQuestion, 1000);
        });

        startCountdownLogic();
    }

    private void startCountdownLogic() {
        currentCountdownTime = COUNTDOWN_SECONDS;
        if (countdownView != null) countdownView.startCountdown(COUNTDOWN_SECONDS);

        countdownUpdateRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentCountdownTime >= 0) {
                    if (countdownView != null) {
                        countdownView.updateElapsedTime(COUNTDOWN_SECONDS - currentCountdownTime);
                    }
                    currentCountdownTime--;
                    if (currentCountdownTime >= 0) {
                        handler.postDelayed(this, 1000);
                    }
                }
            }
        };

        questionEndRunnable = () -> {
            if (answerGroup.getCheckedRadioButtonId() == -1) {
                answerGroup.setOnCheckedChangeListener(null);
                for (int i = 0; i < answerGroup.getChildCount(); i++) {
                    RadioButton rb = (RadioButton) answerGroup.getChildAt(i);
                    String answerText = rb.getText().toString();
                    if (answerText.equals(correctAnswers[questionIndex])) {
                        rb.setBackgroundResource(R.drawable.buttonbenar);
                        rb.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                        rb.setTextSize(24);
                        rb.setAlpha(0.9f);
                        rb.setVisibility(View.VISIBLE);
                    } else {
                        rb.setVisibility(View.GONE);
                    }
                }
                wrongCount++;
                if (wrongSoundPlayer != null) wrongSoundPlayer.start();
                handler.postDelayed(this::nextQuestion, 1000);
            }
        };

        handler.post(countdownUpdateRunnable);
        handler.postDelayed(questionEndRunnable, COUNTDOWN_SECONDS * 1000L);
    }

    private void cancelCountdown() {
        handler.removeCallbacks(countdownUpdateRunnable);
        handler.removeCallbacks(questionEndRunnable);
    }

    private void nextQuestion() {
        cancelCountdown();
        questionIndex++;
        if (questionIndex < questions.length) {
            loadQuestion();
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            Map<String, Object> quizData = new HashMap<>();
            quizData.put("score", score);
            quizData.put("total_questions", questions.length);
            quizData.put("quiz_type", quizType);
            quizData.put("correct", correctCount);
            quizData.put("wrong", wrongCount);
            quizData.put("timestamp", Timestamp.now());

            db.collection("quiz_progress")
                    .document(userId)
                    .collection("attempts")
                    .add(quizData)
                    .addOnSuccessListener(documentReference -> {
                        navigateToFinalScore();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Gagal menyimpan skor ke Firestore!", Toast.LENGTH_SHORT).show();
                        navigateToFinalScore();
                    });
        } else {
            Toast.makeText(this, "Anda tidak login, skor tidak disimpan.", Toast.LENGTH_LONG).show();
            navigateToFinalScore();
        }
    }

    private void navigateToFinalScore() {
        Intent intent = new Intent(QuizActivity.this, Finalscore.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS", questions.length);
        intent.putExtra("Quiztype", quizType);
        intent.putExtra("CORRECT_COUNT", correctCount);
        intent.putExtra("WRONG_COUNT", wrongCount);
        startActivity(intent);
        finish();
    }

    private void showQuitConfirmationDialog() {
        cancelCountdown();
        new AlertDialog.Builder(this)
                .setMessage("Yakin ingin keluar? Progres kuis tidak akan disimpan.")
                .setPositiveButton("Ya", (dialog, id) -> {
                    Intent intent = new Intent(this, Homepage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Tidak", (dialog, id) -> {
                    dialog.dismiss();
                    startCountdownLogic();
                }).show();
    }

    @Override
    public void onBackPressed() {
        showQuitConfirmationDialog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bgMusicPlayer != null && bgMusicPlayer.isPlaying()) {
            bgMusicPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bgMusicPlayer != null) {
            bgMusicPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        if (bgMusicPlayer != null) {
            if (bgMusicPlayer.isPlaying()) bgMusicPlayer.stop();
            bgMusicPlayer.release();
        }
        if (correctSoundPlayer != null) correctSoundPlayer.release();
        if (wrongSoundPlayer != null) wrongSoundPlayer.release();
    }

    private void loadQuizData(String type) {
        // Log untuk memastikan tipe kuis yang dimuat
        Log.d(TAG, "Loading quiz data for type: " + type);
        switch (type) {
            case "sport":
                questions = new String[]{
                        "Olahraga apa yang menggunakan bola kecil dan tongkat untuk memukulnya di lapangan hijau?",
                        "Berapa jumlah pemain dalam satu tim sepak bola di lapangan saat pertandingan?",
                        "Apa nama olahraga yang melibatkan berenang, bersepeda, dan berlari dalam satu kompetisi?",
                        "Dalam olahraga basket, berapa poin yang diberikan untuk tembakan dari luar garis tiga poin?",
                        "Olahraga apa yang dimainkan di atas meja dengan bola kecil dan raket kecil?",
                        "Apa nama olahraga yang menggunakan papan seluncur di atas ombak laut?",
                        "Berapa poin yang diperlukan untuk memenangkan satu set dalam bulu tangkis?",
                        "Olahraga apa yang melibatkan memanjat dinding atau tebing?",
                        "Olahraga apa yang dimainkan dengan bola besar di kolam renang?",
                        "Apa nama olahraga yang menggunakan pedang sebagai alat utama?",
                };
                options = new String[][]{
                        {"Golf", "Tenis", "Bola Basket", "Bola Voli"},
                        {"5", "7", "11", "9"},
                        {"Triathlon", "Maraton", "Sepak Bola", "Rugby"},
                        {"1 poin", "2 poin", "3 poin", "4 poin"},
                        {"Tenis Meja", "Bulu Tangkis", "Squash", "Ping Pong"},
                        {"Surfing", "Skateboarding", "Snowboarding", "Kitesurfing"},
                        {"15 poin", "21 poin", "25 poin", "30 poin"},
                        {"Panjat Tebing", "Bouldering", "Free Climbing", "Caving"},
                        {"Water Polo", "Renang Sinkronisasi", "Selam Permukaan", "Polo Air"},
                        {"Anggar", "Kendo", "Taekwondo", "Judo"}
                };
                correctAnswers = new String[]{
                        "Golf", "11", "Triathlon", "3 poin", "Tenis Meja", "Surfing", "21 poin", "Panjat Tebing", "Polo Air", "Anggar"
                };
                questionImages = new int[]{
                        R.drawable.golf, R.drawable.sepakbola, R.drawable.thriathlon, R.drawable.basket,
                        R.drawable.tenismeja, R.drawable.surfing, R.drawable.badminton, R.drawable.panjattebing,
                        R.drawable.poloair, R.drawable.anggar
                };
                break;
            case "science":
                questions = new String[]{
                        "Apa planet terdekat dengan Matahari?",
                        "Apa unit dasar kehidupan?",
                        "Apa simbol kimia untuk air?",
                        "Bagian tumbuhan mana yang melakukan fotosintesis?",
                        "Apa gaya yang menarik benda ke pusat Bumi?",
                        "Gas apa yang dibutuhkan manusia untuk bernapas?",
                        "Apa nama galaksi tempat tata surya kita berada?",
                        "Apa tulang terpanjang di tubuh manusia?",
                        "Apa satuan ukuran energi?",
                        "Apa warna dari darah yang mengandung oksigen?",
                };
                options = new String[][]{
                        {"Mars", "Venus", "Merkurius", "Bumi"},
                        {"Atom", "Molekul", "Sel", "Organ"},
                        {"O2", "H2O", "CO2", "NaCl"},
                        {"Akar", "Batang", "Daun", "Bunga"},
                        {"Gaya Gesek", "Gaya Angkat", "Gaya Gravitasi", "Gaya Magnet"},
                        {"Karbon Dioksida", "Nitrogen", "Oksigen", "Hidrogen"},
                        {"Andromeda", "Bima Sakti", "Triangulum", "Centaurus A"},
                        {"Tibia", "Fibula", "Femur", "Radius"},
                        {"Watt", "Volt", "Joule", "Ampere"},
                        {"Biru", "Merah Terang", "Ungu", "Hitam"},
                };
                correctAnswers = new String[]{
                        "Merkurius", "Sel", "H2O", "Daun", "Gaya Gravitasi", "Oksigen", "Bima Sakti", "Femur", "Joule", "Merah Terang"
                };
                questionImages = new int[]{
                        R.drawable.tatasurya, R.drawable.cell, R.drawable.water, R.drawable.leaf,
                        R.drawable.gravity, R.drawable.oxygen, R.drawable.milkyway, R.drawable.kerangka,
                        R.drawable.energi, R.drawable.blood
                };
                break;
            case "history":
                questions = new String[]{
                        "Siapakah penemu bola lampu pijar?",
                        "Perang Dunia I dimulai pada tahun berapa?",
                        "Siapakah Firaun perempuan yang terkenal di Mesir kuno?",
                        "Apa nama tembok besar yang dibangun di Tiongkok?",
                        "Revolusi Industri dimulai di negara mana?",
                        "Siapakah penulis 'Romeo dan Juliet'?",
                        "Kapan proklamasi kemerdekaan Indonesia dibacakan?",
                        "Siapakah presiden pertama Amerika Serikat?",
                        "Peristiwa penting apa yang terjadi pada tahun 1492?",
                        "Siapakah pemimpin yang memimpin Uni Soviet selama Perang Dunia II?",
                };
                options = new String[][]{
                        {"Nikola Tesla", "Thomas Edison", "Alexander Graham Bell", "Marie Curie"},
                        {"1905", "1914", "1918", "1939"},
                        {"Nefertiti", "Hatshepsut", "Cleopatra", "Sobekneferu"},
                        {"Tembok Berlin", "Tembok Besar Cina", "Tembok Hadrian", "Tembok Ratapan"},
                        {"Prancis", "Jerman", "Inggris", "Amerika Serikat"},
                        {"Charles Dickens", "Jane Austen", "William Shakespeare", "Leo Tolstoy"},
                        {"17 Agustus 1945", "28 Oktober 1928", "20 Mei 1908", "1 Juni 1945"},
                        {"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"},
                        {"Penemuan Amerika oleh Columbus", "Revolusi Prancis", "Pengeboman Hiroshima", "Akhir Perang Dunia II"},
                        {"Vladimir Lenin", "Joseph Stalin", "Nikita Khrushchev", "Mikhail Gorbachev"},
                };
                correctAnswers = new String[]{
                        "Thomas Edison", "1914", "Cleopatra", "Tembok Besar Cina", "Inggris", "William Shakespeare", "17 Agustus 1945", "George Washington", "Penemuan Amerika oleh Columbus", "Joseph Stalin"
                };
                questionImages = new int[]{
                        R.drawable.thomas, R.drawable.ww1, R.drawable.cleopatra, R.drawable.greatwall,
                        R.drawable.insdutri, R.drawable.romeo, R.drawable.proklamasi, R.drawable.george,
                        R.drawable.colombus, R.drawable.stalin
                };
                break;
            case "food":
                questions = new String[]{
                        "Dari negara mana asal hidangan pasta?",
                        "Buah apa yang digunakan untuk membuat guacamole?",
                        "Apa nama roti pipih India yang sering dimakan dengan kari?",
                        "Dari mana asal cokelat?",
                        "Jenis keju apa yang biasa digunakan pada pizza Margherita?",
                        "Apa bahan utama dalam hidangan sushi?",
                        "Bumbu dapur apa yang dikenal sebagai 'emas merah' dan sangat mahal?",
                        "Dari negara mana asal minuman teh?",
                        "Sayuran akar apa yang sering digunakan untuk membuat kentang goreng?",
                        "Apa nama hidangan penutup Prancis yang terbuat dari telur, gula, dan krim?",
                };
                options = new String[][]{
                        {"Italia", "Prancis", "Spanyol", "Yunani"},
                        {"Tomat", "Alpukat", "Mangga", "Apel"},
                        {"Naan", "Pita", "Tortilla", "Roti Canai"},
                        {"Eropa", "Afrika", "Amerika Tengah dan Selatan", "Asia"},
                        {"Cheddar", "Parmesan", "Mozzarella", "Gouda"},
                        {"Nasi", "Ikan", "Rumput Laut", "Sayuran"},
                        {"Cengkeh", "Kayu Manis", "Kunyit", "Saffron"},
                        {"India", "Jepang", "Cina", "Inggris"},
                        {"Wortel", "Ubi Jalar", "Kentang", "Lobak"},
                        {"Tiramisu", "Crème brûlée", "Profiterole", "Macaron"},
                };
                correctAnswers = new String[]{
                        "Italia", "Alpukat", "Naan", "Amerika Tengah dan Selatan", "Mozzarella", "Nasi", "Saffron", "Cina", "Kentang", "Crème brûlée"
                };
                questionImages = new int[]{
                        R.drawable.pasta, R.drawable.guacamole, R.drawable.rotipipih, R.drawable.cokelat,
                        R.drawable.pizza, R.drawable.sushi, R.drawable.bumbu, R.drawable.teh,
                        R.drawable.kentang, R.drawable.cremebruele
                };
                break;
            default:
                Log.e(TAG, "Unknown quiz type: " + type);
                // Set questions, options, correctAnswers, questionImages to empty arrays
                // or null to trigger the check at the start of onCreate
                questions = new String[]{};
                options = new String[][]{};
                correctAnswers = new String[]{};
                questionImages = new int[]{};
                break;
        }
        if (questions == null || questions.length == 0) {
            Log.e(TAG, "Quiz data is empty or null after loadQuizData for type: " + type);
        }
    }

    // NOTE: `loadQuizData()` method tetap sama seperti sebelumnya
}
