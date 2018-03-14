package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class GridDemo extends AppCompatActivity {

    GridView g;
    String[] str={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glayout);
        g=findViewById(R.id.pen);
        ArrayAdapter<String> ob=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str);
        g.setAdapter(ob);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st=str[position];
                Toast.makeText(getApplicationContext(),""+st,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
