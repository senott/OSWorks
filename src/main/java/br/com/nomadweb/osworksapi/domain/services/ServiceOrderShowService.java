package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceOrderShowService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceOrderToDTOService serviceOrderToDTOService;

    public ResponseEntity<ServiceOrderDTO> execute(Long id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);

        return serviceOrder.map(order -> ResponseEntity.ok(serviceOrderToDTOService.execute(order))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
