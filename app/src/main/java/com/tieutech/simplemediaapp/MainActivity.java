package com.tieutech.simplemediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //MediaPlayer variable
    MediaPlayer mediaPlayer;

    //Audio link variable
    String VIDEO_LINK = "https://download.samplelib.com/mp3/sample-9s.mp3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mediaPlayer = new MediaPlayer();
    }

    //Listener for "Play Music" Button - downloads an audio from a URL link and plays it
    public void playMusicClick(View view) {

        mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(VIDEO_LINK); //Set the URL of the audio
            mediaPlayer.prepare(); //Prepare the audio
            mediaPlayer.start(); //Play the audio
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Listener for "Stop Music" Button
    public void stopMusicClick(View view) {

        //If the audio is playing
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
            mediaPlayer.release();
        }
        else {
            Toast.makeText(MainActivity.this, "Audio not started", Toast.LENGTH_SHORT);
        }
    }

    //Listener for "Show Video" button
    public void showVideoClick(View view) {
        startActivity(new Intent(MainActivity.this, VideoActivity.class));
    }

}