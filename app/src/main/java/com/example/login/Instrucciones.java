package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Instrucciones extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones);

        VideoView mivideo=findViewById(R.id.video1);

        String videop="android.resource://" + getPackageName() + "/" + R.raw.uno;
        Uri uri= Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);
    }
}
