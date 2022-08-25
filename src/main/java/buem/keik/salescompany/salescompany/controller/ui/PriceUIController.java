package buem.keik.salescompany.salescompany.controller.ui;

import buem.keik.salescompany.salescompany.form.PriceForm;
import buem.keik.salescompany.salescompany.model.Currency;
import buem.keik.salescompany.salescompany.model.Price;
import buem.keik.salescompany.salescompany.model.Supplies;
import buem.keik.salescompany.salescompany.service.item.impls.DetailsServiceImpl;
import buem.keik.salescompany.salescompany.service.item.impls.PriceServiceImpl;
import buem.keik.salescompany.salescompany.service.item.impls.SuppliesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ui/v1/prices/")
@Controller
public class PriceUIController {
    @Autowired
    PriceServiceImpl priceService;
    @Autowired
    SuppliesServiceImpl suppliesService;
    @Autowired
    DetailsServiceImpl detailsService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("prices", priceService.getAll());
        return "price/index";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        priceService.delete(id);
        return "redirect:/ui/v1/prices/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model) {
        PriceForm priceForm = new PriceForm();

        var names = suppliesService.getAll()
                .stream()
                .map(supplies -> supplies.getName())
                .collect(Collectors.toList());

        model.addAttribute("names", names);
        model.addAttribute("form", priceForm);
        return "price/addPrice";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") PriceForm form) {
        Price price = new Price();
        price.setPrice(form.getPrice());
        price.setSupplies(suppliesService.get(form.getSupplies()));
        priceService.create(price);
        return "redirect:/ui/v1/prices/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id) {
        Price priceToUpdate = priceService.get(id);
        PriceForm priceForm = new PriceForm();
        priceForm.setId(priceToUpdate.getId());
        priceForm.setPrice(priceToUpdate.getPrice());

        priceForm.setUpdatedAt(priceToUpdate.getUpdatedAt());
        priceForm.setCreatedAt(priceToUpdate.getCreatedAt());
        var currency = Currency.values();
        model.addAttribute("currency", currency);
        model.addAttribute("form", priceForm);
        return "price/updatePrice";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("form") PriceForm form) {
        Price priceToUpdate = new Price();
        priceToUpdate.setId(form.getId());
        priceToUpdate.setPrice(form.getPrice());


        priceToUpdate.setCreatedAt(LocalDateTime.now());
        priceToUpdate.setUpdatedAt(LocalDateTime.now());

        priceService.update(priceToUpdate);

        return "redirect:/ui/v1/prices/";
    }
}
