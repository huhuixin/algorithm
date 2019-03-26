package com.hhx.sort;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户
 *
 * @author hhx
 */
@Data
@Accessors(chain = true)
public class User {
    private int age;
    private String name;
}
