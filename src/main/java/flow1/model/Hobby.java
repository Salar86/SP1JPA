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
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String wikiLink;
    private String category;
    private String type;

    public Hobby(String wikiLink, String category, String type) {
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Users> users;

    public void addUsers(Users user){
        users.add(user);
        if(user != null){
            user.getHobbies().add(this);
        }

    }

}
