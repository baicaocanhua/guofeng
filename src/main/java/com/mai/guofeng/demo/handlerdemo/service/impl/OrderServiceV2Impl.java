package com.mai.guofeng.demo.handlerdemo.service.impl;


import com.mai.guofeng.demo.handlerdemo.service.IOrderService;
import com.mai.guofeng.demo.handlerdemo.handler.AbstractHandler;
import com.mai.guofeng.demo.handlerdemo.handler.HandlerContext;
import com.mai.guofeng.demo.handlerdemo.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 9:54 2019/2/2
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Autowired
    MaiServiceImpl maiService;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance1(dto.getType());
        return handler.handle(dto);
    }

    @Override
    public String sayHandler() {
        maiService.say();
        return "OrderServiceV2Impl";
    }

}
