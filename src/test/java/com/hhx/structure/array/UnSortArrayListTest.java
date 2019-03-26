package com.hhx.structure.array;

import com.hhx.structure.Collection;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnSortArrayListTest {


    @Test
    public void testChangeSize(){
        Collection<String> list = new UnSortArrayList<>(8);
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        assertTrue(list.contains("99"));
        assertTrue(!list.isEmpty());
        assertEquals(100, list.size());
        list.remove("99");
        assertEquals(99, list.size());
    }

}