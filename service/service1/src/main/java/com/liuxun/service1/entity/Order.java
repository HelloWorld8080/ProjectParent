package com.liuxun.service1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liuxun
 * @create 2023-07-07 20:19
 * @description
 */

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private Long productId;
    private Long payId;
    private Double paySum;
    private Integer payStatus;
    private String userRemark;
}
