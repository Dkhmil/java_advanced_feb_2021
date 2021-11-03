package one_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART")
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private int id;
    @Column(name = "CART_NAME")
    private String cartName;
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;

    public Cart(String cartName) {
        this.cartName = cartName;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
        this.totalPrice = items.stream().mapToDouble(Item::getPrice).sum();
    }
}
