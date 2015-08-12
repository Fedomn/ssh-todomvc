package com.fedomn.service.impl;

import com.fedomn.dao.GenericDao;
import com.fedomn.service.GenericService;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

    public abstract GenericDao<T, PK> getDao();

    @Override
    public PK save(T persistentObject) {
        return getDao().save(persistentObject);
    }

    @Override
    public void update(T transientObject) {
        getDao().update(transientObject);
    }

    @Override
    public T findById(PK id) {
        return getDao().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void delete(T persistentObject) {
        getDao().delete(persistentObject);
    }

}
