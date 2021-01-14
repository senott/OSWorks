package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderToDTOService {
    @Autowired
    private ModelMapper modelMapper;

    public ServiceOrderDTO toDTO(ServiceOrder serviceOrder) {
        return modelMapper.map(serviceOrder, ServiceOrderDTO.class);
    }
}
