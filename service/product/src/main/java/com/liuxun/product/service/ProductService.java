package com.liuxun.product.service;

import com.liuxun.model.product.ProductVo;
import com.liuxun.product.entity.Product;
import com.liuxun.product.mapper.ProductDao;
import com.liuxun.util.result.Result;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:26
 * @description
 */
@Slf4j
@Service
public class ProductService {

    @Resource
    private ProductDao productDao;

    @Resource
    private HttpSession httpSession;

    @Transactional
    public  Result updateStoreById(List<ProductVo> ps){

        try {
            ps.forEach(item->productDao.updateStoreByid(getStore(item.getProductId())-item.getConsumNum(),item.getProductId()));
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.ok();
    }
    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Result updateStoresById(List<ProductVo> ps) {
        try {
            ps.forEach(item->productDao.updateStoreByid(getStore(item.getProductId())-item.getConsumNum(),item.getProductId()));
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.ok();
    }

    public Integer getStore(Long productId) {
       return productDao.getStore(productId);
    }
    public Double getPrice(Long productId) {
        return productDao.getPrice(productId);
    }

    public Result updateStoreByProductId(String xid,Long productId, Integer store) {
        try {
            RootContext.bind(xid);
            productDao.updateStoreByProductId(productId,store);
        }catch (Exception e){
            return Result.fail(e);
        }
        return Result.ok();
    }

    @Transactional
    public Result batchUpdateStoreByProductId(String xid, List<ProductVo> productVos) {
        List<Product> products = productDao.batchGetStore(productVos);
        for (int i = 0; i < products.size(); i++) {
            ProductVo productVo=productVos.get(i);
            productVo.setConsumNum(products.get(i).getStore()- productVo.getConsumNum());
        }
        RootContext.bind(xid);
        productDao.batchUpdateStoreByProductId(productVos);
        return Result.ok();
    }
}
