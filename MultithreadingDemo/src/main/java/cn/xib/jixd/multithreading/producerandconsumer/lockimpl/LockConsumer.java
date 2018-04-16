package cn.xib.jixd.multithreading.producerandconsumer.lockimpl;

import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.Consumer;
import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class LockConsumer extends Consumer {
    private NoBlockingStore<Object> store;
    private final ReentrantLock lock = LockHolder.getLock();
    private Condition storeFull = lock.newCondition();
    private Condition storeEmpty = lock.newCondition();

    public LockConsumer(NoBlockingStore store) {
        this.store = store;
        ;
    }

    @Override
    public void consume() {
        while (true) {
            try {
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加锁
            lock.lock();
            while (store.getCurrentNum() <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "容器为空无法消费。当前容器数量" + store.getCurrentNum());
                    storeEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object t=store.getFromStore();
            System.out.println(Thread.currentThread().getName() + "消费了一个。当前容器数量" + store.getCurrentNum());
            storeFull.signalAll();
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
