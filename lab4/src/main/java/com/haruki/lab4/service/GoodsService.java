package com.haruki.lab4.service;

import com.haruki.lab4.dao.GoodsDao;
import com.haruki.lab4.model.PO.GoodsPO;
import com.haruki.lab4.model.PO.ProductPO;
import com.haruki.lab4.util.ResponseCode;
import com.haruki.lab4.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/30
 * Time: 13:30
 * Description：
 */
@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    public ReturnObject getProductById(int id){
        ProductPO productPO = goodsDao.getProductByID(id);
        if (productPO==null){
            return new ReturnObject(ResponseCode.PRODUCT_NOTEXICT);
        }
        return new ReturnObject(ResponseCode.OK,"规格查询成功",productPO);
    }

    public ReturnObject getGoodsById(int id){
        GoodsPO goodsPO = goodsDao.getGoodsByID(id);
        if (goodsPO==null){
            return new ReturnObject(ResponseCode.GOODS_NOTEXICT);
        }
        return new ReturnObject(ResponseCode.OK,"商品查询成功",goodsPO);
    }
}
