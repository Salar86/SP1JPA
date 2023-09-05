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
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String wikiLink;
    private String category;
    private String type;

    public Hobby(String wikiLink, String category, String type) {
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }
}
