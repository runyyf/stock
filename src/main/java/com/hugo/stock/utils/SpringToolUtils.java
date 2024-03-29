package com.hugo.stock.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: yuyf
 * @Description:
 * @Date: Created in 20:39 2018/5/9
 */
@Component
public final class SpringToolUtils implements ApplicationContextAware {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringToolUtils.applicationContext == null) {
            SpringToolUtils.applicationContext = applicationContext;
            System.out.println(
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                            + applicationContext + "========");
//            String[] beanNames = applicationContext.getBeanDefinitionNames();
//            int i = 0 ;
//            for (String str : beanNames){
//                logger.info("{},beanName:{}", ++i, str);
//            }
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
}
