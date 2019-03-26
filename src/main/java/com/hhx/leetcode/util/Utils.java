package com.hhx.leetcode.util;

/**
 * 工具类
 *
 * @author hhx
 */
public class Utils {

    /**
     * 计算运行时间
     * @param computer
     */
    public static void countTime(Computer computer){
        long t1 = System.nanoTime();
        computer.run();
        System.out.println("用时 : " + (System.nanoTime() - t1));
    }

    /**
     * 计算多次运行的平均时间
     * @param runs
     * @param computer
     */
    public static void averageTime(int runs, Computer computer){
        long t1 = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            computer.run();
        }
        System.out.println("平均用时 : " + (System.nanoTime() - t1)/runs);
    }

    /**
     * 比较算法运行时间
     * @param runs
     * @param computers
     */
    public static void compareTime(int runs, Computer... computers){
        System.out.println("共执行"+runs+"次");
        for (Computer computer : computers) {
            averageTime(runs, computer);
        }
    }

    /**
     * 模拟工作时间
     */
    public static void work(long sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
