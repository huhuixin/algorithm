package com.hhx.util;

import lombok.Getter;

import java.util.Comparator;

/**
 * 比较工具类
 *
 * @author hhx
 */
public class ComparatorUtil<E> {

    @Getter
    private long count = 0;

    /**
     * 排序策略, 按照指定规则排序
     */
    private Comparator<E> comparator;

    public ComparatorUtil(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private int compare(E o1, E o2){
        count ++;
        return comparator.compare(o1, o2);
    }

    public boolean eq(E o1, E o2){
        return compare(o1, o2) == 0;
    }

    public boolean lt(E o1, E o2){
        return compare(o1, o2) < 0;
    }

    public boolean le(E o1, E o2){
        return compare(o1, o2) <= 0;
    }

    public boolean gt(E o1, E o2){
        return compare(o1, o2) > 0;
    }

    public boolean ge(E o1, E o2){
        return compare(o1, o2) >= 0;
    }
}
