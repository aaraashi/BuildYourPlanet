package com.example.buildyourplanet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;
public class SecondMissonInstruction extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondmisson_instruction);
        SweetAlertDialog dialog = new SweetAlertDialog(SecondMissonInstruction.this,SweetAlertDialog.WARNING_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText("MISSION");
        dialog.setContentTextSize(23);
        dialog.setContentText("1. Create new planet similar to Earth 2. Consider the features of Earth");
        dialog.setConfirmText("CREATE!");
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                String mission = "mission 2";
                intent.putExtra("mission", mission);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}

