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

public class Sqmile_sqkm extends AppCompatActivity {
    TextView tview_unit1, tview_unit2, tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroupsqm_km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqmile_sqkm);
    }

    public void goBack_toArea(View v) {
        Intent intent = new Intent(this, AreaActivity2.class);
        startActivity(intent);
    }

    public void sqmileTosqkm_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Кв.мили:");
        tview_unit2.setText("Кв.км:");
    }

    public void sqkmTosqmile_text(View v) {
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_unit1.setText("Кв.км:");
        tview_unit2.setText("Кв.мили:");
    }

    public void countsqMile_sqKm(View viev) {
        radioGroupsqm_km = findViewById(R.id.radio_group_sqmile_sqkm);
        int checkButtonIndex = radioGroupsqm_km.getCheckedRadioButtonId();
        tview_unit1 = findViewById(R.id.unit_1);
        tview_unit2 = findViewById(R.id.unit_2);
        tview_enter_unit2 = findViewById(R.id.enter_unit2);
        eText = findViewById(R.id.enter_unittext);

        try {
            float unit1 = Float.parseFloat(eText.getText().toString());
            float unit2;


            switch (checkButtonIndex) {
                case R.id.sqmileTosqkm_rb:
                    unit2 = unit1 * 2.58999f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.sqkmTosqmile_rb:
                    unit2 = unit1 * 0.3861f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfoSq("Вы не ввели значение");
        }


    }

    private void showErrorInfoSq(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Sqmile_sqkm.this);
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
