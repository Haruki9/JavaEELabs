package com.haruki.lab5.controller;

import com.haruki.lab5.model.VO.OrderVO;
import com.haruki.lab5.service.OrderService;
import com.haruki.lab5.service.RocketMQService;
import com.haruki.lab5.util.ResponseCode;
import com.haruki.lab5.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private RocketMQService rocketMQService;

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

    @PostMapping(value = "/add")
    public ReturnObject addNewOrders(@RequestBody OrderVO orderVO){
        boolean flag=orderService.addNewOrders(orderVO);
        if (!flag){
            return new ReturnObject(ResponseCode.CREATED_FAILED,"创建失败",null);
        }
        return new ReturnObject(ResponseCode.CREATED_SUCCESS,"创建订单成功",null);
    }

    @PostMapping(value = "/mq/add")
    public ReturnObject produceNewOrdersMQ(@RequestBody OrderVO orderVO){
        rocketMQService.oneWaySendNewOrderMessage(orderVO);
        return new ReturnObject(ResponseCode.OK);
    }

    @PostMapping(value = "/mq/async/add")
    public ReturnObject asyncProduceNewOrdersMQ(@RequestBody OrderVO orderVO){
        rocketMQService.asyncSendNewOrderMessage(orderVO);
        return new ReturnObject(ResponseCode.OK);
    }
}
