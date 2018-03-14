package com.home.raunak.myapp2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCameraDemo extends AppCompatActivity {

    private ImageView imageView;
    private static final int CAMERA_PIC_REQUEST=1111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_camera_demo);
        imageView=findViewById(R.id.imageView);

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_PIC_REQUEST){

            Bitmap thumbnail= (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);

            ByteArrayOutputStream bytes=new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG,100,bytes);

            Date date=new Date();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date.getTime());

            File file=new File(Environment.getExternalStorageDirectory()+File.separator+"image_"+timeStamp+".jpg");
            try {
                file.createNewFile();
                FileOutputStream fo=new FileOutputStream(file);

                fo.write(bytes.toByteArray());
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
