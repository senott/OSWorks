package br.com.nomadweb.osworksapi.domain.repositories;

import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
