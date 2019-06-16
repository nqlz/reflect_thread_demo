package com.nqlz.thread_demo.block;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/13 22:59
 */
public class InterruptDemo {
    static class Task implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName()+"---"+i+Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("停止异常：--"+
                            Thread.currentThread().getName()+"---"+i+Thread.currentThread().getState());
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread ta = new Thread(new Task(), "线程A");
        Thread tb = new Thread(new Task(), "线程B");
        System.out.println(ta.getName()+"状态："+ta.getState());
        ta.start();
        System.out.println(ta.getName()+"状态："+ta.getState());
        System.out.println("休眠开始");
        Thread.sleep(300);
        ta.interrupt();
        System.out.println(ta.getName()+"状态："+ta.getState());

        System.out.println("再休眠一次");
        Thread.sleep(300);
        System.out.println(ta.getName()+"状态："+ta.getState());

    }
}
