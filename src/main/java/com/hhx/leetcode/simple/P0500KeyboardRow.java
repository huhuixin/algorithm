package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

import java.util.*;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 *          Q W E R T Y U I O P
 *
 *           A S D F G H J K L
 *
 *            Z X C V B N M
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * @author hhx
 */
public class P0500KeyboardRow {

    public static void main(String[] args) {
        // 效率更高一点
        Utils.averageTime(100, () -> {
            new Solution().
                    findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        });
        Utils.averageTime(100, () -> {
            new Solution1().
                    findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        });
    }

    static class Solution {
        public String[] findWords(String[] words) {
            int j = 0;
            for (int i = 0; i < words.length; i++) {
                if (isRowWord(words[i])) {
                    // 把在同行的词交换到前面
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                    j++;
                }
            }
            return Arrays.copyOfRange(words, 0, j);
        }
        static HashMap<Character, Integer> map = new HashMap<>(52);

        static {
            map.put('q', 1);
            map.put('w', 1);
            map.put('e', 1);
            map.put('r', 1);
            map.put('t', 1);
            map.put('y', 1);
            map.put('u', 1);
            map.put('i', 1);
            map.put('o', 1);
            map.put('p', 1);
            map.put('Q', 1);
            map.put('W', 1);
            map.put('E', 1);
            map.put('R', 1);
            map.put('T', 1);
            map.put('Y', 1);
            map.put('U', 1);
            map.put('I', 1);
            map.put('O', 1);
            map.put('P', 1);

            map.put('a', 2);
            map.put('s', 2);
            map.put('d', 2);
            map.put('f', 2);
            map.put('g', 2);
            map.put('h', 2);
            map.put('j', 2);
            map.put('k', 2);
            map.put('l', 2);
            map.put('A', 2);
            map.put('S', 2);
            map.put('D', 2);
            map.put('F', 2);
            map.put('G', 2);
            map.put('H', 2);
            map.put('J', 2);
            map.put('K', 2);
            map.put('L', 2);

            map.put('z', 3);
            map.put('x', 3);
            map.put('c', 3);
            map.put('v', 3);
            map.put('b', 3);
            map.put('n', 3);
            map.put('m', 3);
            map.put('Z', 3);
            map.put('X', 3);
            map.put('C', 3);
            map.put('V', 3);
            map.put('B', 3);
            map.put('N', 3);
            map.put('M', 3);
        }

        public static boolean isRowWord(String words){
            char[] chars = words.toCharArray();
            if(chars.length == 1){
                return true;
            }
            int rows = map.get(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if(rows != map.get(chars[i])){
                    return false;
                }
            }
            return true;
        }
    }


    static class Solution1 {

        private final int[] LETTER = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

        public String[] findWords(String[] words) {
            int j = 0;
            for (int i = 0; i < words.length; i++) {
                if (isOneRow(words[i])) {
                    // 把在同行的词交换到前面
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                    j++;
                }
            }
            return Arrays.copyOfRange(words, 0, j);
        }

        private boolean isOneRow(String s) {
            char[] chars = s.toCharArray();
            int row = LETTER[getOffset(chars[0])];
            for (int i = 1; i < chars.length; i++) {
                if (LETTER[getOffset(chars[i])] != row) return false;
            }
            return true;
        }
        private int getOffset(char c) {
            // 判断这个词
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            }
            if (c >= 'A' && c <= 'Z') {
                return c - 'A';
            }
            return -1;
        }
    }
}
