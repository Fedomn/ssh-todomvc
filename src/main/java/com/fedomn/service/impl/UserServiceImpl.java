package com.fedomn.service.impl;

import com.fedomn.dao.UserDao;
import com.fedomn.model.User;
import com.fedomn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        setGenericDao(userDao);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public void deleteById(String userId) {
        userDao.delete(userDao.findById(userId));
    }
}
