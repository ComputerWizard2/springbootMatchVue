package com.luckye.learnvue.entity;

import lombok.Data;
import org.yaml.snakeyaml.events.Event;

@Data
public class LoginData {
    private  String id;
    private String rid;
    private String userName;
    private String mobile;

    private String token;

    private Mata mate;

}
