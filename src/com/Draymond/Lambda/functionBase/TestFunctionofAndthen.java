package com.Draymond.Lambda.functionBase;


import java.util.function.Function;

/**
 * @author Draymond
 * @date 2021/1/9 18:50
 */
public class TestFunctionofAndthen {

    public static void main(String[] args) {
        // 翻译过来就是：就是现将传过来的参数执行apply(T t)方法,之后把apply(T t)里面返回的结果再去执行第二个Function函数
        System.out.println(testFunction(2,i -> i * 2 + 1,j -> j * j));
    }

    public static int testFunction(int i, Function<Integer,Integer> function1,Function<Integer,Integer> function2) {

        return function1.andThen(function2).apply(i);
    }
}
