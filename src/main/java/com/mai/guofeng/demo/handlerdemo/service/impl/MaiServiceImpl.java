package com.mai.guofeng.demo.handlerdemo.service.impl;

import com.mai.guofeng.demo.handlerdemo.service.MaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaiServiceImpl implements MaiService {

    @Autowired
    OrderServiceV2Impl orderServiceV2;

    @Override
    public String say() {
        orderServiceV2.sayHandler();
        return "123";
    }
}
