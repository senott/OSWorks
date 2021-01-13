package br.com.nomadweb.osworksapi.api.controllers;

import br.com.nomadweb.osworksapi.domain.models.Client;
import br.com.nomadweb.osworksapi.domain.repositories.ClientRepository;
import br.com.nomadweb.osworksapi.domain.services.ClientDeleteService;
import br.com.nomadweb.osworksapi.domain.services.ClientSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> index() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> show(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Autowired
    private ClientSaveService clientSaveService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody Client client) {
        return clientSaveService.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        return ResponseEntity.ok(clientSaveService.save(client));
    }

    @Autowired
    private ClientDeleteService clientDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientDeleteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
