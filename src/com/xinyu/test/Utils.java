package com.xinyu.test;

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

}
