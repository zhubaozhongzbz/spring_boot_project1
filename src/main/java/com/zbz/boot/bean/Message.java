package com.zbz.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private  String  title;
    private  String  type;
    private  String  link;
}
