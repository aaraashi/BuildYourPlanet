package com.example.buildyourplanet;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlanetInstruction extends AppCompatActivity implements Serializable {
    ImageView reusableImageView, iv_earth;
    private ObjectAnimator anim;
    String testString;
    TextView test;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_instruction);

//        Button createButton = (Button)findViewById(R.id.start);
//        createButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
//                startActivity(intent);
//            }
//        });

        //test = findViewById(R.id.tv_test);
        ArrayList<Double> Wlist = (ArrayList<Double>) getIntent().getSerializableExtra("data");

//        for (int i = 0 ; i < 9 ; i++){
//
//            testString += Wlist.get(i).toString() + ' ';
//            test.setText(testString);
//        }

        iv_earth = findViewById(R.id.earth);

        final Button onButton = (Button) findViewById(R.id.start);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.translate_position);
                //performAnimation2(R.anim.spin);
            }
        });
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
                    finish();
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
                        finish();
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
