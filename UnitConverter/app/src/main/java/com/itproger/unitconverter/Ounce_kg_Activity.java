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

public class Ounce_kg_Activity extends AppCompatActivity {

    TextView tview_unit1,tview_unit2,tview_enter_unit2;
    EditText eText;
    View v;

    RadioGroup radioGroup_ounce_kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ounce_kg);
    }
    public void goBack_toMass(View v) {
        Intent intent=new Intent(this,MassActivity.class);
        startActivity(intent);
    }
    public void ounceTokg_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("Унции:");
        tview_unit2.setText("Кг:");
    }
    public void kgToounce_text(View v){
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_unit1.setText("Кг:");
        tview_unit2.setText("Унции:");
    }
    public void countOunce_Kg(View viev) {
        radioGroup_ounce_kg=findViewById(R.id.radio_group_ounce_kg);
        int checkButtonIndex= radioGroup_ounce_kg.getCheckedRadioButtonId();
        tview_unit1=findViewById(R.id.unit_1);
        tview_unit2=findViewById(R.id.unit_2);
        tview_enter_unit2=findViewById(R.id.enter_unit2);
        eText=findViewById(R.id.enter_unittext);

        try{
            float unit1=Float.parseFloat(eText.getText().toString());
            float unit2;


            switch(checkButtonIndex) {
                case R.id.ounce_kg:
                    unit2=unit1*0.02835f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
                case R.id.kg_ounce:
                    unit2=unit1*35.27396f;
                    tview_enter_unit2.setText(String.valueOf(unit2));
                    break;
            }
        } catch (Throwable e) {
            showErrorInfo("Вы не ввели значение");
        }



    }

    private void showErrorInfo(String text) {
        AlertDialog.Builder builder =new AlertDialog.Builder(Ounce_kg_Activity.this);
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