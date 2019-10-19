package com.example.buildyourplanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button first_misson = (Button)findViewById(R.id.firstMission);
        Button second_misson = (Button)findViewById(R.id.secondMisson);
        Button third_misson = (Button)findViewById(R.id.thirdMisson);

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
        third_misson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ThirdMissonActivity.class);
                startActivity(intent);
            }
        });
    }
}
