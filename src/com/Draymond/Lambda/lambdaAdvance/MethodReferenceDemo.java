package com.Draymond.Lambda.lambdaAdvance;


import java.util.*;
import java.util.function.*;

public class MethodReferenceDemo {

    /**
     * 方法引用实际上是个Lambda表达式的一种语法糖
     * 我们可以将方法看作是一个【函数指针】，function pointer
     * 方法引用共分为4类：
     * 1、类名::静态方法名
     * 2、引用名（对象名）::实例方法名
     * 3、类名::实例方法名
     * 4、构造方法引用：类名::new
     */
    static class MethodReferenceTest {

        public String getString(Supplier<String> supplier) {
            return supplier.get() + "test";
        }

        public String getString2(String str, Function<String, String> function) {
            return function.apply(str);
        }

        public static void main(String[] args) {
            Student student = new Student("zhangsan", 10);
            Student student1 = new Student("lisi", 90);
            Student student2 = new Student("wangwu", 50);
            Student student3 = new Student("zhaoliu", 40);

            List<Student> students = Arrays.asList(student, student1, student2, student3);

            students.sort((studentParam1, studentParam2) -> studentParam1.compareByScore(studentParam2));
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            // 1、类名::静态方法名
            students.sort(Student::compareStudentByName);
            students.forEach(stu -> System.out.println(stu.getName()));

            System.out.println("------------------------");

            // 2、引用名（对象名）::实例方法名
            StudentComparator sc = new StudentComparator();
            students.sort(sc::compareStudentByName);
            students.forEach(stu -> System.out.println(stu.getName()));
            System.out.println("------------------------");
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            // 3、类名::实例方法名
            List<String> cities = Arrays.asList("anhui", "chongqing", "qingdao", "beijing");
            Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
            cities.forEach(c -> System.out.println(c));
            System.out.println("------------------------");

            students.sort(Student::compareByName);
            students.forEach(stu -> System.out.println(stu.getName()));
            System.out.println("------------------------");

            students.sort(Student::compareByScore);
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            Collections.sort(cities, String::compareToIgnoreCase);
            cities.forEach(System.out::println);
            System.out.println("------------------------");

            MethodReferenceTest mrt = new MethodReferenceTest();
            System.out.println(mrt.getString(() -> "hello"));
            System.out.println(mrt.getString2("hello", String::new));
            System.out.println("------------------------");

            // 4、构造方法引用：类名::new
        }

        static class Student {
            private String name;
            private Integer score;

            public Student(String name, Integer score) {
                this.name = name;
                this.score = score;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getScore() {
                return score;
            }

            public void setScore(Integer score) {
                this.score = score;
            }

            public static int compareStudentByScore(Student s1, Student s2) {
                return s1.getScore() - s2.getScore();
            }

            public static int compareStudentByName(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }

            public int compareByScore(Student s) {
                return this.getScore() - s.getScore();
            }

            public int compareByName(Student s) {
                return this.getName().compareToIgnoreCase(s.getName());
            }

        }

        static class StudentComparator {
            public static int compareStudentByScore(Student s1, Student s2) {
                return s1.getScore() - s2.getScore();
            }

            public int compareStudentByName(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        }

    }

}
