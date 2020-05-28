package com.xinyu.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestArray39 {
    public static void main(String[] args) {
        //int 数组转换成 Integer 数组
        int[] arr = new int[]{1,2,3,5,8};
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));

        //Integer 数组转成为int
        int[] array = Arrays.stream(arr2).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(array));

        //int 数组转list
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());

        //list 转integer[]  里面参数比原来数组长，则补充为空的，比原来的短，最终的长度也是原来的长度
//        Integer[] integers = collect.toArray(new Integer[2]);
        Integer[] integers = collect.toArray(new Integer[22]);
        System.out.println(Arrays.toString(integers));

        //list 转int[]
        int[] ints = collect.stream().mapToInt(Integer::valueOf).toArray();

        //integer 数组 转list<integer>
        List<Integer> integers1 = Arrays.asList(integers);

        // TODO: 2020/5/28  java 8 Stream
    }
}
