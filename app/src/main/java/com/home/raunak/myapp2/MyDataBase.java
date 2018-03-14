package com.home.raunak.myapp2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyDataBase extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_base);
        db=openOrCreateDatabase("kolkata",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS student(name varchar(20), pass varchar(20), address varchar(20))");
        e1=findViewById(R.id.editText4);
        e2=findViewById(R.id.editText5);
        b1=findViewById(R.id.button12);
        b2=findViewById(R.id.button13);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=e1.getText().toString();
                String p=e2.getText().toString();
                Cursor c=db.rawQuery("select name, pass from student where name='"+n+"' and pass='"+p+"'",null);
                if(c.moveToNext()){
                    Intent i2=new Intent(MyDataBase.this,ViewRecord.class);
                    startActivity(i2);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed!! Please enter correct Name and Password",Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MyDataBase.this,Reg.class);
                startActivity(i);
            }
        });

    }
}
