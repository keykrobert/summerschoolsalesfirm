package buem.keik.salescompany.salescompany.repository.mongo;

import buem.keik.salescompany.salescompany.model.Details;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DetailsMongoRepository extends MongoRepository<Details, String> {
    List<Details> findByName(String name);

}
