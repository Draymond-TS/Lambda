package com.Draymond.Lambda.lambdaAdvance;

import java.util.*;
import java.util.function.Predicate;

public class PredicatFunctioneTest {

    static class PredicateTest {
        public static void main(String[] args) {
            Predicate<String> predicate = p -> p.length() > 5;
            System.out.println(predicate.test("hello1"));
        }
    }

    static class PredicateTest2 {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            PredicateTest2 predicateTest2 = new PredicateTest2();

            predicateTest2.conditionFilter(list, item -> item % 2 == 0);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item % 2 != 0);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item > 5);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item < 3);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> true);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> false);
            System.out.println("----------");

            predicateTest2.conditionAndFilter(list, item -> item > 5, item -> item % 2 == 0);
            System.out.println("----------");

            System.out.println(predicateTest2.isEqual("test").test("test"));
            System.out.println("----------");
        }

        public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
            list.forEach(c -> {
                if (predicate.test(c)) {
                    System.out.println(c);
                }
            });
        }

        public void conditionAndFilter(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
            list.forEach(c -> {
                if (predicate.and(predicate2).test(c)) {
                    System.out.println(c);
                }
            });
        }

        public Predicate<String> isEqual(Object object) {
            return Predicate.isEqual(object);
        }
    }

}
