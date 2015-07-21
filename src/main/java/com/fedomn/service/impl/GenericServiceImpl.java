package com.fedomn.service.impl;

import com.fedomn.dao.GenericDao;
import com.fedomn.service.GenericService;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

    private GenericDao<T, PK> genericDao;

    public void setGenericDao(GenericDao<T, PK> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public PK save(T persistentObject) {
        return genericDao.save(persistentObject);
    }

    @Override
    public void update(T transientObject) {
        genericDao.update(transientObject);
    }

    @Override
    public T findById(PK id) {
        return genericDao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return genericDao.findAll();
    }

    @Override
    public void delete(T persistentObject) {
        genericDao.delete(persistentObject);
    }

}
