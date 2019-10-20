package com.example.buildyourplanet;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class FirstMissonInstruction extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstmisson_instruction);
        SweetAlertDialog dialog = new SweetAlertDialog(FirstMissonInstruction.this,SweetAlertDialog.WARNING_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText("MISSION");
        dialog.setContentTextSize(20);
        dialog.setContentText("1. The distance between a new planet and an asteroid 3km.\n" +
                "2. The asteroid's mass is 3 * 10^21kg and it is approaching to the Earth with force of 2*10^10\n"
                + "3. Create a new planet that has gravity which can change the orbital inclination of a comet more than 45 degrees");
        dialog.setConfirmText("CREATE!");
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}