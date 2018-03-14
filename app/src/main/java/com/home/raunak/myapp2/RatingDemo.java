package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingDemo extends AppCompatActivity {

    RatingBar ratingBar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_demo);
        ratingBar=findViewById(R.id.ratingBar);
        button=findViewById(R.id.button9);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        });
    }
}
