package com.example.buildyourplanet;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class TypeWriterTextView extends AppCompatTextView {

    private CharSequence sequence;
    private int mIndex;
    private long delay = 5; //default is 150 milliseconds

    public TypeWriterTextView(Context context) {
        super(context);
    }

    public TypeWriterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            setText(sequence.subSequence(0, mIndex++));
            if (mIndex <= sequence.length()) {
                handler.postDelayed(runnable, delay);
            }
        }
    };

    /**
     * Display text with type writer animation
     * @param txt content will be displayed
     */
    public void displayTextWithAnimation(CharSequence txt) {
        sequence = txt;
        mIndex = 0;

        setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, delay);
    }

    /**
     * Change the delay value with this method
     * @param m
     */
    public void setCharacterDelay(long m) {
        delay = m;
    }
}