package com.liuxun.model.order;

import com.liuxun.model.product.ProductVo;
import lombok.Data;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-20 1:10
 * @description
 */
@Data
public class OrderVo {
    private  String phone;
    private  Long accountId;
    private List<ProductVo> productVos;

}
