package buem.keik.salescompany.salescompany.controller.api;

import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.service.item.impls.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/details/")
@RestController
public class DetailsRestController {
    @Autowired
    DetailsServiceImpl service;

    @GetMapping("")
    public List<Details> showAll() {
        return service.getAll();
    }

    @GetMapping("/details/{id}")
    public Details showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/details/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public Details insertOne(@RequestBody Details details) {
        return service.create(details);
    }

    @PutMapping()
    public Details updateOne(@RequestBody Details details) {
        return service.update(details);
    }
}
