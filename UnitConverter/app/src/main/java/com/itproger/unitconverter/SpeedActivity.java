package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class SpeedActivity extends AppCompatActivity {
    RadioGroup radioGroupS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
    }
    public void chooseSpeed(View v) {
        radioGroupS=findViewById(R.id.radio_group_speed);
        int checkedButtonIndex=radioGroupS.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.mph_kmph:
                go_to_mph_kmph(v);
                break;
            case R.id.kn_kmph:
                go_to_knot_kmph(v);
                break;
        }

    }

    public void goBack_fromSpeed(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void go_to_mph_kmph(View v) {
        Intent intent=new Intent(this,Mph_kmphActivity.class);
        startActivity(intent);
    }
    public void go_to_knot_kmph(View v) {
        Intent intent=new Intent(this,Knot_kmphActivity.class);
        startActivity(intent);
    }
}