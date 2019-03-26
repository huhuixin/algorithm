package com.hhx.sort.factory;

import com.hhx.sort.ComparatorUtil;
import com.hhx.sort.IArrayFactory;

import java.util.Comparator;

/**
 * 装饰器
 *
 * @author hhx
 */
public abstract class AbstractArrayDecorator<E> implements IArrayFactory<E>{

    /**
     * 需要装饰的对象
     */
    protected E[] array;
    protected Comparator<E> comparator;

    public AbstractArrayDecorator(IArrayFactory<E> factory, Comparator<E> comparator) {
        this.array = factory.getArray();
        this.comparator = comparator;
    }

    /**
     * 对数组进行修饰
     */
    protected abstract void decorator();

    @Override
    public E[] getArray() {
        decorator();
        return array;
    }
}
