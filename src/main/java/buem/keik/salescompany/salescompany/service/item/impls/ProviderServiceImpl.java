
package buem.keik.salescompany.salescompany.service.item.impls;


import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.repository.mongo.ProviderMongoRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProviderServiceImpl implements IProviderService {
    private LocalDateTime now = LocalDateTime.now();

    private List<Provider> providers = new ArrayList<>(
            Arrays.asList(
                    new Provider("1", "item1", "any Description", "Bratislava, 1", "0660386900", now, now),
                    new Provider("2", "item2", "any Description2", "Bratislava, 2", "0660386900", now, now),
                    new Provider("3", "item3", "any Description3", "Bratislava, 3", "0660386900", now, now),
                    new Provider("4", "item4", "any Description4", "Bratislava, 4", "0660386900", now, now)
            ));

    @PostConstruct
    void init() {
        repository.saveAll(providers);
    }


    @Autowired
    ProviderMongoRepository repository;

    @Override
    public Provider create(Provider provider) {
        provider.setCreatedAt(LocalDateTime.now());
        return repository.save(provider);
    }

    @Override
    public Provider update(Provider provider) {
       // provider.setUpdatedAt(LocalDateTime.now());
        return repository.save(provider);
    }

    @Override
    public Provider get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Provider> getAll() {
        return repository.findAll();
    }
}