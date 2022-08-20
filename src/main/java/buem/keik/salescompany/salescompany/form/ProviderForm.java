package buem.keik.salescompany.salescompany.form;

import buem.keik.salescompany.salescompany.model.Provider;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProviderForm {
    private String id;
    private String name;
    private String description;
    private String address;
    private String telephone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProviderForm() {
    }

    public ProviderForm(String name, String description, String address, String telephone) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.telephone = telephone;
    }

    public ProviderForm(String id, String name, String description, String address, String telephone, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.telephone = telephone;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        return "Provider{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
