package com.Draymond.Lambda.lambdaAdvance;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void test4_1() {
        // 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
            }
        }).start();

        // 使用lambda
        new Thread(() -> System.out.println("start")).start();
    }

}
