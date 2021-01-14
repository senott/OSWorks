package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderIndexService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceOrderToDTOService serviceOrderToDTOService;

    public List<ServiceOrderDTO> execute() {
        return serviceOrderRepository.findAll().stream()
                .map(serviceOrder ->
                        serviceOrderToDTOService.execute(serviceOrder))
                .collect(Collectors.toList());
    }
}
