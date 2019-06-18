package com.nqlz.thread_demo.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/18 17:03
 */
public class SafeHashMapDemo {

    public static void main(String[] args) {
        Map hashMap = new HashMap<>();

        Map map = Collections.synchronizedMap(hashMap);

        map.put("aaa",12);
        map.put("bbaa",32);


    }
}
