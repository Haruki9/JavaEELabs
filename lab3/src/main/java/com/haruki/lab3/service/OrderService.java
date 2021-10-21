package com.haruki.lab3.service;

import com.haruki.lab3.dao.OrderDao;
import com.haruki.lab3.model.PO.OrderItemPO;
import com.haruki.lab3.model.PO.OrderItems;
import com.haruki.lab3.model.PO.OrderWithItemsPO;
import com.haruki.lab3.model.PO.OrdersPO;
import com.haruki.lab3.util.ResponseCode;
import com.haruki.lab3.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 20:49
 * Description：
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public ReturnObject queryOrderById(int id){
        ReturnObject returnObject=null;
        OrdersPO ordersPO=orderDao.getFullOrderById(id);
        if (ordersPO==null)
        {
            returnObject=new ReturnObject(ResponseCode.ORDER_NOTEXICT);
        }
        else {
            returnObject=new ReturnObject(ResponseCode.OK,"完整订单查询成功",ordersPO);
        }
        return returnObject;
    }

    public ReturnObject queryOrderLineItemByOrderId(int id){
        ReturnObject returnObject=null;
        List<OrderItemPO> orderItems=orderDao.getOrderLineItemByOrderId(id);
        if (orderItems==null)
        {
            returnObject=new ReturnObject(ResponseCode.ORDER_NOTEXICT,"订单明细不存在");
        }
        else {
            returnObject=new ReturnObject(ResponseCode.OK,"订单明细查询成功",orderItems);
        }
        return returnObject;
    }

    public ReturnObject getOrderWithItemsUsingSqlStatement(int id){
        ReturnObject returnObject;
        OrderItems orderItems=orderDao.getOrderWithItemsUsingSqlStatement(id);
        if (orderItems==null)
        {
            returnObject=new ReturnObject(ResponseCode.ORDER_NOTEXICT,"订单明细不存在");
        }
        else {
            returnObject=new ReturnObject(ResponseCode.OK,"订单明细查询成功",orderItems);
        }
        return returnObject;
    }

    public ReturnObject getOrderWithItemsUsingDaoControl(int id){
        ReturnObject returnObject;
        OrderItems orderItems=orderDao.getOrderWithItemsUsingDaoControl(id);
        if (orderItems==null){
            returnObject=new ReturnObject(ResponseCode.ORDER_NOTEXICT,"订单不存在");
        }
        else {
            returnObject=new ReturnObject(ResponseCode.OK,"订单及订单明细查询成功",orderItems);
        }
        return returnObject;
    }

    public ReturnObject mybatisEmbedQuerySelection(int id){
        ReturnObject returnObject;
        OrderWithItemsPO orderItems=orderDao.mybatisEmbedQuerySelection(id);
        if (orderItems==null){
            returnObject=new ReturnObject(ResponseCode.ORDER_NOTEXICT,"订单不存在");
        }
        else {
            returnObject=new ReturnObject(ResponseCode.OK,"订单及订单明细查询成功",orderItems);
        }
        return returnObject;
    }
}
