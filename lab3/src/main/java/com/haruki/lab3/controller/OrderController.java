package com.haruki.lab3.controller;

import com.haruki.lab3.service.OrderService;
import com.haruki.lab3.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 21:45
 * Description：
 */
@RestController
@RequestMapping(value="/Orders",produces = "application/json;charset=UTF-8")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping(value = "/{id}")
    public ReturnObject getOrderWithItemsUsingSqlStatement(@PathVariable("id") Integer id){
        ReturnObject retObject=orderService.getOrderWithItemsUsingSqlStatement(id);
        switch (retObject.getCode()){
            case OK:httpServletResponse.setStatus(HttpServletResponse.SC_OK);retObject.setMessage("使用Sql语句成功返回查询结果");break;
            case ORDER_NOTEXICT:httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND );retObject.setMessage("使用Sql语句查询失败");break;
            default:httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return retObject;
    }

    @GetMapping(value = "/Dao/{id}")
    public ReturnObject getOrderWithItemsUsingDaoLogicCombine(@PathVariable("id") Integer id){
        ReturnObject retObject=orderService.getOrderWithItemsUsingDaoControl(id);
        switch (retObject.getCode()){
            case OK:httpServletResponse.setStatus(HttpServletResponse.SC_OK);retObject.setMessage("DAO逻辑组合返回查询结果");break;
            case ORDER_NOTEXICT:httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND );retObject.setMessage("DAO方式返回查询结果失败");break;
            default:httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return retObject;
    }

    @GetMapping(value="/mybatis/{id}")
    public ReturnObject mybatisEmbedQuerySelection(@PathVariable("id") Integer id){
        ReturnObject retObject=orderService.mybatisEmbedQuerySelection(id);
        switch (retObject.getCode()){
            case OK:httpServletResponse.setStatus(HttpServletResponse.SC_OK);retObject.setMessage("DAO逻辑组合返回查询结果");break;
            case ORDER_NOTEXICT:httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND );retObject.setMessage("DAO方式返回查询结果失败");break;
            default:httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return retObject;
    }

    @GetMapping(value = "/items/{id}")
    public ReturnObject getItems(@PathVariable("id") Integer id){
        ReturnObject retObject=orderService.queryOrderItemsByOrderId(id);
        switch (retObject.getCode()){
            case OK:httpServletResponse.setStatus(HttpServletResponse.SC_OK);retObject.setMessage("DAO逻辑组合返回查询结果");break;
            case ORDER_NOTEXICT:httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND );retObject.setMessage("DAO方式返回查询结果失败");break;
            default:httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return retObject;
    }
}
