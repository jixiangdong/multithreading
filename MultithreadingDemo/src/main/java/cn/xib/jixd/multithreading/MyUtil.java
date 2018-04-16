package cn.xib.jixd.multithreading;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jxdong
 * @date 2018/4/13
 */
public class MyUtil {

    //  todo 多线程环境下获取随机数详见博客：http://www.importnew.com/12460.html
    private  static Random random = new Random();
    private  static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static int getRandomNm(int bound) {
        //return random.nextInt(bound);
        return threadLocalRandom.nextInt(bound);
    }


}
