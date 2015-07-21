package com.fedomn.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型DAO
 * @param <T> 实体类型
 * @param <PK> 实体主键类型
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * 持久化对象到数据库
     * @param persistentObject 持久化对象
     * @return 持久化对象主键值
     */
    public PK save(T persistentObject);

    /**
     * 通过主键获取持久化对象
     * @param id 主键值
     * @return 持久化对象
     */
    public T findById(PK id);

    /**
     * 查询实体所有记录
     * @return 返回所有记录
     */
    public List<T> findAll();

    /**
     * 更新一个持久化对象
     * @param transientObject
     */
    public void update(T transientObject);

    /**
     * 删除一个持久化对象
     * @param persistentObject
     */
    public void delete(T persistentObject);

}
