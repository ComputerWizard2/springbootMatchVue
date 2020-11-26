package com.luckye.learnvue.dao;

import com.luckye.learnvue.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询全部的user对象
     * @return
     */
    public List<User> findAllUser();

    /**
     * 根据user 对象查询是否存在
     * @param user
     * @return
     */
    public List<User> findByUser(User user);


}
