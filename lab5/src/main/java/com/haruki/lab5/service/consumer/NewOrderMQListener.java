package com.haruki.lab5.service.consumer;

import com.haruki.lab5.dao.OrderDao;
import com.haruki.lab5.model.VO.OrderVO;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/11/5
 * Time: 23:00
 * Description：
 */
@Component
@RocketMQMessageListener(consumerGroup = "rocketmq-lab5-consumer",topic = "NEW_ORDER_MSG")
public class NewOrderMQListener implements RocketMQListener<OrderVO> {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void onMessage(OrderVO orderVO) {
        orderDao.addNewOrders(orderVO);
        System.out.printf("将订单数据写入数据库。顾客name：%s",orderVO.getConsignee());
    }
}
