package cn.xib.jixd.multithreading.producerandconsumer.lockimpl;

import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class LockImpl {
    public static void main(String[] args) {
        NoBlockingStore<Object> store = new NoBlockingStore();
        for (int i = 0; i < 5; i++) {
            new Thread(new LockConsumer(store), "消费线程" + String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new LockProducer(store), "生产线程" + String.valueOf(i)).start();
        }
    }
}


