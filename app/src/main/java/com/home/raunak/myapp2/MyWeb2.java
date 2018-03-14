package com.home.raunak.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MyWeb2 extends AppCompatActivity {

    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);
        w=findViewById(R.id.gg);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("http://www.facebook.com");
    }
}
