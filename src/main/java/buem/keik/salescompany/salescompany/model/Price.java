package buem.keik.salescompany.salescompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Price {
    @Id
    private String id;
    private double price;

    private Supplies supplies;

    private Details details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Price() {
    }

    public Price(String id, double price, Supplies supplies, Details details, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.price = price;
        this.supplies = supplies;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplies getSupplies() {
        return supplies;
    }

    public void setSupplies(Supplies supplies) {
        this.supplies = supplies;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
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
        Price price = (Price) o;
        return id.equals(price.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", supplies=" + supplies +
                ", details=" + details +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
