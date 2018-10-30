package develop_spring_react.springreactbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long owneirId;

    private String firstName;
    private String lastName;

    // relacionamento entidade 1 para N
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Car> cars;

    public Owner() {}

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getOwneirId() {
        return owneirId;
    }

    public void setOwneirId(Long owneirId) {
        this.owneirId = owneirId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
