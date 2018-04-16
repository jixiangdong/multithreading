package cn.xib.jixd.multithreading.producerandconsumer.base;

/**
 * @author jxdong
 * @date 2018/4/13
 */
public interface Store<T> {
    void addToStore(T t);

    T getFromStore();

}
