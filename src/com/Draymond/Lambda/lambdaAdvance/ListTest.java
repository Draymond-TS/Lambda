package com.Draymond.Lambda.lambdaAdvance;

import org.junit.Test;

import java.util.*;

public class ListTest {

    @Test
    public void test5_1() {
        List<String> list = Arrays.asList("one","two","three");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(System.out::println);
    }
}
