package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.PetService;
import guru.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
@Controller
@RequestMapping("owners/{ownerId}")
public class PetController {

    private static final String  VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petsService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petsService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petsService = petsService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return this.petTypeService.findAll();
    }

    @ModelAttribute("Owner")
    public Owner findOwner(@PathVariable Long ownerId){
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

}
