package com.music.administrator.model;

import jakarta.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int durationInSeconds;
    @ManyToOne
    private Artist artist;

    public Music(Long id, String name, int durationInSeconds, Artist artist) {
        this.id = id;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public Music(String name, int durationInSeconds) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public Music(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
