package buem.keik.salescompany.salescompany.service.item.interfaces;


import buem.keik.salescompany.salescompany.model.Provider;

import java.util.List;

public interface IProviderService {
    Provider create(Provider provider);

    Provider update(Provider provider);

    Provider get(String id);

    void delete(String id);

    List<Provider> getAll();


}