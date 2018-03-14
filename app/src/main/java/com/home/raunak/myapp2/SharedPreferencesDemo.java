package com.home.raunak.myapp2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferencesDemo extends AppCompatActivity {

    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_demo);
        e1=findViewById(R.id.editText);

        SharedPreferences sh=getSharedPreferences("mm",0);
        e1.setText(sh.getString("mytext",""));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp=getSharedPreferences("mm",0);

        SharedPreferences.Editor editor=sp.edit();

        editor.putString("mytext", e1.getText().toString());

        editor.commit();
    }
}
