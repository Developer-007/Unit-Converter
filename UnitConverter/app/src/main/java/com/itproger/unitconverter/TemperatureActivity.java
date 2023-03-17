package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class TemperatureActivity extends AppCompatActivity {
    RadioGroup radioGroupT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
    }
    public void chooseTemperature(View v) {
        radioGroupT=findViewById(R.id.radio_group_temperature);
        int checkedButtonIndex=radioGroupT.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.fc:
                go_to_degF_degC(v);
                break;
            case R.id.rec:
                go_to_degRe_degC(v);
                break;
        }

    }

    public void goBack_fromTemperature(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void go_to_degF_degC(View v) {
        Intent intent=new Intent(this,DegF_DegCActivity.class);
        startActivity(intent);
    }
    public void go_to_degRe_degC(View v) {
        Intent intent=new Intent(this,DegRe_DegCActivity.class);
        startActivity(intent);
    }
}