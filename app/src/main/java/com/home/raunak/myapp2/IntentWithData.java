package com.home.raunak.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentWithData extends AppCompatActivity {

    EditText e1,e2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_data);
        e1=findViewById(R.id.editText9);
        e2=findViewById(R.id.editText11);
        button=findViewById(R.id.button19);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String p=e2.getText().toString();
                Intent intent=new Intent(IntentWithData.this,ShowData.class);
                intent.putExtra("abc",n);
                intent.putExtra("xyz",p);
                startActivity(intent);
            }
        });
    }
}
