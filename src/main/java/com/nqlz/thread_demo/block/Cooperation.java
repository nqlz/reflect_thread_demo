package com.nqlz.thread_demo.block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/12 20:05
 */
public class Cooperation {

    public static void main(String[] args) throws InterruptedException {
        SycContainer container = new SycContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

/**
 * 生产者
 */
class Productor extends Thread {
    private SycContainer container;

    public Productor(SycContainer sycContainer) {
        this.container = sycContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产第  ----》" + i + "个消息；");
            container.push(new SteamedBun(i));
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    private SycContainer container;

    public Consumer(SycContainer sycContainer) {
        this.container = sycContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("消费第  ----》" + container.get().getId() + "个消息；");
        }
    }
}

/**
 * 缓冲区
 */
class SycContainer {
    /**
     * 容器
     */
    private SteamedBun[] buns = new SteamedBun[100];
    /**
     * 计数器
     */
    private int count = 0;

    /**
     * 存储
     */
    public synchronized void push(SteamedBun bun)  {
        if(count == buns.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buns[count] = bun;
        count++;
        this.notifyAll();
    }

    /**
     * 获取
     */
    public synchronized SteamedBun get() {
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        SteamedBun bun = buns[count];
        this.notifyAll();
        return bun;
    }

}

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class SteamedBun {
    private int id;
}