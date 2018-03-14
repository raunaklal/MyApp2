package com.home.raunak.myapp2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyCustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_custom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.red:
                Toast.makeText(getApplicationContext(),"RED",Toast.LENGTH_LONG).show();
                break;
            case R.id.green:
                Toast.makeText(getApplicationContext(),"GREEN",Toast.LENGTH_LONG).show();
                break;
            case R.id.black:
                Toast.makeText(getApplicationContext(),"BLACK",Toast.LENGTH_LONG).show();
                break;
            case R.id.blue:
                Toast.makeText(getApplicationContext(),"BLUE",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
