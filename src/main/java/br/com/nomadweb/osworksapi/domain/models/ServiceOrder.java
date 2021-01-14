package br.com.nomadweb.osworksapi.domain.models;

import br.com.nomadweb.osworksapi.domain.exceptions.BusinessException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;

    private OffsetDateTime openDate;
    private OffsetDateTime closeDate;

    @OneToMany(mappedBy = "serviceOrder")
    private List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void close() {
        if (!getStatus().equals(ServiceOrderStatus.OPEN)) {
            throw new BusinessException("Ordem de serviço não pode ser finalizada.");
        }
        setStatus(ServiceOrderStatus.CLOSED);
        setCloseDate(OffsetDateTime.now());
    }
}
