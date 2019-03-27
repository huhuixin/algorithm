package com.hhx.util.factory.decorator;

import com.hhx.util.IArrayFactory;
import com.hhx.util.factory.AbstractArrayDecorator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 根据给定的比较器 去重复, 只保留第一次出现的元素
 *
 * @author hhx
 */
public class DistinctArrayDecorator<E> extends AbstractArrayDecorator<E> {

    public DistinctArrayDecorator(IArrayFactory<E> factory, Comparator<E> comparator) {
        super(factory, comparator);
    }

    @Override
    protected void decorator() {
        // 遍历数组, 将元素依次放入TreeSet中
        TreeSet<E> set = new TreeSet<>(comparator);
        ArrayList<E> arrayList = new ArrayList<>(array.length);
        for (int i = 0, j = 0; i < array.length; i++) {
            // 插入失败说明已存在,跳过
            if (set.add(array[i])){
                arrayList.add(array[i]);
            }
        }
        array = ((E[]) arrayList.toArray());
    }
}
