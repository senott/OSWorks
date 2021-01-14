package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.domain.exceptions.EntityNotFoundException;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderCloseService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder execute(Long serviceOrderId) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

        serviceOrder.close();

        return serviceOrderRepository.save(serviceOrder);
    }
}
