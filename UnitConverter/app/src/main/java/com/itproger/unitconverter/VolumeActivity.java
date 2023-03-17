package com.itproger.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class VolumeActivity extends AppCompatActivity {
    RadioGroup radioGroupV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
    }

    public void chooseVolume(View v) {
        radioGroupV = findViewById(R.id.radio_group_V);
        int checkedButtonIndex = radioGroupV.getCheckedRadioButtonId();

        switch (checkedButtonIndex) {
            case R.id.o_barrel_l:
                go_to_obarrel_l(v);
                break;
            case R.id.gal_l:
                go_to_gallon_l(v);
                break;
            case R.id.quart_l:
                go_to_quart_l(v);
                break;
            case R.id.pint_l:
                go_to_pint_l(v);
                break;
        }
    }

        public void goBack_fromVolume (View v){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        public void go_to_obarrel_l (View v){
            Intent intent = new Intent(this, O_barrel_l_Activity.class);
            startActivity(intent);
        }
        public void go_to_gallon_l (View v){
            Intent intent = new Intent(this, Gallon_l_Activity.class);
            startActivity(intent);
        }
        public void go_to_quart_l (View v){
            Intent intent = new Intent(this, Quart_l_Activity.class);
            startActivity(intent);
        }
        public void go_to_pint_l (View v){
            Intent intent = new Intent(this, Pint_l_Activity.class);
            startActivity(intent);
        }
}