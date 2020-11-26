package com.luckye.learnvue.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.luckye.learnvue.entity.Result;
import com.luckye.learnvue.entity.User;
import com.luckye.learnvue.service.UserService;
import com.luckye.learnvue.utils.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录页面
 */
@RestController()
public class LoginCotroller {

    @Autowired
    private UserService userService;

    @CrossOrigin(value = "*",maxAge = 3600)
    @RequestMapping("/login")
    public Result<String> UserController(@RequestBody User user) {
        Result<String> result =new Result();

        boolean byUser = userService.findByUser(user);
        if (byUser){
            String token = GenerateToken.token(user.getUserName(), user.getPassWord());
            List<User> users = userService.findAllUser();
            result.setStatus(Result.success);
            result.setData(token);
            System.out.println("请求已经到达！！");
            return result;
        }else {
            result.setStatus(Result.err);
            return result;
        }

    }


}
