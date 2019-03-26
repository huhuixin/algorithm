package com.hhx.sort.factory;

import com.hhx.sort.IArrayFactory;

/**
 * 指定数组
 *
 * @author hhx
 */
public class AbstractArrayFactory<E> implements IArrayFactory<E> {

    protected E[] array;

    public AbstractArrayFactory() {
    }

    public AbstractArrayFactory(E[] array) {
        this.array = array;
    }

    @Override
    public E[] getArray() {
        return array;
    }
}
