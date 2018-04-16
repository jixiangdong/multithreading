package cn.xib.jixd.multithreading.producerandconsumer.base;

import java.util.ArrayList;

/**
 * 线程不安全
 * @author jxdong
 * @date 2018/4/13
 */
public class NoBlockingStore<T> implements Store<T> {
    //最多允许存储10个
    private final int maxNum = 10;
    //使用Arraylist作为Store
    private ArrayList<T> list = new ArrayList<>(maxNum);

    @Override
    public void addToStore(T t) {
        list.add(t);

    }

    @Override
    public T getFromStore() {
        if (list.size() > 0) {
            return list.remove(list.size() - 1);
        }
        return null;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public int getCurrentNum() {
        return list.size();
    }

}
