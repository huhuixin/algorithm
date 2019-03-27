package com.hhx.leetcode.simple;

import com.hhx.util.RunUtils;

import java.util.ArrayList;

import static com.hhx.util.RandomUtil.*;

/**
 * 字符的最短距离
 *
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 * @author hhx
 */
public class P0821ShortestDistanceToCharacter {

    public static void main(String[] args) {
        RunUtils.compareTime(1000,
                () -> new Solution().shortestToChar(randomLetterString(randomInt(1, 10000)), randomLetter()),
                () -> new Solution1().shortestToChar(randomLetterString(randomInt(1, 10000)), randomLetter())
                );
    }

    static class Solution {
        public int[] shortestToChar(String S, char C) {
            ArrayList<Integer> list = new ArrayList<>(S.length()/26);
            char[] chars = S.toCharArray();
            int[] res = new int[chars.length];
            // 记录 目标 位置的下标,得到一个有序数组
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == C){
                    list.add(i);
                }
            }
            if(list.size() == 0){
                return res;
            }
            // 最小坐标的左边
            int step = 0;
            for (int j = list.get(0); j >= 0; j--) {
                res[j] = step ++;
            }
            // 最大坐标的右边
            step = 0;
            for (int j = list.get(list.size()-1); j < chars.length; j++) {
                res[j] = step ++;
            }
            // 从区间两头向中间递增
            for (int i = 0; i < list.size() - 1; i++) {
                step = 1;
                int minIndex = list.get(i) + 1;
                int maxIndex = list.get(i + 1) - 1;
                while(minIndex <= maxIndex){
                    res[minIndex++] = res[maxIndex--] = step++;
                }
            }
            return res;
        }
    }

    static class Solution1 {
        public int[] shortestToChar(String S, char C) {
            char[] chars = S.toCharArray();
            int[] result = new int[chars.length];
            int preIndex = -1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == C) {
                    preIndex = i;
                    result[i] = 0;
                } else {
                    if (preIndex == -1) {
                        result[i] = S.indexOf(C) - i;
                    } else {
                        result[i] = S.indexOf(C, i) == -1 ? i - preIndex : Math.min(i - preIndex, S.indexOf(C, i) - i);
                    }
                }
            }
            return result;
        }
    }
}
