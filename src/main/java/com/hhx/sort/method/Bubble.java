package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.sort.IArrayFactory;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 冒泡排序
 * 每次对比相邻的两个, 将较大的移到后面
 * 3, 2, 1, 4
 *
 * 2 , 3, 1, 4
 * 2, 1, 3, 4
 * 2, 1, 3, 4
 * 1, 2, 3, 4
 *
 * @author hhx
 */
public class Bubble<E> extends AbstractSort<E> {

    public Bubble(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    public Bubble(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        super(factory, comparator, showType);
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        for (int i = 0; i < length; i++) {
            // 每次确定一个最大值, 内循环每次减少1
            for (int j = 0; j < length - i - 1; j++) {
                if(comparator.gt(array[j], array[j + 1])){
                    swap(j, j + 1);
                }
                showStatus();
            }
        }
    }
}
