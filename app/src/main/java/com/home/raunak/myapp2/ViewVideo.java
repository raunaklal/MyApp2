package com.home.raunak.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ViewVideo extends AppCompatActivity {

    VideoView vv;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        Bundle extras= intent.getExtras();
        filename=extras.getString("videofilename");
        setContentView(R.layout.activity_view_video);
        vv=findViewById(R.id.videoView);
        vv.setVideoPath(filename);
        vv.setMediaController(new MediaController(this));
        vv.requestFocus();
        vv.start();
    }
}
