package com.home.raunak.myapp2;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends ListActivity {


    String ar[]={"My Grid View Demo","Google","Facebook","Custom Menu","Intent Demo","E-Mail Sending","CheckBox Demo",
            "Radio Button Demo","Spinner Demo","Rating Demo","Seekbar Demo","Service Demo","My Music Player",
            "My Data Base","Sensor Demo","Shared Preference Demo","Google Map Demo","My GPS","Intent With Data",
            "SD Card Demo","My Notification Demo","MyView Demo","My Bluetooth Demo","My Camera Demo",
            "My Content Provider Demo"};
    Class c[]={GridDemo.class, WebDemo.class, WebDemo2.class,MyCustom.class,MyIntent.class,EmailDemo.class,CheckBoxDemo.class,
            RadioDemo.class,SpinnerDemo.class,RatingDemo.class,SeekBarDemo.class,ServiceDemo.class,MyMusicDemo.class,
            MyDataBase.class,SensorDemo.class,SharedPreferencesDemo.class,MyMap.class,MyGps.class,IntentWithData.class,
            SDCardDemo.class,MyNotificationDemo.class,MyViewDemo.class,MyBluetoothDemo.class,MyCameraDemo.class,
            MyContentProviderDemo.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        myProgress();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,ar));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent i= new Intent(MainActivity.this,c[position]);
        startActivity(i);
    }

    void myProgress(){
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading Please Wait!!");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCancelable(false);
        pd.setTitle("MY ANDROID APP");
        pd.show();
        Thread t=new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        sleep(1000/20);
                    }catch (Exception e){}
                    pd.setProgress(i);
                }
                pd.dismiss();
            }
        };
        t.start();
    }

}
