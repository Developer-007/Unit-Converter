package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_clc(View v){
        radioGroup = findViewById(R.id.radio_group_units);
        int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

        switch(checkedButtonIndex) {
            case R.id.length:
                goToLength();
                break;
            case R.id.area:
                goToArea();
                break;
            case R.id.volume:
                goToVolume();
                break;
            case R.id.speed:
                goToSpeed();
                break;
            case R.id.temperature:
                goToTemperature();
                break;
            case R.id.mass:
                goToMass();
                break;
        }
    }

    public void goToLength() {
        Intent intent=new Intent(this,LengthActivity.class);
        startActivity(intent);
    }
    public void goToArea() {
        Intent intent=new Intent(this,AreaActivity2.class);
        startActivity(intent);
    }
    public void goToVolume() {
        Intent intent=new Intent(this,VolumeActivity.class);
        startActivity(intent);
    }
    public void goToSpeed() {
        Intent intent=new Intent(this,SpeedActivity.class);
        startActivity(intent);
    }
    public void goToTemperature() {
        Intent intent=new Intent(this,TemperatureActivity.class);
        startActivity(intent);
    }
    public void goToMass() {
        Intent intent=new Intent(this,MassActivity.class);
        startActivity(intent);
    }
}