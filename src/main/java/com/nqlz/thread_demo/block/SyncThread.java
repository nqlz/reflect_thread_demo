package com.nqlz.thread_demo.block;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/13 23:23
 */
public class SyncThread implements Runnable {


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.startsWith("A")) {
            async();
        } else if (name.startsWith("B")) {
            syncObjectBlock();
        } else if (name.startsWith("C")) {
            syncObjectMethod();
        }else if (name.startsWith("D")) {
            syncObjectBlock1();
        }else if (name.startsWith("E")) {
            syncObjectMethod1();
        }
    }

    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "异步方法开始");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "异步方法结束");

        } catch (Exception e) {

        }

    }

    private void syncObjectBlock() {
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "同步代码块方法开始");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "同步代码块方法结束");
            }

        } catch (Exception e) {

        }
    }
    private void syncObjectBlock1() {
        try {
            synchronized (SyncThread.class) {
                System.out.println(Thread.currentThread().getName() + "同步代码块类锁方法开始");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "同步代码块类锁方法结束");
            }

        } catch (Exception e) {

        }
    }

    /**
     * 非静态同步方法用的是对象锁
     *
     */
    private synchronized void syncObjectMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "非静态同步方法开始");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "非静态同步方法结束");
        } catch (Exception e) {

        }
    }
    private synchronized static  void syncObjectMethod1() {
        try {
            System.out.println(Thread.currentThread().getName() + "静态同步类锁方法开始");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "静态同步类锁方法结束");
        } catch (Exception e) {

        }
    }
}