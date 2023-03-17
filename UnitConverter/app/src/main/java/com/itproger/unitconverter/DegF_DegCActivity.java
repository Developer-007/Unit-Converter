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

public class DegF_DegCActivity extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;
    RadioGroup radioGroup_degF_degC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deg_fdeg_cactivity);
    }
    public void goBack_toTemperature(View v) {
        Intent intent = new Intent(this, TemperatureActivity.class);
        startActivity(intent);
    }

    public void degFTodegC_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("°F:");
        tview_unit2.setText("°C:");
    }

    public void degCTodegF_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("°C:");
        tview_unit2.setText("°F:");
    }
    public void countdegF_degC(View viev) {
        radioGroup_degF_degC = findViewById(R.id.radio_group_degF_degC);
        int checkButtonIndex = radioGroup_degF_degC.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.degFTodegC:
                    unit2 = (unit1-32.0f) * (5.0f/9.0f);
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.degCTodegF:
                    unit2 = unit1 * (9.0f/5.0f)+32.0f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DegF_DegCActivity.this);
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