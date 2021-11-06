package com.haruki.lab5.service;

import com.haruki.lab5.model.VO.OrderVO;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/11/5
 * Time: 18:11
 * Description：
 */
@Service
public class RocketMQService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void asyncSendNewOrderMessage(OrderVO orderVO){
        Message<OrderVO> message=MessageBuilder.withPayload(orderVO).build();
        rocketMQTemplate.asyncSend("NEW_ORDER_MSG", message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("订单写入MQ。");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("订单写入MQ失败。");
            }
        },30000,1);
    }

    public void oneWaySendNewOrderMessage(OrderVO orderVO){
        Message<OrderVO> message=MessageBuilder.withPayload(orderVO).build();
        rocketMQTemplate.sendOneWay("NEW_ORDER_MSG",message);
    }
}
