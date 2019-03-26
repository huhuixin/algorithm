package com.hhx.structure.array;

import com.hhx.structure.Collection;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数组
 *
 * 内存连续
 *
 * 优点: 支持随机访问(目标内存地址 = base_address + index * size), 时间复杂度O(1)
 *      内存连续, 支持CPU缓存
 *
 * 缺点: 大小固定
 *
 *
 * @author hhx
 */
public abstract class AbstractArrayList<E> implements Collection<E> {

    protected Object[] array;
    protected int length = 0;
    protected int capacity;

    public AbstractArrayList() {
        this(16);
    }

    public AbstractArrayList(int capacity) {
        this.array = new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E o) {
        return indexOf(o) > -1;
    }

    abstract int indexOf(E o);

    public E get(int index){
        return (E) array[index];
    }

    @Override
    public String toString() {
        return Stream.of(array)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
