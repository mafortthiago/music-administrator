package com.music.administrator.principal;

import com.music.administrator.repository.ArtistRepository;
import com.music.administrator.repository.MusicRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Screen {
    private final Scanner scanner = new Scanner(System.in);
    private final ScreenArtists screenArtists;
    private final ScreenMusics screenMusics;

    public Screen(ArtistRepository artistRepository, MusicRepository musicRepository) {
        this.screenArtists = new ScreenArtists(artistRepository);
        this.screenMusics = new ScreenMusics(musicRepository, artistRepository);
    }

    private String exibeMenu(){
        return """
                *** Music administrator ***
                | 1 | Managing artists
                | 2 | Managing music
                
                | 0 | Terminate
                
                -> Which option do you want?
                """;
    }
    public void menu(){
        int opcao = -1;
        while (opcao != 0){
            System.out.println(exibeMenu());
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    screenArtists.menu();
                    break;
                case 2:
                    screenMusics.menu();
                    break;
                case 3:
                    this.findMusicByArtist();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Option doesn't exists.");
            }
        }
    }

    private void findMusicByArtist() {
    }
}
