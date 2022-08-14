package buem.keik.salescompany.salescompany.repository;


import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.model.Supplies;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class SuppliesFakeRepository {

    private LocalDateTime now = LocalDateTime.now();
    private Supplies suppliesObject;
    private List<Supplies> supplies = new ArrayList<>(
            Arrays.asList(
                    new Supplies("1", "name1", 25, suppliesObject, now)
            ));

    public List<Supplies> findAll() {
        return this.supplies;
    }

    public Supplies findById(String id) {
        return this.supplies.stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Supplies update(Supplies supplie) {
        this.deleteById(supplie.getId());
        supplie.setUpdatedAt(LocalDateTime.now());
        this.supplies.add(supplie);
        return supplie;
    }

    public void deleteById(String id) {
        Supplies supplie = this.findById(id);
        int index = supplies.indexOf(supplie);
        this.supplies.remove(index);

    }

    public Supplies save(Supplies supplie) {
        supplie.setId(UUID.randomUUID().toString());
        supplie.setCreatedAt(LocalDateTime.now());
        this.supplies.add(supplie);
        return supplie;
    }
}