package com.liuxun.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxun
 * @create 2023-07-07 20:19
 * @description
 */

@Data
@TableName("order")
public class Order {
//   @TableId(type = IdType.AUTO)
    private Long orderNo;
    private Long orderId;
    private Long productId;
    private Long accountId;
    private Integer consumNum;
    private Integer payStatus;
    private String userRemark;
}
