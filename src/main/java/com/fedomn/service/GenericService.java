package com.fedomn.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {

    public PK save(T persistentObject);

    public void update(T transientObject);

    public T findById(PK id);

    public List<T> findAll();

    public void delete(T persistentObject);

}
