package com.hhx.search.method;

import com.hhx.search.AbstractSearch;
import com.hhx.util.IArrayFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 二分查找法
 * @author hhx
 */
public class Binary<E> extends AbstractSearch<E> {

    private ArrayList<E> array;

    public Binary(IArrayFactory<E> arrayFactory, Comparator<E> comparator, Function<E, String> showType) {
        super(comparator, showType);
        this.array = new ArrayList<>(Arrays.asList(arrayFactory.getArray()));
        array.sort(comparator);
    }

    @Override
    protected boolean add(E e) {
        // 保证插入之后依然有序
        int length = array.size();
        // 二分插入
        return array.add(e);
    }

    @Override
    protected boolean remove(E e) {
        // 二分删除

        return false;
    }

    @Override
    public boolean contains(E e) {
        // 二分查找
        int l = 0, h = array.size() - 1, mid;
        while (l < h){
            mid = l + ((h - l) >> 1);
            System.out.println(String.format("search [%d, %d], mid = %d", l, h, mid));
            if(comparator.eq(array.get(mid), e)){
                return true;
            }else if(comparator.lt(array.get(mid), e)){
                // 向后半区查找
                l = mid + 1;
            }else{
                // 向前半区查找
                h =  mid - 1;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return showType == null?
                array.toString():
                array.stream().map(showType).collect(Collectors.joining(", ", "[", "]"));
    }
}
