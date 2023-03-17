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

public class Mph_kmphActivity extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;
    RadioGroup radioGroup_mph_kmph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mph_kmph);
    }
    public void goBack_toSpeed(View v) {
        Intent intent = new Intent(this, SpeedActivity.class);
        startActivity(intent);
    }
    public void mphTokmph_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Мили/ч:");
        tview_unit2.setText("Км/ч:");
    }

    public void kmphTomph_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Км/ч:");
        tview_unit2.setText("Мили/ч:");
    }
    public void countmph_kmph(View viev) {
        radioGroup_mph_kmph = findViewById(R.id.radio_group_mph_kmph);
        int checkButtonIndex = radioGroup_mph_kmph.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.mphTokmph:
                    unit2 = unit1 * 1.609f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.kmphTomph:
                    unit2 = unit1 * 0.621f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Mph_kmphActivity.this);
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