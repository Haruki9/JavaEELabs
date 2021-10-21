package com.haruki.lab3.model.PO;

import lombok.Data;

import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/21
 * Time: 17:59
 * Description：
 */
@Data
public class OrderWithItemsPO {
    private OrdersPO ordersPO;
    private List<OrderItemPO> lineItems;
}
