package guru.springframework.springpetclinic.services;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.Person;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
