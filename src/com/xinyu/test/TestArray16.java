package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray16 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }


    /**
     *
     * 括号生成
     给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

     例如，给出 n = 3，生成结果为：

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     *
     *
      "((()))",
     "(()())",
     "(())()",
     "()()()"
     "()(())",

     *
     *
     */
//    public static List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        StringBuilder stringBuffer  = new StringBuilder("");
//        for (int i = 0; i < n *2; i++) {
//            if (i == 0) {
//                stringBuffer.append("(");
//            }else {
//                stringBuffer.append(")");
//            }
//
//        }
//        if (n == 1) {
//            result.add(stringBuffer.toString());
//            return result;
//        }
//        int count = n-1;
//        for (int i = 1; i < n; i++) {
//            for (int j =i+1; j <2*n-1 ; j++){
//                StringBuilder stringBuffer1 = new StringBuilder(stringBuffer);
//                stringBuffer1.setCharAt(i,'(');
//                stringBuffer1.setCharAt(j,'(');
//                result.add(stringBuffer1.toString());
//            }
//
//        }
//        return result;
//    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,n,"",result);
        return result;
    }

    private static void generate(int left,int right,String str, List<String> result) {
        if (left == right && left == 0) {
            result.add(str);
        }
        if (right > left) {
            generate(left,right-1,str +")",result);
        }
        if (left > 0) {
            generate(left-1,right,str + "(",result);
        }
    }


}
