package cn.xib.jixd.multithreading.producerandconsumer.synchronizedimpl;


import cn.xib.jixd.multithreading.producerandconsumer.base.NoBlockingStore;

/**
 * synchronized实现生产者消费者
 *
 * @author jxdong
 * @date 2018/4/13
 */
public class SynchronizedImpl {
    public static void main(String[] args) {
        NoBlockingStore<Object> store = new NoBlockingStore();
        for (int i = 0; i < 5; i++) {
            new Thread(new SyncConsumer(store), "消费线程" + String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new SyncProducer(store), "生产线程" + String.valueOf(i)).start();
        }
    }
}





