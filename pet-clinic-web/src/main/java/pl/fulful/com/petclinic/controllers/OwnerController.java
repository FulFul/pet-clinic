package pl.fulful.com.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fulful.com.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String allOwners(Model model) {
//        model.addAttribute("owners_param", ownerService.findAll().stream().collect(Collectors.toList()));
        model.addAttribute("owners_param", ownerService.findAll());

        return "owners/index";
    }
}
