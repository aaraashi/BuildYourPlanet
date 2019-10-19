package com.example.buildyourplanet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Button successButton = (Button)findViewById(R.id.success);
        Button failButton = (Button)findViewById(R.id.fail);
        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(ResultActivity.this,SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("SUCCESS")
                        .setContentText("It is appropriate planet")
                        .show();
            }
        });

        failButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(ResultActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("FAIL")
                        .setConfirmButtonBackgroundColor(Color.RED)
                        .setContentText("It is inappropriate planet")
                        .setConfirmText("Try Again")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });

    }
}
