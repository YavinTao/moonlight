/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-23
 */
package com.github.yavin.moonlight.service.impl;

import com.github.yavin.moonlight.mapper.UserMapper;
import com.github.yavin.moonlight.po.User;
import com.github.yavin.moonlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User byId(Integer uid) {
        return null;
    }

    public void update(User users) {

    }

    public User login(String username, String password) {
        return userMapper.findUser(username, password);
    }
}
