package com.music.administrator.principal;

import com.music.administrator.model.Artist;
import com.music.administrator.model.EnumArtist;
import com.music.administrator.model.Music;
import com.music.administrator.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ScreenArtists {
    private Scanner scanner = new Scanner(System.in);

    private ArtistRepository artistRepository;

    public ScreenArtists(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    private String showMenu() {
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
        System.out.println("What's the artist's type? (solo,duo or band)");
        var artistType = scanner.nextLine();
        EnumArtist enumArtist = EnumArtist.valueOf(artistType.toUpperCase());
        artistRepository.save(new Artist(artistName, enumArtist));
    }

    private void update() {
        System.out.println("Which artist id do you want to change?");
        var idArtist = scanner.nextLong();
        scanner.nextLine();
        Optional<Artist> artistSearch = artistRepository.findById(idArtist);
        if (artistSearch.isPresent()) {
            System.out.println("What's the artist's name?");
            var artistName = scanner.nextLine();
            System.out.println("What's the artist's type? (solo,duo or band)");
            var artistType = scanner.nextLine();
            EnumArtist enumArtist = EnumArtist.valueOf(artistType.toUpperCase());
            artistRepository.save(new Artist(artistName, enumArtist, idArtist));
        }else{
            System.out.println("Doesn't have artist with this id.");
        }
    }

    private void listing() {
        List<Artist> artists = artistRepository.findAll();
        artists.forEach(a -> System.out.println("|" + a.getId() + "| " + a.getName()));
    }

    private void delete() {
        System.out.println("Which artist id do you want to change?");
        var idArtist = scanner.nextLong();
        scanner.nextLine();
        Optional<Artist> artistSearch = artistRepository.findById(idArtist);
        if (artistSearch.isPresent()) {
            artistRepository.deleteById(idArtist);
            System.out.println("Artist deleted");
        } else{
            System.out.println("Doesn't have artist with this id.");
        }

    }
}
