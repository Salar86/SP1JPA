package flow1.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int zip;
    private String hobby;

    public UserDTO(String firstName, String lastName, String email, String address, int zip, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.hobby = hobby;
    }


}
