package guru.springframework.springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //@column is JPA annotation which indicates what you want the column name to be in the table
    //If not used hibername will create the name itself using snake case
    @Column(name= "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


}