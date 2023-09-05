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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    @ManyToOne (cascade = CascadeType.ALL)
    private Zip zip;

    public Address(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    public void addUser(Users users){
        this.users.add(users);
        if(users != null){
            users.setAddress(this);
        }
    }
}
