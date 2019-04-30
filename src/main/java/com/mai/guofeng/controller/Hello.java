package com.mai.guofeng.controller;

import com.mai.guofeng.demo.handlerdemo.handler.AbstractHandler;
import com.mai.guofeng.demo.handlerdemo.model.OrderDTO;
import com.mai.guofeng.demo.handlerdemo.service.impl.OrderServiceV2Impl;
import com.mai.guofeng.demo.handlerdemo.util.BeanTool;
import com.mai.guofeng.model.Column;
import com.mai.guofeng.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
public class Hello {

    @Autowired
    OrderServiceV2Impl orderServiceV2;

    @Value("${maimai}")
    private String maimai;

    @Value("${test.port}")
    private String port;

    @GetMapping("maimai")
    public String getmai() {
        return maimai + port;
    }

    @GetMapping("hello")
    public String hello() {
        Map<String, AbstractHandler> map = BeanTool.getBeans(AbstractHandler.class);
        for (Map.Entry<String, AbstractHandler> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        AbstractHandler ah = map.get("groupHandler");
        OrderDTO dto = new OrderDTO();
        dto.setType("2");
        System.out.println(ah.handle(dto));
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setType("1");
        System.out.println(orderServiceV2.handle(orderDTO));


        return "123";
    }

    public static void main(String[] args) {
        String[] str = getColumnValue(Student.class);
        for (int i = 1; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    public static String[] getColumnValue(Class classz) {
        Field[] fields = classz.getDeclaredFields();
        Field field;
        String[] value = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
        }
        for (int i = 1; i < fields.length; i++) {
            try {
                field = classz.getDeclaredField(fields[i].getName());
                //获取指定类型注解
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    value[i] = column.name();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
