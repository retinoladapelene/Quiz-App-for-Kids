package com.example.funquiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomCurvedBottomNavigationView extends View {

    private Paint navPaint;
    private Path navPath;

    private float centerX = 0f; // Posisi X tengah floating button

    public CustomCurvedBottomNavigationView(Context context) {
        super(context);
        init();
    }

    public CustomCurvedBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCurvedBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        navPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        navPaint.setColor(Color.parseColor("#212121")); // Warna hitam navigasi
        navPaint.setStyle(Paint.Style.FILL);

        navPath = new Path();
    }

    // Metode untuk mengatur posisi floating button (dari Activity utama)
    public void setFloatingButtonPosition(float x) {
        this.centerX = x;
        invalidate(); // Memaksa View untuk digambar ulang
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Atur posisi awal centerX di sini jika Anda ingin default yang spesifik,
        // misal di tengah-tengah item pertama.
        // if (centerX == 0f) {
        //     centerX = w / 6f; // Contoh: perkiraan tengah item pertama dari 3 item
        // }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        navPath.reset();

        float navBarHeight = getHeight(); // Tinggi total View kustom
        float curveHeight = 40f; // Ketinggian lekukan dari atas nav bar (kedalaman lekukan)
        float curveWidth = 60f; // Lebar lekukan di bagian atas

        // Posisi awal dan akhir lengkungan di bagian atas
        float startCurveX = centerX - (curveWidth / 2f) - 30f; // Sesuaikan offset untuk membuat lengkungan lebih halus
        float endCurveX = centerX + (curveWidth / 2f) + 30f; // Sesuaikan offset

        // Menggambar bentuk utama bilah navigasi dengan lekukan
        navPath.moveTo(0f, curveHeight); // Mulai dari kiri atas (dengan offset ke bawah)
        navPath.lineTo(startCurveX, curveHeight); // Garis lurus ke titik awal lekukan

        // Bagian lengkungan (Bezier curve)
        // Control point 1 (di kiri atas lengkungan)
        navPath.cubicTo(
                centerX - curveWidth, curveHeight, // x1, y1
                centerX - curveWidth - 10f, 0f, // x2, y2 - mendekati tepi atas untuk kurva
                centerX, 0f // x3, y3 - titik tengah lengkungan di paling atas
        );

        // Control point 2 (di kanan atas lengkungan)
        navPath.cubicTo(
                centerX + curveWidth + 10f, 0f, // x1, y1
                centerX + curveWidth, curveHeight, // x2, y2
                endCurveX, curveHeight // x3, y3 - titik akhir lekukan
        );

        navPath.lineTo(getWidth(), curveHeight); // Garis lurus ke kanan atas
        navPath.lineTo(getWidth(), navBarHeight); // Garis ke kanan bawah
        navPath.lineTo(0f, navBarHeight); // Garis ke kiri bawah
        navPath.close(); // Tutup path

        canvas.drawPath(navPath, navPaint);
    }
}