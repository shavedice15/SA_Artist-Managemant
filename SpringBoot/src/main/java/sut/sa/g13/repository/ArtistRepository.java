package sut.sa.g13.repository;

import sut.sa.g13.entity.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends JpaRepository<Artist,Long>{
    Artist findByArtistId(Long artistId);
}
