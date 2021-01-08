package com.Draymond.Lambda.functionBase;


import java.util.function.Function;

/**
 * @author Zerox
 * @date 2018/12/4 15:59
 *
 *
 * 1.R apply(T t)
 * 按照以往的逻辑,我们先来看下原始接口是怎么说的
 * 翻译过来就是：将给定的参数应用到这个函数上,传入的参数类型为T返回类型为R
 *
 */
public class TestFunction {

    public static void main(String[] args) {

        System.out.println(testFunction(2,i -> i * 2 + 1));
    }

    public static int testFunction(int i, Function<Integer,Integer> function) {

        return function.apply(i);
    }
}
