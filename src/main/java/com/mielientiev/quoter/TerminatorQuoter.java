package com.mielientiev.quoter;

import com.mielientiev.quoter.annotation.DeprecatedClass;
import com.mielientiev.quoter.annotation.InjectRandomInt;
import com.mielientiev.quoter.annotation.PostProxy;
import com.mielientiev.quoter.annotation.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = Terminator1000Quoter.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 10)
    private int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Phase 2 ");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1 Spring create instance");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
