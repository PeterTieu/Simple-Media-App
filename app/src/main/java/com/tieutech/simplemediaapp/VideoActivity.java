package com.tieutech.simplemediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    //View variable
    VideoView videoView;

    //Video link variable
    String VIDEO_LINK = "https://download.samplelib.com/mp4/sample-5s.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Obtain view
        videoView = findViewById(R.id.videoView);

        //Add a Media Controller to the video (i.e. play, rewind, seek bar, etc.)
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Uri uri = Uri.parse(VIDEO_LINK);
        videoView.setVideoURI(uri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();

//                videoView.getCurrentPosition();
//                videoView.isPlaying();
            }
        });

        //Set what happens when the video finishes playing
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(VideoActivity.this, "Video is finished", Toast.LENGTH_SHORT).show();

                videoView.seekTo(0); //Reset the video to the start position once it is completed
            }
        });
    }

}