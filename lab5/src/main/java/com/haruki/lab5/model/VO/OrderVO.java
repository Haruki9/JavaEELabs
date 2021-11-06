package com.haruki.lab5.model.VO;

import lombok.Data;

import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:36
 * Description：
 */
@Data
public class OrderVO {
    private String consignee;
    private long regionId;
    private String address;
    private String mobile;
    private String message;
    private long couponId;
    private long presaleId;
    private long grouponId;
    private List<OrderItemVO> orderItems;
}
