package buem.keik.salescompany.salescompany.service.item.interfaces;

import buem.keik.salescompany.salescompany.model.Supplies;

import java.util.List;

public interface ISuppliesService {
    Supplies create(Supplies supplies);

    Supplies update(Supplies supplies);

    Supplies get(String id);

    void delete(String id);

    List<Supplies> getAll();
}
