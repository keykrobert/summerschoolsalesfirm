package buem.keik.salescompany.salescompany.repository.mongo;

import buem.keik.salescompany.salescompany.model.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderMongoRepository extends MongoRepository<Provider, String> {

}
