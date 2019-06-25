package com.example.luvaplayer;

public class Song {

    /** Song title */
    private String mSongTitle;

    /** Song artist */
    private String mSongArtiste;

    /** Song play duration */
    private String mSongDuration;

    /** Drawable resource ID */
    private int mImageResourceId;

    /**
     * Create a new Song object.
     *
     * @param SongTitle: the title of the song
     * @param SongArtiste: the name of the artiste who did the song
     * @param SongDuration: the duration of the song
     * @param ImageResourceID: the image resource ID
     */
    public Song(String SongTitle, String SongArtiste, String SongDuration, int ImageResourceID) {
        mSongTitle = SongTitle;
        mSongArtiste = SongArtiste;
        mSongDuration = SongDuration;
        mImageResourceId = ImageResourceID;
    }

    /**
     * Get the song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the song artist
     */
    public String getSongArtiste() {
        return mSongArtiste;
    }

    /**
     * Get the song duration
     */
    public String getSongDuration() {
        return mSongDuration;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
