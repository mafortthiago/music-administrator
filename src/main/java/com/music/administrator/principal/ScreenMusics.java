package com.music.administrator.principal;

import com.music.administrator.model.Artist;
import com.music.administrator.model.Music;
import com.music.administrator.repository.ArtistRepository;
import com.music.administrator.repository.MusicRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ScreenMusics {
    private Scanner scanner = new Scanner(System.in);
    private MusicRepository musicRepository;
    private ArtistRepository artistRepository;

    public ScreenMusics(MusicRepository musicRepository, ArtistRepository artistRepository) {
        this.musicRepository = musicRepository;
        this.artistRepository = artistRepository;
    }

    private String showMenu() {
        return """
                *** Music administrator
                | 1 | Insert
                | 2 | Update
                | 3 | Listing
                | 4 | Delete
                                
                | 0 | Terminate
                                
                -> Which option do you want?
                """;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println(this.showMenu());
            opcao = this.scanner.nextInt();
            this.scanner.nextLine();
            switch (opcao) {
                case 1:
                    this.insert();
                    break;
                case 2:
                    this.update();
                    break;
                case 3:
                    this.listing();
                    break;
                case 4:
                    this.delete();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Option doesn't exists.");
            }
        } while (opcao != 0);
    }

    private void insert() {
        System.out.println("What's the artist's name?");
        var artistName = scanner.nextLine();
        Optional<Artist> artistSearch = artistRepository.findByNameContainingIgnoreCase(artistName);
        if (artistSearch.isPresent()) {
            System.out.println("What is the name of the song?");
            var songName = scanner.nextLine();
            System.out.println("What's the music duration? (in seconds)");
            var musicDuration = scanner.nextInt();
            scanner.nextLine();
            Music music = new Music(songName, musicDuration);
            music.setArtist(artistSearch.get());
            musicRepository.save(music);
        } else {
            System.out.println("Artist not found");
        }
    }

    private void update() {
        System.out.println("Which song id do you want to change?");
        var idMusic = scanner.nextLong();
        scanner.nextLine();
        Optional<Music> musicSearch = musicRepository.findById(idMusic);
        if (musicSearch.isPresent()) {
            System.out.println("What is the name of the song?");
            var songName = scanner.nextLine();
            System.out.println("What's the music duration? (in seconds)");
            var musicDuration = scanner.nextInt();
            scanner.nextLine();
            Music music = new Music(idMusic, songName, musicDuration, musicSearch.get().getArtist());
            musicRepository.save(music);
        }
        else{
            System.out.println("Doesn't have song with this id.");
        }
    }

    private void listing() {
        List<Music> music = musicRepository.findAll();
        System.out.println("Songs: ");
        music.forEach(m -> System.out.println("| " + m.getId() + " | " + m.getName()));
    }

    private void delete() {
        System.out.println("Which song id do you want to delete?");
        var idMusic = scanner.nextLong();
        scanner.nextLine();
        Optional<Music> musicSearch = musicRepository.findById(idMusic);
        musicSearch.ifPresent(music -> musicRepository.deleteById(music.getId()));
    }
}
