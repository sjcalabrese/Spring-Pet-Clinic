package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping(value="/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }
    @GetMapping()
    public String processFindForm(Owner owner, BindingResult result, Model model){
        //allow paramaterless get request for /owners to return all records
        if(owner.getLastName() == null){
            owner.setLastName("");
        }
        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }else if(results.size() == 1){
            //1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }else{
            //multiple owners
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    /**
     *  Custom handler for displaying ownder.
     *
     * @param ownerId the Id of the owner to display
     * @return a ModelMap with the Model attributes for the view
     */
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


}
