package com.mc.jfaker;

import lombok.Builder;
import lombok.Data;

/**
*@author mc
*@create 2021-06-07 22:33
*
 **/
@Data
@Builder
public class User {
    /**
    * ID
    */
    private Integer id;

    /**
    * 姓名
    */
    private String realname;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 电话
    */
    private String cellphone;

    /**
    * 学校
    */
    private String universityname;

    /**
    * 城市
    */
    private String city;

    /**
    * 地址
    */
    private String street;
}