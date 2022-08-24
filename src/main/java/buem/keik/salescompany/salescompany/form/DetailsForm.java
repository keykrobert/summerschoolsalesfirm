package buem.keik.salescompany.salescompany.form;

import buem.keik.salescompany.salescompany.model.Currency;
import java.time.LocalDateTime;


public class DetailsForm {
    private String id;
    private String name;
    private String sku;
    private double price;
    private String comment;

    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DetailsForm() {
    }

    public DetailsForm(String name, String sku, double price, String comment, Currency currency) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.comment = comment;
        this.currency = currency;
    }

    public DetailsForm(String id, String name, String sku, double price, String comment, Currency currency, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.comment = comment;
        this.currency = currency;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
        return "Details{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", currency=" + currency +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
