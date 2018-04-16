package cn.xib.jixd.multithreading.producerandconsumer.lockimpl;


import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;
import cn.xib.jixd.multithreading.producerandconsumer.base.Producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class LockProducer extends Producer {
    private NoBlockingStore<Object> store;
    private final ReentrantLock lock = LockHolder.getLock();
    private Condition storeFull = lock.newCondition();
    private Condition storeEmpty = lock.newCondition();
   public LockProducer(NoBlockingStore store)
   {
      this.store=store;
   }

    @Override
    public void produce() {
        while (true) {
            try {
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加锁
            lock.lock();
            while (store.getCurrentNum() >= store.getMaxNum()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "容器为满无法生产。当前容器数量" + store.getCurrentNum());
                    storeFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            store.addToStore(new Object());
            System.out.println(Thread.currentThread().getName() + "生产了一个。当前容器数量" + store.getCurrentNum());
            storeEmpty.signalAll();
            lock.unlock();

        }
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }
}
