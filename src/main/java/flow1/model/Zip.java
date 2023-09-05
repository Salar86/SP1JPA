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
public class Zip {
    @Id
    private int zip;
    @Column (name = "city", length = 50)
    private String city;
    @Column (name = "region",length = 50)
    private String region;
    @Column (name = "municipality",length = 50)
    private String municipality;

    public Zip(int zip, String city, String region, String municipality) {
        this.zip = zip;
        this.city = city;
        this.region = region;
        this.municipality = municipality;
    }

    @OneToMany(mappedBy = "zip",cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        if (address != null) {
            address.setZip(this);
        }
    }












}
