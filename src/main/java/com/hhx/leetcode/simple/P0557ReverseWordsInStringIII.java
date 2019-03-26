package com.hhx.leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author hhx
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */
public class P0557ReverseWordsInStringIII {

    public static void main(String[] args) {
        System.out.println(
            new Solution().reverseWords("I Love Java")
        );
    }

    static class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            List<String> lists = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0 ; i--) {
                char c = chars[i];
                if(c == ' '){
                    lists.add(sb.toString());
                    sb = new StringBuilder();
                }else{
                    sb.append(c);
                }
            }
            lists.add(sb.toString());
            sb = new StringBuilder();
            for (int i = lists.size() - 1; i >= 0; i--) {
                sb.append(lists.get(i));
                if(i > 0){
                   sb.append(' ');
                }
            }
            return sb.toString();
        }
    }

    static class Solution1 {
        public String reverseWords(String s) {
            char[] cl = s.toCharArray();
            int start = 0;
            int nextSpace = s.indexOf(' ',start);
            while(nextSpace != -1) {
                //翻转找到的单词
                reverse(cl,start,nextSpace - 1);
                start = nextSpace + 1;
                nextSpace = s.indexOf(' ',start);
            }
            reverse(cl,start,cl.length - 1);
            return new String(cl);
        }

        public void reverse(char[] cl,int start,int end){
            while(start < end){
                char temp = cl[start];
                cl[start] = cl[end];
                cl[end] = temp;
                start ++;
                end --;
            }
        }
    }
}
