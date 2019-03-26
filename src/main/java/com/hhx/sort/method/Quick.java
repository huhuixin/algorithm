package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.sort.IArrayFactory;

import java.util.Comparator;
import java.util.function.Function;

/**
 *
 * 快速排序
 *
 * 原地排序
 *
 * 每次选择给定区间的一个元素作为区分点, 将比这个元素大的放右边, 小的放左边
 *
 * @author hhx
 */
public class Quick<E> extends AbstractSort<E> {

    public Quick(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    public Quick(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        super(factory, comparator, showType);
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        quickSort(0, array.length - 1);
    }

    private void quickSort(int i, int j) {
        System.out.print("sort : [" + i +  "," + j + "]:  ");
        showStatus();
        // 最小坐标 low
        int l = i;
        // 最大坐标high
        int h = j;
        // 选择关键元素,作为对比标准
        E k = array[i];
        System.out.println("key :" + getStatus(k));
        while(l < h){
            // 从后向前, 寻找第一个比k小的元素
            while(l < h && comparator.lt(k, array[h])){
                h --;
            }
            if (l < h){
                move(h, l++);
                showStatus();
            }
            // 从前向后, 寻找第一个比k大的元素
            while(l < h && comparator.gt(k, array[l])){
                l ++;
            }
            if (l < h){
                move(l, h--);
                showStatus();
            }
        }
        array[l] = k;
        System.out.print("sort end : ");showStatus();
        if (l - 1 > i){
            quickSort(i, l - 1);
        }
        if (h + 1 < j){
            quickSort(h + 1, j);
        }
    }
}
