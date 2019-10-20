package com.example.buildyourplanet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class FirstMissonInstruction extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstmisson_instruction);
        final SweetAlertDialog dialog = new SweetAlertDialog(FirstMissonInstruction.this,SweetAlertDialog.WARNING_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText("MISSION");
        dialog.setContentTextSize(20);
        dialog.setContentText("Create a new planet with gravity which can change the orbit of the asteroid by more than 45 degrees.");
        dialog.setConfirmText("CREATE!");
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                showAddItemDialog(FirstMissonInstruction.this);
            }
        });
        dialog.show();
    }

    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Details")
                .setMessage("1. The distance between a new planet and the asteroid 3km.\n"
                        +"2. The asteroid's mass is 3 * 10^21kg \n" +
                        "3. It is approaching to the Earth with force of 2*10^5\n"
                        +"4. Assume the new planet is not affected by other existing planets")
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
        dialog.show();
    }

}