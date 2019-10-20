package com.example.buildyourplanet;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateActivity extends AppCompatActivity {
    ImageView reusableImageView;
    CheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    EditText et_dust, et_water, et_carbon, et_hydrogen, et_rocks, et_soil,
    et_temp, et_distance, et_atmo, et_diameter;
    private ObjectAnimator anim;
    LottieAnimationView animationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // declaration components
        ch1 = findViewById(R.id.cb_surface_dust);
        ch2 = findViewById(R.id.cb_surface_water);
        ch3 = findViewById(R.id.cb_surface_carbon);
        ch4 = findViewById(R.id.cb_surface_hydrogen);
        ch5 = findViewById(R.id.cb_surface_rocks);
        ch6 = findViewById(R.id.cb_surface_soil);

        et_dust = findViewById(R.id.et_dust);
        et_water = findViewById(R.id.et_water);
        et_carbon = findViewById(R.id.et_carbon);
        et_hydrogen = findViewById(R.id.et_hydrogen);
        et_rocks = findViewById(R.id.et_rocks);
        et_soil = findViewById(R.id.et_soil);
        et_temp = findViewById(R.id.et_temp);
        et_distance = findViewById(R.id.et_distance);
        et_atmo = findViewById(R.id.et_atmo);
        et_diameter = findViewById(R.id.et_diameter);

        // animation view
        animationView = findViewById(R.id.animation_preview);
        animationView.playAnimation();
        //animationView.setScale(1.4f);
        animationView.setProgress(0.5f);
    }

    public void completePlanet (View v) {

        double dust = 0, water = 0, carbon = 0, hydrogen = 0, rocks = 0, soil = 0,
                temp = 0, distance = 0, atmo = 0, diameter = 0;


        if(ch1.isChecked()){
            dust = Double.valueOf(et_dust.getText().toString());
        }
        if(ch2.isChecked()){
            water = Double.valueOf(et_water.getText().toString());
        }
        if(ch3.isChecked()){
            carbon = Double.valueOf(et_carbon.getText().toString());
        }

        if(ch4.isChecked()){
            hydrogen = Double.valueOf(et_hydrogen.getText().toString());
        }
        if(ch5.isChecked()){
            rocks = Double.valueOf(et_rocks.getText().toString());
        }

        if(ch6.isChecked()){
            soil = Double.valueOf(et_soil.getText().toString());
        }

        temp = Double.valueOf(et_temp.getText().toString());
        distance = Double.valueOf(et_distance.getText().toString());
        atmo = Double.valueOf(et_atmo.getText().toString());
        diameter = Double.valueOf(et_diameter.getText().toString());

        ArrayList<Double> values = new ArrayList<Double>();
        values.add(dust);
        values.add(water);
        values.add(carbon);
        values.add(hydrogen);
        values.add(rocks);
        values.add(soil);
        values.add(temp);
        values.add(distance);
        values.add(atmo);
        values.add(diameter);

        Intent values_intent = new Intent(this, PlanetInstruction.class);
        values_intent.putExtra("data", values);
        startActivity(values_intent);

    }
}
