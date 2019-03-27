package com.hhx.sort;

import com.hhx.entity.User;
import com.hhx.sort.method.*;
import com.hhx.util.Arrays;
import com.hhx.util.IArrayFactory;
import com.hhx.util.RandomUtil;
import com.hhx.util.factory.CustomArrayFactory;
import com.hhx.util.factory.RandomArrayFactory;
import com.hhx.util.factory.decorator.DistinctArrayDecorator;
import com.hhx.util.factory.decorator.ReverseArrayDecorator;
import com.hhx.util.factory.decorator.SortArrayDecorator;
import org.junit.After;
import org.junit.Test;

import java.util.function.Supplier;

import static com.hhx.Constant.*;

public class SortTest {

    public static Supplier<User> randomSupplier = () ->
            new User()
                    .setAge(RandomUtil.randomInt(0, 5))
                    .setName(RandomUtil.randomLetterString(1).toLowerCase());

    private static IArrayFactory<User> randomArrayFactory =
            new RandomArrayFactory<>(randomSupplier, 10);

    private static AbstractSort sort;

    @Test
    public void bubbleTestRandom() {
        sort = new Bubble<>(randomArrayFactory, compareByAgeAsc);
    }

    @Test
    public void InsertTestRandom() {
        sort = new Insert<>(randomArrayFactory, compareByAgeAsc, showAge);
    }

    @Test
    public void SelectTestRandom() {
        sort = new Select<>(randomArrayFactory, compareByAgeAsc, showAge);
    }

    @Test
    public void QuickTestRandom() {
          sort = new Quick<>(randomArrayFactory, compareByAgeAsc, showAge);
//        IArrayFactory<Integer> factory = new CustomArrayFactory<>(new Integer[]{53, 31, 39, 36, 42, 28, 74, 68, 11, 6});
//        factory = new SortArrayDecorator<>(factory, Integer::compareTo);
//        factory = new ReverseArrayDecorator<>(factory, Integer::compareTo);
//        sort = new Quick<>(factory
//                , Integer::compareTo, integer -> integer + "");
    }

    @Test
    public void MergeTestRandom() {
        sort = new Merge<>(randomArrayFactory, compareByNameAsc, showAge);
    }

    @Test
    public void CountingTestRandom() {
        sort = new Counting<>(randomArrayFactory, User::getAge, 4);
    }

    @Test
    public void ArrayDecoratorTest() {
        // 避免每次都改变
        randomArrayFactory = new CustomArrayFactory<>(randomArrayFactory.getArray());
        System.out.println(Arrays.toString(randomArrayFactory.getArray(), showAge));
        randomArrayFactory = new ReverseArrayDecorator<>(randomArrayFactory, null);
        System.out.println(Arrays.toString(randomArrayFactory.getArray(), showAge));
        randomArrayFactory = new SortArrayDecorator<>(randomArrayFactory, compareByAgeAsc);
        System.out.println(Arrays.toString(randomArrayFactory.getArray(), showAge));
        randomArrayFactory = new DistinctArrayDecorator<>(randomArrayFactory, compareByAgeAsc);
        System.out.println(Arrays.toString(randomArrayFactory.getArray(), showAge));
    }

    @After
    public void sort() {
        System.out.println("耗时: " + sort.watchSort());
        System.out.println("success: " + sort.isFinished());
        System.out.println("compare count: " + sort.getCompareCount());
        System.out.println("swap count: " + sort.getSwapCount());
        System.out.println("move count: " + sort.getMoveCount());
    }
}