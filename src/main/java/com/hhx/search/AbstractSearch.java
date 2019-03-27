package com.hhx.search;

import com.hhx.util.ComparatorUtil;
import com.hhx.util.IArrayFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * 查找
 * @author hhx
 */
public abstract class AbstractSearch<E> implements ISearch<E> {

    protected ComparatorUtil<E> comparator;

    protected Function<E, String> showType;

    public AbstractSearch(Comparator<E> comparator) {
        this.comparator = new ComparatorUtil<>(comparator);
    }

    public AbstractSearch(Comparator<E> comparator, Function<E, String> showType) {
        this.comparator = new ComparatorUtil<>(comparator);
        this.showType = showType;
    }

    public long getCompareCount(){
        return comparator.getCount();
    }

    /**
     * 添加数据
     * @param e
     * @return
     */
    protected abstract boolean add(E e);

    /**
     * 删除数据
     * @param e
     * @return
     */
    protected abstract boolean remove(E e);
}
