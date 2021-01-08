package com.Draymond.Lambda.lambdaAdvance;

import java.util.function.*;

public class FunctionAdvanceTest {
    /**
     * Function测试类
     */
    class FunctionTest {

        public int compute(int a, Function<Integer, Integer> function) {
            // Function 提供了一个抽象方法  R apply(T t) 接收一个参数 返回 一个值，还有两个默认方法和一个静态方法

            int result = function.apply(a);
            return result;
        }

        public String convert(int a, Function<Integer, String> function) {
            return function.apply(a);
        }
    }
    public void test7_1() {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, value -> {return 2 * value;}));
        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.compute(3, value -> value * value));
        System.out.println(test.convert(5, value -> String.valueOf(value + "helloworld")));
    }

    static class FunctionTest2 {

        public static void main(String[] args) {
            FunctionTest2 test = new FunctionTest2();
//            System.out.println(test.compute(2, value -> value * 3, value -> value * value)); // 12
//            System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); // 36
//            System.out.println(test.compute3(1, 2, (value1, value2) -> value1 * value2));  // 2
//            System.out.println(test.compute3(1, 2, (value1, value2) -> value1 / value2));  // 0.5

            System.out.println(test.compute4(2, 3, (value1, value2) -> value1 + value2, value -> value * value)); // 25
        }


        public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
            return function1.compose(function2).apply(a);
        }

        public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
            return function1.andThen(function2).apply(a);
        }

        public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
            return biFunction.apply(a, b);
        }

        public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
            return biFunction.andThen(function).apply(a, b);
        }
    }

}
