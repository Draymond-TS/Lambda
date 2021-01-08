package com.Draymond.Lambda.lambdaAdvance;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterationTest {
    /**
     * 外部迭代
     */
    @Test
    public void test1_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int number : numbers){
            System.out.println(number);
        }
    }

    /**
     * 内部迭代
     */
    public void test1_2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
    }

    /**
     * java8 lambda进一步
     */
    @Test
    public void test1_3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach((Integer value) -> System.out.println(value));
    }

    /**
     * java8 lambda再进一步
     */
    @Test
    public void test1_4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(value -> System.out.println(value));
    }

    /**
     * java8 lambda再再进一步
     */
    @Test
    public void test1_5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(System.out::println);
    }


}
