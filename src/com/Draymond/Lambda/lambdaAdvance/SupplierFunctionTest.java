package com.Draymond.Lambda.lambdaAdvance;

import javafx.beans.DefaultProperty;

import java.util.function.Supplier;

public class SupplierFunctionTest {
    static class Student2 {
        private String name = "zhangsan";
        private Integer age;

        public Student2() {
        }

        public Student2(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class StudentTest {
        public static void main(String[] args) {
            Supplier<Student2> supplier = () -> new Student2();
            System.out.println(supplier.get().getName());
            System.out.println("--------------");

            // 简化
            Supplier<Student2> supplier1 = Student2::new;
            System.out.println(supplier1.get().getName());
        }
    }

}
