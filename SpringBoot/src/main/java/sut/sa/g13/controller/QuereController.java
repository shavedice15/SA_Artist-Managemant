package sut.sa.g13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g13.entity.*;
import sut.sa.g13.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class QuereController {
    @Autowired private final QuereRepository quereRepository;
    @Autowired private BandRepository bandRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private PlaceRepository placeRepository;
    @Autowired private TypeWorkRepository typeWorkRepository;
    @Autowired private StatusRepository statusRepository;

    @Autowired
    QuereController(QuereRepository quereRepository) {
        this.quereRepository = quereRepository;
    }

    @GetMapping("/Queres")
    public Collection<Quere> Quere() {
        return quereRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Quere/{id}")
    public Optional<Quere> View(@PathVariable Long id) {
        Optional<Quere> Q = quereRepository.findById(id);
        return Q;
    }

    @PostMapping("/Quere/cancel/{quereId}")
    public Quere updateQuere(Quere quere, @PathVariable long quereId) {
        Long statusId = 3L;
        Status status = statusRepository.findByStatusId(statusId);
        quere = quereRepository.findById(quereId);
        quere.setStatusQuere(status);
        return quereRepository.save(quere);
    }

    @PostMapping("/Quere/{bandId}/{username}/{typeworkId}/{placeId}")
    public Quere newQuere(Quere newQuere,@PathVariable Long bandId,@PathVariable String username, @PathVariable Long typeworkId,
                          @PathVariable Long placeId) {
        Long statusId = 1L;
        Customer customer = customerRepository.findByUsername(username);
        Band band = bandRepository.findByBandId(bandId);
        Place place = placeRepository.findByPlaceId(placeId);
        TypeWork typeWork = typeWorkRepository.findByTypeworkId(typeworkId);
        Status status = statusRepository.findByStatusId(statusId);

        newQuere.setBandQuere(band);
        newQuere.setCustomerQuere(customer);
        newQuere.setPlaceQuere(place);
        newQuere.setTypeworkQuere(typeWork);
        newQuere.setStatusQuere(status);

        return quereRepository.save(newQuere);
    }

}
