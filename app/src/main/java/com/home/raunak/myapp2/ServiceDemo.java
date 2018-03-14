package com.home.raunak.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceDemo extends AppCompatActivity implements View.OnClickListener{

    Button button,button2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        button=findViewById(R.id.button10);
        intent=new Intent(ServiceDemo.this,Kbr.class);

        button2=findViewById(R.id.button11);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(button==v){
            startService(intent);
            //finish();
        }
        if(button2==v){
            stopService(intent);
            finish();
        }

    }
}
