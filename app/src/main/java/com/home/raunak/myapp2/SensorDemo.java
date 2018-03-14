package com.home.raunak.myapp2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SensorDemo extends AppCompatActivity implements SensorEventListener{

    RelativeLayout rl;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_demo);
        tv1=findViewById(R.id.textView6);
        rl=findViewById(R.id.sensorDemo);
        SensorManager sm=(SensorManager) getSystemService(SENSOR_SERVICE);

//        int i=Sensor.TYPE_ORIENTATION;
        int i=Sensor.TYPE_PROXIMITY;
        Sensor s=sm.getDefaultSensor(i);
        sm.registerListener(this,s,sm.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] data=event.values;

        float object_distance=data[0];
        Toast.makeText(getApplicationContext(),String.valueOf(object_distance).toString(),Toast.LENGTH_LONG).show();
        if(object_distance==1){
            rl.setBackgroundColor(Color.RED);
        }
        else{
            rl.setBackgroundColor(Color.CYAN);
        }


/*
        float z=data[0];
        float x=data[1];
        float y=data[2];
        String st="ORIENTATION SENSOR";
        st=st+"\nPITCH= "+x;
        st=st+"\nROLL= "+y;
        st=st+"\nAZIMUTH= "+z;

        tv1.setText(st);

        rl.setBackgroundColor(Color.rgb((int)x,(int)y,(int)z));
*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
