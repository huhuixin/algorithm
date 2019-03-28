package com.hhx.sort.action;

import com.hhx.util.RandomUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 并发排序
 *
 * @author hhx
 */
public class ConcurrentSort {

    /**
     * 现在有十万个随机数，和一台4核cpu电脑，要求对这十万个随机数进行排序，并充分利用cpu线程，时间越短越好
     */

    public static void main(String[] args) {
        long c1 = 0, c2 = 0, c3 = 0, c4= 0;
        int length = 10000000;
        for (int i = 0; i < 10; i++) {
            c1 += sort(getRandomArray(length));
            c2 += parallelSort(getRandomArray(length));
            c3 += mySort1(getRandomArray(length));
            c4 += mySort2(getRandomArray(length));
        }
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c3: " + c3);
        System.out.println("c4: " + c4);
    }

    private static int[] getRandomArray(int length){
        return IntStream.generate(() -> RandomUtil.randomInt(0, 1000000))
                .limit(length).toArray();
    }

    private static long sort(int[] array){
        long t = System.nanoTime();
        Arrays.sort(array);
        return System.nanoTime() - t;
    }

    private static long parallelSort(int[] array){
        long t = System.nanoTime();
        Arrays.parallelSort(array);
        return System.nanoTime() - t;
    }

    private static long mySort1(int[] array){
        long t = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        return System.nanoTime() - t;
    }

    private static long mySort2(int[] array){
        long t = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        return System.nanoTime() - t;
    }



    private static void quickSort(int[] array, int i, int j) {
        int l = i;
        int h = j;
        int k = array[i];
        while(l < h){
            while(l < h && k < array[h]){
                h --;
            }
            if (l < h){ array[h] = array[l++]; }
            while(l < h && k > array[l]){
                l ++;
            }
            if (l < h){array[l] = array[h--]; }
        }
        array[l] = k;
        if (l - 1 > i){
            quickSort(array, i, l - 1);
        }
        if (h + 1 < j){
            quickSort(array, h + 1, j);
        }
    }

    private static void mergeSort(int[] array, int i, int j){
        if(i >= j){ return; }
        int mid = i + (j - i)/2;
        mergeSort(array, i, mid);
        mergeSort(array, mid + 1, j);
        merge(array, i, mid, mid + 1, j);
    }

    private static int[] temp = new int[10000000];
    private static void merge(int[] array, int i1, int j1, int i2, int j2) {
        int i = 0;
        while(true){
            if(i1 <= j1){
                if(i2 <= j2){
                    if(array[i1] < array[i2]){
                        temp[i++] = array[i1++];
                    }else{
                        temp[i++] = array[i2++];
                    }
                }else{
                    temp[i++] = array[i1++];
                }
            }else{
                if(i2 <= j2){
                    temp[i++] = array[i2++];
                }else{
                    break;
                }
            }
        }
    }

}
