package com.example.buildyourplanet;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class SecondMissonActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondmisson);
        int count = 0;
        final TypeWriterTextView animationText = (TypeWriterTextView) findViewById(R.id.secondMisson_dialog);
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
                    animationText.displayTextWithAnimation(getString(R.string.lee));
                }
                else if(count== 1) {
                    animationText.displayTextWithAnimation(getString(R.string.lee2));
                }
                else if(count==2)
                {
                    Intent goToMissionActivity = new Intent(getApplicationContext(), SecondMissonInstruction.class);
                    startActivity(goToMissionActivity);
                }
                count++;
            }
        });
    }
}
