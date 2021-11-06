package com.haruki.lab4.controller;

import com.haruki.lab4.service.GoodsService;
import com.haruki.lab4.util.RedisUtil;
import com.haruki.lab4.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/27
 * Time: 17:41
 * Description：
 */
@RestController
@RequestMapping(value = "/goods",produces = "application/json;charset=UTF-8")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/{id}")
    public ReturnObject searchGoodsByID(@PathVariable("id") int id){
        return goodsService.getGoodsById(id);
    }

    @GetMapping("/product/{id}")
    public ReturnObject searchProductByID(@PathVariable("id") int id){
        return goodsService.getProductById(id);
    }
}
