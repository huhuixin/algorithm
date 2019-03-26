package com.hhx.leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 自除数
 *
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * @author hhx
 */
public class P0728SelfDividingNumbers {



     public static void main(String[] args) {
         System.out.println(
             new Solution().selfDividingNumbers(47, 85)
         );
         System.out.println(
                 new Solution().selfDividingNumbers(1, 22)
         );
     }

     static class Solution {

         public List<Integer> selfDividingNumbers(int left, int right) {
             List<Integer> selfDividingNumbers = new ArrayList<>(1000);
             IntStream.range(left, right + 1)
                     .filter(Solution::isSelfDividingNumber)
                     .forEach(number -> selfDividingNumbers.add(number));
             return selfDividingNumbers;
         }

         static boolean isSelfDividingNumber(Integer number){
             int digit;
             int tmp = number;
             while(tmp!= 0){
                 digit = tmp % 10;
                 if(digit == 0 || number % digit != 0){
                     return false;
                 }
                 tmp /= 10;
             }
             return true;
         }
     }

}
