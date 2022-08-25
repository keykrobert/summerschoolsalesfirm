package buem.keik.salescompany.salescompany.service.item.impls;

import buem.keik.salescompany.salescompany.model.Currency;
import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.repository.DetailsFakeRepository;
import buem.keik.salescompany.salescompany.repository.mongo.DetailsMongoRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class DetailsServiceImpl implements IDetailsService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Details> details = new ArrayList<>(
            Arrays.asList(
                    new Details("1","name1", "sku1", 14, "commenyt", Currency.EUR, now, now),
                    new Details("2","name2", "sku2", 15, "commenyt2", Currency.EUR, now, now),
                    new Details("3","name3", "sku3", 16, "commenyt3", Currency.EUR, now, now)
            ));

    @PostConstruct
    void init() {
        repository.saveAll(details);
    }
    @Autowired
    DetailsMongoRepository repository;

    @Override
    public Details create(Details details) {
        details.setCreatedAt(LocalDateTime.now());
        return repository.save(details);
    }

    @Override
    public Details update(Details details) {
        PriceServiceImpl priceService = new PriceServiceImpl();
//        priceService.updatePriceDetail(details);
        return repository.save(details);
    }

    @Override
    public Details get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Details> getAll() {
        return repository.findAll();
    }
}
