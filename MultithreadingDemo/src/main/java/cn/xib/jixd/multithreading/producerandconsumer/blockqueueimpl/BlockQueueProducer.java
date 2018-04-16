package cn.xib.jixd.multithreading.producerandconsumer.blockqueueimpl;

import cn.xib.jixd.multithreading.MyUtil;
import cn.xib.jixd.multithreading.producerandconsumer.base.BlockingStore;
import cn.xib.jixd.multithreading.producerandconsumer.base.Producer;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class BlockQueueProducer extends Producer {
    private BlockingStore<Object> store;
    public BlockQueueProducer(BlockingStore store)
    {
        this.store = store;
    }

    @Override
    public void produce() {
        while (true) {
            try {
                Thread.sleep(MyUtil.getRandomNm(3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             store.addToStore(new Object());
            System.out.println(Thread.currentThread().getName() + "生产了一个。当前容器数量" + store.getCurrentNum());
        }
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }
}
