package guru.springframework.springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//@mappedsuperclass establishes this as a base class, to be used by other classes
// and jpa doesn't need to create a table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    //Using Long instead of primitive long because Long can contain a null value
    //IDENTITY - indicates that the persistence provider must assign primary keys for the entity using
    //a database identity column

    //This is going to be using MySql which allows for the auto implementation of the id value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew(){
        return this.id == null;
    }
}
