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

    /**
     * 一个有序数组
     */
    private ArrayList<E> array;

    public Binary(IArrayFactory<E> arrayFactory, Comparator<E> comparator, Function<E, String> showType) {
        super(comparator, showType);
        this.array = new ArrayList<>(Arrays.asList(arrayFactory.getArray()));
        array.sort(comparator);
    }

    /**
     * 添加到最后一个
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        // 寻找合适的插入位置
        int low = 0, high = array.size() - 1, mid;
        // 逻辑与查找最后一个元素位置相同
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if(comparator.le(array.get(mid), e)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        // high 代表的是查找最后一个target相同的元素下标, 实际上array[high] 只会 <= e
        int insertIndex = high + 1;
        if(insertIndex == array.size()){
            array.add(e);
        }else{
            array.add(insertIndex, e);
        }
        return false;
    }

    /**
     * 删除第一个出现的元素
     * @param e
     * @return
     */
    @Override
    public boolean remove(E e) {
        int index = firstIndexOf(e);
        if(index > -1){
            array.remove(index);
            return true;
        }
        return false;
    }

    /**
     * 查找元素第一次出现的位置
     * @param e
     * @return
     */
    public int firstIndexOf(E e){
        int low = 0, high = array.size() - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if(comparator.ge(array.get(mid), e)){
                high =  mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if (low < array.size() && comparator.eq(array.get(low), e)){
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 查找元素最后一次出现的位置
     * @param e
     * @return
     */
    public int lastIndexOf(E e){
        int low = 0, high = array.size() - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            System.out.println(String.format("search [%d, %d], mid = %d", low, high, mid));
            if(comparator.le(array.get(mid), e)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        // 当元素 < array[0] 时 , high持续递减变成-1
        // 当元素中不存在该值时, 会查找到第一个大于该元素的坐标
        // 当元素中存在该值时, 会查找到该值之后继续向后面的区间再次进行二分查找, 直到某个元素大于e, 此时high - 1就等于元素最后一次出现的位置
        if (high > -1 && comparator.eq(array.get(high), e)){
            return high;
        } else {
            return -1;
        }
    }

    @Override
    public boolean contains(E e) {
        int low = 0, high = array.size() - 1, mid;
        // 二分查找的结束条件 low <= high 的含义是判断能否继续缩短区间, 跳出循环说明二分查找到最细粒度(区间长度为1)无法继续
        while (low <= high){
            mid = low + ((high - low) >> 1);
            System.out.println(String.format("search [%d, %d], mid = %d", low, high, mid));
            if(comparator.eq(array.get(mid), e)){
                return true;
            }else if(comparator.lt(array.get(mid), e)){
                low = mid + 1;
            }else{
                high =  mid - 1;
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
