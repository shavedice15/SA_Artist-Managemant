package sut.sa.g13.controller;

import sut.sa.g13.entity.Artist;
import sut.sa.g13.entity.Band;
import sut.sa.g13.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g13.repository.BandRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class ArtistController {
    @Autowired private final ArtistRepository artistRepository;
    @Autowired private BandRepository bandRepository;

    ArtistController(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @GetMapping("/Artists")
    public Collection<Artist> artists() {
        return artistRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Artist/{bandId}")
    public Collection<Artist> artist(@PathVariable long bandId) {
        Band band = bandRepository.findByBandId(bandId);
        return artistRepository.findByBand(band).stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Artist/add/{artistname}/{bandId}")
    public Artist newArtist(@PathVariable String artistname,@PathVariable Long bandId){
        Band band = bandRepository.findByBandId(bandId);
        Artist newArist = new Artist();
        newArist.setArtistname(artistname);
        newArist.setBand(band);
        return  artistRepository.save(newArist);
    }
}