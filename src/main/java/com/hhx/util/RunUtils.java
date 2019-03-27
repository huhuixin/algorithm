package com.hhx.util;

/**
 * 工具类
 *
 * @author hhx
 */
public class RunUtils {

    /**
     * 计算运行时间
     * @param computer
     */
    public static long countTime(Computer computer){
        long t1 = System.nanoTime();
        computer.run();
        return System.nanoTime() - t1;
    }

    /**
     * 计算多次运行的平均时间
     * @param runs
     * @param computer
     */
    public static long averageTime(int runs, Computer computer){
        long t1 = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            computer.run();
        }
        return (System.nanoTime() - t1)/runs;
    }

    /**
     * 比较算法运行时间
     * @param runs
     * @param computers
     */
    public static void compareTime(int runs, Computer... computers){
        System.out.println("共执行"+runs+"次");
        for (Computer computer : computers) {
            System.out.println("平均耗时:" + averageTime(runs, computer));
        }
    }

    public static void sleepSeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMillis(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
