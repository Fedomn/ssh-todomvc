package com.fedomn.dao.impl;

import com.fedomn.dao.UserDao;
import com.fedomn.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao {


    public User findByName(String name) {
        return (User) getHibernateTemplate().findByExample(new User(name)).get(0);
    }

}
