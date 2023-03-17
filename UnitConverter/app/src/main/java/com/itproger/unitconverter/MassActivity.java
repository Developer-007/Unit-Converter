package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MassActivity extends AppCompatActivity {
    RadioGroup radioGroupMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
    }

    public void chooseMass(View v) {
        radioGroupMass=findViewById(R.id.radio_group_mass);
        int checkedButtonIndex=radioGroupMass.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.kg_pnd:
                go_to_pound_kg(v);
                break;
            case R.id.kg_oz:
                go_to_ounce_kg(v);
                break;
        }

    }
    public void goBack_fromMass(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void go_to_pound_kg(View v) {
        Intent intent=new Intent(this,Pound_kgActivity.class);
        startActivity(intent);
    }
    public void go_to_ounce_kg(View v) {
        Intent intent=new Intent(this,Ounce_kg_Activity.class);
        startActivity(intent);
    }
}