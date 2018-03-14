package com.home.raunak.myapp2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MyMusicDemo extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnSeekCompleteListener {

    TextView tv1,tv2,tv3;
    Button b1,b2,b3,b4,b5;
    ProgressBar pb;
    SeekBar sb;
    ToggleButton tb;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music_demo);
        tv1=findViewById(R.id.textView2);
        tv2=findViewById(R.id.textView3);
        tv3=findViewById(R.id.textView4);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        pb=findViewById(R.id.progressBar);
        sb=findViewById(R.id.seekBar);
        tb=findViewById(R.id.toggleButton);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        sb.setOnSeekBarChangeListener(this);
        tb.setOnClickListener(this);

        mp=MediaPlayer.create(this,R.raw.kabira);
        sb.setMax(mp.getDuration());
        pb.setMax(mp.getDuration());

        Thread t=new Thread()
        {
            public void run(){
                while (true){
                    sb.setProgress(mp.getCurrentPosition());
                    pb.setProgress(mp.getCurrentPosition());
                }
            }
        };
        t.start();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2){
            if(mp.isPlaying()==false) {
                mp.start();
                double c = mp.getDuration();
                double d = c / 1000;
                double e = d / 60;
                double f = d % 60;
                tv3.setText((int) e + ":" + (int) f);
            }
        }
        if(v.getId()==R.id.button3){
            mp.pause();
            double c=mp.getCurrentPosition();
            double d=c/1000;
            double e=d/60;
            double f=d%60;
            tv1.setText((int)e+":"+(int)f);
        }
        if(v.getId()==R.id.button){
            mp.seekTo(0);
            tv1.setText("00:00");
        }
        if(v.getId()==R.id.button4){
            if(mp.getDuration()>(mp.getCurrentPosition()+5000)){
                mp.seekTo(mp.getCurrentPosition()+5000);
                double c=mp.getCurrentPosition();
                double d=c/1000;
                double e=d/60;
                double f=d%60;
                tv1.setText((int)e+":"+(int)f);
            }
        }
        if(v.getId()==R.id.button5){
            if(0<mp.getCurrentPosition()-5000){
                mp.seekTo(mp.getCurrentPosition()-5000);
                double c=mp.getCurrentPosition();
                double d=c/1000;
                double e=d/60;
                double f=d%60;
                tv1.setText((int)e+":"+(int)f);
            }
        }
        if(tb.getText().equals("DISABLE BUTTON")){
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
        }
        if(tb.getText().equals("ENABLE BUTTON")){
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser==true){
            mp.seekTo(progress);
        }
        double c=mp.getCurrentPosition();
        double d=c/1000;
        double e=d/60;
        double f=d%60;
        tv1.setText((int)e+":"+(int)f);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        double c=mp.getCurrentPosition();
        double d=c/1000;
        double e=d/60;
        double f=d%60;
        tv1.setText((int)e+":"+(int)f);

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        double c=mp.getCurrentPosition();
        double d=c/1000;
        double e=d/60;
        double f=d%60;
        tv1.setText((int)e+":"+(int)f);

    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {
        mp.seekTo(0);
    }
}
