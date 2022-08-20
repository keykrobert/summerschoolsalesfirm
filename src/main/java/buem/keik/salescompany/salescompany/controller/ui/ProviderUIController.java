package buem.keik.salescompany.salescompany.controller.ui;

import buem.keik.salescompany.salescompany.form.ProviderForm;
import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.service.item.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ui/v1/items/")
@Controller
public class ProviderUIController {

    @Autowired
    ProviderServiceImpl service;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("providers", service.getAll());
        return "provider";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/ui/v1/items/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model) {
        ProviderForm itemForm = new ProviderForm();
        model.addAttribute("form", itemForm);
        return "addProvider";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") ProviderForm form) {
        Provider provider = new Provider();
        provider.setId(form.getId());
        provider.setName(form.getName());
        provider.setDescription(form.getDescription());
        provider.setAddress(form.getAddress());
        provider.setTelephone(form.getTelephone());
        provider.setCreatedAt(form.getCreatedAt());
        provider.setUpdatedAt(form.getUpdatedAt());
        service.create(provider);
        return "redirect:/ui/v1/items/";
    }

}
