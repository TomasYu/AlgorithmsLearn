package com.xinyu.test;

public class TestInt {

    public static void main(String[] args) {
//        System.out.println(convertToTitle(701));
//        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(2147483647));
//        System.out.println(convertToTitle(701));
    }


    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     *
     * 例如：
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     *  
     *
     * 示例 1：
     *
     * 输入：columnNumber = 1
     * 输出："A"
     * 示例 2：
     *
     * 输入：columnNumber = 28
     * 输出："AB"
     * 示例 3：
     *
     * 输入：columnNumber = 701
     * 输出："ZY"
     * 示例 4：
     *
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static String convertToTitle(int columnNumber) {
        if (columnNumber == 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        int curIndex = 2;
        while (columnNumber > 0){
            if (columnNumber % 26 != 0){
                result.append(getChar(columnNumber % 26));
                columnNumber -= columnNumber %26;
            }else {
                if (columnNumber / 26 <= 26) {
                    result.append(getChar(columnNumber / 26));
                    columnNumber = (int) (columnNumber - columnNumber/26 * Math.pow(26,curIndex));
                    curIndex ++;
                }else {
                    result.append(getChar(26));
                    columnNumber = (int) (columnNumber - 26 * Math.pow(26,curIndex));
                    curIndex ++;
                }
            }

        }
        return result.reverse().toString();
    }


    public static String convertToTitle2(int columnNumber) {
        if (columnNumber == 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        while (columnNumber != 0){
            columnNumber--;
            result.append(getChar(columnNumber % 26));
            columnNumber = columnNumber / 26;

        }
        return result.reverse().toString();
    }

    private static char getChar(int i) {
        return (char) (i + 'A');
    }


}
