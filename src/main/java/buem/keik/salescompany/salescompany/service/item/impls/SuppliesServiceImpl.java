package buem.keik.salescompany.salescompany.service.item.impls;

import buem.keik.salescompany.salescompany.model.Currency;
import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.model.Provider;

import buem.keik.salescompany.salescompany.model.Supplies;
import buem.keik.salescompany.salescompany.repository.SuppliesFakeRepository;
import buem.keik.salescompany.salescompany.repository.mongo.SuppliesMongoRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SuppliesServiceImpl implements ISuppliesService {
    private LocalDateTime now = LocalDateTime.now();

    private Provider provider = new Provider("1", "item1", "any Description", "Bratislava, 1", "0660386900", now, now);
    private Details details = new Details("1","name1", "sku1", 14, "commenyt", Currency.EUR, now, now);

    private List<Supplies> supplies = new ArrayList<>(
            Arrays.asList(
                    new Supplies("1", "Name1", provider, details, 5, now, now, now)
            ));

    @PostConstruct
    void init() {
        repository.saveAll(supplies);
    }

    @Autowired
    SuppliesMongoRepository repository;

    @Override
    public Supplies create(Supplies supplie) {
        supplie.setCreatedAt(LocalDateTime.now());
        supplie.setDate(LocalDateTime.now());
        return repository.save(supplie);
    }

    @Override
    public Supplies update(Supplies supplie) {
        supplie.setDate(LocalDateTime.now());
        supplie.setUpdatedAt(LocalDateTime.now());
        return repository.save(supplie);
    }

    @Override
    public Supplies get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Supplies> getAll() {
        return repository.findAll();
    }
}
