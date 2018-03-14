package com.home.raunak.myapp2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteDemo extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_demo);
        e=findViewById(R.id.editText10);
        b=findViewById(R.id.button15);
        db=openOrCreateDatabase("kolkata",MODE_PRIVATE,null);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e.getText().toString();
                db.execSQL("delete from student where name='"+n+"'");
                Intent i=new Intent(DeleteDemo.this,ViewRecord.class);
                startActivity(i);
            }
        });
    }
}
