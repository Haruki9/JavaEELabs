package com.haruki.lab4.dao;

import com.haruki.lab4.mapper.GoodsMapper;
import com.haruki.lab4.model.PO.GoodsPO;
import com.haruki.lab4.model.PO.ProductPO;
import com.haruki.lab4.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/30
 * Time: 13:15
 * Description：
 */
@Repository
public class GoodsDao {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    GoodsMapper goodsMapper;

    public ProductPO getProductByID(int id){
        String key="p_" + id;
        ProductPO productPO=(ProductPO)redisUtil.get(key);
        if (productPO!=null){
            System.out.println("Get product "+key+" from redis.");
            return productPO;
        }
        try{
            productPO=goodsMapper.getProductById(id);
            productPO.setGoods(goodsMapper.getGoodsInfoById((int)productPO.getGoodsId()));
            redisUtil.set(key,productPO,3600);
            System.out.println("Set product "+key+" in redis.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return productPO;
    }

    public GoodsPO getGoodsByID(int id){
        String key="g_" + id;
        GoodsPO goodsPO=(GoodsPO) redisUtil.get(key);
        if (goodsPO!=null){
            System.out.println("Get product "+key+" from redis.");
            return goodsPO;
        }
        try{
            goodsPO=goodsMapper.getGoodsInfoById(id);
            redisUtil.set(key,goodsPO,3600);
            System.out.println("Set product "+key+" in redis.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return goodsPO;
    }
}
