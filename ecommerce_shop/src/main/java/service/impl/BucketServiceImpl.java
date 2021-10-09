package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.Bucket;
import service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {
    private final GenericDao<Bucket, Long> dao;

    public BucketServiceImpl() {
        dao = new AbstractDao<>(Bucket.class);
    }

    @Override
    public Bucket create(Bucket bucket) {
        return dao.create(bucket);
    }

    @Override
    public Bucket read(Long id) {
        return dao.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return dao.update(bucket);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return dao.readAll();
    }
}
