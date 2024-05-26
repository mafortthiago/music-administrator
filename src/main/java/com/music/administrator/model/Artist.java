package com.music.administrator.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EnumArtist typeArtist;
    @OneToMany(mappedBy = "artist")
    private List<Music> musics;

    public Artist(String name, EnumArtist enumArtist) {
        this.name = name;
        this.typeArtist = enumArtist;
    }
    public Artist(String name, EnumArtist enumArtist, Long id) {
        this.name = name;
        this.typeArtist = enumArtist;
        this.id = id;
    }
    public Artist(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public EnumArtist getTypeArtist() {
        return typeArtist;
    }

    public void setTypeArtist(EnumArtist typeArtist) {
        this.typeArtist = typeArtist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusic(Music music){
        this.musics.add(music);
    }
}
