package com.hhx.leetcode.simple;

/**
 * Excel表列序号
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * @author hhx
 */
public class P0171ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(
            new Solution().titleToNumber("AAA")
        );
    }

    static class Solution {
        public int titleToNumber(String s) {
            char[] chars = s.toCharArray();
            double n = 0;
            // 定义 `0`
            int zero = 'A' - 1;
            for (int i = 0; i < chars.length; i++) {
                n = n + (chars[i] - zero) * Math.pow(26, chars.length - i - 1);
            }
            return (int)n;
        }
    }
}
