package com.nqlz.thread_demo.block;

import java.util.concurrent.*;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/13 21:47
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException {

        ExecutorService executorService =
                new ThreadPoolExecutor(10,10000,
                        10,TimeUnit.SECONDS, new ArrayBlockingQueue<>(40));

        Future submit = executorService.submit(new MyCallable());

        if(!submit.isDone()){
            System.out.println("任务未完成");
        }

        try {
            System.out.println(submit.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdownNow();
        }

    }
}
