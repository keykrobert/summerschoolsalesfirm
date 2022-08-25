package buem.keik.salescompany.salescompany.form;

import java.time.LocalDateTime;

public class PriceForm {
    private String id;
    private double price;

    private String supplies;

    private String details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PriceForm() {
    }

    public PriceForm(String id, double price, String supplies, String details, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public String getSupplies() {
        return supplies;
    }

    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
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
