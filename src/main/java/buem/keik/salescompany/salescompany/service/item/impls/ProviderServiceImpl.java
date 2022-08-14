
package buem.keik.salescompany.salescompany.service.item.impls;


import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.repository.ItemFakeRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    ItemFakeRepository repository;

    @Override
    public Provider create(Provider provider) {
        return repository.save(provider);
    }

    @Override
    public Provider update(Provider provider) {
        return repository.update(provider);
    }

    @Override
    public Provider get(String id) {
        return repository.findById(id);
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