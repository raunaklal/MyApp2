package com.home.raunak.myapp2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reg extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        e1=findViewById(R.id.editText6);
        e2=findViewById(R.id.editText7);
        e3=findViewById(R.id.editText8);
        b1=findViewById(R.id.button14);
        db=openOrCreateDatabase("kolkata",MODE_PRIVATE,null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String p=e2.getText().toString();
                String a=e3.getText().toString();

                db.execSQL("insert into student values('"+n+"','"+p+"','"+a+"')");
                Toast.makeText(getApplicationContext(),"Registration Done",Toast.LENGTH_LONG).show();
                Intent i=new Intent(Reg.this,MyDataBase.class);
                startActivity(i);


            }
        });
    }
}
