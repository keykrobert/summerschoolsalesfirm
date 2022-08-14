package buem.keik.salescompany.salescompany.repository;

import buem.keik.salescompany.salescompany.model.Currency;
import buem.keik.salescompany.salescompany.model.Details;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Repository

public class DetailsFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Details> details = new ArrayList<>(
            Arrays.asList(
                    new Details("1","name1", "sku1", 14, "commenyt", Currency.EUR, now, now),
                    new Details("2","name2", "sku2", 15, "commenyt2", Currency.EUR, now, now),
                    new Details("3","name3", "sku3", 16, "commenyt3", Currency.EUR, now, now)
                    ));

    public List<Details> findAll() {
        return this.details;
    }

    public Details findById(String id) {
        return this.details.stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Details update(Details detail) {
        this.deleteById(detail.getId());
        detail.setUpdatedAt(LocalDateTime.now());
        this.details.add(detail);
        return detail;
    }

    public void deleteById(String id) {
        Details detail = this.findById(id);
        int index = details.indexOf(detail);
        this.details.remove(index);

    }

    public Details save(Details detail) {
        detail.setId(UUID.randomUUID().toString());
        detail.setCreatedAt(LocalDateTime.now());
        this.details.add(detail);
        return detail;
    }
}
