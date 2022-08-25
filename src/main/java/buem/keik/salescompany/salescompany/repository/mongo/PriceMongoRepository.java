package buem.keik.salescompany.salescompany.repository.mongo;

import buem.keik.salescompany.salescompany.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceMongoRepository extends MongoRepository<Price, String> {
}
