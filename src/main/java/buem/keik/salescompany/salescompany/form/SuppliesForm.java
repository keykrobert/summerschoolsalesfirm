package buem.keik.salescompany.salescompany.form;

import buem.keik.salescompany.salescompany.model.Supplies;

import java.time.LocalDateTime;
import java.util.Objects;

public class SuppliesForm {
    private String id;
    private String name;
    private String providerId;
    private String detailsId;
    private int quantity;
    private LocalDateTime date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SuppliesForm() {
    }

    public SuppliesForm(String name, String providerId, String detailsId, int quantity, LocalDateTime date) {
        this.name = name;
        this.providerId = providerId;
        this.detailsId = detailsId;
        this.quantity = quantity;
        this.date = date;
    }

    public SuppliesForm(String id, String name, String providerId, String detailsId, int quantity, LocalDateTime date, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
        this.detailsId = detailsId;
        this.quantity = quantity;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
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
