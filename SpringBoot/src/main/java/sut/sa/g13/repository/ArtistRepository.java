package sut.sa.g13.repository;

import sut.sa.g13.entity.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g13.entity.Band;

import java.util.Collection;

@RepositoryRestResource
public interface ArtistRepository extends JpaRepository<Artist,Long>{
    Collection<Artist> findByBand(Band band);
    Artist findByArtistId(Long artistId);
}
