package com.haruki.lab4.model.PO;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:13
 * Description：
 */

@Data
@Alias("OrderItemPO")
public class OrderItemPO {
    private long id;
    private long orderId;
    private long goodsSkuId;
    private int quantity;
    private long price;
    private long discount;
    private String name;
    private long couponActivity;
    private long beShareId;
    private Date gmtCreate;
    private Date gmtModified;
}
