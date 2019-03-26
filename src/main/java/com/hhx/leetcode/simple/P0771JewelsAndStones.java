package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * @author huhuixin
 */
public class P0771JewelsAndStones {

    public static void main(String[] args) {
        Utils.countTime(() ->
                System.out.println(
                        new Solution().numJewelsInStones("aAdssd", "asdadadfasfasfsafdaAAbbbb")
                )
        );
        Utils.countTime(() ->
            System.out.println(
                    new Solution1().numJewelsInStones("aAdssd", "asdadadfasfasfsafdaAAbbbb")
            )
        );
        Utils.countTime(() ->
            System.out.println(
                    new Solution2().numJewelsInStones("aAdssd", "asdadadfasfasfsafdaAAbbbb")
            )
        );
    }

    static class Solution {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            // 分别拿每个石头跟每个宝石作对比...  优化方案, 转换为列表,拿出之后移除
            for (char j : J.toCharArray()) {
                for (char s : S.toCharArray()) {
                    if(j == s){
                        // 每次对比宝石是否相同,要消耗一定时间
                        //Utils.work(100);
                        count ++;
                    }
                }
            }
            return count;
        }
    }

    static class Solution1 {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            LinkedList<Character> ss = new LinkedList<>();
            // 分别拿每个石头跟每个宝石作对比...  优化方案, 转换为列表,拿出之后移除
            for (char s : S.toCharArray()) {
                ss.add(s);
            }
            for (char j : J.toCharArray()) {
                Iterator<Character> iterator = ss.iterator();
                while (iterator.hasNext()) {
                    // 如果这个是否是宝石A 那就不可能是宝石B, 直接移除
                    if(iterator.next() == j){
                        //Utils.work(100);
                        iterator.remove();
                        count ++;
                    }
                }
            }
            return count;
        }
    }

    static class Solution2 {
        public int numJewelsInStones(String J, String S) {
            int num = 0;
            char c[] = J.toCharArray();
            char d[] = S.toCharArray();
            for(int i = 0;i < d.length;i++) {
                for(int j = 0;j < c.length;j++) {
                    if(d[i] == c[j]) {
                        num++;
                    }
                }
            }
            return num;
        }
    }
}
