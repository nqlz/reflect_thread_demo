package com.nqlz.thread_demo.block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能描述:sleep模拟网络延时
 *
 * @author: MR.zt
 * @date: 2019/6/12 18:25
 */
public class Sleep {



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test t = new test();
        Thread thread = new Thread(t);
        thread.start();
        thread.join();
        System.out.println(t.getName());


        FutureTask<Object> task = new FutureTask<Object>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()){
            System.out.println("请等待执行旺财");
        }
        System.out.println(task.get().toString());
    }


}
@NoArgsConstructor
@AllArgsConstructor
@Data
class test implements Runnable{

    private String name;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "赋值成功";
    }
}

class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        String value = "执行成功";
        Thread.sleep(1000);
        return value;
    }
}