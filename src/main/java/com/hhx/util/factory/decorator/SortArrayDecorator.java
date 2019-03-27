package com.hhx.util.factory.decorator;

import com.hhx.util.IArrayFactory;
import com.hhx.util.factory.AbstractArrayDecorator;

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
