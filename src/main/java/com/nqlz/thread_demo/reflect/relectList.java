package com.nqlz.thread_demo.reflect;

import java.util.ArrayList;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/12 23:59
 */
public class relectList {

    public static void main(String[] args) throws Exception {
        ArrayList list = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();

        list.add("sss");
        list.add(88);

        list1.add(666);

        list1.getClass().getMethod("add", Object.class).invoke(list1, "测试一下");

        System.out.println(list1);


    }
}

