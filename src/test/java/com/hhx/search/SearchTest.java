package com.hhx.search;

import com.hhx.entity.User;
import com.hhx.search.method.Binary;
import com.hhx.util.IArrayFactory;
import com.hhx.util.RandomUtil;
import com.hhx.util.factory.RandomArrayFactory;
import org.junit.After;
import org.junit.Test;

import java.util.function.Supplier;

import static com.hhx.Constant.compareByNameAsc;
import static com.hhx.Constant.showName;

/**
 * @author hhx
 */
public class SearchTest {

    private static AbstractSearch<User> search;

    private static Supplier<User> randomSupplier = () ->
            new User().setAge(RandomUtil.randomInt(0, 1000))
                    .setName(RandomUtil.randomLetterString(1).toLowerCase());

    private static IArrayFactory<User> randomArrayFactory =
            new RandomArrayFactory<>(randomSupplier, 20);

    @Test
    public void binarySearchTest(){
        //search = new Binary<>(randomArrayFactory, compareByAgeAsc, showAge);
        search = new Binary<>(randomArrayFactory, compareByNameAsc, showName);
        System.out.println(search.toString());
    }

    @After
    public void sort() {
        System.out.println("contains: " + search.contains(new User().setAge(304).setName("h")));
        System.out.println("compare count: " + search.getCompareCount());
    }
}