package com.luckye.learnvue.service.impl;

import com.luckye.learnvue.dao.UserMapper;
import com.luckye.learnvue.entity.User;
import com.luckye.learnvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser() {

        return userMapper.findAllUser()==null?null:userMapper.findAllUser();
    }

    @Override
    public boolean findByUser(User user) {
        return userMapper.findByUser(user).size()==0?false:true;
    }
}
