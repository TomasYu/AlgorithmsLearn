package com.xinyu.test;

/**
 * Created by zy on 2019/10/29.
 */
public class Imei {

    public static void main(String[] args) {
        System.out.println(decryptP7("__768c9ea6a6c9d5d1"));
    }

    /**
     * 给业务方解密用，测试用。
     * @return
     */
    public static String decryptP7(String src){
        if (src == null) return "";
        if(src.startsWith("__")){
            src = src.substring(src.indexOf("__")+"__".length());
        }

        int len = src.length();
        StringBuilder sb = new StringBuilder(len);
        char c;
        int num = 0;
        for (int i = 0; i < len; i++) {
            c = src.charAt(i);
            if (c >= '0' && c <= '9') {
                num = c - 48;
                num = getDivide3Num(num);
                num = replaceNum(num);
                c = (char)(num + 48);
            }
            sb.append(String.valueOf(c));
        }

        return sb.toString();
    }

    /**
     * 获取(补10、20)除以3后的值。
     * 结果是唯一的，直接对应结果了。
     */
    private static int getDivide3Num(int num){
        switch (num){
            case 0:
                return 0;
            case 1:
                return 7;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 8;
            case 5:
                return 5;
            case 6:
                return 2;
            case 7:
                return 9;
            case 8:
                return 6;
            case 9:
                return 3;
        }
        return 0;
    }

    /**
     * 调换数字
     * @return
     */
    private static int replaceNum(int num){
        switch (num){
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 8;
            case 3:
                return 7;
            case 4:
                return 6;
            case 5:
                return 5;
            case 6:
                return 4;
            case 7:
                return 3;
            case 8:
                return 2;
            case 9:
                return 1;
        }
        return 0;
    }
}
