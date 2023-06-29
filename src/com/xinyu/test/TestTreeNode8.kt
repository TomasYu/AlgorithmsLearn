package com.xinyu.test

class TestTreeNode8 {
    //https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
    /**
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
     *
     *
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

     

    示例 1：


    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出：3
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    示例 2：


    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出：5
    解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    示例 3：

    输入：root = [1,2], p = 1, q = 2
    输出：1
     

    提示：

    树中节点数目在范围 [2, 105] 内。
    -109 <= Node.val <= 109
    所有 Node.val 互不相同 。
    p != q
    p 和 q 均存在于给定的二叉树中。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    var pP : TreeNode? = null
    var qP : TreeNode? = null
    var pLevel = 0
    var qLevel = 0
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        //层级不一样 那么层级低的
        //层级一样 那么任意一个的parent

        //key(value) level
        //key parent 其实也不用map 两个变量就可
        //后续遍历？？？
        // 不对 还要判断是不是在一边
        //思路有问题

        //我怎么知道在不在一边啊
        //map???



        //没想法了。。。。。
        //不一个树叉这个怎么判断呢》？
        //dfs 啊 这是从下网上的遍历啊

        val map = mutableMapOf<TreeNode, TreeNode>()
        dfs(root,map)
        val set = mutableSetOf<TreeNode>()
        var temp = p
        while (temp != null){
            set.add(temp)
            temp = map[temp]
        }
        temp = q
        while (!set.contains(temp)){
            temp = map[temp]
        }
        return temp

    }

    fun dfs(root: TreeNode?, map: MutableMap<TreeNode, TreeNode>){
        if (root == null){
            return
        }
        if (root.left != null) {
            map[root.left] = root
            dfs(root.left,map)
        }
        if (root.right != null) {
            map[root.right] = root
            dfs(root.right,map)
        }

    }

}