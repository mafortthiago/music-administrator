package com.music.administrator.principal;

import java.util.Scanner;

public class Screen {
    private final Scanner scanner = new Scanner(System.in);
    private final ScreenArtists screenArtists = new ScreenArtists();
    private final ScreenMusics screenMusics = new ScreenMusics();

    private String exibeMenu(){
        return """
                *** Music administrator ***
                | 1 | Managing artists
                | 2 | Managing music
                | 3 | Find music by artist
                
                | 0 | Terminate
                
                -> Which option do you want?
                """;
    }
    public void menu(){
        int opcao = -1;
        while (opcao != 0){
            System.out.println(exibeMenu());
            opcao = scanner.nextInt();
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
