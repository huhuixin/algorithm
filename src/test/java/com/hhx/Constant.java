package com.hhx;

import com.hhx.entity.User;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author hhx
 */
public class Constant {

    public static Comparator<User> compareByAgeAsc = Comparator.comparingInt(User::getAge);
    public static Comparator<User> compareByNameAsc = Comparator.comparing(User::getName);

    public static Function<User, String> showAge = user -> user.getAge() + "";
    public static Function<User, String> showName = User::getName;
    public static Function<User, String> showFull = user -> "(" + user.getName() + ":" + user.getAge() + ")";
}
