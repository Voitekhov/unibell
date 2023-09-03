package voy.task.unibell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import voy.task.unibell.model.entity.Client;

import java.util.Set;

public interface ClientJpaRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT c FROM Client c")
    Set<Client> findAllClients();
}
