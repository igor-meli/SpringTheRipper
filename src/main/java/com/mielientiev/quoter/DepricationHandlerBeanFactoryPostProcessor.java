package com.mielientiev.quoter;

import com.mielientiev.quoter.annotation.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by meli on 11/15/14.
 */
public class DepricationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override   //bean definition created phase
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String name : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(className);
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if (annotation != null) {
                    beanDefinition.setBeanClassName(annotation.newImpl().getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
