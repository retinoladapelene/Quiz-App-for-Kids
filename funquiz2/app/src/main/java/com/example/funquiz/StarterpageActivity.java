package com.example.funquiz; // Mendefinisikan paket (package) tempat kelas ini berada, membantu dalam pengorganisasian kode.

import android.content.Intent; // Mengimpor kelas Intent, yang digunakan untuk memulai aktivitas lain atau berkomunikasi antar komponen.
import android.os.Bundle; // Mengimpor kelas Bundle, digunakan untuk menyimpan data state (keadaan) dari aktivitas.
import android.view.View; // Mengimpor kelas View, merupakan blok bangunan dasar untuk elemen UI.
import android.widget.ImageView; // Mengimpor kelas ImageView, komponen UI untuk menampilkan gambar.

import androidx.activity.EdgeToEdge; // Mengimpor kelas EdgeToEdge dari AndroidX, memungkinkan aplikasi untuk memanjang hingga ke tepi layar.
import androidx.appcompat.app.AppCompatActivity; // Mengimpor kelas AppCompatActivity dari AndroidX, kelas dasar untuk aktivitas yang menyediakan fitur kompatibilitas mundur.
import androidx.core.graphics.Insets; // Mengimpor kelas Insets dari AndroidX, merepresentasikan area yang tidak digunakan oleh konten UI (misalnya, status bar).
import androidx.core.view.ViewCompat; // Mengimpor kelas ViewCompat dari AndroidX, menyediakan metode kompatibilitas untuk View.
import androidx.core.view.WindowInsetsCompat; // Mengimpor kelas WindowInsetsCompat dari AndroidX, merepresentasikan insets jendela.

import com.example.funquiz.R; // Mengimpor kelas R, yang secara otomatis dihasilkan oleh Android dan berisi ID untuk sumber daya (resource) aplikasi seperti layout, gambar, dan string.

public class StarterpageActivity extends AppCompatActivity { // Mendefinisikan kelas publik bernama StarterpageActivity yang mewarisi (extends) dari AppCompatActivity.

    @Override // Menandakan bahwa metode ini mengesampingkan (override) metode dari kelas induk.
    protected void onCreate(Bundle savedInstanceState) { // Metode onCreate dipanggil saat aktivitas pertama kali dibuat. Bundle savedInstanceState digunakan untuk mengembalikan data jika aktivitas dibuat ulang.
        super.onCreate(savedInstanceState); // Memanggil implementasi metode onCreate dari kelas induk (AppCompatActivity).
        // Mengaktifkan fitur EdgeToEdge untuk tampilan layar penuh
        EdgeToEdge.enable(this); // Mengaktifkan mode EdgeToEdge untuk aktivitas ini, membuat konten dapat ditampilkan di belakang system bars.
        // Menetapkan layout XML untuk aktivitas ini
        setContentView(R.layout.starterpage); // Menetapkan file layout XML (starterpage.xml) sebagai tampilan (UI) untuk aktivitas ini.

        // Menangani insets sistem (status bar, navigation bar) untuk menghindari tumpang tindih UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { // Menetapkan listener untuk menangani insets jendela pada View dengan ID 'main'.
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Mendapatkan insets untuk system bars (status bar dan navigation bar).
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Mengatur padding pada View 'main' sesuai dengan ukuran system bars agar konten tidak tertutup.
            return insets; // Mengembalikan insets yang sudah ditangani.
        });

        // Menginisialisasi ImageView (tombol "Get Started") dari layout
        ImageView getStartedButton = findViewById(R.id.myImageView); // Menemukan (find) View dengan ID 'myImageView' dari layout dan menginisialisasikannya sebagai ImageView.

        // Menetapkan OnClickListener untuk tombol "Get Started"
        getStartedButton.setOnClickListener(new View.OnClickListener() { // Menetapkan listener klik pada ImageView 'getStartedButton'.
            @Override
            // Menandakan bahwa metode ini mengesampingkan metode dari antarmuka (interface) View.OnClickListener.
            public void onClick(View v) { // Metode onClick akan dipanggil ketika ImageView diklik.
                // Membuat Intent untuk berpindah ke Loginpage
                Intent intent = new Intent(StarterpageActivity.this, Loginpage.class); // Membuat objek Intent baru. Argumen pertama adalah konteks saat ini (StarterpageActivity), argumen kedua adalah kelas aktivitas tujuan (Loginpage).
                // Memulai aktivitas Loginpage
                startActivity(intent); // Memulai aktivitas yang ditentukan oleh Intent.
                // Opsi: Menutup StarterPage agar tidak bisa kembali ke halaman ini setelah login
                // finish(); // (Komentar) Ini adalah baris opsional. Jika diaktifkan, aktivitas StarterpageActivity akan ditutup setelah berpindah ke Loginpage, sehingga pengguna tidak bisa kembali ke StarterpageActivity dengan tombol 'back'.
            }
        });
    }
}