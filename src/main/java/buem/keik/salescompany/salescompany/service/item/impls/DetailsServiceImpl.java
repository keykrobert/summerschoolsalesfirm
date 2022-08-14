package buem.keik.salescompany.salescompany.service.item.impls;

import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.repository.DetailsFakeRepository;
import buem.keik.salescompany.salescompany.service.item.interfaces.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsServiceImpl implements IDetailsService {
    @Autowired
    DetailsFakeRepository repository;

    @Override
    public Details create(Details details) {
        return repository.save(details);
    }

    @Override
    public Details update(Details details) {
        return repository.update(details);
    }

    @Override
    public Details get(String id) {
        return repository.findById(id);
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
