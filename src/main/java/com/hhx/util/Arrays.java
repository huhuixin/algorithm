package com.hhx.util;

import lombok.experimental.UtilityClass;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 工具类
 *
 * @author hhx
 */
@UtilityClass
public class Arrays {

    public static <E> String toString(E[] array, Function<E, String> function){
        return java.util.Arrays.stream(array)
                .map(e -> e == null ? "null" : function.apply(e))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void swap(Object[] array, int i, int j){
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
