package service;

import model.Bucket;

import java.util.List;

public interface BucketService {
    Bucket create(Bucket bucket);

    Bucket read(Long id);

    Bucket update(Bucket bucket);

    void delete(Long id);

    List<Bucket> readAll();

    boolean isExist(long bucketId);
}
