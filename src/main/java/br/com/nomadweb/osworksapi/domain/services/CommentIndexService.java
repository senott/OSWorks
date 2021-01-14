package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.domain.exceptions.EntityNotFoundException;
import br.com.nomadweb.osworksapi.domain.models.Comment;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentIndexService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<Comment> execute(Long serviceOrderId) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

        return serviceOrder.getComments();
    }
}
