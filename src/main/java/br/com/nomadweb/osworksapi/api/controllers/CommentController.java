package br.com.nomadweb.osworksapi.api.controllers;

import br.com.nomadweb.osworksapi.api.dtos.CommentCreateDTO;
import br.com.nomadweb.osworksapi.api.dtos.CommentDTO;
import br.com.nomadweb.osworksapi.domain.models.Comment;
import br.com.nomadweb.osworksapi.domain.services.CommentCreateService;
import br.com.nomadweb.osworksapi.domain.services.CommentIndexService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/serviceorders/{serviceOrderId}/comments")
public class CommentController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentIndexService commentIndexService;

    @GetMapping
    public List<CommentDTO> index(@PathVariable Long serviceOrderId) {
        List<Comment> comments = commentIndexService.execute(serviceOrderId);

        return comments.stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).collect(Collectors.toList());
    }

    @Autowired
    private CommentCreateService commentCreateService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CommentDTO create(@PathVariable Long serviceOrderId,
                             @Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        return commentCreateService.execute(serviceOrderId, commentCreateDTO);
    }
}
