package cn.xib.jixd.multithreading.producerandconsumer.synchronizedimpl;

import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;
import cn.xib.jixd.multithreading.producerandconsumer.base.Producer;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class SyncProducer extends Producer {
    private NoBlockingStore<Object> store;

    public SyncProducer(NoBlockingStore<Object> store) {
        this.store = store;
    }

    @Override
    public void produce() {
        while (true) {
            //防止生产过快 0-3S随机线程睡眠
            try {
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (store) {

                try {
                    while (store.getCurrentNum() >= store.getMaxNum()) {
                        System.out.println(Thread.currentThread().getName() + "容器为满无法生产。当前容器数量" + store.getCurrentNum());
                        store.wait();
                    }
                    store.notifyAll();
                    store.addToStore(new Object());
                    //操作t
                    System.out.println(Thread.currentThread().getName() + "生产了一个。当前容器数量" + store.getCurrentNum());

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
