package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    @Column(name = "BUCKET_ID")
    private  int id;
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    public Bucket(int id) {
        this.id = id;
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }
}
