package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

/**
 * 实现String 的ToLowerCase方法
 * @author hhx
 */
public class P0709ToLowerCase {

    public static void main(String[] args) {
        Utils.countTime(() ->
            System.out.println(
                new Solution().toLowerCase("HesLLds")
            )
        );
    }

    static class Solution {
        public String toLowerCase(String str) {
            int step = 'a' - 'A';
            StringBuilder sb = new StringBuilder(str.length());
            for (char c : str.toCharArray()) {
                if(c >= 'A' && c <= 'Z'){
                    sb.append((char)(c + step));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
