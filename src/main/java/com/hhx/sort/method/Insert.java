package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.sort.IArrayFactory;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 插入
 *
 * 3, 2, 1, 5, 4
 *
 * 2, 3, 1, 5, 4
 * 1, 2, 3, 5, 4
 * 1, 2, 3, 4, 5
 *
 * @author hhx
 */
public class Insert<E> extends AbstractSort<E> {

    public Insert(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    public Insert(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        super(factory, comparator, showType);
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        for (int i = 1; i < length; i++) {
            E temp = array[i];
            int j = i - 1;
            while(j >= 0 && comparator.gt(array[j], temp)){
                move(j, j + 1);
                j --;
            }
            array[j + 1] = temp;
            showStatus();
        }
    }
}
