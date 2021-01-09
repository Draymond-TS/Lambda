package com.Draymond.Lambda.lambdaAdvance;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BiFunctionAdvanceTest {

    static class Person {
        private String username;
        private Integer age;

        public Person(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class PersonTest {
        public static void main(String[] args) {
            PersonTest test = new PersonTest();

            Person p1 = new Person("zhangsan", 20);
            Person p2 = new Person("lisi", 22);
            Person p3 = new Person("wangwu", 25);

            List<Person> peoples = Arrays.asList(p1, p2, p3);

            List<Person> personResult1 = test.getPersonsByUsername("zhangsan", peoples);
            //personResult1.forEach(person -> System.out.println(person.getUsername()));

            List<Person> personResult2 = test.getPersonsByAge(20, peoples);
            //personResult2.forEach(person -> System.out.println(person.getAge()));

            List<Person> personResult3 = test.getPersonsByAge1(20, peoples);
            //personResult3.forEach(person -> System.out.println(person.getAge()));

            List<Person> personResult4 = test.getPersonsByAge2(20, peoples, (age, personList) -> {
                return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
            });
            personResult4.forEach(person -> System.out.println(person.getAge()));

        }

        public List<Person> getPersonsByUsername(String username, List<Person> persons) {
            return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
        }

        public List<Person> getPersonsByAge(int age, List<Person> persons) {
            return persons.stream().filter(person -> person.getAge() == age).collect(Collectors.toList());
        }

        public List<Person> getPersonsByAge1(int age, List<Person> persons) {
            BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
                return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
            };
            return biFunction.apply(age, persons);
        }

        public List<Person> getPersonsByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
            return biFunction.apply(age, persons);
        }
    }

}
