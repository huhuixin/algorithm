package com.hhx.sort.factory.decorator;

import com.hhx.sort.IArrayFactory;
import com.hhx.sort.factory.AbstractArrayDecorator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据给定的比较器 排序
 *
 * @author hhx
 */
public class SortArrayDecorator<E> extends AbstractArrayDecorator<E> {

    public SortArrayDecorator(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    @Override
    protected void decorator() {
        Arrays.sort(array, comparator);
    }
}
