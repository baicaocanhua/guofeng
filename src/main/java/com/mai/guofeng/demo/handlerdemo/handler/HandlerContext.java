package com.mai.guofeng.demo.handlerdemo.handler;

import com.mai.guofeng.demo.handlerdemo.util.BeanTool;

import java.util.Map;

public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (AbstractHandler) BeanTool.getBean(clazz);
    }

    public AbstractHandler getInstance1(String type) {

        return (AbstractHandler) BeanTool.getBean(type);
    }

}
