package flow1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    private String email;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Phone> phones = new HashSet<>();

    public Users(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addPhone(String phoneNumber) {
        Phone newPhone = new Phone(phoneNumber);
        if (newPhone.validatePhone(phoneNumber)) {
            this.phones.add(newPhone);
            if (newPhone != null) {
                newPhone.setUser(this);
            }
        }
    }


}