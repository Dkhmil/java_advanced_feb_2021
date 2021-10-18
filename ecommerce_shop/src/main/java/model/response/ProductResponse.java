package model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends Product {

    private int productCount;

    public ProductResponse(int id, String name, String description, double price, int productCount) {
        super(id, name, description, price);
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "ProductResponse { id = " + getId() + ", name = " + getName() +
                ", description = " + getDescription() + ", price = " + getPrice() +
                ", productCount = " + productCount + '}';
    }
}
