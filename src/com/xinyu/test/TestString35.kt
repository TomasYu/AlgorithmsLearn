package com.xinyu.test

import java.util.LinkedList

class TestString35 {
    //https://leetcode.cn/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
    /**
    649. Dota2 参议院
    中等
    332
    相关企业
    Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）

    Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：

    禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
    宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
    给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。

    以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。

    假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。



    示例 1：

    输入：senate = "RD"
    输出："Radiant"
    解释：
    第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
    这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
    第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
    示例 2：

    输入：senate = "RDD"
    输出："Dire"
    解释：
    第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
    这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
    这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
    因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利


    提示：

    n == senate.length
    1 <= n <= 104
    senate[i] 为 'R' 或 'D'


     这个有点难啊
     这思路是啥啊这
     很简单啊
     就是互相看权利最后在谁手里
     不停的+1 -1就行

     就是两个集合
     左边和右边
     最后看左边和右边长度的大小就可以了

     想少了
     这个还是有顺序的
     跟数量没有关系
     12121
     还是有关系啊
     12122 这个是1胜？

      当一轮结束的时候，判断游戏是否结束，不结束就继续
    怎么判断游戏是否结束？当前的数据结构里面是不是只有一种元素
      每一轮怎么开始 怎么结束？
      禁用怎么搞？
     list 一边遍历 一边删除？？？

     官方思路太优雅了
     这是怎么想的？？
     算法其实重要的不是你能不能写出来
     只要给你思路一定能写出来
     重要的是能不能想出来思路
     就像产品需求一样

     工作没动力啊
     什么玩意啊
     卧槽
     老是有这种什么都不懂就要搞着搞那的
     真的无处吐槽
     换领导确实很痛苦



    LinkedList
     push pop 都是对第一个操作

     offer 对最后一个操作
     */
    fun predictPartyVictory(senate: String): String {
        //Radiant  Dire
        val listR = LinkedList<Int>()
        val listD = LinkedList<Int>()
        for (i in senate.indices){
            if (senate[i] == 'R'){
                listR.offer(i)
            }else{
                listD.offer(i)
            }
        }

        while (listR.isNotEmpty() && listD.isNotEmpty()){
            val r = listR.pop()
            val d = listD.pop()
            if (r < d){
                listR.offer(r + senate.length)
            }else{
                listD.offer(d + senate.length)
            }
        }

        return if (listR.isEmpty()) "Dire" else "Radiant"
    }
}