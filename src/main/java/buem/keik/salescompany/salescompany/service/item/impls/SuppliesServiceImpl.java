package buem.keik.salescompany.salescompany.service.item.impls;

import buem.keik.salescompany.salescompany.model.Provider;

import buem.keik.salescompany.salescompany.model.Supplies;
import buem.keik.salescompany.salescompany.repository.SuppliesFakeRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SuppliesServiceImpl implements ISuppliesService {
    @Autowired
    SuppliesFakeRepository repository;

    @Override
    public Supplies create(Supplies supplie) {
        return repository.save(supplie);
    }

    @Override
    public Supplies update(Supplies supplie) {
        return repository.update(supplie);
    }

    @Override
    public Supplies get(String id) {
        return repository.findById(id);
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
