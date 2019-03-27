package com.hhx.util.factory;

import com.hhx.util.IArrayFactory;

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
