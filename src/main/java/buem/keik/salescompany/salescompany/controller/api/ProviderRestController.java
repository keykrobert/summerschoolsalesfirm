package buem.keik.salescompany.salescompany.controller.api;


import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.service.item.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/items/")
@RestController
public class ProviderRestController {

    @Autowired
    ProviderServiceImpl service;

    @GetMapping("")
    public List<Provider> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Provider showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public Provider insertOne(@RequestBody Provider provider) {
        return service.create(provider);
    }

    @PutMapping()
    public Provider updateOne(@RequestBody Provider provider) {
        return service.update(provider);
    }


}