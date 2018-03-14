package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tv=findViewById(R.id.textView);
        Bundle ob=getIntent().getExtras();
        String n=ob.getString("abc");
        String p=ob.getString("xyz");
        if(n.equals("Kolkata")&& p.equals("Admin")){
            tv.setText("Login Successful!!!!");
        }
        else {
            tv.setText("Wrong Login ID and password");
        }
    }
}
