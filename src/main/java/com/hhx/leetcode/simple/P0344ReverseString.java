package com.hhx.leetcode.simple;

/**
 * 翻转字符串
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author hhx
 */
public class P0344ReverseString {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
        System.out.println(new Solution().reverseString("hello1"));
    }

    static class Solution {
        public String reverseString(String s) {
            char[] chars = s.toCharArray();
            int half = chars.length/2;
            for (int i = 0, j = chars.length - 1; i < half; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
    }
}
