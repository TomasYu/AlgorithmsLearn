package com.xinyu.test;

import java.lang.reflect.Array;
import java.util.*;

public class TestString10 {

    public static void main(String[] args) {

        System.out.println(topKFrequent2(new String[]{
                "i", "love", "leetcode", "i", "love", "coding"}, 2));

        System.out.println(topKFrequent2(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> count = new HashMap<>();
        for (String word : words) {
            Integer integer = count.get(word);
            if (integer != null) {
                integer++;
                count.put(word,integer);
//                count.put(word,integer++);
            }else {
                count.put(word,1);
            }
        }

        TreeSet<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }else {
                    Integer integer1 = count.getOrDefault(01,1);
                    Integer integer2 = count.getOrDefault(02,1);
                    if (integer1 >= integer2) {
                        return 1;
                    }else {
                        return -1;
                    }
                }

            }
        });
        Iterator<String> iterator1 = count.keySet().iterator();
        while (iterator1.hasNext()) {
            result.add(iterator1.next());
        }

        List<String> res = new ArrayList<>();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
             if (res.size() == k){
                 break;
             }

        }
        return res;
    }


    public static List<String> topKFrequent2(String[] words, int k) {
        HashMap<String,Integer> count = new HashMap<>();
        for (String word : words) {
            Integer orDefault = count.getOrDefault(word, 0);
            count.put(word,++orDefault);
        }

        List<String> res = new ArrayList<>();

        Iterator<Map.Entry<String, Integer>> iterator = count.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            res.add(next.getKey());
        }


        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o1) == (count.get(o2)) ? o1.compareTo(o2) : count.get(o1) - count.get(o2);
            }
        });


        return res.subList(0,k);
    }
}
