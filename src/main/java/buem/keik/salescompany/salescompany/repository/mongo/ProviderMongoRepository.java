package buem.keik.salescompany.salescompany.repository.mongo;

import buem.keik.salescompany.salescompany.model.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderMongoRepository extends MongoRepository<Provider, String> {
    List<Provider> findByName(String name);

}
