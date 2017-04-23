/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-23
 */
package com.github.yavin.moonlight.mapper;

import com.github.yavin.moonlight.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT count(0) FROM t_users WHERE username = #{username}")
    int findUserCount(@Param("username")String username);

    @Select("SELECT * FROM t_users WHERE username = #{username} AND password = #{password}")
    User findUser(@Param("username")String username, @Param("password") String password);

    @Select("SELECT * FROM t_users WHERE uid = #{id}")
    User findById(@Param("uid") int uid);

}
