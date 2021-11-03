package one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FINANCIAL_OPERATION")
public class FinancialOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPERATION_ID")
    private int id;
    @Column(name = "OPERATION_DATE")
    private Date date;
    @Column(name = "TOTAL")
    private double total;
    @OneToOne(mappedBy = "financialOperation")
    private Customer customer;

    public FinancialOperation(Date date, double total) {
        this.date = date;
        this.total = total;
    }
}
