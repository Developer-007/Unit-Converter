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

public class Acre_hectareActivity extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroup_acre_ha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acre_hectare);
    }
    public void goBack_toArea(View v) {
        Intent intent = new Intent(this, AreaActivity2.class);
        startActivity(intent);
    }

    public void acreTohectare_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Акры:");
        tview_unit2.setText("Гектары:");
    }

    public void hectareToacre_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Гектары:");
        tview_unit2.setText("Акры:");
    }
    public void countAcre_Ha(View viev) {
        radioGroup_acre_ha = findViewById(R.id.radio_group_acre_ha);
        int checkButtonIndex = radioGroup_acre_ha.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.acreToha:
                    unit2 = unit1 * 0.40469f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.haToacre:
                    unit2 = unit1 * 2.47105f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Acre_hectareActivity.this);
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