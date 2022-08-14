
package buem.keik.salescompany.salescompany.repository;


import buem.keik.salescompany.salescompany.model.Provider;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ItemFakeRepository {

    private LocalDateTime now = LocalDateTime.now();
    private List<Provider> providers = new ArrayList<>(
            Arrays.asList(
                    new Provider("1", "item1", " desc1", now, now),
                    new Provider("2", "item2", " desc2", now, now),
                    new Provider("3", "item3", " desc3", now, now),
                    new Provider("4", "item4", " desc4", now, now)
            ));

    public List<Provider> findAll() {
        return this.providers;
    }

    public Provider findById(String id) {
        return this.providers.stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Provider update(Provider provider) {
        this.deleteById(provider.getId());
        provider.setUpdatedAt(LocalDateTime.now());
        this.providers.add(provider);
        return provider;
    }

    public void deleteById(String id) {
        Provider provider = this.findById(id);
        int index = providers.indexOf(provider);
        this.providers.remove(index);

    }

    public Provider save(Provider provider) {
        provider.setId(UUID.randomUUID().toString());
        provider.setCreatedAt(LocalDateTime.now());
        this.providers.add(provider);
        return provider;
    }
}