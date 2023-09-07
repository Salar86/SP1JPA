package flow1.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString

public class UserAddressDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int zip;


    public UserAddressDTO(String firstName, String lastName , String address, String city, int zip){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.city = city;
    }

}
