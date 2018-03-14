package com.home.raunak.myapp2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyContentProviderDemo extends AppCompatActivity {

//    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_content_provider_demo);
/*        db=openOrCreateDatabase("rcpl",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS student(name varchar(20), pass varchar(20))");
        db.execSQL("insert into student values('abc',123)");
        db.execSQL("insert into student values('xyz',456)");

        Cursor c=db.rawQuery("select *from student",null);
        String data="";
        while (c.moveToNext()){
            data=data+c.getString(0)+"  "+c.getString(1);
        }
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
*/
        String url="content://com.raunak.lal";
        Uri uri=Uri.parse(url);
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(uri,null,null,null,null);
        String data="STP Content.....\n";
        while (c.moveToNext()){
            data+=c.getString(0);
            data=data+c.getString(1)+"\n";
        }
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}
