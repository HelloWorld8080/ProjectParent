package com.liuxun.order.listener;

import com.liuxun.order.service.OrderService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liuxun
 * @create 2023-08-23 19:54
 * @description
 */
@Component
public class RedisMessageListener implements MessageListener {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private OrderService orderService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息
//        byte[] messageBody = message.getBody();
        String msg = message.toString();
        // 使用值序列化器转换
//        String msg = (String) redisTemplate.getValueSerializer().deserialize(messageBody);
        // 获取监听的频道
//        byte[] channelByte = message.getChannel();
        // 使用字符串序列化器转换
//        String channel =redisTemplate.getStringSerializer().deserialize(channelByte);
        // 渠道名称转换
        String  channel= new String(pattern);
//        System.out.println(patternStr);

//        System.out.println("---频道---: " + channel);
//        System.out.println("---消息内容---: " + msg);
        orderService.updatePayStatusByOrderId(Long.parseLong(channel),Integer.parseInt(msg));
    }
}