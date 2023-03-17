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

public class Mile_KmActivity extends AppCompatActivity {

    TextView tview_unit1,tview_unit2,tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mile_km);
    }

    public void goBack_toLength(View v) {
        Intent intent=new Intent(this,LengthActivity.class);
        startActivity(intent);
    }
    public void mileTokm_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("Мили:");
        tview_unit2.setText("Км:");
    }
    public void kmTomile_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("Км:");
        tview_unit2.setText("Мили:");
    }
    public void countMile_Km(View viev) {
        radioGroup=findViewById(R.id.radio_group_mile_km);
        int checkButtonIndex= radioGroup.getCheckedRadioButtonId();
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_enter_unit2=findViewById(R.id.enter_unit2);
        eText=findViewById(R.id.enter_unittext);

        try{
            float unit1=Float.parseFloat(eText.getText().toString());
            float unit2;


            switch(checkButtonIndex) {
                case R.id.pmile_km:
                    unit2=unit1*1.609f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.pkm_mile:
                    unit2=unit1*0.621f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfo("Вы не ввели значение");
        }



    }

    private void showErrorInfo(String text) {
        AlertDialog.Builder builder =new AlertDialog.Builder(Mile_KmActivity.this);
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