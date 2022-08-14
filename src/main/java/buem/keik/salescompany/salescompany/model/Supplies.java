package buem.keik.salescompany.salescompany.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Supplies {
    private String id;
    private String name;
    private Provider providerId;
    private Details detailsId;
    private int quantity;
    private LocalDateTime date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Supplies() {
    }

    public Supplies(String name, Provider providerId, Details detailsId, int quantity, LocalDateTime date) {
        this.name = name;
        this.providerId = providerId;
        this.detailsId = detailsId;
        this.quantity = quantity;
        this.date = date;
    }

    public Supplies(String id, String name, Provider providerId, Details detailsId, int quantity, LocalDateTime date, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
        this.detailsId = detailsId;
        this.quantity = quantity;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Supplies(String id, String name, int quantity, Supplies supplies, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.providerId = supplies.getProviderId();
        this.detailsId = supplies.getDetailsId();
        this.date = date;
        this.createdAt = date;
        this.updatedAt = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    public Details getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Details detailsId) {
        this.detailsId = detailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplies supplies = (Supplies) o;
        return id.equals(supplies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Supplies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", providerId=" + providerId +
                ", detailsId=" + detailsId +
                ", quantity=" + quantity +
                ", date=" + date +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
