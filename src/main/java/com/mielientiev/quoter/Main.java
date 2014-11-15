package com.mielientiev.quoter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(Quoter.class).sayQuote();

       // Quoter quoter = applicationContext.getBean(TerminatorQuoter.class);// bad practice on  class name
//        Quoter quoter = applicationContext.getBean(Quoter.class);// bad practice on  class name
//        while (true) {
//            Thread.sleep(300);
//            quoter.sayQuote();
//        }

    }
}
