package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDeleteService {
    @Autowired
    private ClientRepository clientRepository;

    public void execute(Long id) {
        clientRepository.deleteById(id);
    }
}
