package com.zbz.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@TableName("user")//指定表名称
public class User {
    @TableField(exist = false)
    private String userName;
    private Integer age;
    @TableField(exist = false)
    private Pet   pet;
    @TableField(exist = false)
    private String passWord;
    private Integer id;
    private String name;


    public User(String zhangsan, int i, Pet tomCat) {
    }


}
