package com.xinyu.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zy on 2019/5/29.
 */
public class PatternTest {

    public static void main(String[] args) {
//        final String filterPattern = "ResourceType|memtrack|android.os.Debug|BufferItemConsumer|DPM.*|MDM.*|ChimeraUtils|BatteryExternalStats.*|chatty.*|DisplayPowerController|WidgetHelper|WearableService|DigitalWidget.*|^ANDR-PERF-.*";
//
//        Pattern pattern = Pattern.compile( // log level
//                "(\\w)" +
//                        "/" +
//                        // tag
//                        "([^(]+)" +
//                        "\\(\\s*" +
//                        // pid
//                        "(\\d+)" +
//                        // optional weird number that only occurs on ZTE blade
//                        "\\*\\s*\\d+" +
//                        "\\): ");
////
////
//        String text = "05-29 22:09:49.248 D/yuan    (27862): onVisibilityChanged----com.zhangyue.iReader.bookshelf.ui.ViewGridBookShelf{3f8ec1a VFED..CL. ......ID 0,0-1080,2571}";
//        Matcher matcher = pattern.matcher(text);
//        if (matcher.find()) {
//            char logLevelChar = matcher.group(1).charAt(0);
//
//            String logText = text.substring(matcher.end());
//            if (logText.matches("^maxLineHeight.*|Failed to read.*")) {
//
//            } else {
//
//            }
//
//            String tagText = matcher.group(2);
//            if (tagText.matches(filterPattern)) {
//
//            }
//
//            int processId = Integer.parseInt(matcher.group(3));
//        }


        /**
         * java 中 在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。
         * 表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。
         * 一个反斜杠是\\\\ 是因为前面两个\\是 表示我要插入一个正则表达式，后面的\\ 第一个斜杠是转义，第二个\ 是真正的\.
         * 其实你写字符串的时候，第非正则表达式，表示一个斜杠的写法也是\\
         *
         */

        //true  因为正则中，\ 用\\ 表示，所以，java 字符串里面的"\\",在正则里面就是\\\\
//        Pattern pattern = Pattern.compile("\\\\");
//        System.out.println(pattern.matcher("\\").find());

        //编译报错  因为这是一个斜杠  斜杠把" 给转义了，没有完整的字符串
//        Pattern pattern = Pattern.compile("\\");
//        System.out.println(pattern.matcher("\\").find());


        //false
//        Pattern pattern = Pattern.compile("\\w");
//        System.out.println(pattern.matcher("\\").find());



        //true  两个斜杠的正则
//        Pattern pattern2 = Pattern.compile("\\\\\\\\");
//        System.out.println(pattern2.matcher("\\\\").find());


//        false 正则表达式\\\\n  对应的字符串是\\n, 也就是\n 字符串，不是换行符,
//        Pattern pattern2 = Pattern.compile("\\\\n");
//        System.out.println(pattern2.matcher("\n").find());

        //        true 正则表达式\\\\n  对应的字符串是\\n, 也就是\n字符串
//        Pattern pattern3 = Pattern.compile("\\\\n");
//        System.out.println(pattern3.matcher("\\n").find());

////        true 直接写的字符串 匹配  没有使用正则，因为正则是\\
//        Pattern pattern2 = Pattern.compile("\n");
//        System.out.println(pattern2.matcher("\n").find());

        // true  因为\\n 是正则表达式定义的换行
//        Pattern pattern2 = Pattern.compile("\\n");
//        System.out.println(pattern2.matcher("\n").find());

    //正则表达式  true  不太明白这个三个斜杠  其实是
//         Pattern pattern2 = Pattern.compile("\\\n");
//         System.out.println(pattern2.matcher("\n").find());


        //正则表达式  false  正则是匹配一个换行符，字符是一个\，一个n
//        Pattern pattern2 = Pattern.compile("\\\n");
//        System.out.println(pattern2.matcher("\\n").find());

        //正则表达式  false  正则是一个斜杠一个n  字符串是换行符
//        Pattern pattern2 = Pattern.compile("\\\\n");
//        System.out.println(pattern2.matcher("\n").find());

        //正则表达式  true
//        Pattern pattern2 = Pattern.compile("123\\w");
//        System.out.println(pattern2.matcher("123a").find());

        // fasle 原来正则和字符串匹配可以混着用
//        Pattern pattern2 = Pattern.compile("123\\wabc");
//        System.out.println(pattern2.matcher("123abc").find());

        // true
//        Pattern pattern2 = Pattern.compile("\\a");
//        System.out.println(pattern2.matcher("\u0007").find());

        //false
//        Pattern pattern2 = Pattern.compile("\\.a");
//        System.out.println(pattern2.matcher("aa").find());

        //true 因为正则表达式. 就是任意字符
//        Pattern pattern2 = Pattern.compile(".a");
//        System.out.println(pattern2.matcher("aa").find());

        //false  因为多个一个大括号
//        Pattern pattern2 = Pattern.compile("\\p{Lower}{4,}}");
//        Matcher aaaa = pattern2.matcher("aaaa");
//        System.out.println(aaaa.find());

//        //true
//        Pattern p = Pattern.compile("\\p{Lower}{4,}");
//        Matcher m = p.matcher("aaaaaf");
//        System.out.println(m.find());

        // (?<name>X)	X, as a named-capturing group
//        Pattern p = Pattern.compile("(?<aa>\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group("aa"));
//        }else {
//            System.out.println("not find");
//        }

        // (?:X)	X, as a non-capturing group  可以找到 ，并且打印组的时候有值
//        Pattern p = Pattern.compile("(?:\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group());
//        }else {
//            System.out.println("not find");
//        }

        // (?=X)	X, via zero-width positive lookahead  找得到 但是m.group 是空的
//        Pattern p = Pattern.compile("(?=\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group());
//        }else {
//            System.out.println("not find");
//        }

//        (?<=X)	X, via zero-width positive lookbehind  找得到 但是m.group 是空的
//        Pattern p = Pattern.compile("(?<=\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group());
//        }else {
//            System.out.println("not find");
//        }


//        (?<!X)	X, via zero-width negative lookbehind  找得到 但是m.group 是空的
//        Pattern p = Pattern.compile("(?<!\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group());
//        }else {
//            System.out.println("not find");
//        }

//        (?>X)	X, as an independent, non-capturing group  有值
//        Pattern p = Pattern.compile("(?>\\w{3})");
//        Matcher m = p.matcher("aaaaaf");
//        if (m.find()) {
//            System.out.println(m.group());
//        }else {
//            System.out.println("not find");
//        }


        // (?:X)	X, as a non-capturing group   确实只是匹配没有记录值  groupCount 是 0
//        Pattern p = Pattern.compile("(?:\\w{3})(?:\\w{3})(?:\\w{3})");
//        Matcher m = p.matcher("aaabbbccc");
//        if (m.find()) {
//            System.out.println(m.group());
//            System.out.println(m.groupCount());
//        }else {
//            System.out.println("not find");
//        }

        Pattern p = Pattern.compile("(\\w{3}){3}");
        Matcher m = p.matcher("aaabbbccc");
        if (m.find()) {
            System.out.println(m.group());
            System.out.println(m.groupCount());
        }else {
            System.out.println("not find");
        }



    }


    /**
     * 1.^ 和 [^] 是完全不一样的意思，^表示开始，[^] 表示不包含字符
     * 2.\\w 表示一个字符串，后面有* 有+ 才表示多个
     * 3.\\*  和 \\\\* 表达的不一样 \\* 表示的并非正则 因为如果是正则，那么* 表示0个或多个前面的字符，但是*前面不是任何的字符
     * 所以，不认为是一个正则，而是简单的* 号匹配 \\\\* 表示 0个 或多个\
     *4.\\* 表示* ，\\表示转义，正则表达式的特殊字符需要转义
     * 5.ide 都有标识，是字符串，还是正则
     * 6.正则表达式\ 用\\表示，所以\w 就是\\w. 所以在String 里面，\\ 表示反斜杠，正则里面的话，就是\\\\
     */




}
