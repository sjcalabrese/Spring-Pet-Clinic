package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.model.Vet;
import guru.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping(value = {"/vets", "/vets/index", "/vets/index.html", "vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @GetMapping(value = {"/api/vets"})
    public @ResponseBody Set<Vet> getVetsJson(){
        //@ResponseBody will default to json
        return vetService.findAll();
    }
}
