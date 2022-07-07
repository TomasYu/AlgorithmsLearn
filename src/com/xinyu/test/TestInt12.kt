package com.xinyu.test

import kotlin.math.ceil

class TestInt12 {
    /**
     * LCS 01. 下载插件
    小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:

    使用当前带宽下载插件
    将带宽加倍（下载插件数量随之加倍）
    请返回小扣完成下载 n 个插件最少需要多少分钟。

    注意：实际的下载的插件数量可以超过 n 个

    示例 1：

    输入：n = 2

    输出：2

    解释：
    以下两个方案，都能实现 2 分钟内下载 2 个插件

    方案一：第一分钟带宽加倍，带宽可每分钟下载 2 个插件；第二分钟下载 2 个插件
    方案二：第一分钟下载 1 个插件，第二分钟下载 1 个插件
    示例 2：

    输入：n = 4

    输出：3

    解释：
    最少需要 3 分钟可完成 4 个插件的下载，以下是其中一种方案:
    第一分钟带宽加倍，带宽可每分钟下载 2 个插件;
    第二分钟下载 2 个插件;
    第三分钟下载 2 个插件。

    提示：

    1 <= n <= 10^5

    https://leetcode.cn/problems/Ju9Xwi/


    https://leetcode.cn/problems/Ju9Xwi/solution/lcs-01-xia-zai-cha-jian-by-gcsxdu-vl8e/

    https://leetcode.cn/problems/Ju9Xwi/solution/javayi-xing-dai-ma-miao-sha-by-zgv4yyqq3-9e52/

    https://zhidao.baidu.com/question/193104595.html
    log(a)b=log(s)b/log(s)a （括号里的是底数）

    设log(s)b=M,log(s)a =N,log(a)b=R，则s^M=b,s^N=a,a^R=b，

    即(s^N)^R=a^R=b，s^(NR)=b，

    所以M=NR，即R=M/N，log(a)b=log(s)b/log(s)a。
     */

    /**
     * 判断一下几次翻倍能打到 然后向上取整  最后+1 代表 你最后一次下载
     * Math.log(n.toDouble()) / Math.log(2.0)  计算出来就是2的多少次方等于n
     * 因为默认log 的底是e  所以这里用到换底公式
     */
    fun leastMinutes(n: Int): Int {
        return Math.ceil(Math.log(n.toDouble()) / Math.log(2.0)).toInt() + 1
    }


    /**
     *     https://leetcode.cn/problems/Ju9Xwi/solution/lcs-01-xia-zai-cha-jian-by-gcsxdu-vl8e/

    令dp[n]表示下载n个插件需要的最少时间，那么若是选择在当前分钟下载一个，则需要的时间是dp[n-1]+1；若选择在当前分钟加倍带宽，则需要的时间是dp[Math.ceil(i.toDouble() / 2).toInt()] + 1

     */
    fun leastMinutes2(n: Int): Int {
        var dp = Array(n + 1) { 0 }
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[Math.ceil(i.toDouble() / 2).toInt()] + 1)
        }
        return dp[n]
    }
}