package com.haruki.lab5.model.PO;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.util.Date;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:12
 * Description：
 */
@Data
@Alias("OrdersPO")
public class OrdersPO {
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
}
