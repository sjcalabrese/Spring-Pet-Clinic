package guru.springframework.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //any of these will route to index.html
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){

        //wires up the controller with thymeleaf. (finds the index.html file)
        return "index";
    }
}
