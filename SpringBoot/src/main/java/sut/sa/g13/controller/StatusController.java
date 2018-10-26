package sut.sa.g13.controller;

import sut.sa.g13.entity.Status;
import sut.sa.g13.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class StatusController {
    @Autowired private final StatusRepository statusRepository;

    StatusController (StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @GetMapping("/Statuses")
    public Collection<Status> status() {
        return statusRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Status/add/{status}")
    public Status status(@RequestBody String status) {
        Status newStatus = new Status();
        newStatus.setStatusQuere(status);
        return statusRepository.save(newStatus);
    }
}
