package com.nqlz.thread_demo.block;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/14 0:26
 */
public class StringBufferNoSync {
    public static void main(String[] args) {
        /**
         * StringBuffer是线程安全的，由于sb只会在append方法中使用，不可能被其他线程引用
         * 因此sb属于不可能共享的资源，JVM会自动消除内部的锁
         */
        StringBuffer sb = new StringBuffer();
        sb.append(55).append(88);


        StringBuffer sbf = new StringBuffer();
        int i=0;
        while (i<100){
            sbf.append(77);
        }

    }
}
