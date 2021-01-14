package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.exceptions.BusinessException;
import br.com.nomadweb.osworksapi.domain.models.Client;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrderStatus;
import br.com.nomadweb.osworksapi.domain.repositories.ClientRepository;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderIndexService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceOrderToDTOService serviceOrderToDTOService;

    public List<ServiceOrderDTO> index() {
        return serviceOrderRepository.findAll().stream()
                .map(serviceOrder ->
                        serviceOrderToDTOService.toDTO(serviceOrder))
                .collect(Collectors.toList());
    }
}
