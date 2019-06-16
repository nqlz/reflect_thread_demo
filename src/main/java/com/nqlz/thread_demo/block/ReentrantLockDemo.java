package com.nqlz.thread_demo.block;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/16 11:57
 */
public class ReentrantLockDemo implements Runnable {
    private ReentrantLock lock;

    public ReentrantLockDemo(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁。");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo unfairDemo = new ReentrantLockDemo(new ReentrantLock());
        ReentrantLockDemo fairDemo = new ReentrantLockDemo(new ReentrantLock(true));

//        new Thread(fairDemo, "线程A").start();
//        new Thread(fairDemo, "线程B").start();

        new Thread(unfairDemo, "线程A").start();
        new Thread(unfairDemo, "线程B").start();

    }
}
