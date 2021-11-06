package com.haruki.lab4.model.PO;

import lombok.Data;

import java.util.Date;
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
    private long id;
    private long customerId;
    private long shopId;
    private String orderSn;
    private long pid;
    private String consignee;
    private long regionId;
    private String address;
    private String mobile;
    private String message;
    private int orderType;
    private long couponId;
    private long couponActivity;
    private long discountPrice;
    private long originPrice;
    private long freightPrice;
    private long presaleId;
    private long grouponDiscount;
    private int rebateNum;
    private long grouponId;
    private String shipmentSn;
    private int state;
    private int subState;
    private int beDeleted;
    private Date gmtCreate;
    private Date gmtModified;
    private Date confirmTime;
    private List<OrderItemPO> lineItems;
}
