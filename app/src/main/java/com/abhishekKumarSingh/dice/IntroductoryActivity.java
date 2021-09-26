package com.abhishekKumarSingh.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class IntroductoryActivity extends AppCompatActivity {

    private final Handler mWaitHandler = new Handler();
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_introductory);



        text = findViewById(R.id.text);
        text.animate().scaleX(2).scaleY(2).alpha(1)
                .setDuration(1000)
                .setStartDelay(2000)
                .translationY(500)
                .setStartDelay(3000);

        mWaitHandler.postDelayed(() -> {
            //The following code will execute after the 5 seconds.
            try {
                //Go to next page i.e, start the next activity.
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //Let's Finish Splash Activity since we don't want to show this when user press back button.
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5000);  // Give a 5 seconds delay.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}