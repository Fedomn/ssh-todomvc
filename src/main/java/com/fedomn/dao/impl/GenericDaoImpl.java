package com.fedomn.dao.impl;

import com.fedomn.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 获得超类的泛型参数的实际类型
     */
    public GenericDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public PK save(T persistentObject) {
        return (PK) hibernateTemplate.save(persistentObject);
    }

    @Override
    public T findById(PK id) {
        return hibernateTemplate.get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return hibernateTemplate.loadAll(entityClass);
    }

    @Override
    public void update(T transientObject) {
        hibernateTemplate.update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        hibernateTemplate.delete(persistentObject);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
