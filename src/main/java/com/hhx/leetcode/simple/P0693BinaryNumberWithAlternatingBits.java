package com.hhx.leetcode.simple;

/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 *
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 *
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 *
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * @author hhx
 */
public class P0693BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(
            new Solution().hasAlternatingBits(10)
        );
    }

    static class Solution {
        public boolean hasAlternatingBits(int n) {
            // 如果是交替位数, 此处的结果为 n个1组成的2进制数
            // 再加1之后就变成了1个1和n个0
            // 再与之前的n个1做&运算,得出的结果必定为0
            int temp= n ^ (n>>1);
            return (temp&(temp+1))==0;
        }
    }
}
