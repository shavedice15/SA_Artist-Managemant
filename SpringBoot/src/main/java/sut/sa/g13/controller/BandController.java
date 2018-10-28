package sut.sa.g13.controller;

import sut.sa.g13.entity.Band;
import sut.sa.g13.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class BandController {
    @Autowired private final BandRepository bandRepository;

    BandController(BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }

    @GetMapping("/Bands")
    public Collection<Band> artists() {
        return bandRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Band/add/{bandname}/{price}/{typeMusic}")
    public Band newArtist(@PathVariable String bandname,@PathVariable int price, @PathVariable String typeMusic){
        Band newBand = new Band();
        newBand.setBandname(bandname);
        newBand.setPrice(price);
        newBand.setTypeMusic(typeMusic);
        return  bandRepository.save(newBand);
    }
}