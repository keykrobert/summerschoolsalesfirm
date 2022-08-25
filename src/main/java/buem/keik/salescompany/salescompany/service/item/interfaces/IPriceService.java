package buem.keik.salescompany.salescompany.service.item.interfaces;

import buem.keik.salescompany.salescompany.model.Price;

import java.util.List;

public interface IPriceService {
    Price create(Price price);

    Price update(Price price);

    Price get(String id);

    void delete(String id);

    List<Price> getAll();
}

