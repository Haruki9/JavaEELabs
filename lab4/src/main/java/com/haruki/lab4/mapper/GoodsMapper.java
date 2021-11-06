package com.haruki.lab4.mapper;

import com.haruki.lab4.model.PO.GoodsPO;
import com.haruki.lab4.model.PO.ProductPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/27
 * Time: 21:13
 * Description：
 */
@Mapper
public interface GoodsMapper {
    ProductPO getProductById(int id);

    GoodsPO getGoodsInfoById(int id);

    List<ProductPO> getProductByGoodsID(int goods_id);
}
