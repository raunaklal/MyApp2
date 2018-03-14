package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String ar[]={" ","Kolkata","Mumbai","New Delhi", "New York", "Washington DC","Sydney","Cape Town","London","Manhattan"};
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa= new ArrayAdapter(this,android.R.layout.simple_spinner_item,ar);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        //spinner.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_item,ar));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),ar[position],Toast.LENGTH_LONG).show();
        textView.setText(ar[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
