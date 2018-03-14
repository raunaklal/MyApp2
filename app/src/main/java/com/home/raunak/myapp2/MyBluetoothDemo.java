package com.home.raunak.myapp2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MyBluetoothDemo extends AppCompatActivity {

    TextView textView;
    Switch aSwitch;
    Button button,button2;
    BluetoothAdapter bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bluetooth_demo);

        textView=findViewById(R.id.textView8);
        aSwitch=findViewById(R.id.switch1);
        button=findViewById(R.id.button21);
        button2=findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btsan= Settings.ACTION_BLUETOOTH_SETTINGS;
                Intent intent=new Intent(btsan);
                startActivity(intent);
            }
        });
        bt=BluetoothAdapter.getDefaultAdapter();
        if (bt==null){
            Toast.makeText(this, "Bluetooth Device not Found", Toast.LENGTH_LONG).show();
        }
        else {
            boolean status=bt.isEnabled();
            if (status){
                String op="Device Status : ON";
                String dn=bt.getName();
                String mac=bt.getAddress();
                op=op+"\nDevice :"+dn+"\nMAC ADDRESS :"+mac;
                textView.setText(op);
                textView.setTextColor(Color.BLUE);
                aSwitch.setChecked(true);
            }
            else {
                textView.setText("Device Status : OFF");
                textView.setTextColor(Color.RED);
                aSwitch.setChecked(false);
            }
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    bt.enable();
                    String op="Device Status : ON";
                    String dn=bt.getName();
                    String mac=bt.getAddress();
                    op=op+"\nDevice :"+dn+"\nMAC Address: "+mac;
                    textView.setText(op);
                    textView.setTextColor(Color.RED);

                }
                else{
                    bt.disable();
                    textView.setText("DEVICE STATUS : OFF");
                    textView.setTextColor(Color.RED);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] devices=bt.getBondedDevices().toArray();
                String data="Other Devices\n-------";
                for(int i=0;i<devices.length;i++){
                    BluetoothDevice d= (BluetoothDevice) devices[i];
                    String dn=d.getName();
                    data=data+"\n"+dn;
                }
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
            }
        });
    }
}
