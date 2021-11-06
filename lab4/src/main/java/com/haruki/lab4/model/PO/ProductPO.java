package com.haruki.lab4.model.PO;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/27
 * Time: 21:10
 * Description：
 */
@Data
public class ProductPO implements Serializable {
    private long id;
    private long goodsId;
    private String productSn;
    private String name;
    private Double originalPrice;
    private int weight;
    private String imageUrl;
    private int state;
    private String detail;
    private int disabled;

    private GoodsPO goods;
}
