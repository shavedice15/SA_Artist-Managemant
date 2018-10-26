package sut.sa.g13.repository;

import sut.sa.g13.entity.Place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByPlaceId(Long placeId);
}
