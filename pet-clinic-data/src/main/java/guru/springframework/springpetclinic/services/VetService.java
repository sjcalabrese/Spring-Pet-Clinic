package guru.springframework.springpetclinic.services;

import guru.springframework.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet  pet);

    Set<Vet> findAll();
}
