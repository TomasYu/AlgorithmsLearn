package com.xinyu.test;

/**
 * Created by zy on 2020/3/27.
 */
public class TestArray22 {
    public static void main(String[] args) {
        int i = guessNumber(2126753390);
        System.out.println(i);
    }


    /**
     *
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     每次你猜错了，我会告诉你这个数字是大了还是小了。
     你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

     -1 : 我的数字比较小
     1 : 我的数字比较大
     0 : 恭喜！你猜对了！
     示例 :

     输入: n = 10, pick = 6
     输出: 6
     *
     *
     */


    public static int guessNumber(int n) {
        int left = 1,right = n ,mid;
        while (left <= right){
            //如果left + right 超过int 的范围，这种写法不能正确的把数字转成long 数字其实已经是错误的 再long 也是错误的 只有把一个数字转成long 加另一个才行
//            long add = (long)(left + right);
            long add = (long)left + right;
            mid = (int) (add / 2);
            if (guess(mid) == 0) {
                return mid;
            }else if (guess(mid) > 0){
                left = mid + 1;
            }else {
                right = mid -1;
            }

        }
        return -1;


    }

    private static int guess(int mid) {
        int data = 1702766719;
        if (mid == data) {
            return 0;
        }else if (mid < data){
            return 1;
        }
        return -1;
    }
}
