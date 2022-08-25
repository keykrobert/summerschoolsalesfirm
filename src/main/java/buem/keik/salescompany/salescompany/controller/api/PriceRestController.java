package buem.keik.salescompany.salescompany.controller.api;

import buem.keik.salescompany.salescompany.model.Price;
import buem.keik.salescompany.salescompany.service.item.impls.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/prices/")
@RestController
public class PriceRestController {
    @Autowired
    PriceServiceImpl service;

    @GetMapping("")
    public List<Price> showAll() {
        return service.getAll();
    }

    @GetMapping("/price/{id}")
    public Price showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/price/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public Price insertOne(@RequestBody Price price) {
        return service.create(price);
    }

    @PutMapping()
    public Price updateOne(@RequestBody Price price) {
        return service.update(price);
    }
}
