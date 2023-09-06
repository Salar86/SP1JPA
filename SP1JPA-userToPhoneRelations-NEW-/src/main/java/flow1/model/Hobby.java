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
    @Column(name = "wikiLink" , length = 50)
    private String wikiLink;
    @Column(name = "category" , length = 50)
    private String category;
    @Column(name = "type" , length = 50)
    private String type;

    @OneToMany//(mappedBy = "Hobby" ,cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();
    @ManyToOne
    private Users user ;


    public Hobby(String wikiLink, String category, String type) {
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }

}
