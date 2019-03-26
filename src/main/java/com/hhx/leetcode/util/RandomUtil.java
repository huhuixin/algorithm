package com.hhx.leetcode.util;

import com.sun.tools.javac.util.Assert;

import java.util.Random;

/**
 * 随机数
 *
 * @author hhx
 */
public class RandomUtil {

    /**
     * 生成 min - max 之间的长度为length的随机数组, 包含 min 但是不包含 max
     * @param length 长度
     * @param min 最小取值
     * @param max 最大取值
     * @return
     */
    public static int[] randomIntArray(int length, int min, int max){
        return RandomHolder.RANDOM.ints(length, min, max).toArray();
    }

    /**
     * 生成 min - max 之间的随机数, 包含 min 但是不包含 max
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max){
        return RandomHolder.RANDOM.nextInt(max - min) + min;
    }

    /**
     * 指定范围获取随机偶数
     * @param min
     * @param max
     * @return
     */
    public static int randomEven(int min, int max){
        Assert.check(min % 2 == 0, "最小取值必须为偶数");
        int random = RandomHolder.RANDOM.nextInt(max - min) + min;
        return random % 2 == 0 ? random : random - 1;
    }

    /**
     * 随机英文字符
     * @return
     */
    public static char randomLetter(){
        return RandomHolder.LETTERS[randomInt(0, RandomHolder.LETTERS.length)];
    }

    /**
     * 随机字符串
     * @param length 指定长度
     * @return
     */
    public static String randomLetterString(int length){
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(randomLetter());
        }
        return sb.toString();
    }

    /**
     * 从给定的数组中取出随机元素
     * @param array
     * @return
     */
    public static <T> T randomElement(T[] array){
        return array[randomInt(0, array.length)];
    }

    private static final class RandomHolder {
        static final Random RANDOM = new Random();
        static final char[] LETTERS = new char[52];
        static final char[] NUMBERS = new char[10];
        static {
            for (int i = 0; i < 26; i++) {
                LETTERS[i] = (char)('a' + i);
                LETTERS[i + 26] = (char)('A' + i);
            }
            for (int i = 0; i < 10; i++) {
                NUMBERS[i] = (char)('0' + i);
            }
        }
    }
}
