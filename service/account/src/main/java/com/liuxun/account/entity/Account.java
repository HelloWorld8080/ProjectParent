package com.liuxun.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxun
 * @create 2023-08-15 11:28
 * @description
 */
@Data
@TableName("account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Long accountId;
    private Double money;
    private Long userId;
}
