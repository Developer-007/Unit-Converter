package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Foot_mActivity extends AppCompatActivity {
    TextView tview_unit1,tview_unit2,tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_mactivity);
    }
    public void goBack_toLength(View v) {
        Intent intent=new Intent(this,LengthActivity.class);
        startActivity(intent);
    }
    public void footTom_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("Футы:");
        tview_unit2.setText("М:");
    }
    public void mTofoot_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("М:");
        tview_unit2.setText("Футы:");
    }
    public void countFoot_M(View viev) {
        radioGroup = findViewById(R.id.radio_group_foot_m);
        int checkButtonIndex = radioGroup.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try{
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;

            switch (checkButtonIndex) {
                case R.id.pfoot_m:
                    unit2 = unit1 * 0.305f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.pm_foot:
                    unit2 = unit1 * 3.281f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch(Throwable e) {
            showErrorInfo("Вы не ввели значение");
        }

    }
    private void showErrorInfo(String text) {
        AlertDialog.Builder builder =new AlertDialog.Builder(Foot_mActivity.this);
        builder.setTitle("Ошибка!")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}