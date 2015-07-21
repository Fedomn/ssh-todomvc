package com.fedomn.action;

import com.fedomn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;


    public void getList() {
        
    }

}
