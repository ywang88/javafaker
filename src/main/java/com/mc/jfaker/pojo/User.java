package com.mc.jfaker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @author mc
 * @create 2021-06-07 21:46
 **/
@Data
public class User {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
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
