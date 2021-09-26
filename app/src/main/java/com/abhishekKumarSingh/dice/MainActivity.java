package com.abhishekKumarSingh.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inti();

        img.setOnClickListener(view -> {
            Random rnd = new Random();
            int n = rnd.nextInt(6)+1;
            anmate();
            setimage(n);

        });
        btn.setOnClickListener(view -> {

            Random rnd = new Random();
            int n = rnd.nextInt(6)+1;
            anmate();
            setimage(n);

        });
    }

    private void anmate() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        img.startAnimation(animation);
    }

    private void setimage(int num) {
        switch (num){
            case 1: img.setImageResource(R.drawable.one);
                break;
            case 2: img.setImageResource(R.drawable.two);
                break;
            case 3: img.setImageResource(R.drawable.three);
                break;
            case 4: img.setImageResource(R.drawable.four);
                break;
            case 5: img.setImageResource(R.drawable.five);
                break;
            case 6: img.setImageResource(R.drawable.six);
        }

    }

    private void inti() {
        btn = findViewById(R.id.button);
        img = findViewById(R.id.image);
    }
}