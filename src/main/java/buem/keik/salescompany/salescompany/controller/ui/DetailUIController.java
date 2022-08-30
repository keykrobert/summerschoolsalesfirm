package buem.keik.salescompany.salescompany.controller.ui;

import buem.keik.salescompany.salescompany.form.DetailsForm;
import buem.keik.salescompany.salescompany.model.Currency;
import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.service.item.impls.DetailsServiceImpl;
import buem.keik.salescompany.salescompany.service.item.impls.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/details/")
@Controller
public class DetailUIController {
    @Autowired
    DetailsServiceImpl detailsService;
    @Autowired
    PriceServiceImpl priceService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("details", detailsService.getAll());
        return "detail/index";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        detailsService.delete(id);
        return "redirect:/ui/v1/details/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model) {
        DetailsForm detailsForm = new DetailsForm();
        var currency = Currency.values();
        model.addAttribute("currency", currency);
        model.addAttribute("form", detailsForm);
        return "detail/addDetail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") DetailsForm form) {
        Details details = new Details();
        details.setName(form.getName());
        details.setSku(form.getSku());
        details.setPrice(form.getPrice());
        details.setComment(form.getComment());
        details.setCurrency(form.getCurrency());
        detailsService.create(details);
        return "redirect:/ui/v1/details/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id) {
        Details detailsToUpdate = detailsService.get(id);
        DetailsForm detailsForm = new DetailsForm();
        detailsForm.setId(detailsToUpdate.getId());
        detailsForm.setName(detailsToUpdate.getName());



        detailsForm.setSku(detailsToUpdate.getSku());
        detailsForm.setPrice(detailsToUpdate.getPrice());
        detailsForm.setComment(detailsToUpdate.getComment());
        detailsForm.setCurrency(detailsToUpdate.getCurrency());

        detailsForm.setUpdatedAt(detailsToUpdate.getUpdatedAt());
        detailsForm.setCreatedAt(detailsToUpdate.getCreatedAt());
        var currency = Currency.values();
        model.addAttribute("currency", currency);
        model.addAttribute("form", detailsForm);
        return "detail/updateDetail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("form") DetailsForm form) {
        System.out.println(form);
        Details detailsToUpdate = new Details();
        detailsToUpdate.setId(form.getId());
        detailsToUpdate.setName(form.getName());

        detailsToUpdate.setSku(form.getSku());
        detailsToUpdate.setPrice(form.getPrice());
        detailsToUpdate.setComment(form.getComment());
        detailsToUpdate.setCurrency(form.getCurrency());


        detailsToUpdate.setCreatedAt(LocalDateTime.now());
        detailsToUpdate.setUpdatedAt(LocalDateTime.now());

        detailsService.update(detailsToUpdate);

        return "redirect:/ui/v1/details/";
    }
}
