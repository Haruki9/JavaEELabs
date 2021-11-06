package com.haruki.lab4.model.PO;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/27
 * Time: 21:18
 * Description：
 */
@Data
public class GoodsPO implements Serializable {
    private long id;
    private String name;
    private long brandId;
    private long categoryId;
    private long freightId;
    private long shopId;
    private String goodsSn;
    private String detail;
    private String imageUrl;
    private int disabled;
}
