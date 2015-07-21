package com.fedomn.service;

import com.fedomn.model.User;

public interface UserService extends GenericService<User, String> {

    public User findByName(String name);

    public void deleteById(String userId);
}
