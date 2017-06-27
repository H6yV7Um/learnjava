package com.memcached;

import com.memcached.pool.ThreadPool;
import net.spy.memcached.MemcachedClient;

/**
 * Created by dongchunxu on 2017/6/24.
 */
public class Main {
    ThreadPool pool = new ThreadPool();
    public static void main(String[] args) {

       new Main().pool.run(new Tester(1));
       new Main().pool.run(new Tester(177164));
       new Main().pool.run(new Tester(161760));
       new Main().pool.run(new Tester(175652));
       new Main().pool.run(new Tester(122748));
       new Main().pool.run(new Tester(159826));
       new Main().pool.run(new Tester(151480));
       new Main().pool.run(new Tester(121181));
       new Main().pool.run(new Tester(150300));
    }

}
class Tester implements Runnable {
    private int placeId;
    public Tester (int placeId) {
        this.placeId = placeId;
    }
    public void run() {
        for (int i = 1; i < 2000; i++) {
            String key = "CMT_LIST_PLACE_ID_" + placeId + "_PAGESIZE_10_"+i;
            long start = System.currentTimeMillis();
            Object o = MemcachedUtil.getInstance().get(key);
            if (o != null) {
                System.out.println(placeId+"-----有数据-----页码:" + i + ", cost:" + (System.currentTimeMillis() - start));
            } else {
                System.out.println(placeId+"-----no data-----");
                break;
            }
        }
    }
}