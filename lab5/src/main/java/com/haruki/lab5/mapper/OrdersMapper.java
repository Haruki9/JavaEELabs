package com.haruki.lab5.mapper;

import com.haruki.lab5.model.PO.OrderItemPO;
import com.haruki.lab5.model.PO.OrderItems;
import com.haruki.lab5.model.PO.OrderWithItemsPO;
import com.haruki.lab5.model.PO.OrdersPO;
import com.haruki.lab5.model.VO.OrderVO;
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

    boolean addNewOrder(String  consignee,long regionId,String address,String mobile,String message,long couponId,long presaleId,long grouponId);

    boolean addNewOrderItem(long goodsSkuId,long quantity,long couponActivity);
}
