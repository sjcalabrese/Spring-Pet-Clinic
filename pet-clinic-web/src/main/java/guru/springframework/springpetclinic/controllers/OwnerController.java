package guru.springframework.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/owners")
@Controller
public class OwnerController {

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public String listOfOwners(){
        return "owners/index";
    }
}
