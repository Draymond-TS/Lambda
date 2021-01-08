package com.Draymond.Lambda.lambdaAdvance;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class SortTest {

    class Student {
        private String name;
        private String score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }

    /**
     * 普通排序
     */
    @Test
    public void test2_1() {
        List<String> names = Arrays.asList("zhangsan", "wangwu", "lisi", "zhaoliu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Student> students = new ArrayList<Student>();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
    }

    /**
     * java8 lambda排序
     */
    @Test
    public void test2_2() {
        List<String> names = Arrays.asList("zhangsan", "wangwu", "lisi", "zhaoliu");
        List<Student> students = new ArrayList<>();
        Collections.sort(names, (a, b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names, (a, b) -> b.compareTo(a));
        Collections.sort(students, (a, b) -> b.getScore().compareTo(a.getScore()));
        List<String> list = names.stream().sorted((s1,s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        System.out.println(names);
        System.out.println(students);
        System.out.println(list);
    }
}
