package flow1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ZipDTO {

    private int zip;
    private String name;

    public ZipDTO(int zip, String name) {
        this.zip = zip;
        this.name = name;
    }

    public int getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }
}
