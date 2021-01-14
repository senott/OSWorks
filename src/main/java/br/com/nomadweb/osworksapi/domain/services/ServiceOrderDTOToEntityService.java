package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderCreateDTO;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderDTOToEntityService {
    @Autowired
    private ModelMapper modelMapper;

    public ServiceOrder toEntity(ServiceOrderCreateDTO serviceOrderCreateDTO) {
        return modelMapper.map(serviceOrderCreateDTO, ServiceOrder.class);
    }
}
