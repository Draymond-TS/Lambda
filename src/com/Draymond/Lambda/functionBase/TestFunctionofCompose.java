package com.Draymond.Lambda.functionBase;


import java.util.function.Function;

/**
 * @author Draymond
 * @date 2021/1/9 18:50
 */
public class TestFunctionofCompose {

    public static void main(String[] args) {
        // 翻译过来就是：接收一个function类型的函数作为参数,这个函数真是越看越有意思。
        System.out.println(testFunction(2,i -> i * 2 + 1,j -> j * j));
    }

    public static int testFunction(int i, Function<Integer,Integer> function1,Function<Integer,Integer> function2) {

        return function1.compose(function2).apply(i);
    }
}
