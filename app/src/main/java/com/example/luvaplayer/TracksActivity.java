package com.example.luvaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        // Create a list of songs using our custom class Song as type parameter
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.song_title_1), getString(R.string.song_artist_1), "3:42", R.drawable.song_image_1));
        songs.add(new Song(getString(R.string.song_title_2), getString(R.string.song_artist_2), "4:01", R.drawable.song_image_2));
        songs.add(new Song(getString(R.string.song_title_3), getString(R.string.song_artist_3), "3:19", R.drawable.song_image_3));
        songs.add(new Song(getString(R.string.song_title_4), getString(R.string.song_artist_4), "5:24", R.drawable.song_image_4));
        songs.add(new Song(getString(R.string.song_title_5), getString(R.string.song_artist_5), "5:12", R.drawable.song_image_5));
        songs.add(new Song(getString(R.string.song_title_6), getString(R.string.song_artist_6), "3:37", R.drawable.song_image_6));
        songs.add(new Song(getString(R.string.song_title_7), getString(R.string.song_artist_7), "3:50", R.drawable.song_image_7));
        songs.add(new Song(getString(R.string.song_title_8), getString(R.string.song_artist_8), "5:02", R.drawable.song_image_8));
        songs.add(new Song(getString(R.string.song_title_9), getString(R.string.song_artist_9), "4:16", R.drawable.song_image_9));
        songs.add(new Song(getString(R.string.song_title_10), getString(R.string.song_artist_10), "3:55", R.drawable.song_image_10));
        songs.add(new Song(getString(R.string.song_title_11), getString(R.string.song_artist_11), "4:00", R.drawable.song_image_11));
        songs.add(new Song(getString(R.string.song_title_12), getString(R.string.song_artist_12), "4:25", R.drawable.song_image_12));
        songs.add(new Song(getString(R.string.song_title_13), getString(R.string.song_artist_13), "3:20", R.drawable.song_image_13));
        songs.add(new Song(getString(R.string.song_title_14), getString(R.string.song_artist_14), "3:42", R.drawable.song_image_14));
        songs.add(new Song(getString(R.string.song_title_15), getString(R.string.song_artist_15), "4:31", R.drawable.song_image_15));
        songs.add(new Song(getString(R.string.song_title_16), getString(R.string.song_artist_16), "4:10", R.drawable.song_image_16));
        songs.add(new Song(getString(R.string.song_title_17), getString(R.string.song_artist_17), "3:26", R.drawable.song_image_17));
        songs.add(new Song(getString(R.string.song_title_18), getString(R.string.song_artist_18), "4:38", R.drawable.song_image_18));
        songs.add(new Song(getString(R.string.song_title_19), getString(R.string.song_artist_19), "2:59", R.drawable.song_image_19));
        songs.add(new Song(getString(R.string.song_title_20), getString(R.string.song_artist_20), "5:07", R.drawable.song_image_20));
        songs.add(new Song(getString(R.string.song_title_21), getString(R.string.song_artist_21), "3:45", R.drawable.song_image_21));
        songs.add(new Song(getString(R.string.song_title_22), getString(R.string.song_artist_22), "4:03", R.drawable.song_image_22));
        songs.add(new Song(getString(R.string.song_title_23), getString(R.string.song_artist_23), "5:22", R.drawable.song_image_23));
        songs.add(new Song(getString(R.string.song_title_24), getString(R.string.song_artist_24), "3:51", R.drawable.song_image_24));
        songs.add(new Song(getString(R.string.song_title_25), getString(R.string.song_artist_25), "3:39", R.drawable.song_image_25));
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
