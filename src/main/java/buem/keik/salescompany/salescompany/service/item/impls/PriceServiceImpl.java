package buem.keik.salescompany.salescompany.service.item.impls;

import buem.keik.salescompany.salescompany.form.PriceForm;
import buem.keik.salescompany.salescompany.model.*;
import buem.keik.salescompany.salescompany.repository.mongo.DetailsMongoRepository;
import buem.keik.salescompany.salescompany.repository.mongo.PriceMongoRepository;
import buem.keik.salescompany.salescompany.repository.mongo.SuppliesMongoRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {
    private LocalDateTime now = LocalDateTime.now();
    private Provider provider = new Provider("1", "item1", "any Description", "Bratislava, 1", "0660386900", now, now);
    private Details details = new Details("1", "name1", "sku1", 14, "commenyt", Currency.EUR, now, now);
    Supplies supplies = new Supplies("1", "Name1", provider, details, 5, now, now, now);
    private List<Price> prices = new ArrayList<>(
            Arrays.asList(
                    new Price("1", 50, supplies, details, now, now)
            ));

    @PostConstruct
    void init() {
        repository.saveAll(prices);
    }

    @Autowired
    PriceMongoRepository repository;

    @Autowired
    SuppliesMongoRepository mongoRepository;
    @Autowired
    SuppliesServiceImpl suppliesService;


    @Override
    public Price create(Price price) {
        price.setCreatedAt(LocalDateTime.now());
        return repository.save(price);
    }

//    public Price updatePriceDetail(Details detailsToUpdate) {
//        Price priceToUpdate = new Price();
//        DetailsServiceImpl detailsService = new DetailsServiceImpl();
//
//        priceToUpdate.setPrice(detailsToUpdate.getPrice());
//
//        String detailsId = detailsToUpdate.getId();
//
//        var sss = suppliesService.getAll();
//        try {
//            var ss = suppliesService.getAll();
//                //    .filter(test1 -> test1.getDetailsId().getId().equals(detailsId)).findFirst().get();
//        }catch (Exception exception)
//        {
//            System.out.println(exception.getMessage());
//        }
//
//
//        //  priceToUpdate.setSupplies(test);
//        priceToUpdate.setDetails(detailsToUpdate);
//
//        priceToUpdate.setCreatedAt(LocalDateTime.now());
//        priceToUpdate.setUpdatedAt(LocalDateTime.now());
//        return repository.save(priceToUpdate);
//    }

    @Override
    public Price update(Price price) {
        return repository.save(price);
    }

    @Override
    public Price get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Price> getAll() {
        return repository.findAll();
    }
}
