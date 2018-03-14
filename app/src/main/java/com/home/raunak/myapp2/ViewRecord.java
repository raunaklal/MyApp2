package com.home.raunak.myapp2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewRecord extends AppCompatActivity {

    TextView tv;
    Button b1,b2,b3;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        b1=findViewById(R.id.button16);
        b2=findViewById(R.id.button17);
        b3=findViewById(R.id.button18);
        tv=findViewById(R.id.textView5);
        db=openOrCreateDatabase("kolkata",MODE_PRIVATE,null);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.rawQuery("select * from student",null);
                String data="Student Record Is........\nName\tPassword\tAddress\n";
                while (c.moveToNext()){
                    data=data+c.getString(0)+"  "+c.getString(1)+"  "+c.getString(2)+"\n";
                }
                tv.setText(data);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewRecord.this, UpdateDemo.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewRecord.this, DeleteDemo.class);
                startActivity(i);
            }
        });

    }
}
