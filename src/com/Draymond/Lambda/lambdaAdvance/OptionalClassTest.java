package com.Draymond.Lambda.lambdaAdvance;

import  java.util.*;

public class OptionalClassTest {

    static class OptionalTest {
        public static void main(String[] args) {
//            Optional<String> optional = Optional.of(null);
            Optional<String> optional = Optional.empty();

//            if (optional.isPresent()) {
//                System.out.println(optional.get());
//            }
            optional.ifPresent(item -> System.out.println(item)); // 推荐使用
            System.out.println("--------------");

            System.out.println(optional.orElse("world"));
            System.out.println("--------------");

            System.out.println(optional.orElseGet(() -> "nihao"));

        }
    }

    static class OptionalTest2 {
        public static void main(String[] args) {
            Employee e = new Employee("zhangsan");
            Employee e2 = new Employee("lisi");

            Company c = new Company("company1", null);

            List<Employee> employees = Arrays.asList(e, e2);
            c.setEmployees(employees);

            List<Employee> list = c.getEmployees();

            // 赋值
            Optional<Company> optional = Optional.ofNullable(c);
            System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));
        }

        static class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        static class Company {
            private String name;
            private List<Employee> employees;

            public Company(String name, List<Employee> employees) {
                this.name = name;
                this.employees = employees;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Employee> getEmployees() {
                return employees;
            }

            public void setEmployees(List<Employee> employees) {
                this.employees = employees;
            }
        }
    }


}
