package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.domain.exceptions.BusinessException;
import br.com.nomadweb.osworksapi.domain.models.Client;
import br.com.nomadweb.osworksapi.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientSaveService {
    @Autowired
    private ClientRepository clientRepository;

    public Client execute(Client client){
        Client existingClient = clientRepository.findByEmail(client.getEmail());
        if (existingClient != null && !existingClient.equals(client)) {
            throw new BusinessException("Já existe um cliente com este e-mail.");
        }
        return clientRepository.save(client);
    }
}
