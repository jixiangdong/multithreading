package cn.xib.jixd.multithreading.producerandconsumer.base;

/**
 * @author jxdong
 * @date 2018/4/13
 */
public abstract class Consumer implements Runnable {
    @Override
    public void run() {
        before();
        consume();
        after();
    }

    public abstract void consume();

    public abstract void before();

    public abstract void after();
}
