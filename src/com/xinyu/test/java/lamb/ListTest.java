package com.xinyu.test.java.lamb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zy on 2019/10/25.
 */
public class ListTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(31,"小黑"));
        list.add(new Person(23,"小白"));
        list.add(new Person(24,"小蓝"));
        list.add(new Person(21,"小红"));

        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
//                return person1.getAge() > person2.getAge() ? 0 : 1;
                return person1.getAge() > person2.getAge() ? 1 : -1;
            }
        });

//        list.sort((p1,p2) -> p1.getAge() > p2.getAge() ? 1:0);
        list.sort((p1,p2) -> p1.getAge() > p2.getAge() ? 1 : -1);

//        list.forEach(person -> System.out.println(person.getAge()));
        list.stream().filter(person -> person.getAge()> 23).forEach(person -> System.out.println(person.getName()));

    }


}
class Person {
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}