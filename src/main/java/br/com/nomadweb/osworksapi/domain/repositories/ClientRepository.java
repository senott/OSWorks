package br.com.nomadweb.osworksapi.domain.repositories;

import br.com.nomadweb.osworksapi.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
