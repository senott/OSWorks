package br.com.nomadweb.osworksapi.domain.services;

import br.com.nomadweb.osworksapi.api.dtos.CommentCreateDTO;
import br.com.nomadweb.osworksapi.api.dtos.CommentDTO;
import br.com.nomadweb.osworksapi.domain.exceptions.BusinessException;
import br.com.nomadweb.osworksapi.domain.exceptions.EntityNotFoundException;
import br.com.nomadweb.osworksapi.domain.models.Comment;
import br.com.nomadweb.osworksapi.domain.models.ServiceOrder;
import br.com.nomadweb.osworksapi.domain.repositories.CommentRepository;
import br.com.nomadweb.osworksapi.domain.repositories.ServiceOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CommentCreateService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentDTO execute(Long serviceOrderId, CommentCreateDTO commentCreateDTO) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não foi encontrada."));

        Comment comment = modelMapper.map(commentCreateDTO, Comment.class);
        comment.setSentDate(OffsetDateTime.now());
        comment.setServiceOrder(serviceOrder);

        return modelMapper.map(commentRepository.save(comment), CommentDTO.class);
    }
}
