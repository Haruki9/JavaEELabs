package com.haruki.lab4.model.PO;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/21
 * Time: 12:04
 * Description：
 */
@Data
public class OrderItems {
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

    public OrderItems setOrderPO(long id, long customerId, long shopId, String orderSn, long pid, String consignee, long regionId, String address, String mobile, String message, int orderType, long couponId, long couponActivity, long discountPrice, long originPrice, long freightPrice, long presaleId, long grouponDiscount, int rebateNum, long grouponId, String shipmentSn, int state, int subState, int beDeleted, Date gmtCreate, Date gmtModified, Date confirmTime) {
        this.id = id;
        this.customerId = customerId;
        this.shopId = shopId;
        this.orderSn = orderSn;
        this.pid = pid;
        this.consignee = consignee;
        this.regionId = regionId;
        this.address = address;
        this.mobile = mobile;
        this.message = message;
        this.orderType = orderType;
        this.couponId = couponId;
        this.couponActivity = couponActivity;
        this.discountPrice = discountPrice;
        this.originPrice = originPrice;
        this.freightPrice = freightPrice;
        this.presaleId = presaleId;
        this.grouponDiscount = grouponDiscount;
        this.rebateNum = rebateNum;
        this.grouponId = grouponId;
        this.shipmentSn = shipmentSn;
        this.state = state;
        this.subState = subState;
        this.beDeleted = beDeleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.confirmTime = confirmTime;
        return this;
    }

    public OrderItems setForDao(OrdersPO ordersPO, List<OrderItemPO> lineItems){
        this.id = ordersPO.getId();
        this.customerId = ordersPO.getCustomerId();
        this.shopId = ordersPO.getShopId();
        this.orderSn = ordersPO.getOrderSn();
        this.pid = ordersPO.getPid();
        this.consignee = ordersPO.getConsignee();
        this.regionId = ordersPO.getRegionId();
        this.address = ordersPO.getAddress();
        this.mobile = ordersPO.getMobile();
        this.message = ordersPO.getMessage();
        this.orderType = ordersPO.getOrderType();
        this.couponId = ordersPO.getCouponId();
        this.couponActivity = ordersPO.getCouponActivity();
        this.discountPrice = ordersPO.getDiscountPrice();
        this.originPrice = ordersPO.getOriginPrice();
        this.freightPrice = ordersPO.getFreightPrice();
        this.presaleId = ordersPO.getPresaleId();
        this.grouponDiscount = ordersPO.getGrouponDiscount();
        this.rebateNum = ordersPO.getRebateNum();
        this.grouponId = ordersPO.getGrouponId();
        this.shipmentSn = ordersPO.getShipmentSn();
        this.state = ordersPO.getState();
        this.subState = ordersPO.getSubState();
        this.beDeleted = ordersPO.getBeDeleted();
        this.gmtCreate = ordersPO.getGmtCreate();
        this.gmtModified = ordersPO.getGmtModified();
        this.confirmTime = ordersPO.getConfirmTime();
        this.lineItems = lineItems;
        return this;
    }
}
