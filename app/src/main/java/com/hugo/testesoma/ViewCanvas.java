package com.hugo.testesoma;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewCanvas extends View {

    Paint paint = new Paint();
    int resultOfSum;

    float touchX, touchY = 150;

    public ViewCanvas(Context context) {
        super(context);
    }

    public ViewCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        // canvas
        canvas.drawColor(WHITE);

        // como desenhar o circulo (características)
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(BLACK);

        // agora desenha o círculo
        canvas.drawCircle(touchX, touchY, 100, paint);

        // texto
        paint.setColor(WHITE);
        setTextSizeForWidth(paint, 50, String.valueOf(resultOfSum));
        canvas.drawText(String.valueOf(resultOfSum), touchX - 28, touchY + 28, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // muda as posições
            touchX = x;
            touchY = y;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // muda as posições
            touchX = x;
            touchY = y;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            //
        }

        invalidate();

        return true;
    }

    private void setTextSizeForWidth(Paint paint, float desiredWidth, String text) {
        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        final float testTextSize = 48f;

        // Get the bounds of the text, using our testTextSize.
        paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);

        // Calculate the desired size as a proportion of our testTextSize.
        float desiredTextSize = testTextSize * desiredWidth / bounds.width();

        // Set the paint for that size.
        paint.setTextSize(desiredTextSize);
    }

}
