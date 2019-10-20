package com.example.buildyourplanet;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PlanetInstruction extends AppCompatActivity implements Serializable {
    ImageView reusableImageView, iv_earth;
    private ObjectAnimator anim;
    String testString;
    TextView earth_info;

    //177,040,816 = 0.177 * 10^9
    final double mass_dust = 0.177;
    //92,007,110,408.16327‬ = 92.007 * 10^9
    final double mass_wet_soil = 92.007;
    //60,158,495,306.12245‬ = 60.158 * 10^9
    final double mass_dry_soil = 60.158;
    //275,510,204,081.6327
    final double mass_rock = 274.51;
    double gravity = 0;
    double temp = 0;
    double distance = 0;
    double atmo = 0;
    double diameter = 0;
    double planet_mass =0;
    double mass_goal = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_instruction);
        int score = 0 ;
        String mission = getIntent().getStringExtra("mission");

//        Button createButton = (Button)findViewById(R.id.start);
//        createButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
//                startActivity(intent);
//            }
//        });
        ArrayList<Double> Wlist = (ArrayList<Double>) getIntent().getSerializableExtra("data");
        double pct_dust = Wlist.get(0);
        double pct_water = Wlist.get(1);
        double pct_carbon = Wlist.get(2);
        double pct_hydrogen = Wlist.get(3);
        double pct_rocks = Wlist.get(4);
        double pct_soil = Wlist.get(5);
        temp= Wlist.get(6);
        distance= Wlist.get(7);
        atmo= Wlist.get(8);
        diameter= Wlist.get(9);

        double mass_water;
        if(temp< 0)
        {
            //93,775,510,204.08163 = 93.78 * 10^9
            mass_water = 93.78;
        }
        else if (0 <= temp&& temp< 4) {
            //102,021,183,101.53 = 102.21 * 10^9
            mass_water = 102.21;
        } else if (4 <= temp&& temp< 10){
            //102,032,624,851.75 = 102.03 * 10^9
            mass_water = 102.03;
        } else if (10 <= temp&& temp< 21){
            //101900456314.25 = 101.90 * 10^9
            mass_water = 101.90;
        } else if (21 <= temp&& temp< 60){
            //101,534,091,449.32 = 101.53 * 10^9
            mass_water = 101.53;
        }
        else if (60 <= temp&& temp< 71){
            //99,716,487,700.14= 99.72* 10^9
            mass_water = 99.72;
        }
        else if (71 <= temp&& temp< 100){
            //98,592,982,686.14= 98.59* 10^9
            mass_water = 98.59;
        }
        else mass_water = 0;
        CalculateMass(pct_dust, pct_water, pct_rocks, pct_soil, mass_water);
        CalculateGravity();
        if(mission=="mission 1")
        {
            score = CheckMission1();
        }
        else if(mission=="mission 2")
        {
            score = score(pct_dust, pct_water, pct_carbon, pct_hydrogen, pct_rocks, pct_soil);
        }

        message(score);
        iv_earth = findViewById(R.id.earth);
        final Button onButton = (Button) findViewById(R.id.start);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.translate_position);
            }
        });


    }

    protected int score(double dust, double water, double carbon, double hydrogen, double rocks, double soil){
        int num = 0;
        if((dust/100) >= 0.05 && (dust/100) <= 0.15)
            num++;
        if((water/100) >= 0.66 && (water/100) <= 0.76)
            num++;
        if((carbon/100) >= -0.535 && (carbon/100) <=0.535)
            num++;
        if((hydrogen/100) >= -0.0425 && (hydrogen/100) <= 0.0575)
            num++;
        if((rocks/100)>= 0.70 && (rocks/100) <= 0.80)
            num++;
        if((soil/100) >= 0.025 && (soil/100) <= 0.125)
            num++;
        if(temp >= 11.85 && temp <= 21.85)
            num++;
        if(distance >= 140000000 && distance <= 160000000)
            num++;
        if(atmo >= 650 && atmo <= 750)
            num++;
        if(diameter >= 7.756 && diameter <= 17.756)
            num++;
        return num;
    }
    protected void message(int total) {
        if (total == 10) {
            new SweetAlertDialog(PlanetInstruction.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("PERFECT")
                    .setContentText("It is appropriate planet")
                    .show();
        } else if (total >= 6) {
            new SweetAlertDialog(PlanetInstruction.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Very good")
                    .setContentText("It is appropriate planet")
                    .show();
        } else if (total < 6) {
            new SweetAlertDialog(PlanetInstruction.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("FAIL")
                    .setConfirmButtonBackgroundColor(Color.RED)
                    .setContentText("It is inappropriate planet")
                    .setConfirmText("Try Again")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    }).show();
        }

    }
    protected void CalculateMass(double pct_dust,double pct_water, double pct_rocks,double pct_soil,double mass_water)
    {
        double volume = (diameter/2.0) * (diameter/2.0) * (diameter/2.0) * 3.14 * 4.0/3.0; // diameter = 2r
        double dust = 0;
        double water =0;
        double rock = 0;
        double soil =0;
        //wet soil
        if(pct_water > 0)
        {
            dust = volume * (pct_dust/100) * mass_dust;
            soil = volume * (pct_soil/100) * mass_wet_soil;
            water = volume * (pct_water /100) * mass_water;
            rock = volume * (pct_rocks/100) * mass_rock;
            planet_mass = dust+soil+water+rock;
        }
        //dry soil
        else if(pct_water == 0)
        {
            dust = volume * (pct_dust/100) * mass_dust;
            soil = volume * (pct_soil/100) * mass_dry_soil;
            water = volume * (pct_water /100) * mass_water;
            rock = volume * (pct_rocks/100) * mass_rock;
            //unit:kg
            planet_mass = dust+soil+water+rock;
        }
    }
    protected void CalculateGravity()
    {
        // unit : N
        gravity = 132666.3 * planet_mass/(distance * distance);
    }
    protected int CheckMission1()
    {
        // mass 3 * 10^21kg
        // Force: 2*10^5 N
        int result = 0;
        mass_goal = 99950;
        if (planet_mass > 99950)
        {
            //mission success
            result = 10;
        }
        return result;
    }
    // planet popup info
    public void showEarth(View v){

        AlertDialog alertDialog = new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_info)
            .setTitle("Do you want to know about the Earth?")
                .setMessage(getString(R.string.earthIs))
                .setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //set what would happen when positive button is clicked
                    String task = "closed";
                }
            }).show();
    }


    public void showJupiter(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Do you want to know about the Jupiter")
                .setMessage(getString(R.string.jupiterIs))
                .setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        String task = "closed";
//                        Intent intent = new Intent(getApplicationContext(), PlanetInstruction.class);
//                        startActivity(intent);
                    }
                }).show();
    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        reusableImageView = (ImageView)findViewById(R.id.earth);
        reusableImageView.setImageResource(R.drawable.earth);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimatVionListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private class MyAnimatVionListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            //reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
            //reusableImageView.setVisibility(View.INVISIBLE);
        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {

        }

    }
}
