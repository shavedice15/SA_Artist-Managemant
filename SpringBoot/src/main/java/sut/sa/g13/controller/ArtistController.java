package sut.sa.g13.controller;

import sut.sa.g13.entity.Artist;
import sut.sa.g13.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class ArtistController {
    @Autowired private final ArtistRepository artistRepository;

    ArtistController(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @GetMapping("/Artists")
    public Collection<Artist> artists() {
        return artistRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Artist/add/{artistname}/{price}/{typeMusic}")
    public Artist newArtist(@PathVariable String artistname,@PathVariable int price, @PathVariable String typeMusic){
        Artist newArist = new Artist();
        newArist.setArtistname(artistname);
        newArist.setPrice(price);
        newArist.setTypeMusic(typeMusic);
        return  artistRepository.save(newArist);
    }
}