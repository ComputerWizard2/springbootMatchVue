package com.luckye.learnvue.service;

import com.luckye.learnvue.dao.UserMapper;
import com.luckye.learnvue.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {


    public List<User> findAllUser();


    public boolean findByUser(User user);

}
