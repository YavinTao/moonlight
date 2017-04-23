/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-23
 */
package com.github.yavin.moonlight.service;

import com.github.yavin.moonlight.po.User;

public interface UserService {

    /**
     * 根据用户id查询
     *
     * @param uid
     * @return
     */
    User byId(Integer uid);

    /**
     * 更新用户信息
     * @param users
     */
    void update(User users);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
