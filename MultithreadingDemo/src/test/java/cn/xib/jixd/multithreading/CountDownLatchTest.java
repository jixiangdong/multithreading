package cn.xib.jixd.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jxdong
 * @date 2018/4/15
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        threadPoolExecutor.shutdown();
       // threadPoolExecutor.execute(new Task(countDownLatch));
        for(int i=0;i<10;i++){
        threadPoolExecutor.execute(new Task(countDownLatch));}
     //   countDownLatch.await();
     //   System.out.println("main end");
        threadPoolExecutor.shutdown();
    }
}

class Task implements Runnable {
    private CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("start task" + Thread.currentThread().getName());
        int a= Integer.valueOf("addd");
        System.out.println("end task" + Thread.currentThread().getName());
       // countDownLatch.countDown();
    }
}

class TaskInterrupt implements Runnable {
    private CountDownLatch countDownLatch;

    public TaskInterrupt(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("start taskInterrupt" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start task" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}