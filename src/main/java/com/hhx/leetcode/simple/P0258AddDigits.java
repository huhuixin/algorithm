package com.hhx.leetcode.simple;

/**
 * 各位相加
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * @author hhx
 */
public class P0258AddDigits {

    public static void main(String[] args) {
        System.out.println(
            new Solution1().addDigits(38)
        );
    }

    static class Solution {
        public int addDigits(int num) {
            if(num < 10){
                return num;
            }
            int n = 0;
            while(num > 0){
                n += num % 10;
                num /= 10;
            }
            return addDigits(n);
        }
    }

    static class Solution1 {
        public int addDigits(int num) {
            if(num == 0){
                return 0;
            }
            int m = num % 9;
            return m > 0 ? m : 9;
        }
    }

    static class Solution2 {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }
}
