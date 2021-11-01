package many_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {

    private int id;
    private String name;
    private Set<Product> products;

    public Bucket(String name) {
        this.name = name;
    }
}
