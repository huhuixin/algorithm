package com.hhx.sort.factory;

/**
 * 指定数组
 * @author hhx
 */
public class CustomArrayFactory<E> extends AbstractArrayFactory<E> {
    public CustomArrayFactory(E[] array) {
        super(array);
    }
}
