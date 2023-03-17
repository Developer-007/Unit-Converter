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

public class Sqyard_sqmActivity extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroup_sqyard_sqm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqyard_sqm);
    }
    public void goBack_toArea(View v) {
        Intent intent = new Intent(this, AreaActivity2.class);
        startActivity(intent);
    }
    public void sqyardTosqm_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Кв.ярды:");
        tview_unit2.setText("Кв.метры:");
    }

    public void sqmTosqyard_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Кв.метры:");
        tview_unit2.setText("Кв.ярды:");
    }
    public void countsqyard_sqm(View viev) {
        radioGroup_sqyard_sqm = findViewById(R.id.radio_group_sqyard_sqm);
        int checkButtonIndex = radioGroup_sqyard_sqm.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.sqyardTosqm:
                    unit2 = unit1 * 0.83613f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.sqmTosqyard:
                    unit2 = unit1 * 1.19599f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Sqyard_sqmActivity.this);
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