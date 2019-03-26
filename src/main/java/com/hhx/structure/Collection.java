package com.hhx.structure;

/**
 * 抽象集合
 *
 * @author hhx
 */
public interface Collection<E> {

    int size();

    boolean isEmpty();

    boolean contains(E e);

    boolean add(E e);

    boolean remove(E e);
}
