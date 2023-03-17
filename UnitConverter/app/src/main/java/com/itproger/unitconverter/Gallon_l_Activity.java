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

public class Gallon_l_Activity extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;
    RadioGroup radioGroup_gallon_l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallon_lactivity);
    }
    public void goBack_toVolume(View v) {
        Intent intent = new Intent(this, VolumeActivity.class);
        startActivity(intent);
    }
    public void gallonTol_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Галлоны:");
        tview_unit2.setText("Л:");
    }

    public void lTogallon_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Л:");
        tview_unit2.setText("Галлоны:");
    }
    public void countgallon_l(View viev) {
        radioGroup_gallon_l = findViewById(R.id.radio_group_gallon_l);
        int checkButtonIndex = radioGroup_gallon_l.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.gallonTol:
                    unit2 = unit1 * 3.785f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.lTogallon:
                    unit2 = unit1 * 0.264f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Gallon_l_Activity.this);
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