package com.mai.guofeng.controller;

import com.mai.guofeng.demo.handlerdemo.handler.AbstractHandler;
import com.mai.guofeng.demo.handlerdemo.model.OrderDTO;
import com.mai.guofeng.demo.handlerdemo.service.impl.OrderServiceV2Impl;
import com.mai.guofeng.demo.handlerdemo.util.BeanTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller("maimaihandler")
public class HandlerController {

    @Autowired
    OrderServiceV2Impl orderServiceV2;


    @GetMapping("mt")
    public String hello() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setType("1");
        System.out.println(orderServiceV2.handle(orderDTO));

        return "123";
    }
}
