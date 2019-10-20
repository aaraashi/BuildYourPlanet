package com.example.buildyourplanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FirstMissonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstmisson);

        int count = 0;
        final TypeWriterTextView animationText = (TypeWriterTextView) findViewById(R.id.firstmission_dialog);
        //Button btnStartAnimation = (Button) findViewById(R.id.button);
        ImageView btnStartAnimation = (ImageView) findViewById(R.id.dialog_button);

        //Start animation in TextView after click
        btnStartAnimation.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                animationText.setText("");
                animationText.setCharacterDelay(35);
                if(count == 0) {
                    animationText.displayTextWithAnimation(getString(R.string.firstmission_dialog1));

                }
                else if(count==1)
                {
                    animationText.displayTextWithAnimation(getString(R.string.firstmission_dialog2));

                }
                else if(count==2)
                {
                    animationText.displayTextWithAnimation(getString(R.string.firstmission_dialog3));

                }
                else if(count==3)
                {
                    animationText.displayTextWithAnimation(getString(R.string.firstmission_dialog4));

                }

                else if(count==4)
                {
                    Intent goToMissionActivity = new Intent(getApplicationContext(), FirstMissonInstruction.class);
                    startActivity(goToMissionActivity);

                }
                count++;
            }
        });
    }
}
