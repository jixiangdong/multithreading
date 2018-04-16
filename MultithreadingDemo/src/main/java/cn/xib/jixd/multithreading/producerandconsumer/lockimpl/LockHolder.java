package cn.xib.jixd.multithreading.producerandconsumer.lockimpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jxdong
 * @date 2018/4/16
 */
public class LockHolder {
    private  static ReentrantLock lock = new ReentrantLock();
    public static ReentrantLock getLock() {
        return lock;
    }
}
