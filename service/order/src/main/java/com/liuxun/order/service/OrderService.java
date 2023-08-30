package com.liuxun.order.service;

import com.liuxun.model.order.OrderVo;
import com.liuxun.model.product.ProductVo;
//import com.liuxun.service1.client.Service11Client;
import com.liuxun.order.client.AccountClient;
import com.liuxun.order.client.ProductClient;
import com.liuxun.order.client.RedisClient;
import com.liuxun.order.client.UserClient;
import com.liuxun.order.entity.Order;
import com.liuxun.order.entity.Rbda;
import com.liuxun.order.listener.RedisMessageListener;
import com.liuxun.order.mapper.ordermapper.OrderMapper;
import com.liuxun.order.mapper.productmapper.ProductMapper;
import com.liuxun.order.mapper.rbdamapper.RbdaMapper;
import com.liuxun.util.redis.RbdaUtil;
import com.liuxun.util.result.Result;


import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import xyz.downgoon.snowflake.Snowflake;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author liuxun
 * @create 2023-07-08 1:51
 * @description
 */
@Slf4j
@Service
public class OrderService{

    Double paysum=0.0;

    @Resource
    private OrderMapper orderDao;

    @Resource
    private ProductClient productClient;
    @Resource
    private AccountClient accountClient;

    @Resource
    private UserClient userClient;
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private RedisClient redisClient;

//    @Resource
//    private RbdaMapper rbdaMapper;

//    @Autowired
//    private OrderDao2 orderDao2;



    @Autowired
    private Snowflake snowflake;


    @Resource
    private RedisTemplate<String,String> resdisTemplate;

    @Resource
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    @Resource
    private RedisMessageListenerContainer redisMessageListenerContainer;
    @Resource
    private RedisMessageListener redisMessageListener;
//
//    @Resource
//    private RbdaUtil rbdaUtil;
//
//    @Autowired
//    private TransactionManager transactionManager;
//
//    @Resource
//    private ProductMapper productMapper;
//
//
//
    String status=null;
    volatile Map<Long,Boolean> payStatus=new HashMap();

//    @Transactional
//    @GlobalTransactional(rollbackFor = Exception.class)
//    public Result generateOrder(OrderVo v){
////        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(1);
//        Long orderId=System.currentTimeMillis();
//        payStatus.put(orderId,false);
//        String phone=(String)httpServletRequest.getAttribute("phone");
//        Long userId=userClient.getUserIdByPhone(phone);
//
//        try{
//            //        BeanUtils.copyProperties(v,productVo);
////        try {
//
////            JwtHelper.getPhone(token);
//
//
//            List<ProductVo> productVos = v.getProductVos();
//
////            if(rbdaUtil.get(v.getPhone())==null){
////                rbdaUtil.set(v.getPhone(),"order",30, TimeUnit.DAYS);
////                throw new RuntimeException();
////            }
//
////            if(rbdaMapper.getOneByPhone(v.getPhone())==null){
////                Rbda rbda = new Rbda();
////                rbda.setPhone(v.getPhone());
////                rbda.setTableName("order");
////                rbda.setUserId(new Date().getTime());
////                rbdaMapper.insert(rbda);
////                throw new RuntimeException();
////            }
//            log.info("Order全局事务id=================>{}", RootContext.getXID());
//
//            ArrayList<Order> orders = new ArrayList<>();
//
////            redisClient.updatePayStatusByOrderId(RootContext.getXID(),orderId,0);
//            //批量扣件库存
//            productClient.batchUpdateStoreByProductId(RootContext.getXID(),productVos);
//            //生成未支付订单
//            for (int i = 0; i < productVos.size(); i++) {
//                Order order = new Order();
//                ProductVo productVo = productVos.get(i);
//                order.setOrderId(orderId);
//                order.setPayStatus(0);
//                order.setConsumNum(productVo.getConsumNum());
//                order.setProductId(productVo.getProductId());
//                order.setOrderNo(snowflake.nextId());
//                orders.add(order);
//            }
//            orderDao.insertBatchOrder(orders);
//
//            //限时支付
//            resdisTemplate.opsForValue().set(orderId+":"+userId,"0",10, TimeUnit.MINUTES);
//
//
//            scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
//                status=resdisTemplate.opsForValue().get(orderId+":"+userId);
//                log.info("*************scheduledThreadPoolExecutor");
//                Double payMoney=0.0;
////                int ii=5/0;
//                if("1".equals(status)){
//                    if(payStatus.get(orderId)==null){
//                        return;
//                    }
//                    else if(!payStatus.get(orderId)){
//                        synchronized (orderId){
//                            if(!payStatus.get(orderId)){
//                                try {
//                                    orderDao.updatePayStatusByOrderId(orderId,1);
////                                    redisClient.updatePayStatusByOrderId(RootContext.getXID(),orderId,1);
////                                    scheduledThreadPoolExecutor.shutdown();
//                                    payStatus.remove(orderId);
//                                }catch (Exception e){
//                                    log.info(Thread.currentThread().getName()+"开启定时任务报错："+e.toString());
//                                }
//                            }
//                        }
//                    }
//                }
//                else if(status==null){
//                    orderDao.updatePayStatusByOrderId(orderId,2);
//                    payStatus.remove(orderId);
//                }
//            },0,3,TimeUnit.SECONDS);
//
////            accountClient.pay(RootContext.getXID(),1L,payMoney);
////            orderDao.updatePayStatusByOrderId();
//            //批量减库存
////            for (int i = 0; i < productVos.size(); i++) {
////                Long orderNo = snowflake.nextId();
////                order.setOrderNo(orderNo);
////                ProductVo productVo = productVos.get(i);
////                productClient.updateStoreByProductId(RootContext.getXID(),productVo.getProductId(),productClient.getStore(productVo.getProductId())-productVo.getConsumNum());
////                order.setConsumNum(productVo.getConsumNum());
////                int ii=5/0;
////                order.setProductId(productVo.getProductId());
////                orderDao.insertOrder(order);
////            }
////            productClient.getStore(productVos.get(0).getProductId());
////            productClient.batchGetStoresByProductIds(productVos);
////            productClient.batchUpdateStoreByProductId(RootContext.getXID(),productVos);
////            for (int i = 0; i < productVos.size(); i++) {
////
////                ProductVo productVo = productVos.get(i);
////                order.setConsumNum(productVo.getConsumNum());
////                order.setOrderId(orderId);
////                order.setProductId(productVo.getProductId());
//////                key+=":"+productVo.getProductId();
//////                if(i%2==0)
////                orderDao.insertOrder(order);
//////                else
//////                    orderDao2.insertOrder(order);
////
//////                throw new RuntimeException("fdfdsf");
////            }
//////            value=orderId;
//////            resdisTemplate.opsForValue().set(""+new Date().getTime(),Long.toString(orderId));
//
//
////        } catch (RuntimeException e){
//////            return Result.fail();
////            throw e;
////        }
////        order.setId(orderId);
//
////        BeanUtils.copyProperties(v,order);
////        ArrayList<Product> products = new ArrayList<>();
////        productVos.forEach(productVo -> paysum+=productVo.getConsumNum()* service11Client.getPrice(productVo.getProductId()));
////        productVos.forEach(productVo -> products.add(new Product(,productVo.getConsumNum())));
//
////        order.setPaySum(paysum);
////        order.setId(orderId);
////        order.setPayStatus(1);
//
////        productVos.forEach(productVo -> BeanUtils.copyProperties());
////        order.setProducts(v.getProductVos());
////
////        orderDao.insertOrder(order);
//            return Result.ok();
//        }catch (Exception e){
//            try {
//                resdisTemplate.opsForValue().decrement(orderId.toString());
//                GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//            }catch (TransactionException te){
//                return Result.fail(te);
//            }
//            return Result.fail(e);
//        }
//
//    }
//}

    @Transactional
    @GlobalTransactional(rollbackFor = Exception.class)
    public Result generateOrder(OrderVo v){
        Long orderId=System.currentTimeMillis();
        resdisTemplate.opsForValue().set(orderId+":xid",RootContext.getXID(),10,TimeUnit.MINUTES);
        payStatus.put(orderId,false);
        String phone=(String)httpServletRequest.getAttribute("phone");
        Long userId=userClient.getUserIdByPhone(phone);

        try{

            List<ProductVo> productVos = v.getProductVos();
            log.info("Order全局事务id=================>{}", RootContext.getXID());

            ArrayList<Order> orders = new ArrayList<>();
            productClient.batchUpdateStoreByProductId(RootContext.getXID(),productVos);
            //生成未支付订单
            for (int i = 0; i < productVos.size(); i++) {
                Order order = new Order();
                ProductVo productVo = productVos.get(i);
                order.setOrderId(orderId);
                order.setPayStatus(0);
                order.setConsumNum(productVo.getConsumNum());
                order.setProductId(productVo.getProductId());
                order.setOrderNo(snowflake.nextId());
                orders.add(order);
            }
            orderDao.insertBatchOrder(orders);

            //限时支付
            resdisTemplate.opsForValue().set(orderId.toString(),"0",10, TimeUnit.MINUTES);

            return Result.ok();
        }catch (Exception e){
            try {
                resdisTemplate.opsForValue().decrement(orderId+":"+userId);
                GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            }catch (TransactionException te){
                return Result.fail(te);
            }
            return Result.fail(e);
        }

    }
    public void updatePayStatusByOrderId(Long orderId,Integer payStatus) {
        orderDao.updatePayStatusByOrderId(orderId, payStatus);
    }
}