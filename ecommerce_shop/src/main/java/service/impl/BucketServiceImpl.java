package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.Bucket;
import service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {
    private GenericDao<Bucket, Long> dao;

    public BucketServiceImpl() {
        dao = new AbstractDao<>(Bucket.class);
    }

    @Override
    public Bucket create(Bucket bucket) {
        return dao.create(bucket);
    }

    @Override
    public Bucket read(Long id) {
        return null;
    }

    @Override
    public Bucket update(Bucket bucket) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Bucket> readAll() {
        return null;
    }
}
