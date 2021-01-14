package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderIndexService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<ServiceOrder> execute() {
        return serviceOrderRepository.findAll();
    }
}
