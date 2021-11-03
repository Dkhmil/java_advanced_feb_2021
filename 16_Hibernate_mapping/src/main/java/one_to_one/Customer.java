package one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "CUSTOMER_NAME")
    private String fullName;
    @Column(name = "CUSTOMER_EMAIL")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private FinancialOperation financialOperation;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

}
