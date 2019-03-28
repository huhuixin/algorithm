package com.hhx.search;

/**
 * 查找
 * @author hhx
 */
public interface ISearch<E> {
    /**
     * 查找
     * @param e
     * @return
     */
    boolean contains(E e);
}
