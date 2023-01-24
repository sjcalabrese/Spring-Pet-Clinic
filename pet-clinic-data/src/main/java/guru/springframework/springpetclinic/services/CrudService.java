package guru.springframework.springpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    //Used to emulate the CrudRepository interface
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
