package flow1.model;

import jakarta.persistence.Entity;
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
public class Zip {
    @Id
    private int zip;
    private String city;
    private String region;
    private String municipality;

    public Zip(int zip, String city, String region, String municipality) {
        this.zip = zip;
        this.city = city;
        this.region = region;
        this.municipality = municipality;
    }
}
