package buem.keik.salescompany.salescompany.repository.mongo;

import buem.keik.salescompany.salescompany.model.Supplies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuppliesMongoRepository extends MongoRepository<Supplies, String> {
}
