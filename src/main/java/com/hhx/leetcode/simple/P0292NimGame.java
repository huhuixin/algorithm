package com.hhx.leetcode.simple;

import java.util.Random;

/**
 * Nim游戏
 *
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 *
 * @author hhx
 */
public class P0292NimGame {

    public static void main(String[] args) {
        // System.out.println(new Solution().canWinNim(4))
        mock(10, 3, 5, "A", "B");
    }

    /**
     * 模拟
     * @param count 总数
     * @param min 最少拿多少
     * @param max 最多拿多少
     * @param first 先拿者
     * @param last 后拿者
     */
    private static void mock(int count, int min, int max, String first, String last){
        int remainder = count % (min + max);
        if(remainder == 0){
            // 随机拿几个
            int i = (int) (Math.random() * (max - min)) + min;
            System.out.println(first + " 拿走 " + i + " 个石头!");
            mock(count - i, min, max, last, first);
        }else{
            System.out.println(first + " 拿走 " + remainder + " 个石头!");
            if(count <= max && count >= min){
                System.out.println("没有石头了 " + first + " 获胜!");
            }else{
                mock(count - remainder, min, max, last, first);
            }
        }
    }


    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
}
