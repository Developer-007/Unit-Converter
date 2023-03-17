package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class LengthActivity extends AppCompatActivity {
    RadioGroup radioGroupL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
    }

    public void chooseLength(View v) {
        radioGroupL=findViewById(R.id.radio_group_length);
        int checkedButtonIndex=radioGroupL.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.mile_km:
                go_to_mile_km(v);
                break;
            case R.id.seamile_km:
                go_to_smile_km(v);
                break;
            case R.id.yard_m:
                go_to_yard_m(v);
                break;
            case R.id.foot_m:
                go_to_foot_m(v);
                break;
            case R.id.inch_cm:
                go_to_inch_cm(v);
                break;
        }

    }

    public void goBack_fromLength(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void go_to_mile_km(View v) {
        Intent intent=new Intent(this,Mile_KmActivity.class);
        startActivity(intent);
    }
    public void go_to_smile_km(View v) {
        Intent intent=new Intent(this,Seamile_KmActivity.class);
        startActivity(intent);
    }
    public void go_to_yard_m(View v) {
        Intent intent=new Intent(this,Yard_mActivity.class);
        startActivity(intent);
    }
    public void go_to_foot_m(View v) {
        Intent intent=new Intent(this,Foot_mActivity.class);
        startActivity(intent);
    }
    public void go_to_inch_cm(View v) {
        Intent intent=new Intent(this,Inch_cmActivity.class);
        startActivity(intent);
    }
}