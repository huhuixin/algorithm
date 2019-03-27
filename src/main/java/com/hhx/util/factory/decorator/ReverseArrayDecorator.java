package com.hhx.util.factory.decorator;

import com.hhx.util.IArrayFactory;
import com.hhx.util.factory.AbstractArrayDecorator;

import java.util.Comparator;

/**
 * 反转数组
 *
 * @author hhx
 */
public class ReverseArrayDecorator<E> extends AbstractArrayDecorator<E> {

    public ReverseArrayDecorator(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    @Override
    protected void decorator() {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            // 交换首位
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
