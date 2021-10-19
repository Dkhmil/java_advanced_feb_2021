package model;

import dao.annotation.Column;
import dao.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BUCKET")
public class Bucket {
    @Column(name = "BUCKET_ID")
    private int id;
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    public Bucket(LocalDateTime createdDate) {
        this.id = new Random().ints(1, 1000000)
                .findFirst()
                .getAsInt();
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public Bucket(int id) {
        this.id = id;
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }
}
