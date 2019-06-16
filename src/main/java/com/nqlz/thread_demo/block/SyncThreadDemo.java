package com.nqlz.thread_demo.block;

/**
 * 功能描述:类锁和对象锁不相互干扰
 *
 * @author: MR.zt
 * @date: 2019/6/13 23:24
 */
public class SyncThreadDemo {
    public static void main(String[] args) {

        SyncThread syncThread = new SyncThread();
        Thread threada1 = new Thread(syncThread, "A-线程1");
        Thread threada2 = new Thread(syncThread, "A-线程2");

        Thread threadb1 = new Thread(syncThread, "B-线程1");
        Thread threadb2 = new Thread(syncThread, "B-线程2");

        Thread threadc1 = new Thread(syncThread, "C-线程1");
        Thread threadc2 = new Thread(syncThread, "C-线程2");

        Thread threadd1 = new Thread(syncThread, "D-线程1");
        Thread threadd2 = new Thread(syncThread, "D-线程2");

        Thread threade1 = new Thread(syncThread, "E-线程1");
        Thread threade2 = new Thread(syncThread, "E-线程2");

//        threada1.start();
//        threada2.start();
//        threadb1.start();
//        threadb2.start();
//        threadc1.start();
//        threadc2.start();
        threadd1.start();
        threadd2.start();
        threade1.start();
        threade2.start();
    }
}
