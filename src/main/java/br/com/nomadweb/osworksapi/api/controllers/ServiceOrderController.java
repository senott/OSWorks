package br.com.nomadweb.osworksapi.api.controllers;

import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderCreateDTO;
import br.com.nomadweb.osworksapi.api.dtos.ServiceOrderDTO;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/serviceorders")
public class ServiceOrderController {
    @Autowired
    private ServiceOrderCreateService serviceOrderCreateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrderDTO create(@Valid @RequestBody ServiceOrderCreateDTO serviceOrderCreateDTO) {
        ServiceOrder serviceOrder = toModel(serviceOrderCreateDTO);

        return toDTO(serviceOrderCreateService.execute(serviceOrder));
    }

    @Autowired
    private ServiceOrderIndexService serviceOrderIndexService;

    @GetMapping
    public List<ServiceOrderDTO> index() {
        return serviceOrderIndexService.execute().stream().map(serviceOrder -> toDTO(serviceOrder)).collect(Collectors.toList());
    }

    @Autowired
    private ServiceOrderShowService serviceOrderShowService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> show(@PathVariable Long id) {
        return ResponseEntity.ok(toDTO(serviceOrderShowService.execute(id)));
    }

    @Autowired
    private ServiceOrderCloseService serviceOrderCloseService;

    @PatchMapping("/{id}/close")
    public ResponseEntity<ServiceOrderDTO> close(@PathVariable Long id) {
        ServiceOrder serviceOrder = serviceOrderCloseService.execute(id);

        return ResponseEntity.ok(toDTO(serviceOrder));
    }

    @Autowired
    private ModelMapper modelMapper;

    private ServiceOrderDTO toDTO(ServiceOrder execute) {
        return modelMapper.map(execute, ServiceOrderDTO.class);
    }

    private ServiceOrder toModel(ServiceOrderCreateDTO serviceOrderCreateDTO) {
        return modelMapper.map(serviceOrderCreateDTO, ServiceOrder.class);
    }
}
