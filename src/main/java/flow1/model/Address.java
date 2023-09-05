package flow1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;

    public Address(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    public void addUser(Users users){
        if(users != null){
            users.setAddress(this);
        }
    }
}
