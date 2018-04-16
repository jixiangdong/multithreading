package cn.xib.jixd.multithreading.producerandconsumer.base;

/**
 * @author jxdong
 * @date 2018/4/13
 */
public abstract class Producer implements Runnable {
    @Override
    public void run() {
        before();
        produce();
        after();
    }

    public abstract void produce();

    public abstract void before();

    public abstract void after();
}
