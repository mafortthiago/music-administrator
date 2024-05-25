package com.music.administrator.principal;

import java.util.Scanner;

public class ScreenArtists {
    private Scanner scanner = new Scanner(System.in);
    private String showMenu(){
        return """
                *** Artists administrator
                | 1 | Insert
                | 2 | Update
                | 3 | Listing
                | 4 | Delete
                
                | 0 | Terminate
                -> Which option do you want?
                """;
    }
    public  void menu() {
        int opcao;
        do {
            System.out.println(this.showMenu());
            opcao = this.scanner.nextInt();
            switch (opcao){
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
    }

    private void update() {
    }

    private void listing() {
    }

    private void delete() {
    }
}
