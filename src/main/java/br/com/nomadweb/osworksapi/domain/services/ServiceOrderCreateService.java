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

import java.time.OffsetDateTime;

@Service
public class ServiceOrderCreateService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceOrderToDTOService serviceOrderToDTOService;

    public ServiceOrderDTO create(ServiceOrder serviceOrder) {
        Client client = clientRepository.findById(serviceOrder.getClient().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado."));

        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setOpenDate(OffsetDateTime.now());

        return serviceOrderToDTOService.toDTO(serviceOrderRepository.save(serviceOrder));
    }
}
