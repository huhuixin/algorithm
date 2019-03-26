package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.util.IArrayFactory;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 选择
 *
 *  每一次从待排序的数据元素中选出最小（或最大）的一个元素，
 *  存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 *  然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法
 *
 * 3, 2, 1, 5, 4
 *
 * 1    2, 3, 5, 4
 * 1, 2   3, 5, 4
 * 1, 2, 3, 5, 4
 * 12345
 *
 * @author hhx
 */
public class Select<E> extends AbstractSort<E> {

    public Select(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    public Select(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        super(factory, comparator, showType);
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if(comparator.lt(array[j], array[minIndex])){
                    minIndex = j;
                }
            }
            // 交换无序区最小坐标 和 无序区最小值
            swap(i, minIndex);
            showStatus();
        }
    }
}
