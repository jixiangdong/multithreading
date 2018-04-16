package cn.xib.jixd.multithreading.producerandconsumer.blockqueueimpl;

import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.BlockingStore;
import cn.xib.jixd.multithreading.producerandconsumer.base.Consumer;


/**
 * @author jxdong
 * @date 2018/4/16
 */
public class BlockQueueConsumer extends Consumer {
    private BlockingStore<Object> store;

    public BlockQueueConsumer(BlockingStore store) {
        this.store = store;
    }

    @Override
    public void consume() {
        while (true) {
            try {
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object t = store.getFromStore();
            System.out.println(Thread.currentThread().getName() + "消费了一个。当前容器数量" + store.getCurrentNum());
        }
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }
}
