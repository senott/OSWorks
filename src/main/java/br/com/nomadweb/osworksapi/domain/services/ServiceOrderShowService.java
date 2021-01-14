package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.exceptions.EntityNotFoundException;
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

    public ServiceOrder execute(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

        return serviceOrder;
    }
}
