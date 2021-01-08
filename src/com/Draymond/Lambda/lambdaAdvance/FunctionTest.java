package com.Draymond.Lambda.lambdaAdvance;

import org.junit.Test;

public class FunctionTest {

    @Test
    public void test3_1() {
        TheInterface theInterface = () -> {};
        System.out.println(theInterface.getClass().getInterfaces()[0]);
        TheInterface2 theInterface2 = () -> {};
        System.out.println(theInterface2.getClass().getInterfaces()[0]);

    }

    @FunctionalInterface
    interface TheInterface {
        void myMethod();
    }

    @FunctionalInterface
    interface TheInterface2 {
        void myMethod2();
    }


}
