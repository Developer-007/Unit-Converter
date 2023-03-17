package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class AreaActivity2 extends AppCompatActivity {
    RadioGroup radioGroupA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area2);
    }
    public void chooseArea(View v) {
        radioGroupA=findViewById(R.id.radio_group_A);
        int checkedButtonIndex=radioGroupA.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.mile2_km2:
                go_to_sqmile_sqkm(v);
                break;
            case R.id.acr_ga:
                go_to_acre_ha(v);
                break;
            case R.id.yard2_m2:
                go_to_sqyard_sqm(v);
                break;
            case R.id.foot2_m2:
                go_to_sqfoot_sqm(v);
                break;
        }

    }


    public void goBack_fromArea(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void go_to_sqmile_sqkm(View v) {
        Intent intent=new Intent(this,Sqmile_sqkm.class);
        startActivity(intent);
    }
    public void go_to_acre_ha(View v) {
        Intent intent=new Intent(this,Acre_hectareActivity.class);
        startActivity(intent);
    }
    public void go_to_sqyard_sqm(View v) {
        Intent intent=new Intent(this,Sqyard_sqmActivity.class);
        startActivity(intent);
    }
    public void go_to_sqfoot_sqm(View v) {
        Intent intent=new Intent(this,Sqfoot_sqmActivity.class);
        startActivity(intent);
    }

}