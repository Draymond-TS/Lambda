package com.Draymond.Lambda.functionBase;


import java.util.function.Function;

/**
 * @author Zerox
 * @date 2018/12/5 13:21
 */
public class TestFunctionIdentity {

    public static void main(String[] args) {
        // 翻译过来就是：输入是什么。输出就是什么,暂时,我还没有什么遇到高级的用法
        Function<String,String> function = Function.identity();
        String strValue = testIdentity(function);
        System.out.println(strValue);
    }

    public static String testIdentity(Function<String,String> function) {
        return function.apply("hello world");
    }
}
