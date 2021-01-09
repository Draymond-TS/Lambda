package com.Draymond.Lambda.functionBase;


import java.util.function.Function;

/**
 * @author Draymond
 * @date 2021/1/9 18:50
 *
 * 1.R apply(T t)
 * 按照以往的逻辑,我们先来看下原始接口是怎么说的
 * 翻译过来就是：将给定的参数应用到这个函数上,传入的参数类型为T返回类型为R
 *
 */
public class TestFunction {

    public static void main(String[] args) {
        // 一个入参 ，确定抽象方法是 apply(T t) ，一个被@FunctionalInterface 定义的接口， 也只能有一个抽象方法
        Function<Integer,Integer> function = j -> j * 2 +1 ;
        int i = testFunction(2, function);
        System.out.println(i);

        // 简化
        int result = testFunction(2, integer -> integer * 2 + 1);
        System.out.println(result);
    }

    public static int testFunction(int i, Function<Integer,Integer> function) {
        return function.apply(i);
    }
}
