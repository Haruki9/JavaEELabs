package com.haruki.lab5.model.PO;

import lombok.Data;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 16:37
 * Description：
 */
@Data
public class GoodsSkuPO {
    private long id;
    private long goodsSpuId;
    private String skuId;
    private String name;
    private long originalPrice;
    private String configuration;
    private int weight;
    private String imageUrl;
    private int state;
    private int inventory;
    private String detail;
    private int disabled;
}
