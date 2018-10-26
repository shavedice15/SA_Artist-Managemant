package sut.sa.g13.controller;

import sut.sa.g13.entity.TypeWork;
import sut.sa.g13.repository.TypeWorkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class TypeWorkController {
    @Autowired private final TypeWorkRepository typeWorkRepository;

    TypeWorkController(TypeWorkRepository typeWorkRepository) {
        this.typeWorkRepository = typeWorkRepository;
    }

    @GetMapping("/TypeWorks")
    public Collection<TypeWork> typeWork() {
        return typeWorkRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/TypeWork/add/{typeWork}")
    public TypeWork typeWork(@RequestBody String typeWork) {
        TypeWork newType = new TypeWork();
        newType.setTypeWork(typeWork);
        return typeWorkRepository.save(newType);
    }
}
