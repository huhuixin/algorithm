package com.hhx.sort;

/**
 * @author hhx
 */
public interface IArrayFactory<E>{

    /**
     * 获取待排序数组
     * @return
     */
    E[] getArray();
}
