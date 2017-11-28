package com.example.yyun.yytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {


    private  static int BBCAMERA_REQUEST_CODE=1;
    private  static int BBGALLARY_REQUEST_CODE=2;
    private  static int CHECK_REQUEST_CODE=3;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==BBCAMERA_REQUEST_CODE){
            if(data==null){
                return;
            }
            else {
                Bundle extras = data.getExtras();
                if(extras != null){
                    Bitmap bm=extras.getParcelable("data");
                    ImageView photo=(ImageView)findViewById(R.id.photo);
                    photo.setImageBitmap(bm);
                }
            }
        }
        else if(requestCode==BBGALLARY_REQUEST_CODE){

            if(data==null){
                return;
            }
            InputStream is=null;
            Uri uri;
            uri = data.getData();
            try {
                is=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(is);
                ImageView GallaryPhoto = (ImageView) findViewById(R.id.gallaryPhoto);
                GallaryPhoto.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else if(requestCode==CHECK_REQUEST_CODE){
            if(data == null)
            {
                return;
            }
            Bundle extras = data.getExtras();
            if(extras == null){
                return;
            }
            Bitmap bm = extras.getParcelable("data");
            ImageView imageView = (ImageView)findViewById(R.id.gallaryPhoto);
            imageView.setImageBitmap(bm);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Button btn_camera=(Button)findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,BBCAMERA_REQUEST_CODE);
            }
        });

        Button btn_gallary=(Button)findViewById(R.id.btn_gallary);
        btn_gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,BBGALLARY_REQUEST_CODE);
            }
        });

    }
}
