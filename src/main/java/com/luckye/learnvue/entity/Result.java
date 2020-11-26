package com.luckye.learnvue.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {
    public final static  String success="200";
    public final static  String err ="500";
    //默认是成功的
    private String status = success;

    public  T data;







}
