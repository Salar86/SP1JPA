package flow1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Phone {
    @Id
    private String phoneNumber;

    @ManyToOne
    private Users user;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean validatePhone(String phone) {
        return phone.matches("[+]45+[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
    }


}
