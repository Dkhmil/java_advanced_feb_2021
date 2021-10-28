package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BUCKET_PRODUCT")
public class BucketProduct implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "BUCKET_ID", referencedColumnName = "BUCKET_ID")
    private Bucket bucket;
    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;
    @Column(name = "PRODUCT_COUNT")
    private int productCount;
}
