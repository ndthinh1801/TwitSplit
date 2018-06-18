package com.thinhnd.twitsplit.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thinhnd.twitsplit.R;
import com.thinhnd.twitsplit.ui.message.MessageActivity;

public class SplashActivity extends AppCompatActivity {

    // Splash screen time out
    private static final int SPLASH_TIME_OUT = 1500;

    private final Runnable mStartActivityRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MessageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(getMainLooper()).postDelayed(mStartActivityRunnable, SPLASH_TIME_OUT);

    }
}
