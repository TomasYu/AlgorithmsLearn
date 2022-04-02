package com.xinyu.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream2 {



    private static void test1() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().skip(1).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //打印信息
        //2
        //3
        //4
        //5
    }

    private static void test2() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().filter(integer -> integer > 2).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        //打印信息
        //3
        //4
        //5
    }

    private static void test3() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().anyMatch(integer -> integer > 2));
        //打印信息
        //true
    }

    private static void test4() {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5);
        int max = integers.stream().max(Comparator.comparingInt(x -> x)).get();
        int min = integers.stream().min(Comparator.comparingInt(x -> x)).get();
        System.out.println(max);
        System.out.println(min);
        //打印信息
        //9
        //1
    }


    private static void test5() {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5);
        int count = (int) integers.stream().count();
        System.out.println(count);
        //打印信息
        //6
    }

    private static void test6() {
        List<Integer> integers = Arrays.asList(9, 1, 2);
//        int total = integers.stream().reduce((integer, integer2) -> integer + integer2).get();
        int total = integers.stream().reduce(Integer::sum).get();
        System.out.println(total);
        //打印信息
        //12
    }


    private static void test7() {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5);
        integers.stream().map((i)-> i + "*").collect(Collectors.toList()).forEach(System.out::println);
        //打印信息
        //9*
        //1*
        //2*
        //3*
        //4*
        //5*

    }

    private static void test8() {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5);
        integers.stream().flatMap((Function<Integer, Stream<String>>) integer -> Stream.of(integer + "#"))
                .collect(Collectors.toList()).forEach(System.out::println);
        //打印信息
        //9#
        //1#
        //2#
        //3#
        //4#
        //5#
    }

    private static void test9() {
        List<Integer> integers = Arrays.asList(9, 1, 2, 3, 4, 5);
        integers.stream().sorted(Comparator.comparingInt(x -> x)).forEach(System.out::println);
        //打印信息
        //1
        //2
        //3
        //4
        //5
        //9

    }

    private static void test10() {
        List<Integer> integers = Arrays.asList(1, 1, 2, 2, 3, 5);
        integers.stream().distinct().sorted(Comparator.comparingInt(x -> x)).
                forEach(System.out::println);
        //打印信息
        //1
        //2
        //3
        //5
    }

    private static void test11() {
        List<Integer> integers = Arrays.asList(1, 1, 2, 2, 3, 5);
        System.out.println(integers.stream().map(x -> x + "").collect(Collectors.joining("|")));
        //打印信息
        //1|1|2|2|3|5
    }

    private static void test12() {
        List<Integer> integers = Arrays.asList(1, 5);
        System.out.println(integers.stream().collect(Collectors.averagingInt(x -> x)));
        //打印信息
        //3.0
    }


    public static void main(String[] args) {


        test12();

    }
}
