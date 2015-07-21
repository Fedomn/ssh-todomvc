package com.fedomn.dao;

import com.fedomn.model.User;

public interface UserDao extends GenericDao<User, String>{

    public User findByName(String name);

}
