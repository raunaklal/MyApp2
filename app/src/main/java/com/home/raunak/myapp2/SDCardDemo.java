package com.home.raunak.myapp2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SDCardDemo extends AppCompatActivity {

    private Cursor videocursor;
    private int video_column_index;
    ListView videolist;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard_demo);
        init_phone_video_grid();
    }

    public void init_phone_video_grid(){
        String[] proj={MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.DISPLAY_NAME,
                MediaStore.Video.Media.SIZE };

        videocursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,proj,null,null,null);
        count=videocursor.getCount();
        videolist=findViewById(R.id.lv);
        videolist.setAdapter(new VideoAdapter(getApplicationContext()));
        videolist.setOnItemClickListener(videogridlistener);

    }

    AdapterView.OnItemClickListener videogridlistener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            video_column_index=videocursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            videocursor.moveToPosition(position);
            String filename=videocursor.getString(video_column_index);
            Intent intent=new Intent(SDCardDemo.this,ViewVideo.class);
            intent.putExtra("videofilename",filename);
            startActivity(intent);
        }
    };

    public class VideoAdapter extends BaseAdapter{

        private Context vContext;

        public VideoAdapter(Context applicationContext) {
            vContext=applicationContext;
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            String id=null;
            convertView=null;
            if(convertView==null){
                convertView= LayoutInflater.from(vContext).inflate(R.layout.layout_video,parent,false);
                holder=new ViewHolder();
                holder.txtTitle= convertView.findViewById(R.id.txtTitle);
                holder.txtSize=convertView.findViewById(R.id.txtSize);
                holder.thumbImage=convertView.findViewById(R.id.imgIcon);

                video_column_index=videocursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
                videocursor.moveToPosition(position);
                id=videocursor.getString(video_column_index);
                video_column_index=videocursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);
                videocursor.moveToPosition(position);
                holder.txtTitle.setText(id);
                holder.txtSize.setText(" Size(KB) : "+ videocursor.getString(video_column_index));

                String[] proj={MediaStore.Video.Media._ID,
                        MediaStore.Video.Media.DATA,
                        MediaStore.Video.Media.DISPLAY_NAME,
                        MediaStore.Video.Media.SIZE };

                Cursor cursor=managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,proj, MediaStore.Video.Media.DISPLAY_NAME+ "=?",new String[]{id},null);
                cursor.moveToFirst();
                long ids= cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media._ID));

                ContentResolver crThumb = getContentResolver();
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize=1;
                Bitmap curThumb= MediaStore.Video.Thumbnails.getThumbnail(crThumb, ids, MediaStore.Video.Thumbnails.MICRO_KIND,options);
                holder.thumbImage.setImageBitmap(curThumb);
                curThumb=null;
            }

            return convertView;
        }
    }
    static class ViewHolder {
        TextView txtTitle;
        TextView txtSize;
        ImageView thumbImage;
    }
}
