package com.xinyu.test;

public class TestString15 {

    /**
     * https://leetcode-cn.com/problems/word-search/
     *
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *
     *

     *
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    public static int arr[][] = new int[][]{{1,0},{-1,1},{-1,-1},{1,-1}};
    public static int arr[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};;
    public boolean exist(char[][] board, String word) {

        int length = word.length();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(board,i,j,visited,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board,int i, int j,boolean [][] visited,int k,String word){
        if (board[i][j] != word.charAt(k)){
            return false;
        }else {
            if (k == word.length()-1){
                return true;
            }
        }
        boolean result = false;
        visited[i][j] = true;
        for (int l = 0; l < arr.length; l++) {
            int newi = i + arr[l][0];
            int newJ = j + arr[l][1];
            if (newi < board.length && newi >=0 && newJ >=0 & newJ <board[0].length &&!visited[newi][newJ] ) {
                if (check(board, newi, newJ,visited,k+1,word)) {
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
