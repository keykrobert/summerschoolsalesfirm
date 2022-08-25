package buem.keik.salescompany.salescompany.controller.ui;

import buem.keik.salescompany.salescompany.form.ProviderForm;
import buem.keik.salescompany.salescompany.form.SuppliesForm;
import buem.keik.salescompany.salescompany.model.Details;
import buem.keik.salescompany.salescompany.model.Provider;
import buem.keik.salescompany.salescompany.model.Supplies;
import buem.keik.salescompany.salescompany.repository.mongo.DetailsMongoRepository;
import buem.keik.salescompany.salescompany.repository.mongo.ProviderMongoRepository;
import buem.keik.salescompany.salescompany.service.item.impls.DetailsServiceImpl;
import buem.keik.salescompany.salescompany.service.item.impls.ProviderServiceImpl;
import buem.keik.salescompany.salescompany.service.item.impls.SuppliesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ui/v1/supplies/")
@Controller
public class SuppliesUIController {

    @Autowired
    SuppliesServiceImpl suppliesService;
    @Autowired
    ProviderServiceImpl providerService;
    @Autowired
    DetailsServiceImpl detailsService;

    @Autowired
    private ProviderMongoRepository providerMongoRepository;

    @Autowired
    private DetailsMongoRepository detailsMongoRepository;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("supplies", suppliesService.getAll());
        return "supplies/index";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        suppliesService.delete(id);
        return "redirect:/ui/v1/supplies/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model) {
        SuppliesForm suppliesForm = new SuppliesForm();
        Map<String, String> providerMap = getProviderMap();
        Map<String, String> detailsMap = getDetailsMap();
        model.addAttribute("providerMap", providerMap);
        model.addAttribute("detailsMap", detailsMap);
        model.addAttribute("form", suppliesForm);
        return "supplies/addSupplies";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") SuppliesForm form) {
        Supplies supplies = new Supplies();
        supplies.setName(form.getName());

        Provider provider = providerMongoRepository.findByName(form.getProviderId()).get(0);
        Details details = detailsMongoRepository.findByName(form.getDetailsId()).get(0);

        supplies.setProviderId(provider);
        supplies.setDetailsId(details);
        supplies.setQuantity(form.getQuantity());
        suppliesService.create(supplies);
        return "redirect:/ui/v1/supplies/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id) {
        Supplies suppliesToUpdate = suppliesService.get(id);
        SuppliesForm suppliesForm = new SuppliesForm();
        suppliesForm.setId(suppliesToUpdate.getId());
        suppliesForm.setName(suppliesToUpdate.getName());
        suppliesForm.setProviderId(suppliesToUpdate.getProviderId().getId());
        suppliesForm.setDetailsId(suppliesToUpdate.getDetailsId().getId());
        suppliesForm.setQuantity(suppliesToUpdate.getQuantity());
        // suppliesForm.setDate(suppliesForm.getDate());


        suppliesForm.setUpdatedAt(suppliesToUpdate.getUpdatedAt());
        suppliesForm.setCreatedAt(suppliesToUpdate.getCreatedAt());

        Map<String, String> providerMap = getProviderMap();
        Map<String, String> detailsMap = getDetailsMap();
        model.addAttribute("providerMap", providerMap);
        model.addAttribute("detailsMap", detailsMap);

        model.addAttribute("form", suppliesForm);
        return "supplies/updateSupplies";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("form") SuppliesForm form) {
        System.out.println(form);
        Supplies suppliesToUpdate = new Supplies();
        suppliesToUpdate.setId(form.getId());
        suppliesToUpdate.setName(form.getName());

        Provider provider = providerMongoRepository.findByName(form.getProviderId()).get(0);
        Details details = detailsMongoRepository.findByName(form.getDetailsId()).get(0);

        suppliesToUpdate.setProviderId(provider);
        suppliesToUpdate.setDetailsId(details);
        suppliesToUpdate.setQuantity(form.getQuantity());

        suppliesToUpdate.setCreatedAt(LocalDateTime.now());
        suppliesToUpdate.setUpdatedAt(LocalDateTime.now());

        suppliesService.update(suppliesToUpdate);

        return "redirect:/ui/v1/supplies/";
    }

    private Map<String, String> getProviderMap() {
        Map<String, String> providerMap = new LinkedHashMap<>();
        List<Provider> providers = providerMongoRepository.findAll();
        providers.stream()
                .map(Provider::getName)
                .forEach(stringName -> providerMap.put(stringName, stringName));
        return providerMap;
    }

    private Map<String, String> getDetailsMap() {
        Map<String, String> detailsMap = new LinkedHashMap<>();
        List<Details> readers = detailsMongoRepository.findAll();
        readers.stream()
                .map(details -> details.getName())
                .forEach(stringName -> detailsMap.put(stringName, stringName));
        return detailsMap;
    }


}
