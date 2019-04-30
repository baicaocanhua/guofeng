package com.mai.guofeng.demo.handlerdemo.handler.biz;


import com.mai.guofeng.demo.handlerdemo.handler.AbstractHandler;
import com.mai.guofeng.demo.handlerdemo.handler.HandlerType;
import com.mai.guofeng.demo.handlerdemo.model.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @Author: CipherCui
 * @Description: 普通订单处理器
 * @Date: Created in 10:17 2019/2/2
 */
@Component("1")
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理普通订单";
    }

}
