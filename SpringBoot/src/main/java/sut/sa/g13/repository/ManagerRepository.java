package sut.sa.g13.repository;

import sut.sa.g13.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByUsername(String username);
}
