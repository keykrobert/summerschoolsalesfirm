package buem.keik.salescompany.salescompany.service.item.interfaces;

import buem.keik.salescompany.salescompany.model.Details;

import java.util.List;

public interface IDetailsService {
    Details create(Details details);

    Details update(Details details);

    Details get(String id);

    void delete(String id);

    List<Details> getAll();
}
