package com.team04.musiccloud.audio;

import java.time.LocalDateTime;
import java.util.Objects;

public class AudioMeta {
    private String id;
    private String title;
    private String author;
    private String album;
    private LocalDateTime releaseDate;
    
    public AudioMeta(String title, String author, String album, LocalDateTime releaseDate) {
        setTitle(title);
        setAuthor(author);
        setAlbum(album);
        setReleaseDate(releaseDate);
    }
    
    public AudioMeta(String id, String title, String author, String album, LocalDateTime releaseDate) {
        this(title, author, album, releaseDate);
        setId(id);
    }
    
    public AudioMeta(AudioMeta other) {
        this(other.id, other.title, other.author, other.album, other.releaseDate);
    }
    
    public String getId() {
        return id;
    }
    
    protected void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    protected void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    protected void setAuthor(String author) {
        this.author = author;
    }
    
    public String getAlbum() {
        return album;
    }
    
    protected void setAlbum(String album) {
        this.album = album;
    }
    
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }
    
    protected void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        
        AudioMeta audioMeta = (AudioMeta) o;
        
        return Objects.equals(title, audioMeta.title) &&
                Objects.equals(author, audioMeta.author) &&
                Objects.equals(releaseDate, audioMeta.releaseDate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseDate);
    }
}