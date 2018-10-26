package sut.sa.g13.repository;

import sut.sa.g13.entity.Quere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuereRepository extends JpaRepository <Quere, Long> {
    Quere findById(long quereId);
}
