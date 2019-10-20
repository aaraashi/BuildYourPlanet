package com.example.buildyourplanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button first_misson = (Button)findViewById(R.id.firstMission);
        Button second_misson = (Button)findViewById(R.id.secondMission);

        // animation view
        animationView = findViewById(R.id.animation_view);
        animationView.playAnimation();
        //animationView.setScale(1.4f);
        animationView.setProgress(0.5f);

        first_misson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), FirstMissonActivity.class);
                startActivity(intent);
            }
        });
        second_misson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SecondMissonActivity.class);
                startActivity(intent);
            }
        });
    }

    public void test (View v) {
        Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(intent);
    }
}
