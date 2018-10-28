package sut.sa.g13.repository;

import sut.sa.g13.entity.Band;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BandRepository extends JpaRepository<Band,Long>{
    Band findByBandId(Long bandId);
}

