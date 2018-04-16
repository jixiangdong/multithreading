package cn.xib.jixd.multithreading.producerandconsumer.base;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class BlockingStore<T> implements Store<T> {
    //最多允许存储10个
    private final int maxNum = 10;
    private BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<T>(maxNum);

    @Override
    public void addToStore(T t) {
        try {
            blockingQueue.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getFromStore() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public   int  getCurrentNum()
    {
        return  blockingQueue.size();
    }

}
