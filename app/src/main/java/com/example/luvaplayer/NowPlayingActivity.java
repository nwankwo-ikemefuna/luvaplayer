package com.example.luvaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //retrieve song info from tracks activity and render in the respective views of this activity

        //Song Title
        String SongTitle = getIntent().getStringExtra("song_title");
        TextView txtSongTitle = (TextView) findViewById(R.id.song_title);
        txtSongTitle.setText(SongTitle);

        //Song Artist
        String SongArtist = getIntent().getStringExtra("song_artist");
        TextView txtSongArtist = (TextView) findViewById(R.id.song_artist);
        txtSongArtist.setText(SongArtist);

        //Song Image
        int SongImageResourceID = getIntent().getIntExtra("song_image", 0);
        //song image icon
        ImageView imgSongImageIcon = (ImageView) findViewById(R.id.song_image_icon);
        imgSongImageIcon.setImageResource(SongImageResourceID);
        //song image
        ImageView imgSongImage = (ImageView) findViewById(R.id.song_image);
        imgSongImage.setImageResource(SongImageResourceID);

        // OnClickListener for the tracks icon to return user to the music library
        ImageView tracks_icon = (ImageView) findViewById(R.id.tracks_icon);
        // Set a click listener on that View
        tracks_icon.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the tracks icon is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(NowPlayingActivity.this, TracksActivity.class);
                startActivity(tracksIntent);
            }
        });

    }
}
