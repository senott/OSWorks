package br.com.nomadweb.osworksapi.api.dtos;

import java.time.OffsetDateTime;

public class CommentDTO {
    private Long id;
    private String description;
    private OffsetDateTime dateSent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(OffsetDateTime dateSent) {
        this.dateSent = dateSent;
    }
}
