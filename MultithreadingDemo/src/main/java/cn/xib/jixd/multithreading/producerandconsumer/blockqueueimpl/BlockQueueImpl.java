package cn.xib.jixd.multithreading.producerandconsumer.blockqueueimpl;

import cn.xib.jixd.multithreading.producerandconsumer.base.BlockingStore;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class BlockQueueImpl {
    public static void main(String[] args) {
        BlockingStore<Object> store = new BlockingStore();
        for (int i = 0; i < 5; i++) {
            new Thread(new BlockQueueConsumer(store), "消费线程" + String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new BlockQueueProducer(store), "生产线程" + String.valueOf(i)).start();
        }
    }
}
