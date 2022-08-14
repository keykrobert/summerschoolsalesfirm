package buem.keik.salescompany.salescompany.controller.api;


import buem.keik.salescompany.salescompany.model.Supplies;
import buem.keik.salescompany.salescompany.service.item.impls.SuppliesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/supplies/")
@RestController
public class SuppliesRestController {

    @Autowired
    SuppliesServiceImpl service;

    @GetMapping("")
    public List<Supplies> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Supplies showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public Supplies insertOne(@RequestBody Supplies supplies) {
        return service.create(supplies);
    }

    @PutMapping()
    public Supplies updateOne(@RequestBody Supplies supplies) {
        return service.update(supplies);
    }


}