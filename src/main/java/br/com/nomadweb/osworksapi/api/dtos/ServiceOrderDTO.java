package br.com.nomadweb.osworksapi.api.dtos;

import br.com.nomadweb.osworksapi.domain.models.ServiceOrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ServiceOrderDTO {
    private Long id;
    private ClientShortDTO client;
    private String description;
    private BigDecimal price;
    private ServiceOrderStatus status;
    private OffsetDateTime openDate;
    private OffsetDateTime closeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientShortDTO getClient() {
        return client;
    }

    public void setClient(ClientShortDTO client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(OffsetDateTime openDate) {
        this.openDate = openDate;
    }

    public OffsetDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(OffsetDateTime closeDate) {
        this.closeDate = closeDate;
    }
}
