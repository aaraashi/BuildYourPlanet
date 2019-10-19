package com.example.buildyourplanet;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetInstruction extends AppCompatActivity {
    ImageView reusableImageView;
    private ObjectAnimator anim;

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

        final Button onButton = (Button) findViewById(R.id.start);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.translate_position);
                //performAnimation2(R.anim.spin);
            }
        });
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
