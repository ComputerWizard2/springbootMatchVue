package com.luckye.learnvue.config;

import com.luckye.learnvue.entity.TokenModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RedisTokenHelp {


    @Autowired
    private RedisClient redisClient;

    public TokenModel create(String id) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel mode = new TokenModel(id, token);
        redisClient.set(id == null ? null : String.valueOf(id), token, RedisClient.TOKEN_EXPIRES_SECOND);
        return mode;
    }

    public boolean check(TokenModel model) {
        boolean result = false;
        if(model != null) {
            String userId = model.getUserId().toString();
            String token = model.getToken();
            String authenticatedToken = redisClient.get(userId);
            if(authenticatedToken != null && authenticatedToken.equals(token)) {
                redisClient.expire(userId, RedisClient.TOKEN_EXPIRES_SECOND);
                result = true;
            }
        }
        return result;
    }

    public TokenModel get(String authStr) {
        TokenModel model = null;
        if(StringUtils.isNotEmpty(authStr)) {
            String[] modelArr = authStr.split("_");
            if(modelArr.length == 2) {
                String userId = modelArr[0];
                String token = modelArr[1];
                model = new TokenModel(userId, token);
            }
        }
        return model;
    }

    public boolean delete(Integer id) {
        return redisClient.remove(id == null ? null : String.valueOf(id));
    }
}
