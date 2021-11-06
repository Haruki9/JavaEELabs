package com.haruki.lab5.model.VO;

import lombok.Data;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:37
 * Description：
 */
@Data
public class OrderItemVO {
    private long goodsSkuId;
    private long quantity;
    private long couponActivity;
}
