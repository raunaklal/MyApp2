package com.home.raunak.myapp2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDemo extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_demo);
        b=findViewById(R.id.button);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        db=openOrCreateDatabase("kolkata",MODE_PRIVATE,null);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String p=e2.getText().toString();
                String a=e3.getText().toString();

                db.execSQL("update student set pass='"+p+"', address='"+a+"' where name='"+n+"'");
                Intent i=new Intent(UpdateDemo.this,ViewRecord.class);
                startActivity(i);
            }
        });
    }
}
