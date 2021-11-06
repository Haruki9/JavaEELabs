package com.haruki.lab4.mapper;

import com.haruki.lab4.model.PO.OrderItemPO;
import com.haruki.lab4.model.PO.OrderItems;
import com.haruki.lab4.model.PO.OrderWithItemsPO;
import com.haruki.lab4.model.PO.OrdersPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:44
 * Description：
 */
@Mapper
public interface OrdersMapper {
    OrdersPO queryFullOrderInfoById(int id);

    List<OrderItemPO> queryOrderLineItemByOrderId(int id);

    //sql关联表查询
    OrderItems relationQueryOrderItemById(int id);

    //mybatis嵌套select查询
    OrderWithItemsPO mybatisEmbedSelection(int id);
}
