package buem.keik.salescompany.salescompany.controller.ui;

import buem.keik.salescompany.salescompany.form.ProviderForm;
import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.service.item.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    public String addItem(@ModelAttribute("form") ProviderForm form){
        Provider provider = new Provider();
        provider.setName(form.getName());
        provider.setDescription(form.getDescription());
        provider.setTelephone(form.getDescription());
        provider.setAddress(form.getDescription());
        service.create(provider);
        return "redirect:/ui/v1/items/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        Provider providerToUpdate = service.get(id);
        ProviderForm providerForm = new ProviderForm();
        providerForm.setId(providerToUpdate.getId());
        providerForm.setName(providerToUpdate.getName());
        providerForm.setDescription(providerToUpdate.getDescription());
        providerForm.setAddress(providerToUpdate.getAddress());
        providerForm.setTelephone(providerToUpdate.getTelephone());
        providerForm.setUpdatedAt(providerToUpdate.getUpdatedAt());
        providerForm.setCreatedAt(providerToUpdate.getCreatedAt());
        model.addAttribute("form", providerForm);
        return "updateProvider";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") ProviderForm form){
        System.out.println(form);
        Provider providerToUpdate = new Provider();
        providerToUpdate.setId(form.getId());
        providerToUpdate.setName(form.getName());
        providerToUpdate.setDescription(form.getDescription());
        providerToUpdate.setAddress(form.getAddress());
        providerToUpdate.setTelephone(form.getTelephone());
        providerToUpdate.setCreatedAt(LocalDateTime.now());
        providerToUpdate.setUpdatedAt(LocalDateTime.now());

        service.update(providerToUpdate);

        return "redirect:/ui/v1/items/";
    }

}
