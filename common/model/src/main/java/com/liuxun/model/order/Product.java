package com.liuxun.model.order;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuxun
 * @create 2023-07-19 23:56
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

//    @TableId(type= IdType.AUTO)
    Long productId;

    String productName;
    Integer store;
}
