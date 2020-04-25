package pl.fulful.com.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String allOwners(Model model) {

        return "owners/index";
    }
}
