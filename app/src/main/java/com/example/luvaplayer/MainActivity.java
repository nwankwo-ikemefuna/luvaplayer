package com.example.luvaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the tracks category
        TextView tracks = (TextView) findViewById(R.id.tracks);
        // Set a click listener on that View
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the tracks View is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracksIntent = new Intent(getApplicationContext(), TracksActivity.class);
                startActivity(tracksIntent);
            }
        });

        // Find the View that shows the playlists category
        TextView playlists = (TextView) findViewById(R.id.playlist);
        // Set a click listener on that View
        playlists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlists View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistsIntent = new Intent(getApplicationContext(), MyPlaylistActivity.class);
                startActivity(playlistsIntent);
            }
        });

        // Recently Played Songs
        // Create a list of songs using our custom class Song as type parameter
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.song_title_1), getString(R.string.song_artist_1), "3:42", R.drawable.song_image_1));
        songs.add(new Song(getString(R.string.song_title_5), getString(R.string.song_artist_5), "5:12", R.drawable.song_image_5));
        songs.add(new Song(getString(R.string.song_title_10), getString(R.string.song_artist_10), "3:55", R.drawable.song_image_10));
        songs.add(new Song(getString(R.string.song_title_18), getString(R.string.song_artist_18), "4:38", R.drawable.song_image_18));
        songs.add(new Song(getString(R.string.song_title_20), getString(R.string.song_artist_20), "5:07", R.drawable.song_image_20));
        songs.add(new Song(getString(R.string.song_title_21), getString(R.string.song_artist_21), "3:45", R.drawable.song_image_21));
        songs.add(new Song(getString(R.string.song_title_26), getString(R.string.song_artist_26), "4:20", R.drawable.song_image_26));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list layout file.
        ListView listView = (ListView) findViewById(R.id.song_list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        //Attach onClickListener to the individual list items to open the Now Playing Activity when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg) {
                Song currentSong = songs.get(position);
                Intent NowPlayingIntent = new Intent(getApplicationContext(), NowPlayingActivity.class);
                //pass current song params to NowPlaying Activity
                NowPlayingIntent.putExtra("song_title", currentSong.getSongTitle());
                NowPlayingIntent.putExtra("song_artist", currentSong.getSongArtiste());
                NowPlayingIntent.putExtra("song_duration", currentSong.getSongDuration());
                NowPlayingIntent.putExtra("song_image", currentSong.getImageResourceId());
                startActivity(NowPlayingIntent);
            }
        });

    }

}
