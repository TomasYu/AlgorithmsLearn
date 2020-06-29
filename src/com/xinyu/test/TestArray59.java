package com.xinyu.test;

public class TestArray59 {
    /**
     * 俄罗斯套娃信封问题
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     *
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     *
     * 说明:
     * 不允许旋转信封。
     *
     * 示例:
     *
     * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出: 3
     * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     */

    public int maxEnvelopes(int[][] envelopes) {

        //我们只考虑 每一个我可以装的下的信封
        //形成一个dp数组
        //然后取dp数组的最大值
        //不同时考虑比自己大的 和  比 自己小的
        // 那样会有重复计算
        //从第一个开始 找比自己小的最大值
        //


        //首先遍历一遍数组 找到每一个信封 的最大最小值
        //存到数组里面

        //然后计算每一个dp
        //fmax = fmax(less) + 1
        //fmax 使用数组缓存




        return -1;
    }


    public static void main(String[] args) {

        //lis
        TestArray59 testArray59 = new TestArray59();
        System.out.println(testArray59.longestIncreceSubsquence(new int[]{1}));


    }

    /**
     * 递增最长子序列
     * list
     */
    public int longestIncreceSubsquence(int[] arr){
        int temp[] = new int[arr.length];
        int size = 0,left =0,mid,right;
        for (int i : arr) {
            //对于每一个数字 查找插入位置
            left = 0;
            right = size;
            while (left < right){
                //查找位置
                mid = (left + right) / 2;
                //如果找到了 没有什么问题
                //如果没有找到 那么对于左右两边的两个数来说
                //left + right /2 结果一定等于left 的值
                if (temp[mid] == i){
                    left = mid;
                    break;
                }else if (temp[mid] > i) {
                    //我们找的就是第一个比自己大的值  所有右边要包含当前值
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            if (left > size) {
                size ++;
            }
            if (left == size) {
                if (i > temp[left]) {
                    size++;
                    if (left + 1 < temp.length) {
                        left ++;
                    }
                }
            }
            //如果比所有的数都大
            temp[left] = i;
        }
        return size;
    }

}
