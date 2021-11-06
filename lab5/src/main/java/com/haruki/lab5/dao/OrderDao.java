package com.haruki.lab5.dao;

import com.haruki.lab5.mapper.OrdersMapper;
import com.haruki.lab5.model.PO.OrderItemPO;
import com.haruki.lab5.model.PO.OrderItems;
import com.haruki.lab5.model.PO.OrderWithItemsPO;
import com.haruki.lab5.model.PO.OrdersPO;
import com.haruki.lab5.model.VO.OrderItemVO;
import com.haruki.lab5.model.VO.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 19:50
 * Description：
 */
@Repository
public class OrderDao {
    @Autowired
    OrdersMapper mapper;

    public OrdersPO getFullOrderById(int id){
        OrdersPO ordersPO=null;
        try{
            ordersPO=mapper.queryFullOrderInfoById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ordersPO;
    }


    public List<OrderItemPO> getOrderLineItemByOrderId(int orderId){
        List<OrderItemPO> orderItems=null;
        try{
            orderItems=mapper.queryOrderLineItemByOrderId(orderId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return orderItems;
    }

    public OrderItems getOrderWithItemsUsingSqlStatement(int id){
        OrderItems orderItems=null;
        try{
            orderItems=mapper.relationQueryOrderItemById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return orderItems;
    }

    public OrderItems getOrderWithItemsUsingDaoControl(int id){
        OrderItems orderItems=new OrderItems();
        try{
            OrdersPO ordersPO=mapper.queryFullOrderInfoById(id);
            List<OrderItemPO> items=mapper.queryOrderLineItemByOrderId(id);
            orderItems.setForDao(ordersPO,items);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return orderItems;
    }

    public OrderWithItemsPO mybatisEmbedQuerySelection(int id){
        OrderWithItemsPO orderItems=null;
        try{
            orderItems=mapper.mybatisEmbedSelection(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return orderItems;
    }

    public boolean addNewOrders(OrderVO orderVO){
        try{
            List<OrderItemVO> items=orderVO.getOrderItems();
            for (OrderItemVO item:items){
                mapper.addNewOrderItem(item.getGoodsSkuId(),item.getQuantity(),item.getCouponActivity());
            }
            mapper.addNewOrder(orderVO.getConsignee(),orderVO.getRegionId(),orderVO.getAddress(), orderVO.getMobile(),orderVO.getMessage(), orderVO.getCouponId(), orderVO.getPresaleId(),orderVO.getGrouponId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
       return true;
    }
}
