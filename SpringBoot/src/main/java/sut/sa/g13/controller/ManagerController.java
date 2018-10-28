package sut.sa.g13.controller;

import org.springframework.web.bind.annotation.*;
import sut.sa.g13.entity.Manager;
import sut.sa.g13.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class ManagerController {
    @Autowired private final ManagerRepository managerRepository;

    ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/Managers")
    public Collection<Manager> managers() {
        return managerRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Manager/user/{username}")
    public Manager manager (@PathVariable String username) {
        Manager findManager = managerRepository.findByUsername(username);
        return findManager;
    }
}
