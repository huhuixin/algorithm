package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制字符串
 *
 * 将一个二进制字符串改变多少位之后可以编程另外一个二进制字符串
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意： 0 ≤ x, y < 231.
 * 示例:  输入: x = 1, y = 4
 * 输出: 2  解释: 1   (0 0 0 1) 4   (0 1 0 0)
 *
 * @author hhx
 */
public class P0461HammingDistance {

    public static void main(String[] args) {
        Utils.compareTime(100,
                () -> new Solution().hammingDistance(1, 4),
                () -> new Solution1().hammingDistance(1, 4)
        );
    }

    static class Solution {
        public int hammingDistance(int x, int y) {
            // 抑或运算之后, 相同位置值不同的都是1,计算1的个数即可
            return Integer.toBinaryString(x ^ y)
                    .replaceAll("0", "").length();
        }
    }

    static class Solution1 {
        public int hammingDistance(int x, int y) {
            int i = x ^ y;
            int c = 0;
            while(i > 0){
                // 最后一位是否为1
                if((i & 1) == 1){
                    c ++;
                }
                i = i >> 1;
            }
            return c;
        }
    }
}
