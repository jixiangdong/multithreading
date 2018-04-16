package cn.xib.jixd.multithreading.producerandconsumer.synchronizedimpl;

import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.Consumer;
import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class SyncConsumer extends Consumer {
    private NoBlockingStore<Object> store;

    public SyncConsumer(NoBlockingStore<Object> store) {
        this.store = store;
    }

    @Override
    public void consume() {
        while (true) {
            try {
                //防止消费过快 随机线程随机睡眠0-3S
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (store) {
                try {
                    while (store.getCurrentNum() <= 0) {
                        System.out.println(Thread.currentThread().getName() + "容器为空无法消费。当前容器数量" + store.getCurrentNum());
                        store.wait();
                    }
                    Object t = store.getFromStore();
                    System.out.println(Thread.currentThread().getName() + "消费了一个。当前容器数量" + store.getCurrentNum());
                    store.notifyAll();
                    //操作t
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }
}
