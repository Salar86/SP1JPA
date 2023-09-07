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
    private String name;
    private String wikiLink;
    private String category;
    private String type;

    public Hobby(String name, String wikiLink, String category, String type) {
        this.name = name;
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    public void addUsers(Users user){
        this.users.add(user);
        if(user != null){
            user.getHobbies().add(this);

        }

    }

}
