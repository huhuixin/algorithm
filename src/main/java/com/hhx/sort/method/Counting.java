package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.sort.IArrayFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * 计数排序, 仅限于 元素个数不多的情况
 *
 * 下标 作为 元素的值, 元素的值作为元素的个数
 *
 * @author hhx
 */
public class Counting<E> extends AbstractSort<E> {
    private int max;
    private ToIntFunction<E> getValue;
    /**
     * 构造函数
     * @param factory
     * @param getValue 需要排序的字段, 必须为 正整数
     */
    public Counting(IArrayFactory<E> factory, ToIntFunction<E> getValue, int max) {
        super(factory, Comparator.comparingInt(getValue), e -> getValue.applyAsInt(e) + "");
        this.max = max;
        this.getValue = getValue;
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        int[] countArray = new int[max + 1];
        for (E e : array) {
            int index = getValue.applyAsInt(e);
            countArray[index]++;
            System.out.println("countArray: " + Arrays.toString(countArray));
        }
        // 对countArray中的值做叠加操作
        for (int i = 1; i <= max; ++i){
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        // 现在 countArray 中的值的 实际意义是 小于等于下标值元素的数量
        System.out.println("added countArray: " + Arrays.toString(countArray));

        // 向数组中转移数据
        E[] temp = ((E[]) new Object[length]);
        for (int i = length - 1; i >= 0; --i){
            // 倒序依次获得原数组中的元素的 取出元素int值
            int ai = getValue.applyAsInt(array[i]);
            // 根据统计个数 计算出该元素的下标 = (统计值 - 1)
            int ic = countArray[ai] - 1;
            // 将元素放入数组
            temp[ic] = array[i];
            // 计数器减1
            countArray[ai]--;
            System.out.println("added countArray: " + Arrays.toString(countArray));
            System.out.println("status: " + com.hhx.sort.Arrays.toString(temp, showType));
        }
        array = temp;
    }
}
