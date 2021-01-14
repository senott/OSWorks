package br.com.nomadweb.osworksapi.api.controllers;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderCreateDTO;
import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.services.ServiceOrderCreateService;
import br.com.nomadweb.osworksapi.domain.services.ServiceOrderDTOToEntityService;
import br.com.nomadweb.osworksapi.domain.services.ServiceOrderIndexService;
import br.com.nomadweb.osworksapi.domain.services.ServiceOrderShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/serviceorders")
public class ServiceOrderController {
    @Autowired
    private ServiceOrderCreateService serviceOrderCreateService;

    @Autowired
    private ServiceOrderDTOToEntityService serviceOrderDTOToEntityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrderDTO create(@Valid @RequestBody ServiceOrderCreateDTO serviceOrderCreateDTO) {
        ServiceOrder serviceOrder = serviceOrderDTOToEntityService.execute(serviceOrderCreateDTO);

        return serviceOrderCreateService.execute(serviceOrder);
    }

    @Autowired
    private ServiceOrderIndexService serviceOrderIndexService;

    @GetMapping
    public List<ServiceOrderDTO> index() {
        return serviceOrderIndexService.execute();
    }

    @Autowired
    private ServiceOrderShowService serviceOrderShowService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> show(@PathVariable Long id) {
        return serviceOrderShowService.execute(id);
    }
}
