package com.liuxun.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxun
 * @create 2023-08-08 19:09
 * @description
 */
@Data
@TableName("RBDA")
public class Rbda {
    @TableId
    private Long userId;
    private String phone;
    private String tableName;
    private String url;
}
