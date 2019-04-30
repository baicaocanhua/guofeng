package com.mai.guofeng.demo.handlerdemo.handler;


import com.mai.guofeng.demo.handlerdemo.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:40 2019/2/1
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.mai.guofeng.demo.handlerdemo.handler.biz";


    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     * @see HandlerType
     * @see HandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // Maps.newHashMapWithExpectedSize(3);
        Map<String, Class> handlerMap = new HashMap<>(3);
        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMap.put(type, clazz);
        });
        HandlerContext context = new HandlerContext(handlerMap);


        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }

}
