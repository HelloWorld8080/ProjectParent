package com.liuxun.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxun
 * @create 2023-08-18 16:55
 * @description
 */
@TableName("user")
@Data
public class User {
    @TableId(type=IdType.AUTO)
    private Long UserId;
    private String UserName;
    private String password;
    private String phone;
}
