package com.home.raunak.myapp2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class RadioDemo extends AppCompatActivity {

    RadioGroup radioGroup;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_demo);
        radioGroup=findViewById(R.id.rg);
        linearLayout=findViewById(R.id.li);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radioButton:
                        linearLayout.setBackgroundColor(Color.RED);
                        //linearLayout.setBackgroundResource(R.drawable.pick);
                        //Intent ob=new Intent(RadioDemo.this,MyRed.class);
                        //startActivity(ob);
                        break;
                    case R.id.radioButton2:
                        linearLayout.setBackgroundColor(Color.GREEN);
                        //Intent obj=new Intent(MyRadio.this,MyGreen.class);
                        //startActivity(obj);
                        break;
                }
            }
        });
    }
}
