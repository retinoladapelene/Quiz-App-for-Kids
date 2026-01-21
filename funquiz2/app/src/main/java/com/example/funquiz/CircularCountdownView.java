    package com.example.funquiz;

    import android.content.Context;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.RectF;
    import android.util.AttributeSet;
    import android.util.Log;
    import android.view.View;

    import androidx.annotation.Nullable;
    import androidx.core.content.ContextCompat; // Import this to get colors from resources

    public class CircularCountdownView extends View {

        private Paint circlePaint;
        private Paint progressArcPaint;
        private Paint textPaint;
        private RectF arcRect;

        private int countdownTime = 30; // Total time for countdown mode
        private int elapsedTime = 0;    // Elapsed time for countdown mode

        private boolean isPercentageMode = false;
        private int currentPercentage = 0; // Stores the percentage for display mode

        // --- NEW: Default progress color for percentage mode ---
        private int defaultProgressColor;
        private int defaultCircleColor;
        private int defaultTextColor;


        public CircularCountdownView(Context context) {
            super(context);
            init();
        }

        public CircularCountdownView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            // --- Added for custom attributes ---
            init();
            // You would typically read custom attributes here if you define them for colors directly in XML for this view.
            // For simplicity, we'll keep using the setters or direct color values.
        }

        private void init() {
            // Initialize default colors from resources
            defaultProgressColor = ContextCompat.getColor(getContext(), R.color.quiz_progress_color); // Use your new color
            defaultCircleColor = ContextCompat.getColor(getContext(), R.color.gray); // Use a gray from colors.xml or define if not present
            defaultTextColor = ContextCompat.getColor(getContext(), R.color.white); // Use black from colors.xml or define

            circlePaint = new Paint();
            circlePaint.setColor(defaultCircleColor); // Use default
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeWidth(10f);
            circlePaint.setAntiAlias(true);

            progressArcPaint = new Paint();
            progressArcPaint.setColor(defaultProgressColor); // Use default
            progressArcPaint.setStyle(Paint.Style.STROKE);
            progressArcPaint.setStrokeWidth(10f);
            progressArcPaint.setAntiAlias(true);
            progressArcPaint.setStrokeCap(Paint.Cap.ROUND);

            textPaint = new Paint();
            textPaint.setColor(defaultTextColor); // Use default
            textPaint.setTextSize(30f);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setAntiAlias(true);

            arcRect = new RectF();
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int desiredSize = (int) (textPaint.getTextSize() * 3);
            int width = resolveSizeAndState(desiredSize, widthMeasureSpec, 0);
            int height = resolveSizeAndState(desiredSize, heightMeasureSpec, 0);
            int size = Math.min(width, height);
            setMeasuredDimension(size, size);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            float strokeHalf = circlePaint.getStrokeWidth() / 2;
            arcRect.set(strokeHalf, strokeHalf, w - strokeHalf, h - strokeHalf);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawOval(arcRect, circlePaint); // Draw background circle (e.g., light gray)

            float sweepAngle;
            String displayText;
            int activeProgressColor;
            int backgroundArcColor;

            if (isPercentageMode) {
                sweepAngle = 360f * currentPercentage / 100f;
                displayText = String.format("%d%%", currentPercentage);
                activeProgressColor = defaultProgressColor; // Use the defaultProgressColor (your #927AFF)
                backgroundArcColor = ContextCompat.getColor(getContext(), R.color.gray); // Use gray for the empty part
            } else {
                sweepAngle = 360f * (countdownTime - elapsedTime) / countdownTime; // Remaining time
                displayText = String.format("%02d", countdownTime - elapsedTime);
                activeProgressColor = ContextCompat.getColor(getContext(), R.color.white); // White for countdown remaining time
                backgroundArcColor = ContextCompat.getColor(getContext(), R.color.gray); // Gray for elapsed time
            }

            // Draw background arc (empty part of progress)
            progressArcPaint.setColor(backgroundArcColor);
            canvas.drawArc(arcRect, -90 + sweepAngle, 360 - sweepAngle, false, progressArcPaint); // Draw from the end of progress to fill 360

            // Draw actual progress arc
            progressArcPaint.setColor(activeProgressColor);
            canvas.drawArc(arcRect, -90, sweepAngle, false, progressArcPaint); // Draw from top (-90) clockwise

            float xPos = getWidth() / 2f;
            float yPos = (getHeight() / 2f) - ((textPaint.descent() + textPaint.ascent()) / 2f);
            canvas.drawText(displayText, xPos, yPos, textPaint);
        }


        public void startCountdown(int seconds) {
            isPercentageMode = false;
            countdownTime = seconds;
            elapsedTime = 0;
            textPaint.setColor(ContextCompat.getColor(getContext(), R.color.white)); // Set text color to white for countdown
            invalidate();
        }

        public void updateElapsedTime(int seconds) {
            isPercentageMode = false;
            elapsedTime = seconds;
            if (elapsedTime > countdownTime) {
                elapsedTime = countdownTime;
            }
            textPaint.setColor(ContextCompat.getColor(getContext(), R.color.white)); // Set text color to white for countdown
            invalidate();
        }

        public void setProgressPercentage(int percentage) {
            isPercentageMode = true;
            this.currentPercentage = percentage;
            if (this.currentPercentage < 0) this.currentPercentage = 0;
            if (this.currentPercentage > 100) this.currentPercentage = 100;
            textPaint.setColor(defaultTextColor); // Set text color for percentage\
            Log.d("CircularCountdown", "Set percentage: " + percentage);
            invalidate();
        }

        // --- Optional Setters (adjusted to use default colors or take new ones) ---
        public void setCountdownTime(int countdownTime) {
            this.countdownTime = countdownTime;
            invalidate();
        }

        // This setter is for the main outline circle
        public void setCircleColor(int color) {
            circlePaint.setColor(color);
            defaultCircleColor = color; // Also update default if set programmatically
            invalidate();
        }

        // This setter is for the progress arc itself
        public void setProgressColor(int color) {
            // This will set the color for both modes if called.
            // If you want different colors for countdown and percentage, you'll need
            // separate color variables for each mode, or rely on the onDraw logic.
            progressArcPaint.setColor(color);
            defaultProgressColor = color; // Also update default if set programmatically
            invalidate();
        }

        public void setTextColor(int color) {
            textPaint.setColor(color);
            defaultTextColor = color; // Also update default if set programmatically
            invalidate();
        }

        public void setTextSize(float textSize) {
            textPaint.setTextSize(textSize);
            requestLayout();
            invalidate();
        }

        public void setStrokeWidth(float width) {
            circlePaint.setStrokeWidth(width);
            progressArcPaint.setStrokeWidth(width);
            float strokeHalf = width / 2;
            arcRect.set(strokeHalf, strokeHalf, getWidth() - strokeHalf, getHeight() - strokeHalf);
            invalidate();
        }
    }