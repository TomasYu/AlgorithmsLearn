package com.xinyu.test;

import java.util.List;

/**
 * Created by zy on 2019/1/24.
 */
public class Utils {

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array){
        StringBuilder stringBuffer = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            stringBuffer.append(array[i]);
            if (i != array.length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        System.out.println("数组："+stringBuffer.toString());
    }

    /**
     * 打印数组
     * @param list
     */
    public static void printList(List list){
        StringBuilder stringBuffer = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            if (o instanceof List) {
                printList((List) o);
            }else {
                stringBuffer.append(o);
                if (i != list.size() - 1) {
                    stringBuffer.append(",");
                }
            }

        }
        stringBuffer.append("]");
        System.out.println("数组："+stringBuffer.toString());
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void MaoPao(int nums[]) {
        if (nums ==null) {
            return;
        }
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }


}
