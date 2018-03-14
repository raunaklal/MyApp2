package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxDemo extends AppCompatActivity {

    CheckBox c,p,b,t;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_demo);
        c=findViewById(R.id.checkBox);
        p=findViewById(R.id.checkBox2);
        b=findViewById(R.id.checkBox3);
        t=findViewById(R.id.checkBox4);
        button=findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected items:");
                if(p.isChecked()){
                    result.append("\nPizza 200Rs");
                    totalAmount+=200;
                }
                if(c.isChecked()){
                    result.append("\nCoffee 20Rs");
                    totalAmount+=20;
                }
                if(b.isChecked()){
                    result.append("\nBurger 50Rs");
                    totalAmount+=50;
                }
                if(t.isChecked()){
                    result.append("\nTea 12Rs");
                    totalAmount+=12;
                }
                result.append("\nTotal: "+totalAmount+"Rs");
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
