package com.xinyu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestArray37 {

    public static void main(String[] args) {
        HashMap<String,Integer> test = new HashMap<>();
        String aaa = "aaa";
        test.put(aaa,1);
        //putIfAbsent 如果当前map 里面没有 那么才把值放到map 里面  返回map 里面key 对应的值  如果之前没有值 返回null
        test.putIfAbsent(aaa,3);
        System.out.println(test.get(aaa));
        String ddd = "ddd";
        System.out.println(test.putIfAbsent(ddd, 20));

        //getOrDefault 如果没有对应的key 则返回默认值
        String ccc = "ccc";
        Integer orDefault = test.getOrDefault(ccc, -1);
        System.out.println(orDefault);

        //如果对应的key 没有值  那么计算一个key对应的value
        Integer computeIfAbsent1 = test.computeIfAbsent(aaa, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 100;
            }
        });
        System.out.println(computeIfAbsent1);
        System.out.println(test.get(aaa));

        String eee = "eee";
        Integer computeIfAbsent = test.computeIfAbsent(eee, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                //计算key 对应的value
                return s.length();
            }
        });
        System.out.println(computeIfAbsent);

        System.out.println(test.get(eee));

        Integer computeIfPresent = test.computeIfPresent(aaa, new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return null;
            }
        });
        System.out.println(computeIfPresent);
        System.out.println(test.get(aaa));

        Integer computeIfPresent2 = test.computeIfPresent("fff", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return 100000;
            }
        });
        System.out.println(computeIfPresent2);
        System.out.println(test.get("fff"));
    }

    /**
     * 寻找重复的子树
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     *
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     *
     * 示例 1：
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   2   4
     *        /
     *       4
     * 下面是两个重复的子树：
     *
     *       2
     *      /
     *     4
     * 和
     *
     *     4
     * 因此，你需要以列表的形式返回上述重复子树的根结点。
     */
    HashMap<String,Integer> treeNodeMap = new HashMap<>();
    List<TreeNode> treeNodes = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        computerNode(root);
        return treeNodes;
    }

    public String computerNode(TreeNode node){
        if (node == null) {
            return "";
        }
        String key = node.val + "-" + computerNode(node.left) + " -" + computerNode(node.right);
        int value = treeNodeMap.getOrDefault(key, 0) + 1;
        treeNodeMap.put(key, value);
        if (value == 2) {
            treeNodes.add(node);
        }
        return key;

    }





    public <Type> Type get(Class aa){
        return (Type) aa;
    }
}
