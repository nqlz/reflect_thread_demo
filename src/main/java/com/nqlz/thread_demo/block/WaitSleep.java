package com.nqlz.thread_demo.block;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/13 22:05
 */
public class WaitSleep {
    public static void main(String[] args) throws InterruptedException {
        final  Object obj = new Object();

        new Thread(()->{
            System.out.println("线程A等待获取锁。。。。");
            synchronized (obj){
                System.out.println("线程A获取锁了555");
                try {
                    Thread.sleep(0xc8);
                    System.out.println("线程A开始等待");
                    //线程A进入等待池，不会去竞争锁
                    obj.wait();
//                    Thread.sleep(1000);
                    System.out.println("线程A等待旺财完成。。。。");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
        Thread.sleep(100);
        new Thread(()->{
            System.out.println("线程B等待获取锁。。。。");
            synchronized (obj){
                System.out.println("线程B获取锁了555");
                try {
                    System.out.println("线程B开始sleeping");
                    Thread.sleep(200);
                    System.out.println("线程B等待旺财完成。。。。");
                    //随机选取一个处于等待池中的线程进入锁池，
//                    obj.notify();
                    //会让所有处于等待池的线程进入锁池，去竞争获取锁的机会
                    obj.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
}
/**
 * 锁池：EntryList
 * 等待池：WaitSet
 *
 */