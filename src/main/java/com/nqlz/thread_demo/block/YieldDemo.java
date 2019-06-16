package com.nqlz.thread_demo.block;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/13 22:39
 */
public class YieldDemo {
    static class yieldTask implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"---"+i);
                if (i==5){
                    Thread.yield();
                }
            }

        }
    }
    public static void main(String[] args) {
        new Thread(new yieldTask(),"线程A").start();
        new Thread(new yieldTask(),"线程B").start();

    }
}
